package Repositories;

import Entities.User;
import Repositories.Interfaces.IRestaurantsCrud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RestaurantsCrud implements IRestaurantsCrud {

    private Connection con;
    private Statement ste;
    private PreparedStatement prs;

    public Connection getCon() {
        return con;
    }

    public RestaurantsCrud(Connection con) {
        this.con = con;
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(UserCrudImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void create(User user) throws SQLException {

    }

    @Override
    public User find(int id) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<User> findAll() throws SQLException {
        return null;
    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public void update(int id, User user) throws SQLException {

    }
}
