/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Entities.Reservation;
import Entities.User;
import Repositories.Interfaces.ReservationCrudInterface;
import Repositories.Interfaces.UserCrudInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author m.rhouma
 */
public class ReservationCrudImpl implements ReservationCrudInterface {

    private Connection con;
    private Statement ste;
    private PreparedStatement prs;
    private UserCrudInterface userCrud;

    public ReservationCrudImpl(Connection con, UserCrudInterface userCrud) {
        this.con = con;
        this.userCrud = userCrud;
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ReservationCrudImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void create(Reservation t) throws SQLException {
        String req = "INSERT INTO reservations ( date, user_id, restaurant_id, hotel_id,event_id) VALUES(?,?,?,?,?)";
        prs = con.prepareStatement(req);
        prs.setDate(1, t.getDate());
        prs.setInt(2, t.getUser().getId());
        prs.executeUpdate();
    }

    @Override
    public Reservation find(int id) throws SQLException {
        String query = "select * from reservations where id = ?";
        prs = con.prepareStatement(query);
        prs.setInt(1, id);
        ResultSet rs = prs.executeQuery();
        Reservation reservation = new Reservation();
        while (rs.next()) {
            // Call User repo and get user by id
            User user = userCrud.find(rs.getInt("user_id"));
            reservation = new Reservation(rs.getInt("id"), user, rs.getDate("date"));
        }
        return reservation;
    }

    @Override
    public ArrayList<Reservation> findAll() throws SQLException {
        String query = "select * from reservation";
        ArrayList<Reservation> list = new ArrayList<>();
        ResultSet rs = ste.executeQuery(query);
        while (rs.next()) {
            User user = userCrud.find(rs.getInt("user_id"));
            list.add(new Reservation(rs.getInt("id"), user, rs.getDate("date")));
        }
        return list;
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = "delete from reservations where id = ?";
        prs = con.prepareStatement(query);
        prs.setInt(1, id);
        prs.execute();
    }

    @Override
    public void update(int id, Reservation t) throws SQLException {
        String query = "UPDATE reservations SET date= ?,user_id=?";
        prs = con.prepareStatement(query);
        prs.setDate(1, t.getDate());
        prs.setInt(2, t.getUser().getId());
        prs.setInt(1, id);
        prs.execute();
    }

    @Override
    public int CountHotelReservationByDate(int hotel_id, Date date) throws SQLException {
        String query = "select count(*) from reservations where date = ? and hotel_id=?";
        prs = con.prepareStatement(query);
        prs.setInt(1, hotel_id);
        prs.setDate(2, date);
        ResultSet rs = prs.executeQuery();
        int count = 0;
        while (rs.next()) {
            count = rs.getInt(1);
        }
        return count;
    }

    @Override
    public int CountRestaurantReservationByDate(int restaurant_id, Date date) throws SQLException {
        String query = "select count(*) from reservations where date = ? and restaurant_id=?";
        prs = con.prepareStatement(query);
        prs.setInt(1, restaurant_id);
        prs.setDate(2, date);
        ResultSet rs = prs.executeQuery();
        int count = 0;
        while (rs.next()) {
            count = rs.getInt(1);
        }
        return count;
    }

    @Override
    public int CountEventReservationByDate(int event_id, Date date) throws SQLException {
        String query = "select count(*) from reservations where date = ? and event_id=?";
        prs = con.prepareStatement(query);
        prs.setInt(1, event_id);
        prs.setDate(2, date);
        ResultSet rs = prs.executeQuery();
        int count = 0;
        while (rs.next()) {
            count = rs.getInt(1);
        }
        return count;
    }

}
