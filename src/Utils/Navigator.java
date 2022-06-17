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
import javafx.stage.Stage;

/**
 *
 * @author m.rhouma
 */
public class Navigator {
    
    private static Stage stage;
    private static Scene scene;
    private static Parent home;
    
    public static void goToView(Class cls,ActionEvent event,String view) throws IOException {
        home = FXMLLoader.load(cls.getResource(view));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(home);
        stage.setScene(scene);
        stage.show();
   }
}
