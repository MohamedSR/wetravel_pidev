/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Views.Restaurants.Add;

import Entities.Restaurant;
import Repositories.RestaurantCrudImpl;
import Services.RestaurantService;
import Utils.DataSource;
import Utils.Navigator;
import Utils.UploadImage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
    @FXML
    private Label successMsg;
    @FXML
    private Label errMsg;
    @FXML
    private Button addRestaurantBtn;
    @FXML
    private Button backToListBtn;
    @FXML
    private AnchorPane addRestaurantPane;
    @FXML
    private Button imgInput;
    
    @FXML
    private Label imgPath;
    @FXML
    private boolean  validated;
    
    RestaurantCrudImpl rcrud = new RestaurantCrudImpl(DataSource.getInstance().getCon());
    RestaurantService restaurantService = new RestaurantService(rcrud);

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SpinnerValueFactory<Integer> valueFactory= new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 500, 0);
        capacity.setValueFactory(valueFactory);
    }


        public void selectImage(ActionEvent event){
            String path="";
            path = UploadImage.selectImage(event,path);
            imgPath.setText(path);

        }
    public void addRestaurant(){
        Restaurant restaurant= new Restaurant(capacity.getValue(),addresse.getText(),ville.getText(),city.getText(),name.getText(),imgPath.getText());
        if(!restaurant.isValid()){
            errMsg.setText("Veuillez compléter les informations manquantes");
        }else{
            try {
            addRestaurantBtn.setDisable(true);
            backToListBtn.setDisable(true);
            restaurantService.createRestaurantWithImage(restaurant);
            successMsg.setText("Le restaurant a été ajouté avec succès");
            addRestaurantBtn.setDisable(false);
            backToListBtn.setDisable(false);
        } catch (SQLException ex) {
            addRestaurantBtn.setDisable(false);
            backToListBtn.setDisable(false);
            Logger.getLogger(AddRestaurantController.class.getName()).log(Level.SEVERE, null, ex);
            errMsg.setText("Une erreur a été rencontré lors de l'ajout");
        }
        }
    }    
    
    public void backToList(ActionEvent event) throws IOException{
        Navigator.goToView(getClass(), event,addRestaurantPane,"../List/RestaurantsList.fxml");
    }
    
}
