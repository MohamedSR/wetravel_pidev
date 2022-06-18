/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Views.Restaurants.List;

import Repositories.RestaurantCrudImpl;
import Services.RestaurantService;
import Utils.DataSource;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import Entities.Restaurant;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author m.rhouma
 */
public class RestaurantsListController implements Initializable {
    @FXML
    private TableView restaurantsList;
    private ArrayList<Restaurant> restaurant =  new ArrayList() ;
    RestaurantCrudImpl rcrud = new RestaurantCrudImpl(DataSource.getInstance().getCon());
    RestaurantService restaurantService = new RestaurantService(rcrud);
    @FXML
    private TableColumn<Restaurant, String> nameCol;
    @FXML
    private TableColumn<Restaurant, String> paysCol;
    @FXML
    private TableColumn<Restaurant, String> villeCol;
    @FXML
    private TableColumn<Restaurant, String> capacityCol;
    @FXML
    private TableColumn<Restaurant, Void> actionCol;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            nameCol.setCellValueFactory(new PropertyValueFactory<Restaurant, String>("name"));
            paysCol.setCellValueFactory(new PropertyValueFactory<Restaurant, String>("pays"));
            villeCol.setCellValueFactory(new PropertyValueFactory<Restaurant, String>("ville"));
            capacityCol.setCellValueFactory(new PropertyValueFactory<Restaurant, String>("capacity"));
            restaurant = restaurantService.findAllRestaurants();
            ObservableList<Restaurant> data = FXCollections.<Restaurant>observableArrayList();
            data.addAll(restaurant);
            restaurantsList.setItems(data);
            actionCol.setCellFactory(param->new TableCell<Restaurant,Void>(){
                private final Button editButton = new Button("edit");
                private final Button deleteButton = new Button("delete");
            });

        } catch (Exception e) {
        }
    }    
    
}
