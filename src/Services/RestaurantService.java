package Services;

import Entities.Restaurant;
import Repositories.Interfaces.RestaurantCrudInterface;

import java.sql.SQLException;
import java.util.ArrayList;

public class RestaurantService {

    private final RestaurantCrudInterface restaurantsCrud;

    public RestaurantService(RestaurantCrudInterface restaurantsCrud) {
        this.restaurantsCrud = restaurantsCrud;
    }

    public void createRestaurant(Restaurant restaurants) throws SQLException {
        restaurantsCrud.create(restaurants);
    }
    public void createRestaurantWithImage(Restaurant restaurants) throws SQLException {
        restaurantsCrud.createWithImage(restaurants);
    }

    public Restaurant findRestaurants(int id) throws SQLException {
        return restaurantsCrud.find(id);
    }

    public ArrayList<Restaurant> findAllRestaurants() throws SQLException {
        return restaurantsCrud.findAll();
    }

    public ArrayList<Restaurant> findByVille(String ville) throws SQLException{
        return restaurantsCrud.findByVille(ville);
    }

    public void deleteRestaurants(int id) throws SQLException {
        restaurantsCrud.delete(id);
    }

    public void updateRestaurants(int id, Restaurant restaurants) throws SQLException {
        restaurantsCrud.update(id, restaurants);
    }
}
