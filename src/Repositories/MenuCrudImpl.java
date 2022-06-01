package Repositories;

import Entities.Menu;
import Entities.Restaurants;
import Repositories.Interfaces.MenuCrudInterface;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MenuCrudImpl implements MenuCrudInterface {

    private Connection con;
    private Statement ste;
    private PreparedStatement prs;
    private RestaurantsCrudImpl restaurantsCrud;

    public Connection getCon() {
        return con;
    }

    public MenuCrudImpl(Connection con, RestaurantsCrudImpl restaurantsCrud) {
        this.con = con;
        this.restaurantsCrud = restaurantsCrud;
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(RestaurantsCrudImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void create(Menu menu) throws SQLException {
        String query="insert into menu_categories (name,restaurant_id) values(?,?)";
        prs = con.prepareStatement(query);
        prs.setString(1, menu.getName());
        prs.setInt(2,menu.getId());
        prs.executeUpdate();
    }

    @Override
    public Menu find(int id) throws SQLException {
        String query="select * from menu_categories where id = ?";
        prs = con.prepareStatement(query);
        prs.setInt(1,id);
        ResultSet rs = prs.executeQuery();

        Menu menu = new Menu();
        while(rs.next()){
            Restaurants restaurant = restaurantsCrud.find(rs.getInt("restaurant_id"));
            new Menu(
                    rs.getInt("id"),restaurant,rs.getString("name"));
        }
        return menu;
    }

    @Override
    public ArrayList<Menu> findAll() throws SQLException {
        return null;
    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public void update(int id, Menu menu) throws SQLException {

    }
}
