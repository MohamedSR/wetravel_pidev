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
import Utils.Navigator;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import java.io.File;

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
        FileChooser fileChooser = new FileChooser();
         //Set extension filter
        FileChooser.ExtensionFilter extFilterJPG
                = new FileChooser.ExtensionFilter("JPG files (*.JPG)", "*.JPG");
        FileChooser.ExtensionFilter extFilterjpg
                = new FileChooser.ExtensionFilter("jpg files (*.jpg)", "*.jpg");
        FileChooser.ExtensionFilter extFilterPNG
                = new FileChooser.ExtensionFilter("PNG files (*.PNG)", "*.PNG");
        FileChooser.ExtensionFilter extFilterpng
                = new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
        fileChooser.getExtensionFilters()
                .addAll(extFilterJPG, extFilterjpg, extFilterPNG, extFilterpng);
        //Show open file dialog
        File file = fileChooser.showOpenDialog(null);
        imgPath.setText(file.getAbsolutePath());
    }
    public void addRestaurant(){
        Restaurant restaurant= new Restaurant(capacity.getValue(),addresse.getText(),ville.getText(),city.getText(),name.getText(),imgPath.getText());
        try {
            addRestaurantBtn.setDisable(true);
            backToListBtn.setDisable(true);
            restaurantService.createRestaurant(restaurant);
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
    
    public void backToList(ActionEvent event) throws IOException{
        Navigator.goToView(getClass(), event,addRestaurantPane,"../List/RestaurantsList.fxml");
    }
    
}
