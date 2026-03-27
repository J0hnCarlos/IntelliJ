import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import oracle.sql.DATE;

public class SignUp implements Handler {

    public static final String URL = "/SignUp.html";
    JDBCConnection jdbc;
    Connection connection;

    public void handle(Context ctx) throws Exception {
        String html = "<html>\n";

        html = html + "<head>" + "<title>Sign Up</title>";

        html = html + "<link rel='stylesheet' type='text/css' href='common.css' />\n";

        html = html + "<body>\n";

        html = html + "<h1>Sign Up</h1>\n";
        html = html + " <form action='/SignUp.html' method='post'>\n";
        html = html + "     <div class='form-group'>\n";
        html = html + "         <label for='email_textbox'> Email: </label>\n";
        html = html + "         <input class='form-control' type='email' id='email_textbox' name='email_textbox'>\n";
        html = html + "     </div>\n";
        html = html + "     <div class='form-group'>\n";
        html = html + "         <label for='password_textbox'> Password: </label>\n";
        html = html + "         <input class='form-control' type='password' id='password_textbox' name='password_textbox'>\n";
        html = html + "     </div>\n";
        html = html + "     <div class='form-group'>\n";
        html = html + "         <label for='username_textbox'> Screen Name: </label>\n";
        html = html + "         <input class='form-control' type='text' id='screen_name' name='username_textbox'>\n";
        html = html + "     </div>\n";
        html = html + "     <div class='form-group'>\n";
        html = html + "         <label for='FullName_textbox'> Full Name: </label>\n";
        html = html + "         <input class='form-control' type='text' id='fullName_textbox' name='FullName_textbox'>\n";
        html = html + "     </div>\n";
        html = html + "     <div class='form-group'>\n";
        html = html + "         <label for='gender_dropdown'> Gender: </label>\n";
        html = html + "         <select id='gender_dropdown' name='gender_dropdown'>\n";
        html = html + "             <option> Male</option>\n";
        html = html + "             <option> Female</option>\n";
        html = html + "             <option> Rather Not Say</option>\n";
        html = html + "      </select>\n";
        html = html + "     </div>\n";
        html = html + "     <div class='form-group'>\n";
        html = html + "         <label for='DOB_date'> Date Of Birth: </label>\n";
        html = html + "         <input class='form-control' type='DATE' id='DOB_date' name='DOB_date'>\n";
        html = html + "     </div>\n";
        html = html + "     <div class='form-group'>\n";
        html = html + "         <label for='status_dropdown'> Status: </label>\n";
        html = html + "         <select id='status_dropdown' name='status_dropdown'>\n";
        html = html + "             <option> Available</option>\n";
        html = html + "             <option> Busy</option>\n";
        html = html + "             <option> Not Available</option>\n";
        html = html + "             <option> Idle</option>\n";
        html = html + "         </select>\n";
        html = html + "     </div>\n";
        html = html + "     <div class='form-group'>\n";
        html = html + "         <label for='Location_textbox'> Location: </label>\n";
        html = html + "         <input class='form-control' type='text' id='Location_textbox' name='Location_textbox'>\n";
        html = html + "     </div>\n";
        html = html + "         <button type='submit' class='btn btn-primary'>Submit</button>\n";

//        html = html + "<link rel='stylesheet' href='https://www.w3schools.com/w3css/4/w3.css'>\n";
//        html = html + "<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>\n";
//
//        html = html + "<body>\n";
//
//        html = html + "<form action='/Login.html' class='w3-container w3-card-4 w3-light-grey w3-text-blue w3-margin'>\n";
//        html = html + "<h2 class='w3-center'>Profile Setting</h2>\n";
//        html = html + "<div class='w3-row w3-section'>\n";
//        html = html + "<div class='w3-rest'>\n";
//        html = html + "<input class='w3-input w3-border' type='text' id='screen_name' name='username_textbox' placeholder='Screen Name'>\n";
//        html = html + "</div>\n";
//        html = html + "</div>\n";
//
//        html = html + "<div class='w3-row w3-section'>\n";
//        html = html + "<div class='w3-rest'>\n";
//        html = html + "<input class='w3-input w3-border' id='fullName_textbox' name='FullName_textbox' type='text' placeholder='Full Name'>\n";
//        html = html + "</div>\n";
//        html = html + "</div>\n";
//
//        html = html + "<div class='w3-row w3-section'>\n";
//        html = html + "<div class='w3-rest'>\n";
//        html = html + "<input class='w3-input w3-border' name='email' type='text' placeholder='Email'>\n";
//        html = html + "</div>\n";
//        html = html + "</div>\n";
//
//        html = html + "<div class='w3-row w3-section'>\n";
//        html = html + "<div class='w3-rest'>\n";
//        html = html + "<input class='w3-input w3-border' type='DATE' id='DOB_date' name='DOB_date' type='DATE'>\n";
//        html = html + "</div>\n";
//        html = html + "</div>\n";
//
//        html = html + "<div class='w3-row w3-section'>\n";
//        html = html + "<div class='w3-rest'>\n";
//        html = html + "<input class='w3-input w3-border' name='message' type='text' placeholder='Message'>\n";
//        html = html + "</div>\n";
//        html = html + "</div>\n";
//
//        html = html + "<p class='w3-center'>\n";
//        html = html + "<button class='w3-button w3-section w3-blue w3-ripple'> Send </button>\n";
//        html = html + "</p>\n";
//        html = html + "</form>\n";

        //Finish HTML webpages
        html = html + "</body>" + "</html>\n";

        ctx.html(html);
    }

    public void SignUp() {
        Context ctx = null;
        String email = ctx.formParam("email_textbox");
        String password = ctx.formParam("password_textbox");
        String screenName = ctx.formParam("screen_name");
        String fullName = ctx.formParam("fullName_textbox");
        DateFormat format = new SimpleDateFormat("DD, MM, YYYY", Locale.ENGLISH);
        try {
            Date dateOfBirth = format.parse(ctx.formParam("DOB_date"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String gender = ctx.formParam("gender_dropdown");
        String status = ctx.formParam("status_dropdown");
        String location = ctx.formParam("Location_textbox");
//        String visibility = ctx.formParam("password_textbox");

        try {
            PreparedStatement prepareStatement = connection.prepareStatement("INSERT INTO member (email, password, fullName, screenName, dateOfBirth, gender, status, location, visibility )"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            prepareStatement.setString(1, email);
            prepareStatement.setString(2, password);
            prepareStatement.setString(3, fullName);
            prepareStatement.setString(4, screenName);
            prepareStatement.setDate(5, null);
            prepareStatement.setString(6, gender);
            prepareStatement.setString(7, status);
            prepareStatement.setString(8, location);
            prepareStatement.setString(9, null);
            prepareStatement.execute();
        } catch (SQLException e) {
            System.out.println("IT DOES NOT WORK");
        }
    }
}
