package donadoni.controllers.movies;

import donadoni.dao.MovieDao;
import donadoni.models.Movie;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

/**
 * @author Sebastian Rodriguez, 2020. email: sebastian.rodriguez@rmit.edu.au
 */
public class MovieUpdateController implements Handler {
    @Override
    public void handle(@NotNull Context ctx) throws Exception {

        Movie movie = MovieDao.INSTANCE.get(ctx.pathParam("id", Long.class).get());
        movie.setTitle(ctx.formParam("title"));
        movie.setReleaseYear(ctx.formParam("releaseYear", Integer.class).get());
        movie.setSynopsis(ctx.formParam("synopsis"));

        MovieDao.INSTANCE.update(movie);
        ctx.redirect("/movies/" + movie.getId());
    }
}
