package donadoni.dao;

import donadoni.models.Cinema;
import donadoni.models.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CinemaDao {
    public static CinemaDao INSTANCE = new CinemaDao();

    private static String SELECT_ALL = "SELECT * FROM cinemas";
    private static String SELECT_BY_ID = "SELECT * FROM cinemas WHERE id=?";
    private static String SELECT_BY_NAME = "SELECT * FROM cinemas WHERE name_=?";
    private static String INSERT = "INSERT INTO cinemas(name_, location) VALUES(?,?)";
    private static String UPDATE = "UPDATE cinemas SET name_ = ?, location = ? WHERE id=?";

    private CinemaDao(){

    }

    public List<Cinema> getAll() throws SQLException {
        Connection connection = DBUtils.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery(SELECT_ALL);
        List<Cinema> cinema = new ArrayList<>();
        while (rs.next()) {
            cinema.add(mapCinema(rs));
        }
        connection.close();
        return cinema;
    }

    public Cinema get(Long id) throws SQLException {
        Connection connection = DBUtils.getConnection();
        PreparedStatement stm = connection.prepareStatement(SELECT_BY_ID);
        stm.setLong(1, id);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            Cinema c = mapCinema(rs);
            return c;
        }
        connection.close();
        throw new SQLException("No Cinema with id = " + id);
    }
    public Cinema get(String name) throws SQLException {
        Connection connection = DBUtils.getConnection();
        PreparedStatement stm = connection.prepareStatement(SELECT_BY_NAME);
        stm.setString(1, name);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            Cinema c = mapCinema(rs);
            return c;
        }
        connection.close();
        throw new SQLException("No Cinema with name = " + name);
    }

    public Cinema create(Cinema cinema) throws SQLException {
        Connection connection = DBUtils.getConnection();
        PreparedStatement stm = connection.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
        stm.setString(1, cinema.getName());
        stm.setString(2, cinema.getLocation());
        stm.executeUpdate();
        ResultSet generatedKeys = stm.getGeneratedKeys();
        if (generatedKeys.next()) {
            cinema.setId(generatedKeys.getLong(1));
        } else {
            connection.close();
            throw new SQLException("Creating Cinema failed, no ID obtained.");
        }
        connection.close();
        return cinema;
    }

    /**
     * Update an existing record.
     * @param cinema the record to update
     * @return either (1) the row count for SQL Data Manipulation Language (DML) statements
     *        or (2) 0 for SQL statements that return nothing
     * @throws SQLException
     */
    public int update(Cinema cinema) throws SQLException {
        Connection connection = DBUtils.getConnection();
        PreparedStatement stm = connection.prepareStatement(UPDATE);
        stm.setString(1, cinema.getLocation());
        stm.setString(2, cinema.getName());
        stm.setLong(3,cinema.getId());
        return stm.executeUpdate();
    }

    private Cinema mapCinema(ResultSet rs) throws SQLException {
        Cinema cinema = new Cinema(rs.getString(2), rs.getString(3));
        cinema.setId(rs.getLong(1));
        return cinema;
    }
}