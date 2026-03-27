import java.sql.*;
import java.util.ArrayList;

public class JDBCConnection {

    private static final String DATABASE_USERNAME = "s3701835";
    private static final String DATABASE_PASSWORD = "rmit123!";

    private static final String DATABASE_URL = "jdbc:oracle:thin:@//localhost:9922/CSAMPR1.its.rmit.edu.au";
    private static JDBCConnection jdbc = null;
    private static Connection connection;
    public static Connection getConnection;

    public static JDBCConnection getConnection() {

        SSHTunnel.getSession();

        if(jdbc == null) {
            jdbc = new JDBCConnection();
        }
        return jdbc;
    }

    private JDBCConnection() {
        System.out.println("Created JDBC Connection Object");

        try{
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
        } catch (SQLException e) {
            //If there is an error, lets just print the error
            System.err.println(e.getMessage());
        }
    }

    public static void closeConnection() {
        try{
            if(connection != null) {
                connection.close();
                System.out.println("Database Connection closed");
            }
        }catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    //Get Username by the User from the database
    public ArrayList<String> getUsername() {
        ArrayList<String> username = new ArrayList<String>();

        try{
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = "Select *" + "\n"+
                    "FROM username";

            ResultSet results = statement.executeQuery(query);

            while(results.next()) {
                String Username = results.getString("Username");

                username.add(Username);
            }

            statement.close();
        } catch(SQLException e) {
            System.err.println(e.getMessage());
        }

        return username;
    }

    // Get Password from database
    public ArrayList<String> getPassword(String username){
        ArrayList<String> password = new ArrayList<String>();

        try{
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = "SELECT *" + "\n" +
                    "FROM password" + "\n" +
                    "WHERE Username = username";

            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                String Password = results.getString("Password");
                password.add(Password);
            }

            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return password;
    }

    public Boolean isLogin(String username, String password) throws SQLException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM Users WHERE username = ? and password = ?";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);

            rs = ps.executeQuery();

            if(rs.next()){
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        } finally {
            ps.close();
            rs.close();
        }
    }

    public void newUser(){

    }
}
