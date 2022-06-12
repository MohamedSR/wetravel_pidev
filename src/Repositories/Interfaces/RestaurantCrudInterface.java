package Repositories.Interfaces;

import Entities.Restaurant;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RestaurantCrudInterface extends CrudRepository<Restaurant>{
    public ArrayList<Restaurant> findByVille(String ville) throws SQLException;
}
