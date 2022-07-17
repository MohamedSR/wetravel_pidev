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
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;



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
        import javafx.scene.control.*;
        import javafx.scene.layout.AnchorPane;
        import javafx.stage.Stage;
        import javafx.scene.control.Alert.AlertType;
        import java.io.IOException;
        import java.net.URL;
        import java.sql.Date;
        import java.sql.SQLException;
        import java.text.ParseException;
        import java.text.SimpleDateFormat;
        import java.util.Calendar;
        import java.util.ResourceBundle;
        import java.util.logging.Level;
        import java.util.logging.Logger;

        import javafx.scene.layout.HBox;
        import javafx.stage.Stage;
        import javafx.scene.paint.Color;
        import javafx.scene.text.Font;
        import javafx.scene.text.FontPosture;
        import javafx.scene.text.FontWeight;
        import javafx.scene.text.Text;

public class EventDeleteController extends Application implements Initializable {

    @FXML
    private TextField nomEvent;
    @FXML
    private AnchorPane deleteEventPane;


    EventCrudImpl eventCrud = new EventCrudImpl(DataSource.getInstance().getCon());
    EventService eventService = new EventService(eventCrud);

    @Override
    public void initialize(URL url, ResourceBundle rb) {


        // TODO
    }





    public void supprimerEvent(ActionEvent e) throws ParseException {
        //Creating a dialog
        Dialog<String> dialog = new Dialog<String>();
        //Setting the title
        dialog.setTitle("Erreur");
        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        //Setting the content of the dialog
        dialog.setContentText("verifier votre saisie !");
        //Adding buttons to the dialog pane
        dialog.getDialogPane().getButtonTypes().add(type);
        //Setting the label
        Text txt = new Text("Click the button to show the dialog");
        Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12);
        txt.setFont(font);


        try {
            eventService.deleteEvent(nomEvent.getText());
            System.out.println("goooooooooooooooood");
            switchToHome(e);

        } catch (SQLException | IOException ex) {
            //err.setText("verifier votre saisie !");
            //showAlertWithHeaderText();
            dialog.showAndWait();

            Logger.getLogger(EventController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }



    private void showAlertWithHeaderText() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("erreur");
        alert.setHeaderText("erreur:");
        alert.setContentText("verifier votre saisie !");

        alert.showAndWait();
    }

    public void switchToHome(ActionEvent event) throws IOException {
        Navigator.goToView(getClass(), event, deleteEventPane, "./EventList.fxml");
    }

    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("EventDelete.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
