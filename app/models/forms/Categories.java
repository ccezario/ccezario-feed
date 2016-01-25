package models.forms;

import models.Category;
import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

public class Categories {

    public static class Messages {
        public static final String SELECT_ONE_FIELD = "categories.error.select_one_field";
        public static final String SELECT_THIS_FIELD = "categories.error.select_this_field";
    }

    public Boolean cars = false;
    public String cars_tags;
    public Boolean economy = false;
    public String economy_tags;
    public Boolean education = false;
    public String education_tags;
    public Boolean foods = false;
    public String foods_tags;
    public Boolean games = false;
    public String games_tags;
    public Boolean movies = false;
    public String movies_tags;
    public Boolean music = false;
    public String music_tags;
    public Boolean people = false;
    public String people_tags;
    public Boolean places = false;
    public String places_tags;
    public Boolean politics = false;
    public String politics_tags;
    public Boolean sports = false;
    public String sports_tags;
    public Boolean tech = false;
    public String tech_tags;
    public Boolean transportation = false;
    public String transportation_tags;
    public Boolean travel = false;
    public String travel_tags;
    public Boolean tv = false;
    public String tv_tags;
    public Boolean weather = false;
    public String weather_tags;

    public Categories(){
        super();
    }

    public Categories(List<Category> categories) {
        for(Category category : categories) {
            if (category.category.equals("cars")) {
                this.cars = true;
                this.cars_tags = category.tags;
            } else if (category.category.equals("economy")) {
                this.economy = true;
                this.economy_tags = category.tags;
            } else if (category.category.equals("education")) {
                this.education = true;
                this.education_tags = category.tags;
            } else if (category.category.equals("foods")) {
                this.foods = true;
                this.foods_tags = category.tags;
            } else if (category.category.equals("games")) {
                this.games = true;
                this.games_tags = category.tags;
            } else if (category.category.equals("movies")) {
                this.movies = true;
                this.movies_tags = category.tags;
            } else if (category.category.equals("music")) {
                this.music = true;
                this.music_tags = category.tags;
            } else if (category.category.equals("people")) {
                this.people = true;
                this.people_tags = category.tags;
            } else if (category.category.equals("places")) {
                this.places = true;
                this.places_tags = category.tags;
            } else if (category.category.equals("politics")) {
                this.politics = true;
                this.politics_tags = category.tags;
            } else if (category.category.equals("sports")) {
                this.sports = true;
                this.sports_tags = category.tags;
            } else if (category.category.equals("tech")) {
                this.tech = true;
                this.tech_tags = category.tags;
            } else if (category.category.equals("transportation")) {
                this.transportation = true;
                this.transportation_tags = category.tags;
            } else if (category.category.equals("travel")) {
                this.travel = true;
                this.travel_tags = category.tags;
            } else if (category.category.equals("tv")) {
                this.tv = true;
                this.tv_tags = category.tags;
            } else if (category.category.equals("weather")) {
                this.weather = true;
                this.weather_tags = category.tags;
            }
        }
    }

    public List<ValidationError> validate() {

        List<ValidationError> errors = new ArrayList<ValidationError>();
        if ( cars == false && economy == false && education == false && foods == false && games == false &&
            movies == false && music == false && people == false && places == false && politics == false &&
            sports == false && tech == false && transportation == false && travel == false && tv == false &&
            weather == false) {
            errors.add( new ValidationError("cars", Messages.SELECT_ONE_FIELD));
        }
        if ( cars == false && !cars_tags.isEmpty() ) {
            errors.add( new ValidationError( "cars", Messages.SELECT_THIS_FIELD ) );
        }
        if ( economy == false && !economy_tags.isEmpty() ) {
            errors.add( new ValidationError( "economy", Messages.SELECT_THIS_FIELD ) );
        }
        if ( education == false && !education_tags.isEmpty() ) {
            errors.add( new ValidationError( "education", Messages.SELECT_THIS_FIELD ) );
        }
        if ( foods == false && !foods_tags.isEmpty() ) {
            errors.add( new ValidationError( "foods", Messages.SELECT_THIS_FIELD ) );
        }
        if ( games == false && !games_tags.isEmpty() ) {
            errors.add( new ValidationError( "games", Messages.SELECT_THIS_FIELD ) );
        }
        if ( movies == false && !movies_tags.isEmpty() ) {
            errors.add( new ValidationError( "movies", Messages.SELECT_THIS_FIELD ) );
        }
        if ( music == false && !music_tags.isEmpty() ) {
            errors.add( new ValidationError( "music", Messages.SELECT_THIS_FIELD ) );
        }
        if ( people == false && !people_tags.isEmpty() ) {
            errors.add( new ValidationError( "people", Messages.SELECT_THIS_FIELD ) );
        }
        if ( places == false && !places_tags.isEmpty() ) {
            errors.add( new ValidationError( "places", Messages.SELECT_THIS_FIELD ) );
        }
        if ( politics == false && !politics_tags.isEmpty() ) {
            errors.add( new ValidationError( "politics", Messages.SELECT_THIS_FIELD ) );
        }
        if ( sports == false && !sports_tags.isEmpty() ) {
            errors.add( new ValidationError( "sports", Messages.SELECT_THIS_FIELD ) );
        }
        if ( tech == false && !tech_tags.isEmpty() ) {
            errors.add( new ValidationError( "tech", Messages.SELECT_THIS_FIELD ) );
        }
        if ( transportation == false && !transportation_tags.isEmpty() ) {
            errors.add( new ValidationError( "transportation", Messages.SELECT_THIS_FIELD ) );
        }
        if ( travel == false && !travel_tags.isEmpty() ) {
            errors.add( new ValidationError( "travel", Messages.SELECT_THIS_FIELD ) );
        }
        if ( tv == false && !tv_tags.isEmpty() ) {
            errors.add( new ValidationError( "tv", Messages.SELECT_THIS_FIELD ) );
        }
        if ( weather == false && !weather_tags.isEmpty() ) {
            errors.add( new ValidationError( "weather", Messages.SELECT_THIS_FIELD ) );
        }

        return errors.isEmpty() ? null : errors;
    }
}
