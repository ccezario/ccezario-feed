package controllers;

import models.Category;
import models.User;
import models.forms.Categories;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import static play.data.Form.form;

import play.mvc.Security;
import views.html.*;

import java.util.ArrayList;
import java.util.List;

@Security.Authenticated(Secured.class)
public class Settings extends Controller {

    /**
     * Configure page.
     */
    public static Result configure() {
        User user = User.findByEmail(session().get("email"));
        Form<Categories> form = form(Categories.class);
        if (user.categories != null) {
            Categories categories = new Categories(user.categories);
            form = form(Categories.class).fill(categories);
        }
        return ok(configure.render(form));
    }

    /**
     * Post settings.
     */
    public static Result post() {
        Form<Categories> form = form(Categories.class).bindFromRequest();
        if(form.hasErrors()) {
            return badRequest(configure.render(form));
        } else {
            User user = User.findByEmail(session().get("email"));
            Category.deleteUserCategories(user);
            List<Category> categories = makeList(form.get());
            user.categories = categories;
            user.configured = true;
            User.update(user);
            flash("success", "Successfully updated your settings.");
            return redirect(routes.Feed.list());
        }
    }

    private static List<Category> makeList(Categories categories) {
        List<Category> list = new ArrayList<Category>();
        if ( categories.cars == true ) {
            Category cat = new Category();
            cat.category = "cars";
            cat.tags = categories.cars_tags;
            list.add(cat);
        }
        if ( categories.economy == true ) {
            Category cat = new Category();
            cat.category = "economy";
            cat.tags = categories.economy_tags;
            list.add(cat);
        }
        if ( categories.education == true ) {
            Category cat = new Category();
            cat.category = "education";
            cat.tags = categories.education_tags;
            list.add(cat);
        }
        if ( categories.foods == true ) {
            Category cat = new Category();
            cat.category = "foods";
            cat.tags = categories.foods_tags;
            list.add(cat);
        }
        if ( categories.games == true ) {
            Category cat = new Category();
            cat.category = "games";
            cat.tags = categories.games_tags;
            list.add(cat);
        }
        if ( categories.movies == true ) {
            Category cat = new Category();
            cat.category = "movies";
            cat.tags = categories.movies_tags;
            list.add(cat);
        }
        if ( categories.music == true ) {
            Category cat = new Category();
            cat.category = "music";
            cat.tags = categories.music_tags;
            list.add(cat);
        }
        if ( categories.people == true ) {
            Category cat = new Category();
            cat.category = "people";
            cat.tags = categories.people_tags;
            list.add(cat);
        }
        if ( categories.places == true ) {
            Category cat = new Category();
            cat.category = "places";
            cat.tags = categories.places_tags;
            list.add(cat);
        }
        if ( categories.politics == true ) {
            Category cat = new Category();
            cat.category = "politics";
            cat.tags = categories.politics_tags;
            list.add(cat);
        }
        if ( categories.sports == true ) {
            Category cat = new Category();
            cat.category = "sports";
            cat.tags = categories.sports_tags;
            list.add(cat);
        }
        if ( categories.tech == true ) {
            Category cat = new Category();
            cat.category = "tech";
            cat.tags = categories.tech_tags;
            list.add(cat);
        }
        if ( categories.transportation == true ) {
            Category cat = new Category();
            cat.category = "transportation";
            cat.tags = categories.transportation_tags;
            list.add(cat);
        }
        if ( categories.travel == true ) {
            Category cat = new Category();
            cat.category = "travel";
            cat.tags = categories.travel_tags;
            list.add(cat);
        }
        if ( categories.tv == true ) {
            Category cat = new Category();
            cat.category = "tv";
            cat.tags = categories.tv_tags;
            list.add(cat);
        }
        if ( categories.weather == true ) {
            Category cat = new Category();
            cat.category = "weather";
            cat.tags = categories.weather_tags;
            list.add(cat);
        }
        return list;
    }
}
