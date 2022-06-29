/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Views.Home;

import Utils.Navigator;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author m.rhouma
 */
public class HomeController extends Application  implements Initializable{

    final String RESTAURANT_VIEW = "../Restaurants/List/RestaurantsList.fxml";
    final String USER_VIEW = "../User/List/UserList.fxml";
    final String EVENT_VIEW = "../Event/EventList.fxml";
    final String HOTEL_VIEW = "../hotel/List/HotelsList.fxml";
    final String LOGIN_VIEW = "../Login/Login.fxml";
    final String DASHBOARD_VIEW = "../Dashboard/Dashboard.fxml";


    @FXML
    private AnchorPane corPane;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void gotoRestaurant(ActionEvent event) throws IOException {
        this.goToView(event, RESTAURANT_VIEW);
    }

    public void gotoUser(ActionEvent event) throws IOException {
        this.goToView(event, USER_VIEW);
    }

    public void goToEvent(ActionEvent event) throws IOException {
        this.goToView(event, EVENT_VIEW);
    }

    public void goToHotel(ActionEvent event) throws IOException {
        this.goToView(event, HOTEL_VIEW);
    }

    public void goToView(ActionEvent event, String view) throws IOException {
        Navigator.goToView(getClass(), event, corPane, view);
    }

    public void goToLogin(ActionEvent event) throws IOException {
        Navigator.goToScreen(getClass(), event, LOGIN_VIEW);
    }

    public void gotoStats(ActionEvent event) throws IOException {
        this.goToView(event, DASHBOARD_VIEW);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            this.gotoStats(null);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
