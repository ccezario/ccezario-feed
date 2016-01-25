package models.forms;

import helpers.utils.Password;
import models.User;

public class Login {
        
    public String email;
    public String password;
        
    public String validate() {
        if(User.authenticate(email, password) == null) {
            return "Invalid user or password";
        }
        return null;
    }
        
}