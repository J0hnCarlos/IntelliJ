package donadoni.controllers.tickets;

import donadoni.utils.Views;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class seatSelect implements Handler {
    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        ctx.render("/views/tickets/seatSelect.html");
    }
}
