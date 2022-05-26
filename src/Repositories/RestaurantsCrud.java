package Repositories;

import Entities.Restaurants;
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
            Logger.getLogger(RestaurantsCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void create(Restaurants restaurants) throws SQLException {
        String req="INSERT INTO restaurants ( name, capacity, adresse, ville, pays) VALUES(?,?,?,?,?)";
        prs = con.prepareStatement(req);
        prs.setString(1, restaurants.getName());
        prs.setInt(2,restaurants.getCapacity());
        prs.setString(3, restaurants.getAdresse());
        prs.setString(4, restaurants.getVille());
        prs.setString(5, restaurants.getPays());
        prs.executeUpdate();
    }

    @Override
    public Restaurants find(int id) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<Restaurants> findAll() throws SQLException {
        return null;
    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public void update(int id, Restaurants restaurants) throws SQLException {

    }
}
