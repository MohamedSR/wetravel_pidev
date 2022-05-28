package Repositories;

<<<<<<< HEAD:src/Repositories/RestaurantCrudImpl.java
import Entities.Restaurant;
=======
import Entities.Restaurants;
import Repositories.Interfaces.RestaurantsCrudInterface;
>>>>>>> 351e5e9... Rename files and refactoring code:src/Repositories/RestaurantsCrudImpl.java

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Repositories.Interfaces.RestaurantCrudInterface;

<<<<<<< HEAD:src/Repositories/RestaurantCrudImpl.java
public class RestaurantCrudImpl implements RestaurantCrudInterface {
=======
public class RestaurantsCrudImpl implements RestaurantsCrudInterface {
>>>>>>> 351e5e9... Rename files and refactoring code:src/Repositories/RestaurantsCrudImpl.java

    private Connection con;
    private Statement ste;
    private PreparedStatement prs;

    public Connection getCon() {
        return con;
    }

<<<<<<< HEAD:src/Repositories/RestaurantCrudImpl.java
    public RestaurantCrudImpl(Connection con) {
=======
    public RestaurantsCrudImpl(Connection con) {
>>>>>>> 351e5e9... Rename files and refactoring code:src/Repositories/RestaurantsCrudImpl.java
        this.con = con;
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
<<<<<<< HEAD:src/Repositories/RestaurantCrudImpl.java
            Logger.getLogger(RestaurantCrudImpl.class.getName()).log(Level.SEVERE, null, ex);
=======
            Logger.getLogger(RestaurantsCrudImpl.class.getName()).log(Level.SEVERE, null, ex);
>>>>>>> 351e5e9... Rename files and refactoring code:src/Repositories/RestaurantsCrudImpl.java
        }
    }

    @Override
    public void create(Restaurant restaurants) throws SQLException {
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
    public Restaurant find(int id) throws SQLException {
        String req = "select * from restaurants where id = ?";
        prs = con.prepareStatement(req);
        prs.setInt(1,id);
        ResultSet rs = prs.executeQuery();

        Restaurant restaurant = new Restaurant();
        while(rs.next()){
            restaurant =
                    new Restaurant(
                        rs.getInt("id"),rs.getInt("capacity"),rs.getString("adresse"),
                        rs.getString("ville"),rs.getString("pays"),rs.getString("name"));
        }
        return restaurant;
    }

    @Override
    public ArrayList<Restaurant> findAll() throws SQLException {
        String req = "select * from restaurants";
        ArrayList<Restaurant> list = new ArrayList<>();
        ResultSet rs = ste.executeQuery(req);

        while (rs.next()){
            list.add(new Restaurant(
                            rs.getInt("id"),rs.getInt("capacity"),rs.getString("adresse")
                            ,rs.getString("ville"),rs.getString("pays"),rs.getString("name")));
        }

        return list;
    }

    @Override
    public void delete(int id) throws SQLException {
        String req ="delete from restaurants where id = ?";
        prs = con.prepareStatement(req);
        prs.setInt(1, id);
        prs.execute();
        System.out.println("Restaurants deleted successfully");
    }

    @Override
    public void update(int id, Restaurant restaurants) throws SQLException {
        String req ="UPDATE restaurants SET name = ?, capacity = ?, adresse = ?, ville = ?, pays = ? WHERE id = ?;";
        prs = con.prepareStatement(req);

        prs.setString(1, restaurants.getName());
        prs.setInt(2,restaurants.getCapacity());
        prs.setString(3, restaurants.getAdresse());
        prs.setString(4, restaurants.getVille());
        prs.setString(5, restaurants.getPays());
        prs.setInt(6, id);

        prs.executeUpdate();
        System.out.println("Restaurants updated successfully");
    }
}
