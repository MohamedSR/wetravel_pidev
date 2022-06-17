/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Views.Home;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.scene.Node;

/**
 * FXML Controller class
 *
 * @author m.rhouma
 */
public class HomeController extends Application { 
   
    private Stage stage;
    private Scene scene;
    final String RESTAURANT_VIEW = "../Restaurants/List/RestaurantsList.fxml";
    
     public static void main(String[] args) {
        launch(args);
    }
     public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }
    public void gotoRestaurant(ActionEvent event) throws IOException{
        this.goToView(event, RESTAURANT_VIEW);
    }
     public void goToView(ActionEvent event,String view) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource(view));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(home);
        stage.setScene(scene);
        stage.show();
   }
}
