/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Views.UserEvent;

import Entities.Event;
import Repositories.EventCrudImpl;
import Services.EventService;
import Utils.DataSource;
import Utils.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;


public class UserEventController implements Initializable {

    @FXML
    private TextFlow Event;
    @FXML
    private TextFlow Event1;
    @FXML
    private TextFlow Event2;
    @FXML
    private Pane pane;
    @FXML
    private ImageView eventimg;
    @FXML
    private ImageView eventimg1;
    @FXML
    private ImageView eventimg2;
    Entities.Event event =new Event();
    EventCrudImpl eventCrud = new EventCrudImpl(DataSource.getInstance().getCon());
    EventService eventService = new EventService(eventCrud);
    final String HOME_VIEW = "../UserHome/UserHome.fxml";
    final String RESTAURANT_VIEW = "../UserRestaurant/UserRestaurant.fxml";
    final String HOTEL_VIEW = "../UserHotel/UserHotel.fxml";


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            int id = getRandomNumberUsingNextInt(1,6);
            event = eventService.getEvent(id);
            Text textR = new Text(event.toString());
            Event.getChildren().add(textR);
            String link="File:"+event.getImage();
            Image rest = new Image(link);
            eventimg = new ImageView(rest);
            eventimg.setFitHeight(150);
            eventimg.setFitWidth(150);
            eventimg.setSmooth(true);
            eventimg.setLayoutX(1);
            eventimg.setLayoutY(1);
            eventimg.setCache(true);
            pane.getChildren().add(eventimg);

            int id1 = getRandomNumberUsingNextInt(1,6);

            while (id1==id){
                id1 = getRandomNumberUsingNextInt(1,6);
            }
            event = eventService.getEvent(id1);
            textR = new Text(event.toString());
            Event1.getChildren().add(textR);
            link="File:"+event.getImage();
            Image rest1 = new Image(link);
            eventimg1 = new ImageView(rest1);
            eventimg1.setFitHeight(150);
            eventimg1.setFitWidth(150);
            eventimg1.setSmooth(true);
            eventimg1.setLayoutX(1);
            eventimg1.setLayoutY(150);
            eventimg1.setCache(true);
            pane.getChildren().add(eventimg1);
            int id2 = getRandomNumberUsingNextInt(1,6);

            while (id2==id){
                id2 = getRandomNumberUsingNextInt(1,6);
            }

            event = eventService.getEvent(id2);
            textR = new Text(event.toString());
            Event2.getChildren().add(textR);
            link="File:"+event.getImage();
            Image rest2 = new Image(link);
            eventimg2 = new ImageView(rest2);
            eventimg2.setFitHeight(150);
            eventimg2.setFitWidth(150);
            eventimg2.setSmooth(true);
            eventimg2.setLayoutX(1);
            eventimg2.setLayoutY(300);
            eventimg2.setCache(true);
            pane.getChildren().add(eventimg2);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
     public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("UserEvent.fxml"));
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }
    public void gotoRestaurant(ActionEvent event) throws IOException{
        this.goToView(event, RESTAURANT_VIEW);
    }
    public void goToHome(ActionEvent event) throws IOException{
        this.goToView(event, HOME_VIEW);
    }
    public void goToHotel(ActionEvent event) throws IOException{
        this.goToView(event, HOTEL_VIEW);
    }
    public void goToView(ActionEvent event,String view) throws IOException {
         Navigator.goToScreen(getClass(), event, view);
   }
}
