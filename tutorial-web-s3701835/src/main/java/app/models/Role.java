package app.models;

/**
 * @author Sebastian Rodriguez, 2020. email: sebastian.rodriguez@rmit.edu.au
 */
public enum Role implements io.javalin.core.security.Role {
    ADMIN,
    REGISTERED,
    ANONYMOUS
}
