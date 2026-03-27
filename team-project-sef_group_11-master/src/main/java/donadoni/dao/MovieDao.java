package donadoni.dao;

import donadoni.models.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A Data Access Object for the Movie model.
 *
 * Implementation could be improved by students.
 *
 * @author Sebastian Rodriguez, 2020. email: sebastian.rodriguez@rmit.edu.au
 */
public class MovieDao {

    public static MovieDao INSTANCE = new MovieDao();

    private static String SELECT_ALL = "SELECT * FROM movies";
    private static String SELECT_BY_ID = "SELECT * FROM movies WHERE id=?";
    private static String INSERT = "INSERT INTO movies(title, releaseYear, synopsis, price) VALUES(?,?,?,?)";
    private static String UPDATE = "UPDATE movies SET title = ?, releaseYear = ?,  synopsis = ?, price = ? WHERE id=?";

    private MovieDao() {
    }

    public List<Movie> getAll() throws SQLException {
        Connection connection = DBUtils.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery(SELECT_ALL);
        List<Movie> movies = new ArrayList<>();
        while (rs.next()) {
            movies.add(mapMovie(rs));
        }
        connection.close();
        return movies;
    }

    public Movie get(Long id) throws SQLException {
        Connection connection = DBUtils.getConnection();
        PreparedStatement stm = connection.prepareStatement(SELECT_BY_ID);
        stm.setLong(1, id);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            Movie m = mapMovie(rs);
            return m;
        }
        connection.close();
        throw new SQLException("No Movie with id = " + id);
    }

    public Movie create(Movie movie) throws SQLException {
        Connection connection = DBUtils.getConnection();
        PreparedStatement stm = connection.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
        stm.setString(1, movie.getTitle());
        stm.setInt(2, movie.getReleaseYear());
        stm.setString(3, movie.getSynopsis());
        stm.executeUpdate();
        ResultSet generatedKeys = stm.getGeneratedKeys();
        if (generatedKeys.next()) {
            movie.setId(generatedKeys.getLong(1));
        } else {
            connection.close();
            throw new SQLException("Creating movie failed, no ID obtained.");
        }
        connection.close();
        return movie;
    }

    /**
     * Update an existing record.
     * @param movie the record to update
     * @return either (1) the row count for SQL Data Manipulation Language (DML) statements
     *        or (2) 0 for SQL statements that return nothing
     * @throws SQLException
     */
    public int update(Movie movie) throws SQLException {
        Connection connection = DBUtils.getConnection();
        PreparedStatement stm = connection.prepareStatement(UPDATE);
        stm.setString(1, movie.getTitle());
        stm.setInt(2, movie.getReleaseYear());
        stm.setString(3, movie.getSynopsis());
        stm.setLong(4,movie.getId());
        return stm.executeUpdate();
    }

    private Movie mapMovie(ResultSet rs) throws SQLException {
        Movie movie = new Movie(rs.getString(2), rs.getInt(3));
        movie.setId(rs.getLong(1));
        movie.setSynopsis(rs.getString(4));
        return movie;
    }

}
