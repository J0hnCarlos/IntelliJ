import java.util.ArrayList;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class Login implements Handler{

    public static final String URL ="/";

    @Override
    public void handle( Context ctx) throws Exception {

        String html ="<html>\n";

        // Add some Title infromation
        html = html + "<head>" + "<title>Login</title>\n";

        html = html + "<link rel='stylesheet' type='text/css' href='common.css' />\n";
        html = html + "<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n";
        html = html + "<link class='navbar-brand' to='/'>Facebook Lite</link>\n";
        html = html + "<body>\n";


//        html = html + " <h2>Login</h2>";
//        html = html + "     <form action='/Home.html' method='post'>\n";
//        html = html + "         <div class='form-group'>\n";
//        html = html + "             <label for='username_input'>Username:</label> \n";
//        html = html + "             <input class='form-control' type='text' id='username' name='username'> \n";
//        html = html + "         </div>\n";
//        html = html + "         <div class='form-group'>\n";
//        html = html + "             <label for='password_input'>Password: </label> \n";
//        html = html + "             <input class='form-control' type='password' id='password' name='password'> \n";
//        html = html + "         </div>\n";
//        html = html + "             <button type='submit' class='btn btn-primary' onclick='checkDetail()'>Submit</button>\n";
//        html = html + "         </form>\n";
//        html = html + "         <form action='/SignUp.html' method='post' action='/SignUp'>\n";
//        html = html + "           <button type='submit'><a href='SignUp.html'> Sign Up</a></button>\n";
//        html = html + "         </form>\n";

        html = html + "<div class=\'w3-modal-content w3-card-4 w3-animate-zoom\' style=\'max-width:600px\'>\n";
        html = html + "<form class='w3-container' action='/Home.html'>\n";
        html = html + "<div class='w3-section'>\n";
        html = html + "<label><b>Username</b></label>\n";
        html = html + "<input class='w3-input w3-border w3-margin-bottom' type='text' placeholder='Enter Username' name='username' required>\n";
        html = html + "<label><b>Password</b></label>\n";
        html = html + "<input class='w3-input w3-border' type='text' placeholder='Enter Password' name='password' required>\n";
        html = html + "<button class='w3-button w3-block w3-green w3-section w3-padding' type='submit'>Login</button>\n";
        html = html + "<input class='w3-check w3-margin-top' type='checkbox' checked='checked'> Remember me\n";
        html = html + "</div>\n";
        html = html + "</form>\n";
        html = html + "</div>\n";


        //Finish HTML webpages
        html = html + "</body>" + "</html>\n";

        String username = ctx.formParam("username");
        String password = ctx.formParam("password");
        if (username == null || username == "" ) {
            html = html + "<h2><i>Please Enter your Username</i></h2>\n";
        } else if(password == null || password == "" ){
            html = html + "<h2><i>Please Enter your Password</i></h2>\n";
        } else {

            JDBCConnection jdbc = JDBCConnection.getConnection();

            boolean authenthic = false;
            if (jdbc.isLogin(username, password)) {
                authenthic = true;
            } else {
                authenthic = false;
            }

            if(authenthic){
                System.out.println(username + " Successfully log in");
            } else {
                System.out.println (username + " Unsuccessful log in");
            }

        }

        ctx.html(html);
    }
}
