package app.controllers.welcome;

import app.App;
import io.javalin.Javalin;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
        assertThat(response.getBody().toString()).contains("Welcome to");
    }
}