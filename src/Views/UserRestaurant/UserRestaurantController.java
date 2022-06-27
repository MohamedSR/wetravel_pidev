/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Views.UserRestaurant;

import Entities.Restaurant;
import Repositories.RestaurantCrudImpl;
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


public class UserRestaurantController implements Initializable {

    @FXML
    private ImageView getRestimg;
    @FXML
    private ImageView imageView;
    @FXML
    private ImageView restimg;
    @FXML
    private TextFlow Restaurant;
    @FXML
    private TextFlow Restaurant1;
    @FXML
    private TextFlow Restaurant2;
    @FXML
    private Pane pane;


    Entities.Restaurant restaurant = new Restaurant();
    RestaurantCrudImpl restaurantCrud = new RestaurantCrudImpl(DataSource.getInstance().getCon());
    RestaurantService restaurantService = new RestaurantService(restaurantCrud);
    final String HOME_VIEW = "../UserHome/UserHome.fxml";
    final String HOTEL_VIEW = "../UserHotel/UserHotel.fxml";
    final String EVENT_VIEW = "../UserEvent/UserEvent.fxml";
    

     public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("UserRestaurant.fxml"));
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            int id = getRandomNumberUsingNextInt(1,6);
            restaurant = restaurantService.findRestaurants(id);
            Text textR = new Text(restaurant.toString());
            Restaurant.getChildren().add(textR);
            String link="@../../assets/"+restaurant.getName()+".PNG";
            Image rest = new Image(link);
            restimg = new ImageView(rest);
            restimg.setFitHeight(150);
            restimg.setFitWidth(150);
            restimg.setSmooth(true);
            restimg.setLayoutX(1);
            restimg.setLayoutY(1);
            restimg.setCache(true);
            pane.getChildren().add(restimg);

            int id1 = getRandomNumberUsingNextInt(1,6);

            while (id1==id){
                id1 = getRandomNumberUsingNextInt(1,6);
            }
            restaurant = restaurantService.findRestaurants(id1);
            textR = new Text(restaurant.toString());
            Restaurant1.getChildren().add(textR);
            link="@../../assets/"+restaurant.getName()+".PNG";
            Image rest1 = new Image(link);
            getRestimg = new ImageView(rest1);
            getRestimg.setFitHeight(150);
            getRestimg.setFitWidth(150);
            getRestimg.setLayoutX(1);
            getRestimg.setLayoutY(150);
            getRestimg.setSmooth(true);
            getRestimg.setCache(true);
            pane.getChildren().add(getRestimg);
            int id2 = getRandomNumberUsingNextInt(1,6);

            while (id2==id){
                id2 = getRandomNumberUsingNextInt(1,6);
            }

            restaurant = restaurantService.findRestaurants(id2);
            textR = new Text(restaurant.toString());
            Restaurant2.getChildren().add(textR);
            link="@../../assets/"+restaurant.getName()+".PNG";
            Image rest2 = new Image(link);
            imageView = new ImageView(rest2);
            imageView.setFitHeight(150);
            imageView.setFitWidth(150);
            imageView.setLayoutX(1);
            imageView.setLayoutY(300);
            imageView.setSmooth(true);
            imageView.setCache(true);
            pane.getChildren().add(imageView);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public void gotoHome(ActionEvent event) throws IOException{
        this.goToView(event, HOME_VIEW);
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
