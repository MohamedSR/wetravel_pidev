/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Views.UserHome;

import Entities.Event;
import Entities.Hotel;
import Entities.Restaurant;
import Repositories.EventCrudImpl;
import Repositories.HotelCrudImpl;
import Repositories.RestaurantCrudImpl;
import Services.EventService;
import Services.HotelsService;
import Services.RestaurantService;
import Utils.DataSource;
import Utils.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class UserHomeController implements Initializable {

    @FXML
    private ImageView eventimg;
    @FXML
    private ImageView hotelimg;
    @FXML
    private ImageView restimg;
    @FXML
    private TextFlow Hotel;
    @FXML
    private TextFlow Restaurant;
    @FXML
    private TextFlow Event;
    HotelCrudImpl hcrud = new HotelCrudImpl(DataSource.getInstance().getCon());
    HotelsService hotelService = new HotelsService(hcrud);
    Hotel hotel = new Hotel();
    Event event =new Event();
    EventCrudImpl eventCrud = new EventCrudImpl(DataSource.getInstance().getCon());
    EventService eventService = new EventService(eventCrud);
    Restaurant restaurant = new Restaurant();
    RestaurantCrudImpl restaurantCrud = new RestaurantCrudImpl(DataSource.getInstance().getCon());
    RestaurantService restaurantService = new RestaurantService(restaurantCrud);
    final String RESTAURANT_VIEW = "../UserRestaurant/UserRestaurant.fxml";
    final String EVENT_VIEW = "../UserEvent/UserEvent.fxml";
    final String HOTEL_VIEW = "../UserHotel/UserHotel.fxml";

     public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("UserHome.fxml"));
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            hotel = hotelService.get(1);
            Text text = new Text(hotel.toString());
            Hotel.getChildren().add(text);
//            hotelimg.setImage();
            restaurant = restaurantService.findRestaurants(1);
            Text textR = new Text(restaurant.toString());
            Restaurant.getChildren().add(textR);


            restimg.setImage(new Image("../assets/viamercato"));
            event = eventService.getEvent(1);
            Text textE = new Text(event.toString());
            Event.getChildren().add(textE);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void gotoRestaurant(ActionEvent event) throws IOException{
        this.goToView(event, RESTAURANT_VIEW);
    }
    public void goToEvent(ActionEvent event) throws IOException{
        this.goToView(event, EVENT_VIEW);
    }
    public void goToHotel(ActionEvent event) throws IOException{
        this.goToView(event, HOTEL_VIEW);
    }
    public void goToView(ActionEvent event,String view) throws IOException {
         Navigator.goToView(getClass(), event, view);
   }
}
