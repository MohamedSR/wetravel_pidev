package Views.Event;

import Entities.Event;
import Repositories.EventCrudImpl;
import Services.EventService;
import Utils.DataSource;
import Utils.Navigator;
import Utils.UploadImage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EventController extends Application implements Initializable {

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
    private Label err;
    @FXML
    private AnchorPane addEventPane;
    @FXML
    private Button imgInput;

    @FXML
    private Label imgPath;

    EventCrudImpl eventCrud = new EventCrudImpl(DataSource.getInstance().getCon());
    EventService eventService = new EventService(eventCrud);

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void onClickAjouterEvent(ActionEvent e) {

        //Date date = Date.valueOf(dateEvent.getText());
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        int capacit = Integer.parseInt(capaciteEvent.getText());
        Event event = new Event(nomEvent.getText(), adresseEvent.getText(), capacit, villeEvent.getText(), paysEvent.getText(), date
        ,imgPath.getText());

        try {
            eventService.createEventWithImage(event);
            System.out.println("goooooooooooooooood");
            switchToHome(e);

        } catch (SQLException | IOException ex) {
            err.setText("verifier votre saisie !");
            Logger.getLogger(EventController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void selectImage(ActionEvent event){
        String path="";
        path = UploadImage.selectImage(event,path);
        imgPath.setText(path);
    }

    public void switchToHome(ActionEvent event) throws IOException {
        Navigator.goToView(getClass(), event, addEventPane, "./EventList.fxml");
    }

    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Event.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
