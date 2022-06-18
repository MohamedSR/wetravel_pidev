package Views.Event;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
import Repositories.EventCrudImpl;
import Services.EventService;
import Utils.DataSource;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import Entities.Event;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author m.rhouma
 */
public class EventListController implements Initializable {
    @FXML
    private TableView eventList;
    private ArrayList<Event> events =  new ArrayList() ;
    EventCrudImpl ecrud = new EventCrudImpl(DataSource.getInstance().getCon());
    EventService eventService = new EventService(ecrud);
    @FXML
    private TableColumn<Event, String> nameCol;
    @FXML
    private TableColumn<Event, String> adresseCol;
    @FXML
    private TableColumn<Event, String> capacityCol;
    @FXML
    private TableColumn<Event, String> villeCol;
    @FXML
    private TableColumn<Event, String> paysCol;
    @FXML
    private TableColumn<Event, String> dateCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            nameCol.setCellValueFactory(new PropertyValueFactory<Event, String>("name"));
            adresseCol.setCellValueFactory(new PropertyValueFactory<Event, String>("adresse"));
            paysCol.setCellValueFactory(new PropertyValueFactory<Event, String>("pays"));
            villeCol.setCellValueFactory(new PropertyValueFactory<Event, String>("ville"));
            capacityCol.setCellValueFactory(new PropertyValueFactory<Event, String>("capacity"));
            dateCol.setCellValueFactory(new PropertyValueFactory<Event, String>("date"));
            events = eventService.getAllEvents();
            ObservableList<Event> data = FXCollections.<Event>observableArrayList();
            data.addAll(events);
            for (int i = 0; i < events.size();i++)
            {
                System.out.println(events.get(i).getName());
            }               eventList.setItems(data);

        } catch (Exception e) {
        }
    }

}

