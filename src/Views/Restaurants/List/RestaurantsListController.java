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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author m.rhouma
 */
public class RestaurantsListController implements Initializable {

    @FXML
    private TableView restaurantsList;
    private ArrayList<Restaurant> restaurant = new ArrayList();
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
    private TableColumn actionsCol;
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
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        paysCol.setCellValueFactory(new PropertyValueFactory<>("pays"));
        villeCol.setCellValueFactory(new PropertyValueFactory<>("ville"));
        capacityCol.setCellValueFactory(new PropertyValueFactory<>("capacity"));

        Callback<TableColumn<Restaurant, String>, TableCell<Restaurant, String>> cellFactory = (param) -> {
            final TableCell<Restaurant, String> cell = new TableCell<Restaurant, String>() {
                @Override
                public void updateItem(String r, boolean empty) {
                    super.updateItem(r, empty);
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        final Button editBtn = new Button("Editer");
                        editBtn.getStyleClass().addAll("btn","btn_yellow");
                        editBtn.setOnAction(ae -> {
                            Restaurant rst = getTableView().getItems().get(getIndex());
                            try {
                                Navigator.goToUpdateRestaurantScreen(getClass(), ae, restaurantsPane, "../Update/UpdateRestaurant.fxml", rst);
                            } catch (IOException ex) {
                                Logger.getLogger(RestaurantsListController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        });

                        final Button deleteBtn = new Button("Supprimer");
                        deleteBtn.getStyleClass().addAll("btn","btn_red");
                        deleteBtn.setOnAction(ae -> {
                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Êtes-vous sûr?", ButtonType.YES, ButtonType.CANCEL);
                            alert.showAndWait();

                            if (alert.getResult() == ButtonType.YES) {
                                Restaurant rst = getTableView().getItems().get(getIndex());
                                try {
                                    restaurantService.deleteRestaurants(rst.getId());
                                    getTableView().getItems().remove(rst);

                                } catch (SQLException ex) {
                                    Logger.getLogger(RestaurantsListController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        });
                        HBox pane = new HBox(deleteBtn, editBtn);
                        setGraphic(pane);
                        setText(null);
                    }

                }
            };
            return cell;
        };
        actionsCol.setCellFactory(cellFactory);
        try {
            restaurant = restaurantService.findAllRestaurants();
        } catch (SQLException ex) {
            Logger.getLogger(RestaurantsListController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObservableList<Restaurant> data = FXCollections.<Restaurant>observableArrayList();
        data.addAll(restaurant);
        restaurantsList.setItems(data);
    }

    public void goToAddRestaurant(ActionEvent event) throws IOException {
        Navigator.goToView(getClass(), event, restaurantsPane, "../Add/AddRestaurant.fxml");
    }

    public void genertePDF() {
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
