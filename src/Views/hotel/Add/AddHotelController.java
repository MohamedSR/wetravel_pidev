/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Views.hotel.Add;

import Entities.Hotel;
import Repositories.HotelCrudImpl;
import Services.HotelsService;
import Utils.DataSource;
import Utils.Navigator;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.SpinnerValueFactory;

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
    
    @FXML
    private Label successMsg;
    @FXML
    private Label errMsg;
    
    HotelCrudImpl rcrud = new HotelCrudImpl(DataSource.getInstance().getCon());
    HotelsService hotelService = new HotelsService(rcrud);
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SpinnerValueFactory<Integer> valueFactory= new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 500, 0);
        capacity.setValueFactory(valueFactory);
        SpinnerValueFactory<Integer> starsValueFactory= new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, 1);
        stars.setValueFactory(starsValueFactory);
    }

    public void addHotel(){
        Hotel hotel= new Hotel(name.getText(),capacity.getValue(),stars.getValue(),addresse.getText(),ville.getText(),pays.getText());
        try {
            hotelService.create(hotel);
            successMsg.setText("L'hotel a été ajouté avec succès");
        } catch (SQLException ex) {
            Logger.getLogger(AddHotelController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }        
    
    public void backToList(ActionEvent event) throws IOException{
        Navigator.goToView(getClass(), event,"../List/HotelsList.fxml");
    }
    
}