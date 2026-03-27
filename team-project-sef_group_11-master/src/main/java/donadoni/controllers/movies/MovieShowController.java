package donadoni.controllers.movies;

import donadoni.dao.MovieDao;
import donadoni.models.Movie;
import donadoni.utils.Views;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 * @author Sebastian Rodriguez, 2020. email: sebastian.rodriguez@rmit.edu.au
 */
public class MovieShowController implements Handler {

    static final String TEMPLATE = Views.templatePath("movies/show.html");

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        Long id = ctx.pathParam("id",Long.class).get();

        Movie movie = MovieDao.INSTANCE.get(id);

        Map<String, Object> model = Views.baseModel(ctx);
        model.put("movie", movie);
        ctx.render(TEMPLATE,model);
    }
}
