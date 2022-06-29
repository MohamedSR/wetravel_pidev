/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Entities.User;
import Repositories.Interfaces.UserCrudInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author m.rhouma
 */
public class UserCrudImpl implements UserCrudInterface {

    private Connection con;
    private Statement ste;
    private PreparedStatement prs;

    public Connection getCon() {
        return con;
    }

    public UserCrudImpl(Connection con) {
        this.con = con;
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(UserCrudImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void create(User t) throws SQLException {
        String req="INSERT INTO users ( name, role, email, password,phone) VALUES(?,?,?,?,?)";
        prs = con.prepareStatement(req);
        prs.setString(1, t.getName());
        prs.setString(2, t.getRole());
        prs.setString(3, t.getEmail());
        prs.setString(4, t.getPassword());
        prs.setString(5, t.getPhone());
        prs.executeUpdate();
    }
    @Override
    public void createWithImage(User t) throws SQLException {
        String req="INSERT INTO users ( name, role, email, password,phone,image) VALUES(?,?,?,?,?,?)";
        prs = con.prepareStatement(req);
        prs.setString(1, t.getName());
        prs.setString(2, t.getRole());
        prs.setString(3, t.getEmail());
        prs.setString(4, t.getPassword());
        prs.setString(5, t.getPhone());
        prs.setString(6, t.getImage());
        prs.executeUpdate();
    }

    @Override
    public User find(int id) throws SQLException{
        String query = "select * from users where id = ?";
        prs = con.prepareStatement(query);
        prs.setInt(1, id);
        ResultSet rs  = prs.executeQuery();
        User user = new User();
        while(rs.next()){
            user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("role"), rs.getString("email"), rs.getString("password"), rs.getString("phone"));
        }
         return user;
    }

    @Override
    public ArrayList<User> findAll() throws SQLException{
        String query = "select * from users";
        ArrayList<User> list = new ArrayList<>();
        ResultSet rs = ste.executeQuery(query);
        while(rs.next()){
            list.add(new User(rs.getInt("id"), rs.getString("name"), rs.getString("role"), rs.getString("email"), rs.getString("password"), rs.getString("phone")));
        }
        return list;
    }

    @Override
    public void delete(int id) throws SQLException{
        String query = "delete from users where id = ?";
        prs = con.prepareStatement(query);
        prs.setInt(1, id);
        prs.execute();
    }

    @Override
    public void update(int id, User t) throws SQLException{
        String query = "UPDATE users SET name= ?,phone=?,email=?,password=?,role=? where id = ?";
        prs = con.prepareStatement(query);
        prs.setString(1, t.getName());
        prs.setString(2, t.getPhone());
        prs.setString(3, t.getEmail());
        prs.setString(4, t.getPassword());
        prs.setString(5, t.getRole());
        prs.setInt(6, id);
        prs.execute();
    }
    @Override
    public User getByLogin(String login) throws SQLException{
        String query = "select * from users where email = ?";
        prs = con.prepareStatement(query);
        prs.setString(1, login);
        ResultSet rs  = prs.executeQuery();
        User user = new User();
        while(rs.next()){
            user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("role"), rs.getString("email"), rs.getString("password"), rs.getString("phone"));
        }
        return user;
    }
}
