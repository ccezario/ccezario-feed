package controllers;

import helpers.Alchemy.Data.DataNews;
import models.User;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;


import services.AlchemyDataNews;
import views.html.*;

import java.util.List;

@Security.Authenticated(Secured.class)
public class Feed extends Controller {

    /**
     * Handle feed list
     */
    public static Result list() {
        User user = User.findByEmail(session().get("email"));
        AlchemyDataNews adn = new AlchemyDataNews();
        List<DataNews> dataNewsList = adn.getNews(user);
        return ok( list.render(dataNewsList) );
    }
}
