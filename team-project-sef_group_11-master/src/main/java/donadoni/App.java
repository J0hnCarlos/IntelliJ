package donadoni;

import donadoni.auth.AccessManager;
import donadoni.auth.LoginController;
import donadoni.controllers.movies.*;
import donadoni.controllers.payment.ticketPayment;
import donadoni.controllers.tickets.*;
import donadoni.controllers.welcome.WelcomeController;
import donadoni.dao.MovieDao;
import donadoni.models.Movie;
import donadoni.models.Role;
import donadoni.utils.Views;
import io.javalin.Javalin;
import io.javalin.core.util.RouteOverviewPlugin;
import io.javalin.plugin.rendering.JavalinRenderer;
import io.javalin.plugin.rendering.template.JavalinThymeleaf;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.Thymeleaf;

import java.util.Map;

import static io.javalin.core.security.SecurityUtil.roles;

/**
 * Main Application Class.
 * <p>
 * Running this class as regular java application will start the HTTP Server and configure our web application.
 *
 * @author Sebastian Rodriguez, 2020. email: sebastian.rodriguez@rmit.edu.au
 */
public class App {


    public static void main(String[] args) {

        //Create our HTTP server and listen in port 7000
        Javalin app = Javalin.create(config -> {
            config.enableDevLogging();
            config.registerPlugin(new RouteOverviewPlugin("/help/routes"));
            config.addStaticFiles("public/");
            config.accessManager(new AccessManager());
        }).start(7000);

        //Register the engine to process html views
        JavalinRenderer.register(JavalinThymeleaf.INSTANCE, ".html");

        //Configure Web Routes
        configureRoutes(app);

    }

    public static void configureRoutes(Javalin app) {

        app.get(WelcomeController.URL, new WelcomeController());

        //Paths should be in Variables, but kept here for learning purposes.
        app.get("/movies", new MovieListController());
        app.get("/movies/new", new MovieNewController(), roles(Role.ADMIN)); //Secured for ADMINs only
        app.post("/movies", new MovieCreateController(), roles(Role.ADMIN));//Secured for ADMINs only
        app.get("/movies/:id/edit", new MovieEditController(), roles(Role.ADMIN));//Secured for ADMINs only
        app.post("movies/:id", new MovieUpdateController(), roles(Role.ADMIN));//Secured for ADMINs only
        app.get("/movies/:id", new MovieShowController());

        // book ticket page
        app.get("/bookTicket", new TicketListController());
        app.post("/bookTicket/new", new TicketCreateController());
        app.get("/bookTicket/emailTicket", new emailTicket());
        app.get("/bookTicket/seatSelect", new TicketListController());
        app.post("/bookTicket", new TicketCreateController());
        app.get("/emailTicket", new emailTicket());

        // payment
        app.get("/payment", new ticketPayment());
        //Auth
        app.get("/login", ctx -> {
            ctx.render("/views/auth/login.html", Views.baseModel(ctx));
        });

        app.post("auth", new LoginController());
        app.get("/logout", ctx -> {
            AccessManager.logout(ctx);
            ctx.redirect("/");
        });

    }


}
