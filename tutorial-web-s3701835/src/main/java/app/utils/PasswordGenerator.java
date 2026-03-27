package app.utils;

import org.mindrot.jbcrypt.BCrypt;

/**
 * @author Sebastian Rodriguez, 2020. email: sebastian.rodriguez@rmit.edu.au
 */
public class PasswordGenerator {

    public static void main(String[] args) {
        System.out.println("Encrypted Password : "+ BCrypt.hashpw(args[0], BCrypt.gensalt()));
    }
}
