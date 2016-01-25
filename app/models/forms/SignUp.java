package models.forms;

import models.User;
import play.data.validation.Constraints;
import play.data.validation.ValidationError;

import java.util.List;
import java.util.ArrayList;

public class SignUp {

    public static class Messages {
        public static final String PASSWORDS_DO_NOT_MATCH = "signup.error.passwords_not_same";
        public static final String REGISTERED_USER = "signup.error.registered_user";
    }

    @Constraints.Required
    @Constraints.MaxLength( 100 )
    @Constraints.Email
    public String email;
    @Constraints.Required
    @Constraints.MinLength(5)
    public String password;
    @Constraints.Required
    @Constraints.MinLength(5)
    public String repeatPassword;

    public List<ValidationError> validate() {

        List<ValidationError> errors = new ArrayList<ValidationError>();
        if ( User.findByEmail(email) != null) {
            errors.add( new ValidationError( "email", Messages.REGISTERED_USER ) );
        }
        if ( password == null || !password.equals( repeatPassword ) ) {
            errors.add( new ValidationError( "password", Messages.PASSWORDS_DO_NOT_MATCH ) );
        }

        return errors.isEmpty() ? null : errors;
    }


}