package donadoni.controllers.cinema;

import donadoni.dao.CinemaDao;
import donadoni.utils.Views;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class CinemaListController implements Handler {
    static final String TEMPLATE = Views.templatePath("cinema/cinemaSelect.html");

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        Map<String, Object> model = Views.baseModel(ctx);
        model.put("cinema", CinemaDao.INSTANCE.getAll());
        ctx.render(TEMPLATE,model);
    }
}
