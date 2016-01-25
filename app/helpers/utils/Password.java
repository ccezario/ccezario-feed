package helpers.utils;

import org.mindrot.jbcrypt.BCrypt;


public class Password {

    public static String hash(final String clearString) {
        return BCrypt.hashpw(clearString, BCrypt.gensalt());
    }

    public static boolean check(final String hashed, final String candidate) {
        if(hashed == null || candidate == null) {
            return false;
        }
        return BCrypt.checkpw(candidate, hashed);
    }
}