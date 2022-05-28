
import Entities.Restaurants;
import Entities.User;
import Repositories.Interfaces.RestaurantsCrudInterface;
import Repositories.RestaurantsCrudImpl;
import Repositories.UserCrudImpl;
import Services.RestaurantService;
import Services.UserService;
import Utils.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author m.rhouma
 */
public class WeTravel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // Init Data source
        DataSource ds =  DataSource.getInstance();
        
        // Init repositories
        UserCrudImpl userCrud = new UserCrudImpl(ds.getCon());
        RestaurantsCrudInterface restaurantsCrud = new RestaurantsCrudImpl(ds.getCon());
        
        // Init services
        UserService userService = new UserService(userCrud);
        RestaurantService restaurantService = new RestaurantService(restaurantsCrud);
        
        // Tests
        User user = new User("Mohamed","ADMIN","moihamed@wetravel.com","mohamed123","22001002");
        userService.create(user);
        ArrayList users = userService.getAll();

        System.out.println(users);

        Restaurants restaurant = new Restaurants(70,"Lac 2", "Tunis", "Tunisie", "via mercato");
        Restaurants restaurant2 = new Restaurants(50,"Lac 1", "Tunis", "Tunisie", "New Food");
        Restaurants restaurant3 = new Restaurants(60,"Lac 1", "Tunis", "Tunisie", "Good Food");

        restaurantService.createRestaurant(restaurant);
        restaurantService.createRestaurant(restaurant2);

        restaurantService.updateRestaurants(2,restaurant3);

        restaurantService.deleteRestaurants(3);

        Restaurants resto = restaurantService.findRestaurants(1);
        ArrayList restaurants = restaurantService.findAllRestaurants();

        System.out.println(resto);
        System.out.println(restaurants);



    }
    
}
