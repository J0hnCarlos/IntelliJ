package donadoni.dao;

import donadoni.models.Movie;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Basic Movie DAO Testing.
 * Tests are intentionally incomplete.
 *
 * @author Sebastian Rodriguez, 2020. email: sebastian.rodriguez@rmit.edu.au
 */
class MovieDaoTest {

    @BeforeEach
    void setup(){
        //Use a different DB for testing
        String DB = "jdbc:h2:file:./target/donadonitest";
        //Set the environment property so that DBUtils point to the same file DB.
        System.setProperty(DBUtils.DB_URL,DB);
        //Get Flyway instance
        Flyway flyway = Flyway.configure().dataSource(DB, "sa","").load();
        //Clean testing DB before each test to make sure we have a consistent state
        flyway.clean();
        //Set up db
        flyway.migrate();
    }

    @Test
    void create() throws SQLException {
        Movie m = new Movie("Goodfellas", 1990);
        Movie m2 = MovieDao.INSTANCE.create(m);
        assertNotNull(m2.getId());
        assertEquals(3,m2.getId());

    }

    @Test
    void getAll() throws SQLException {
        List<Movie> all = MovieDao.INSTANCE.getAll();
        assertEquals(2,all.size());
    }

    @Test
    void get() throws SQLException {
        Movie movie = MovieDao.INSTANCE.get(1l);
        assertNotNull(movie);
        assertEquals("Star Wars", movie.getTitle());

    }

    @Test
    void update() throws SQLException {
        Movie movie = MovieDao.INSTANCE.get(1l);
        assertNotNull(movie);
        assertEquals("Star Wars", movie.getTitle());
        movie.setTitle("New Title");
        int result = MovieDao.INSTANCE.update(movie);
        //query updated 1 record
        assertEquals(1, result);
        //get if back from the db
        movie = MovieDao.INSTANCE.get(1l);
        assertNotNull(movie);
        assertEquals("New Title", movie.getTitle());
    }
}