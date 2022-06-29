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
import Utils.Navigator;
import Utils.PdfGenerator;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

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
    @FXML
    private AnchorPane restaurantsPane;
    @FXML
    private Button exportPDF;
    
    private Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);
    private Alert alertErr = new Alert(Alert.AlertType.ERROR);
    
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
        } catch (Exception e) {
        }
    }
  

    public void goToAddRestaurant(ActionEvent event) throws IOException{
        Navigator.goToView(getClass(), event,restaurantsPane,"../Add/AddRestaurant.fxml");
    }    
    public void genertePDF(){
        try {
            exportPDF.setText("Exportation en cours ...");
            exportPDF.setDisable(true);
            PdfGenerator.generateRestaurantPDF(restaurant);
            exportPDF.setDisable(false);
            alertInfo.setHeaderText("");
            alertInfo.setTitle("Info");
            exportPDF.setText("Exporter PDF");
            alertInfo.setContentText("le PDF est exporté avec succéss");
            alertInfo.showAndWait();
        } catch (FileNotFoundException ex) {
            exportPDF.setDisable(false);
            exportPDF.setText("Exporter PDF");
            
            alertErr.setHeaderText("");
            alertErr.setTitle("Erreur");
            alertErr.setContentText("Une erreur a été rencontrée lors de l'exportation de PDF");
            
            Logger.getLogger(RestaurantsListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
