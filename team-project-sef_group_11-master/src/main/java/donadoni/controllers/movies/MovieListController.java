package donadoni.controllers.movies;

import donadoni.dao.MovieDao;
import donadoni.utils.Views;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 * @author Sebastian Rodriguez, 2020. email: sebastian.rodriguez@rmit.edu.au
 */
public class MovieListController implements Handler {

    static final String TEMPLATE = Views.templatePath("movies/list.html");

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        Map<String, Object> model = Views.baseModel(ctx);
        model.put("movies", MovieDao.INSTANCE.getAll());
        ctx.render(TEMPLATE,model);
    }
}
