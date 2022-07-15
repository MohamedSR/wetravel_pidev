/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import Entities.Restaurant;
import Views.Restaurants.Add.AddRestaurantController;
import Views.Restaurants.Update.UpdateRestaurantController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;

/**
 *
 * @author m.rhouma
 */
public class Navigator {
    
    private static Stage stage;
    private static Scene scene;
    private static Parent home;
    
    public static void goToView(Class cls,ActionEvent event,AnchorPane anchorPane,String view) throws IOException {
        AnchorPane fxmlLoader = FXMLLoader.load(cls.getResource(view));
        try {
            if(!anchorPane.getChildren().isEmpty()){
                anchorPane.getChildren().clear();
            }
            anchorPane.getChildren().add(fxmlLoader);
        } catch (Exception e) {
            e.printStackTrace();
        }
   }

    public static void goToScreen(Class cls,ActionEvent event,String view) throws IOException {
        home = FXMLLoader.load(cls.getResource(view));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(home);
        stage.setScene(scene);
        stage.show();
    }
    
    
    public static void goToUpdateRestaurantScreen(Class cls,ActionEvent event,AnchorPane anchorPane,String view,Restaurant r) throws IOException {
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(cls.getResource(view));
        AnchorPane fxmlLoader = loader.load();
        UpdateRestaurantController urs = loader.getController();
        urs.initData(r);
        try {
            if(!anchorPane.getChildren().isEmpty()){
                anchorPane.getChildren().clear();
            }
            anchorPane.getChildren().add(fxmlLoader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
