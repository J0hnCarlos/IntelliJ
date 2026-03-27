package donadoni.controllers.movies;

import donadoni.dao.MovieDao;
import donadoni.models.Movie;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

/**
 * @author Sebastian Rodriguez, 2020. email: sebastian.rodriguez@rmit.edu.au
 */
public class MovieCreateController implements Handler {

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        Movie movie = new Movie(
                ctx.formParam("title"),
                ctx.formParam("releaseYear", Integer.class).get()
        );

        movie.setSynopsis(ctx.formParam("synopsis", ""));

        movie = MovieDao.INSTANCE.create(movie);
        ctx.redirect("/movies/" + movie.getId());

    }
}
