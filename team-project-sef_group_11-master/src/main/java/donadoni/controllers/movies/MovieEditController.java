package donadoni.controllers.movies;

import donadoni.dao.MovieDao;
import donadoni.utils.Views;
import io.javalin.core.security.AccessManager;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 * @author Sebastian Rodriguez, 2020. email: sebastian.rodriguez@rmit.edu.au
 */
public class MovieEditController implements Handler {
    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        Map<String, Object> model = Views.baseModel(ctx);
        model.put("movie", MovieDao.INSTANCE.get(ctx.pathParam("id", Long.class).get()));
        ctx.render("/views/movies/edit.html", model);
    }
}
