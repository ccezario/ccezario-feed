package helpers.Alchemy.Data;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

public class DataNews {

    private static class Constants {
        public static final String IMAGE = "image";
        public static final String IMAGE_KEYWORDS = "imageKeywords";
        public static final String TITLE = "title";
        public static final String URL = "url";
    }

    private String image;
    private List<String> imageKeywords;
    private String title;
    private String url;

    public DataNews(){
        super();
    }

    public DataNews(final JsonNode n){
        if ( n.has(Constants.IMAGE)) {
            this.image = n.get(Constants.IMAGE).asText();
        }
        if ( n.has(Constants.IMAGE_KEYWORDS)) {
            this.imageKeywords = n.get(Constants.IMAGE_KEYWORDS).findValuesAsText("");
        }
        if ( n.has(Constants.TITLE)) {
            this.title = n.get(Constants.TITLE).asText();
        }
        if ( n.has(Constants.URL)) {
            this.url = n.get(Constants.URL).asText();
        }
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getImageKeywords() {
        return imageKeywords;
    }

    public void setImageKeywords(List<String> imageKeywords) {
        this.imageKeywords = imageKeywords;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
