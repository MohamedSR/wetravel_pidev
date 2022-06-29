package Views.hotel.PageHotels;

import Entities.Hotel;
import Repositories.HotelCrudImpl;
import Services.HotelsService;
import Utils.DataSource;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PageHotelsController implements Initializable {

    @FXML
    private TableView hotelsList;
    private ArrayList<Hotel> hotels =  new ArrayList() ;
    HotelCrudImpl hcrud = new HotelCrudImpl(DataSource.getInstance().getCon());
    HotelsService hotelService = new HotelsService(hcrud);
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
    @FXML
    private AnchorPane hotelsPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
            starsCol.setCellValueFactory(new PropertyValueFactory<>("stars"));
            capacityCol.setCellValueFactory(new PropertyValueFactory<>("capacity"));
            adresseCol.setCellValueFactory(new PropertyValueFactory<>("adresse"));
            paysCol.setCellValueFactory(new PropertyValueFactory<>("pays"));
            villeCol.setCellValueFactory(new PropertyValueFactory<>("ville"));
            hotels = hotelService.findAllHotels();
            ObservableList<Hotel> data = FXCollections.<Hotel>observableArrayList();
            data.addAll(hotels);
            hotelsList.setItems(data);
        } catch (SQLException e) {
        }
    }
}
