package app.controllers.welcome;

import app.utils.Views;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.Map;

/**
 * Controller to handle the welcome page
 *
 * @author Sebastian Rodriguez, 2020. email: sebastian.rodriguez@rmit.edu.au
 */
public class WelcomeController implements Handler {

    public static final String URL = "/";

    static final String TEMPLATE = Views.templatePath("welcome/index.html");

    @Override
    public void handle(@NotNull Context context) throws Exception {
        Map<String, Object> model = Views.baseModel(context);
        model.put("date", new Date());
        context.render(TEMPLATE, model);
    }
}
