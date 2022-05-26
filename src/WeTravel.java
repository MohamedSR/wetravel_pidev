
import Entities.Restaurants;
import Entities.User;
import Entities.hotels;
import Repositories.HotelsCrudImpl;
import Services.HotelsService;
import Repositories.Interfaces.IRestaurantsCrud;
import Repositories.RestaurantsCrud;
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
        DataSource ds = DataSource.getInstance();

        // Init repositories
        UserCrudImpl userCrud = new UserCrudImpl(ds.getCon());
        IRestaurantsCrud restaurantsCrud = new RestaurantsCrud(ds.getCon());
        HotelsCrudImpl hotelCrud = new HotelsCrudImpl(ds.getCon());

        // Init services
        UserService userService = new UserService(userCrud);
        RestaurantService restaurantService = new RestaurantService(restaurantsCrud);
        HotelsService hotelService = new HotelsService(hotelCrud);

        // Tests
        User user = new User("Mohamed", "ADMIN", "moihamed@wetravel.com", "mohamed123", "22001002");
        userService.create(user);
        ArrayList users = userService.getAll();

        System.out.println(users);

        // Tests d'hotel
        hotels hotel = new hotels("el mouradi", 4, 100, "elmouradi@Sousse.com", "Sousse", "Tunisie");
        hotelService.create(hotel);
        ArrayList hotelss = hotelService.getAll();
        System.out.println(hotelss);

        Restaurants restaurant = new Restaurants(70, "Lac 2", "Tunis", "Tunisie", "via mercato");
        Restaurants restaurant2 = new Restaurants(50, "Lac 1", "Tunis", "Tunisie", "New Food");
        Restaurants restaurant3 = new Restaurants(60, "Lac 1", "Tunis", "Tunisie", "Good Food");

        restaurantService.createRestaurant(restaurant);
        restaurantService.createRestaurant(restaurant2);

        restaurantService.updateRestaurants(2, restaurant3);

        restaurantService.deleteRestaurants(3);

        Restaurants resto = restaurantService.findRestaurants(1);
        ArrayList restaurants = restaurantService.findAllRestaurants();

        System.out.println(resto);
        System.out.println(restaurants);
    }

}
