package donadoni.dao;

import donadoni.models.Movie;
import donadoni.models.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDao {
    public static TicketDao INSTANCE = new TicketDao();

    private static String SELECT_ALL = "SELECT * FROM tickets";
    private static String SELECT_BY_ID = "SELECT * FROM tickets WHERE id=?";
    private static String INSERT = "INSERT INTO tickets(sessionDetail, numOfTickets) VALUES(?,?)";
    private static String UPDATE = "UPDATE tickets SET sessionDetail = ?, numOfTickets = ? WHERE id=?";

    private TicketDao() {
    }

    public List<Ticket> getAll() throws SQLException {
        Connection connection = DBUtils.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery(SELECT_ALL);
        List<Ticket> tickets = new ArrayList<>();
        while (rs.next()) {
            tickets.add(mapTicket(rs));
        }
        connection.close();
        return tickets;
    }

    public Ticket get(Long id) throws SQLException {
        Connection connection = DBUtils.getConnection();
        PreparedStatement stm = connection.prepareStatement(SELECT_BY_ID);
        stm.setLong(1, id);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            Ticket t = mapTicket(rs);
            return t;
        }
        connection.close();
        throw new SQLException("No Ticket with id = " + id);
    }

    public Ticket create(Ticket ticket) throws SQLException {
        Connection connection = DBUtils.getConnection();
        PreparedStatement stm = connection.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
        stm.setString(1, ticket.getSessionDetail());
        stm.setInt(2, ticket.getNumOfTicket());
        stm.executeUpdate();
        ResultSet generatedKeys = stm.getGeneratedKeys();
        if (generatedKeys.next()) {
            ticket.setID(generatedKeys.getLong(1));
        } else {
            connection.close();
            throw new SQLException("Creating ticket failed, no ID obtained.");
        }
        connection.close();
        return ticket;
    }

    public int update(Ticket ticket) throws SQLException {
        Connection connection = DBUtils.getConnection();
        PreparedStatement stm = connection.prepareStatement(UPDATE);
        stm.setLong(1,ticket.getID());
        stm.setString(2, ticket.getSessionDetail());
        stm.setInt(3, ticket.getNumOfTicket());
        return stm.executeUpdate();
    }

    private Ticket mapTicket(ResultSet rs) throws SQLException {
        Ticket ticket = new Ticket(rs.getString(2), rs.getInt(3));
        ticket.setID(rs.getLong(1));
        ticket.setSessionDetail(rs.getString(2));
        ticket.setNumOfTicket(rs.getInt(3));
        return ticket;
    }
}
