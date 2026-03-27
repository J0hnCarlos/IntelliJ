package donadoni.controllers.tickets;

import donadoni.dao.MovieDao;
import donadoni.dao.TicketDao;
import donadoni.utils.Views;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class TicketListController implements Handler {
    static final String TEMPLATE = Views.templatePath("tickets/seatSelect.html");

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        Map<String, Object> model = Views.baseModel(ctx);
        model.put("movies", MovieDao.INSTANCE.getAll());
        model.put("tickets", TicketDao.INSTANCE.getAll());
//        model.put("sessions", SessionDao.INSTANCE.getAll());
        ctx.render(TEMPLATE,model);
    }
}
