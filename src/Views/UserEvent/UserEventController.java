/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Views.UserEvent;

import Utils.Navigator;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class UserEventController extends Application {

    final String HOME_VIEW = "../UserHome/UserHome.fxml";
    final String RESTAURANT_VIEW = "../UserRestaurant/UserRestaurant.fxml";
    final String HOTEL_VIEW = "../UserHotel/UserHotel.fxml";


    public static void main(String[] args) {
        launch(args);
    }
     public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("UserEvent.fxml"));
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }
    public void gotoRestaurant(ActionEvent event) throws IOException{
        this.goToView(event, RESTAURANT_VIEW);
    }
    public void goToHome(ActionEvent event) throws IOException{
        this.goToView(event, HOME_VIEW);
    }
    public void goToHotel(ActionEvent event) throws IOException{
        this.goToView(event, HOTEL_VIEW);
    }
    public void goToView(ActionEvent event,String view) throws IOException {
         Navigator.goToView(getClass(), event, view);
   }
}
