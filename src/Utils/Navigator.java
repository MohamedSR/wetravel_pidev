/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
}
