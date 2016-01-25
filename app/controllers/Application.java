package controllers;

import helpers.utils.Password;
import models.forms.SignUp;
import play.mvc.*;
import play.data.*;
import static play.data.Form.*;

import views.html.*;

import models.*;
import models.forms.Login;

public class Application extends Controller {
    
    /**
     * Login page.
     */
    public static Result login() {
        return ok(
            login.render(form(Login.class))
        );
    }
    
    /**
     * Handle login form submission.
     */
    public static Result authenticate() {
        Form<Login> loginForm = form(Login.class).bindFromRequest();
        if(loginForm.hasErrors()) {
            return badRequest(login.render(loginForm));
        } else {
            createSession(loginForm.get().email);
            User user = User.findByEmail(loginForm.get().email);
            if (user.configured) {
                return redirect(routes.Feed.list());
            } else {
                return redirect(routes.Settings.configure());
            }
        }
    }

    /**
     * Logout and clean the session.
     */
    public static Result logout() {
        session().clear();
        flash("success", "You've been logged out");
        return redirect(routes.Application.login());
    }

    /**
     * SignUp page.
     */
    public static Result signUpGet() {
        return ok(signUp.render(form(SignUp.class)));
    }

    /**
     * Validate and create new user.
     */
    public static Result signUpPost() {
        Form<SignUp> signUpForm = form(SignUp.class).bindFromRequest();
        if(signUpForm.hasErrors()) {
            return badRequest(signUp.render(signUpForm));
        } else {
            String password = Password.hash(signUpForm.get().password);
            User user = new User(signUpForm.get().email, password);
            User.create(user);
            createSession(user.email);
            return redirect(routes.Settings.configure());
        }
    }

    private static void createSession(String email){
        session("email", email);
    }

}