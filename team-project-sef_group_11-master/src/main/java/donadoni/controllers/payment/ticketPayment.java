package donadoni.controllers.payment;

import donadoni.utils.Views;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class ticketPayment implements Handler {
    public static final String URL = "/";

    static final String TEMPLATE = Views.templatePath("payment/ticketPayment.html");

    @Override
    public void handle(@NotNull Context context) throws Exception{
        Map model = Views.baseModel(context);
        context.render(TEMPLATE,model);
    }
}
