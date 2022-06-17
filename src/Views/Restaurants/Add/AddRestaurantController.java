/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Views.Restaurants.Add;

import Repositories.RestaurantCrudImpl;
import Services.RestaurantService;
import Utils.DataSource;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import Entities.Restaurant;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.SpinnerValueFactory;

/**
 * FXML Controller class
 *
 * @author m.rhouma
 */
public class AddRestaurantController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private Spinner<Integer> capacity ;

    @FXML
    private TextField city;
    @FXML
    private TextField ville;
    @FXML
    private TextField addresse;
    
    RestaurantCrudImpl rcrud = new RestaurantCrudImpl(DataSource.getInstance().getCon());
    RestaurantService restaurantService = new RestaurantService(rcrud);
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void addRestaurant(){
        Restaurant restaurant= new Restaurant(10,addresse.getText(),ville.getText(),city.getText(),name.getText());
        try {
            restaurantService.createRestaurant(restaurant);
        } catch (SQLException ex) {
            Logger.getLogger(AddRestaurantController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
