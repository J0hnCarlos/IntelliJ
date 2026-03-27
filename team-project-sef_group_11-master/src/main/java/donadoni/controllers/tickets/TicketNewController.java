package donadoni.controllers.tickets;

import donadoni.dao.MovieDao;
import donadoni.models.Ticket;
import donadoni.utils.Views;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
public class TicketNewController implements Handler {

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        Map<String, Object> model = Views.baseModel(ctx);
        model.put("ticket", new Ticket());
        ctx.render("/views/tickets/bookTicket.html", model);
    }
}