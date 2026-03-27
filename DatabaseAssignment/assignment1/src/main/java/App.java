import java.io.IOException;

import io.javalin.Javalin;
import io.javalin.core.util.RouteOverviewPlugin;

public class App{

    public static final int JAVALIN_PORT = 7000;
    public static final String CSS_DIR = "css/";

    public static final String RMIT_USERNAME = "s3701835";
    public static char[] password = null;
    public static String pass = "Minecraftredstone1609!!!!";

    public static void main(String[] args) throws Exception{

        try{
            password = PasswordField.getPassword(System.in, "Click here and enter your RMIT password for account \"" + RMIT_USERNAME + "\": ");
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        //Establish SSH Tunnel trhrough firewall to RMIT Oracle Server
        SSHTunnel.open();

        //Establish database connection
        if(JDBCConnection.getConnection() == null){
            throw new Exception("Could not establish connection to database");
        }

        Javalin app = Javalin.create(config -> {
            config.registerPlugin(new RouteOverviewPlugin("/help/routes"));

            config.addStaticFiles(CSS_DIR);

        }).start(JAVALIN_PORT);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            app.stop();
        }));

        app.events(event ->{
            event.serverStopping(() -> {
                System.out.println("Server Stopping");
            });
            event.serverStopped(() -> {
                System.out.println("Server Stopped");
                //Close Database Connection
                JDBCConnection.closeConnection();
                //Close SSH Tunnel
                SSHTunnel.close();
            });
        });

        configureRoutes(app);
    }

    private static void configureRoutes(Javalin app) {

        app.get(Login.URL, new Login());
        app.get(SignUp.URL, new SignUp());
        app.get(Home.URL, new Home());
        app.get(Maintainence.URL, new Maintainence());
    }

}
