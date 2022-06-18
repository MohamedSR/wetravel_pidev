/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Views.hotel.List;

import Entities.Hotel;
import Repositories.RestaurantCrudImpl;
import Services.HotelsService;
import Services.RestaurantService;
import Utils.DataSource;
import Views.hotel.List.Entities.Restaurant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author m.rhouma
 */
public class HotelsListController implements Initializable {
    @FXML
    private TableView restaurantsList;
    private ArrayList<Hotel> restaurant =  new ArrayList() ;
    RestaurantCrudImpl rcrud = new RestaurantCrudImpl(DataSource.getInstance().getCon());
    RestaurantService restaurantService = new RestaurantService(rcrud);
    @FXML
    private TableColumn<Hotel, String> nameCol;
    @FXML
    private TableColumn<Hotel, Integer> starsCol;
    @FXML
    private TableColumn<Hotel, String> capacityCol;
    @FXML
    private TableColumn<Hotel, String> adresseCol;
    @FXML
    private TableColumn<Hotel, String> paysCol;
    @FXML
    private TableColumn<Hotel, String> villeCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public <hotel> void initialize(URL url, ResourceBundle rb) {
        try {
            nameCol.setCellValueFactory(new PropertyValueFactory<Hotel, String>("name"));
            starsCol.setCellValueFactory(new PropertyValueFactory<Hotel, Integer>("stars"));
            capacityCol.setCellValueFactory(new PropertyValueFactory<Hotel, String>("capacity"));
            adresseCol.setCellValueFactory(new PropertyValueFactory<Hotel, String>("adresse"));
            paysCol.setCellValueFactory(new PropertyValueFactory<Hotel, String>("pays"));
            villeCol.setCellValueFactory(new PropertyValueFactory<Hotel, String>("ville"));
            hotel hotel = HotelsService.findAllHotels();
            ObservableList<hotel> data = FXCollections.<hotel>observableArrayList();
            data.addAll(hotel);
            restaurantsList.setItems(data);

        } catch (Exception e) {
        }
    }    
    
}
