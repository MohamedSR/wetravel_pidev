/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Views.Restaurants.Update;

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
public class UpdateRestaurantController implements Initializable {

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
    private Button updateRestaurantBtn;
    @FXML
    private Button backToListBtn;
    @FXML
    private AnchorPane updateRestaurantPane;
    @FXML
    private Button imgInput;
    
    @FXML
    private Label imgPath;

    private Restaurant restaurant;
    RestaurantCrudImpl rcrud = new RestaurantCrudImpl(DataSource.getInstance().getCon());
    RestaurantService restaurantService = new RestaurantService(rcrud);
    
    
    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    public void initData(Restaurant restaurant){
        this.setRestaurant(restaurant);
        SpinnerValueFactory<Integer> valueFactory= new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 500, restaurant.getCapacity());
        capacity.setValueFactory(valueFactory);
        addresse.setText(restaurant.getAdresse());
        ville.setText(restaurant.getVille());
        city.setText(restaurant.getPays());
        name.setText(restaurant.getName());
        imgPath.setText(restaurant.getImage());
    }

        public void selectImage(ActionEvent event){
            String path="";
            path = UploadImage.selectImage(event,path);
            imgPath.setText(path);

        }

    public void updateRestaurant(){
        try {
            restaurant.setAdresse(addresse.getText());
            restaurant.setCapacity(capacity.getValue());
            restaurant.setVille(ville.getText());
            restaurant.setPays(city.getText());
            restaurant.setName(name.getText());
            restaurant.setImage(imgPath.getText());
            
            updateRestaurantBtn.setDisable(true);
            backToListBtn.setDisable(true);
            System.out.println("id: "+restaurant);
            restaurantService.updateRestaurants(restaurant.getId(),restaurant);
            successMsg.setText("Le restaurant a été modifié avec succès");
            updateRestaurantBtn.setDisable(false);
            backToListBtn.setDisable(false);
        } catch (SQLException ex) {
            updateRestaurantBtn.setDisable(false);
            backToListBtn.setDisable(false);
            Logger.getLogger(UpdateRestaurantController.class.getName()).log(Level.SEVERE, null, ex);
            errMsg.setText("Une erreur a été rencontré lors de l'ajout");
        }
    }    
    
    public void backToList(ActionEvent event) throws IOException{
        Navigator.goToView(getClass(), event,updateRestaurantPane,"../List/RestaurantsList.fxml");
    }
    
}
