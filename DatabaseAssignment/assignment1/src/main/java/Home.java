import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.sql.Connection;

public class Home implements Handler {

    public static final String URL = "/Home.html";
    JDBCConnection jdbc;
    Connection connection;

    @Override
    public void handle(Context ctx) throws Exception {

        String html = "<html>\n";

        // Add some Title infromation
        html = html + "<head>" + "<title>Home</title>\n";

        html = html + "<link rel='stylesheet' type='text/css' href='common.css' />\n";
        html = html + "<body>\n";
        html = html + "<form action='/Home.html' style='text-align: center'>\n";
        html = html + "<textarea name='message' rows='10' cols='30' placeholder='Please enter your post message'></textarea>\n";
        html = html + "<br><br>\n";
        html = html + "<button>Post</button>\n";
        html = html + "</form>\n";
        html = html + "<div style='text-align: center'>\n";
        html = html + "Sample post\n";
        html = html + "<br><br>\n";
        html = html + "<button>Like</button>";
        html = html + "<br><br>\n";
        html = html + "<textarea name='message' rows='10' cols='30' placeholder='Comment'></textarea>\n";
        html = html + "</div>";
//        html = html + "<div class=\'w3-sidebar w3-light-grey w3-bar-block\' style=\'width:25%\'>\n";
//        html = html"  <h3 class=\"w3-bar-item\">Menu</h3>\n";
//                "  <a href=\"#\" class=\"w3-bar-item w3-button\">Link 1</a>\n" +
//                "  <a href=\"#\" class=\"w3-bar-item w3-button\">Link 2</a>\n" +
//                "  <a href=\"#\" class=\"w3-bar-item w3-button\">Link 3</a>\n" +
//                "</div>"


        //Finish HTML webpages
        html = html + "</body>" + "</html>\n";

        ctx.html(html);
    }
}

