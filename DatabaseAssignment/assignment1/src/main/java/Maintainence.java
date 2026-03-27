import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.sql.Connection;

public class Maintainence implements Handler{
    public static final String URL = "/Maintainence.html";
    JDBCConnection jdbc;
    Connection connection;

    @Override
    public void handle(Context ctx) throws Exception {

        String html = "<html>\n";

        // Add some Title infromation
        html = html + "<head>" + "<title>Profile Maintainence</title>\n";

        html = html + "<link rel='stylesheet' type='text/css' href='common.css' />\n";

        html = html + "<body>\n";

        html = html + "<h1>Profile Maintainence</h1>\n";
        html = html + " <form action='/Home.html' method='post'>\n";
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
        html = html + "         <button type='submit' class='btn btn-primary'>Save Changes</button>\n";


        //Finish HTML webpages
        html = html + "</body>" + "</html>\n";

        ctx.html(html);
    }
}
