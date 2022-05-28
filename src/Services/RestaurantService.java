package Services;

import Entities.Restaurants;
import Repositories.Interfaces.RestaurantsCrudInterface;

import java.sql.SQLException;
import java.util.ArrayList;

public class RestaurantService {

        private final RestaurantsCrudInterface restaurantsCrud;

    public RestaurantService(RestaurantsCrudInterface restaurantsCrud) {
        this.restaurantsCrud = restaurantsCrud;
    }

    public void createRestaurant(Restaurants restaurants) throws SQLException {
        restaurantsCrud.create(restaurants);
    }

    public Restaurants findRestaurants(int id) throws SQLException{
        return restaurantsCrud.find(id);
    }

    public ArrayList<Restaurants> findAllRestaurants() throws SQLException{
        return restaurantsCrud.findAll();
    }

    public void deleteRestaurants(int id) throws SQLException{
        restaurantsCrud.delete(id);
    }

    public void updateRestaurants(int id, Restaurants restaurants) throws SQLException{
        restaurantsCrud.update(id,restaurants);
    }
}
