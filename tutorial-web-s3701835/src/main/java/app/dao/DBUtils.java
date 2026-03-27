package app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility Class to set up common DB access functions
 *
 *
 * @author Sebastian Rodriguez, 2020. email: sebastian.rodriguez@rmit.edu.au
 */
public class DBUtils {
    /**
     * URL of the database to connect to. Must be same as db.url property in pom.xml
     */
    public static final String DB_DEFAULT_URI = "jdbc:h2:file:./target/webapp";
    public static final String DB_URL = "db.url";
    public static final String DB_USER = "db.user";
    public static final String DB_PASSWORD = "db.password";

    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(
                System.getProperty(DB_URL,DB_DEFAULT_URI),
                System.getProperty(DB_USER,"sa"),
                System.getProperty(DB_PASSWORD,""));
    }

}
