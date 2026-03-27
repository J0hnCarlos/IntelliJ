package donadoni.controllers.tickets;

import donadoni.dao.MovieDao;
import donadoni.dao.TicketDao;
import donadoni.models.Ticket;
import donadoni.utils.Views;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class emailTicket implements Handler {

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        Map<String, Object> model = Views.baseModel(ctx);
        model.put("tickets", TicketDao.INSTANCE.getAll());
        ctx.render("/views/tickets/emailTicket.html");
    }
}

