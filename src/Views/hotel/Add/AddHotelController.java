/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Views.hotel.Add;

import Entities.Hotel;
import Entities.Restaurant;
import Repositories.HotelCrudImpl;
import Repositories.RestaurantCrudImpl;
import Services.HotelsService;
import Services.RestaurantService;
import Utils.DataSource;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * FXML Controller class
 *
 * @author m.rhouma
 */



public class AddHotelController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private Spinner<Integer> capacity ;
    @FXML
    private Spinner<Integer> stars ;

    @FXML
    private TextField addresse;

    @FXML
    private TextField ville;
    @FXML
    private TextField pays;
    
    HotelCrudImpl rcrud = new HotelCrudImpl(DataSource.getInstance().getCon());
    HotelsService hotelService = new HotelsService(rcrud);
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void addHotel(){
        Hotel hotel= new Hotel(10,name.getText(),capacity.getValue(),stars.getValue(),addresse.getText(),ville.getText(),pays.getText());
        try {
            hotelService.create(hotel);
        } catch (SQLException ex) {
            Logger.getLogger(AddHotelController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
