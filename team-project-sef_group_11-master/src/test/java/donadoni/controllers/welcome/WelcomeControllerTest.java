package donadoni.controllers.welcome;

import donadoni.App;
import donadoni.utils.Views;
import io.javalin.Javalin;
import io.javalin.core.util.RouteOverviewPlugin;
import io.javalin.http.Context;
import io.javalin.plugin.rendering.JavalinRenderer;
import io.javalin.plugin.rendering.template.JavalinThymeleaf;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Basic Integration test as example.
 *
 * @author Sebastian Rodriguez, 2020. email: sebastian.rodriguez@rmit.edu.au
 */
class WelcomeControllerTest {

    private static final String URL = "http://localhost:1234/";
    static Javalin app = null;


    @BeforeAll
    public static void setup() {
        app = Javalin.create();
        App.configureRoutes(app);
        app.start(1234);
    }

    @AfterAll
    static void tearDown() {
        app.stop();
    }

    @Test
    public void GET_welcome_renders() {
        HttpResponse response = Unirest.get(URL).asString();
        assertThat(response.getStatus()).isEqualTo(200);
    }

    @Test
    public void GET_welcome_renders_message() {
        HttpResponse response = Unirest.get(URL).asString();
        assertThat(response.getBody().toString()).contains("Welcome to Donadoni Cinemas");
    }
}