package app.auth;

import app.models.User;
import io.javalin.core.security.Role;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

/**
 * @author Sebastian Rodriguez, 2020. email: sebastian.rodriguez@rmit.edu.au
 */
public class AccessManager implements io.javalin.core.security.AccessManager {
    private static final String USER_KEY = "currentUser";

    private static final User ANON = new User("none@test.com","Anonymous", app.models.Role.ANONYMOUS);

    public static User getSessionCurrentUser(Context ctx) {
        User user = ctx.sessionAttribute(USER_KEY);
        if(user == null){
            user = ANON;
            loginUser(ctx,user);
        }
        return user;
    }

    @Override
    public void manage(@NotNull Handler handler, @NotNull Context ctx, @NotNull Set<Role> permittedRoles) throws Exception {
        Role userRole = getUserRole(ctx);
        if (permittedRoles.isEmpty() || permittedRoles.contains(userRole)) {
            handler.handle(ctx);
        } else {
            ctx.status(401).result("Unauthorized");
        }
    }

    private Role getUserRole(Context ctx) {
        return getSessionCurrentUser(ctx).getRole();
    }

    public static void loginUser(Context ctx, User user){
        ctx.sessionAttribute(USER_KEY,user);
    }

    public static void logout(Context ctx) {
        ctx.sessionAttribute(USER_KEY,null);
    }


}
