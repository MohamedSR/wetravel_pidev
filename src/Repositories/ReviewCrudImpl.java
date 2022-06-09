/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Entities.Reservation;
import Entities.Review;
import Entities.User;
import Repositories.Interfaces.UserCrudInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import Repositories.Interfaces.ReviewCrudInterface;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author m.rhouma
 */
public class ReviewCrudImpl implements ReviewCrudInterface {

    private Connection con;
    private Statement ste;
    private PreparedStatement prs;
    private UserCrudInterface userCrud;

    public ReviewCrudImpl(Connection con, UserCrudInterface userCrud) {
        this.con = con;
        this.userCrud = userCrud;
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ReviewCrudImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void create(Review t) throws SQLException {
        String req = "INSERT INTO reviews ( date, user_id, restaurant_id, hotel_id,event_id) VALUES(?,?,?,?,?)";
        prs = con.prepareStatement(req);
        prs.setDate(1, t.getDate());
        prs.setInt(2, t.getUser().getId());
        prs.executeUpdate();
    }

    @Override
    public Review find(int id) throws SQLException {
        String query = "select * from reviews where id = ?";
        prs = con.prepareStatement(query);
        prs.setInt(1, id);
        ResultSet rs = prs.executeQuery();
        Review review = new Review();
        while (rs.next()) {
            // Call User repo and get user by id
            User user = userCrud.find(rs.getInt("user_id"));
            review = new Review(rs.getInt("id"), user, rs.getDate("date"));
        }
        return review;
    }

    @Override
    public ArrayList<Review> findAll() throws SQLException {
        String query = "select * from revoews";
        ArrayList<Review> list = new ArrayList<>();
        ResultSet rs = ste.executeQuery(query);
        while (rs.next()) {
            User user = userCrud.find(rs.getInt("user_id"));
            list.add(new Review(rs.getInt("id"), user, rs.getDate("date")));
        }
        return list;
    }

    @Override
    public void delete(int id) throws SQLException {
          String query = "delete from reviews where id = ?";
        prs = con.prepareStatement(query);
        prs.setInt(1, id);
        prs.execute();
    }

    @Override
    public void update(int id, Review t) throws SQLException {
        String query = "UPDATE reviews SET date= ?,user_id=?";
        prs = con.prepareStatement(query);
        prs.setDate(1, t.getDate());
        prs.setInt(2, t.getUser().getId());
        prs.setInt(1, id);
        prs.execute();
    }

}
