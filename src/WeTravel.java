/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */

import Views.UserRestaurant.UserRestaurantController;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author m.rhouma
 */
public class WeTravel extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        UserRestaurantController lc = new UserRestaurantController();
        //LoginController lc = new LoginController();
        lc.start(primaryStage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
