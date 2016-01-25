package services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import helpers.Alchemy.Data.DataNews;
import models.Category;
import models.User;
import play.Play;
import play.libs.F;
import play.libs.ws.WS;
import play.libs.ws.WSResponse;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class AlchemyDataNews {

    private final String BASE_URL = "https://access.alchemyapi.com/calls/";
    private final String API = "data/GetNews";
    private final String API_KEY = "apikey=";

    public List<DataNews> getNews(User user){
        try {
            final F.Promise<WSResponse> promise = WS.url(BASE_URL.concat(API))
                    .setQueryString(API_KEY.concat(Play.application().configuration().getString("apikey")))
                    .setQueryString("outputMode=json")
                    .setQueryString("start=now-1d&end=now")
                    .setQueryString("maxResults=100")
                    .setQueryString(getQueryParameter(user))
                    .setQueryString("return=enriched.url.title,enriched.url.url,enriched.url.image")
                    .get();
            final WSResponse res = promise.get(10000);

            String json = InputStreamToString();

            ObjectMapper mapper = new ObjectMapper();

            JsonNode rootNode = mapper.readTree(res.getBody());

            List<DataNews> dataNewsList = new ArrayList<DataNews>();

            if (rootNode.isObject()) {

                JsonNode docsNode = rootNode.path("result").path("docs");
                if (docsNode.size() == 0){
                    rootNode = mapper.readValue(json, JsonNode.class);
                    docsNode = rootNode.path("result").path("docs");
                }
                for (JsonNode node : docsNode) {
                    JsonNode urlNode = node.path("source").path("enriched").path("url");
                    DataNews dataNews = mapper.treeToValue(urlNode, DataNews.class);
                    dataNewsList.add(dataNews);
                }
            }
            return dataNewsList;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    private String InputStreamToString(){
        try {
            InputStream inputstream = Play.application().resourceAsStream("json.json");

            String output = "";
            int data = inputstream.read();
            while(data != -1){
                output += (char) data;
                data = inputstream.read();
            }
            return output;
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    private String getQueryParameter(User user){
        String query = "q.enriched.url.title=[";
        for(Category cat : user.categories){
            query = query.concat(cat.tags.concat(","));
        }
        query = query.concat("]");
        query = query.replace(",", "^");
        query = query.replace(";", "^");
        query = query.replaceAll("\\s","");
        query = query.replace("^]","]");
        return query;
    }
}
