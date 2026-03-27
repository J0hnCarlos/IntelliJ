package donadoni.controllers.cinema;

import donadoni.dao.CinemaDao;
import donadoni.dao.MovieDao;
import donadoni.models.Cinema;
import donadoni.models.Movie;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class CinemaCreateController implements Handler {
    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        Cinema cinema = new Cinema(
                ctx.formParam("location"),
                ctx.formParam("name_")
        );

        cinema = CinemaDao.INSTANCE.create(cinema);
        ctx.redirect("/cinema/" + cinema.getId());

    }
}
