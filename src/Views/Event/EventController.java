package Views.Event;

import Entities.Event;
import Repositories.EventCrudImpl;
import Services.EventService;
import Utils.DataSource;
import Views.Restaurants.Add.AddRestaurantController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static javafx.application.Application.launch;
import javafx.application.Application;
import javafx.fxml.Initializable;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EventController extends  Application implements Initializable {
    @FXML
    private TextField nomEvent;
    @FXML
    private TextField capaciteEvent;
    @FXML
    private TextField adresseEvent;
    @FXML
    private TextField paysEvent;
    @FXML
    private TextField villeEvent;
    @FXML
    private TextField dateEvent;
    @FXML
    private Label err ;

    EventCrudImpl eventCrud = new EventCrudImpl(DataSource.getInstance().getCon());
    EventService eventService = new EventService(eventCrud);

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    public void onClickAjouterEvent() {

            //Date date = Date.valueOf(dateEvent.getText());
            java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            int capacit = Integer.parseInt(capaciteEvent.getText());
           Event event = new Event( nomEvent.getText(), adresseEvent.getText(),capacit,villeEvent.getText(),paysEvent.getText(),date
                    );

        try {
            eventService.createEvent(event);
            System.out.println("goooooooooooooooood");
        } catch (SQLException ex) {
            err.setText("verifier votre saisie !");
            Logger.getLogger(EventController.class.getName()).log(Level.SEVERE, null, ex);
        }

}
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Event.fxml"));
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
