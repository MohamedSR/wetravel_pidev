package Views.Event;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
import Repositories.EventCrudImpl;
import Services.EventService;
import Utils.DataSource;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import Entities.Event;
import Utils.Navigator;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    @FXML
    private AnchorPane eventsPane;
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

    public void AjouterEvent(ActionEvent event) throws IOException {
        switchToEventAjout(event);
    }

    public void switchToEventAjout(ActionEvent event) throws IOException {

        Navigator.goToView(getClass(), event,eventsPane,"./Event.fxml");
    }
}

