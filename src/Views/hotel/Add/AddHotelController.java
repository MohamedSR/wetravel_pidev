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
import Utils.UploadImage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
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
    
    @FXML
    private Label successMsg;
    @FXML
    private Label errMsg;
    @FXML
    private AnchorPane hotelsPane;
    @FXML
    private Label imgPath;
    
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
        Hotel hotel= new Hotel(name.getText(),capacity.getValue(),stars.getValue(),addresse.getText(),ville.getText(),pays.getText(),imgPath.getText());
        try {
            hotelService.createWithImage(hotel);
            successMsg.setText("L'hotel a été ajouté avec succès");
        } catch (SQLException ex) {
            Logger.getLogger(AddHotelController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void selectImage(ActionEvent event){
        String path="";
        path = UploadImage.selectImage(event,path);
        imgPath.setText(path);
    }
    
    public void backToList(ActionEvent event) throws IOException{
        Navigator.goToView(getClass(), event,hotelsPane,"../List/HotelsList.fxml");
    }
    
}
