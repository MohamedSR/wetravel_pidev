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
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Random;
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
    @FXML
    private Pane pane;


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
            int id = getRandomNumberUsingNextInt(1,5);
            hotel = hotelService.get(id);
            Text text = new Text(hotel.toString());
            Hotel.getChildren().add(text);
            String link="@../../assets/via mercato.PNG";
            Image htl = new Image(link);
            hotelimg = new ImageView(htl);
            hotelimg.setFitHeight(150);
            hotelimg.setFitWidth(150);
            hotelimg.setSmooth(true);
            hotelimg.setLayoutX(1);
            hotelimg.setLayoutY(1);
            hotelimg.setCache(true);
            pane.getChildren().add(hotelimg);

            id = getRandomNumberUsingNextInt(1,6);
            restaurant = restaurantService.findRestaurants(id);
            Text textR = new Text(restaurant.toString());
            Restaurant.getChildren().add(textR);
            link="@../../assets/el mouradi.PNG";
            Image rest = new Image(link);
            restimg = new ImageView(rest);
            restimg.setFitHeight(150);
            restimg.setFitWidth(150);
            restimg.setSmooth(true);
            restimg.setLayoutX(1);
            restimg.setLayoutY(150);
            restimg.setCache(true);
            pane.getChildren().add(restimg);

            id = getRandomNumberUsingNextInt(1,5);
            event = eventService.getEvent(id);
            Text textE = new Text(event.toString());
            Event.getChildren().add(textE);
            link="@../../assets/Rio Carnival.PNG";
            Image ev = new Image(link);
            eventimg = new ImageView(ev);
            eventimg.setFitHeight(150);
            eventimg.setFitWidth(150);
            eventimg.setSmooth(true);
            eventimg.setLayoutX(1);
            eventimg.setLayoutY(300);
            eventimg.setCache(true);
            pane.getChildren().add(eventimg);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
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
         Navigator.goToScreen(getClass(), event, view);
   }
}
