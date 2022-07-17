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
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
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
    List<Event> eventList = eventService.getAllEvents();
    Object[] events = eventList.toArray();

    public UserEventController() throws SQLException {
    }


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
         Pagination pagination = new Pagination(events.length/3, 0);
         pagination.setStyle("-fx-border-color:red;");
         pagination.setPageFactory(new Callback<Integer, Node>() {

             @Override
             public Node call(Integer pageIndex) {
                 try {
                     return createPage(pageIndex);
                 } catch (SQLException e) {
                     throw new RuntimeException(e);
                 }
             }
         });

         AnchorPane anchor = new AnchorPane();
         AnchorPane.setTopAnchor(pagination, 10.0);
         AnchorPane.setRightAnchor(pagination, 10.0);
         AnchorPane.setBottomAnchor(pagination, 10.0);
         AnchorPane.setLeftAnchor(pagination, 10.0);
         anchor.getChildren().addAll(pagination);
         Scene scene = new Scene(anchor, 720, 480);
         stage.setScene(scene);
         stage.setTitle("PaginationSample");
         stage.show();
     }

    public VBox createPage(int pageIndex) throws SQLException {
        VBox box = new VBox(5);
        int page = pageIndex * 3+1;
        for (int i = page; i < page + 3; i++) {
            event = eventService.getEvent(i);
            Label font = new Label(event.toString());

            String link="File:"+event.getImage();
            Image ev = new Image(link);
            ImageView hotelimg = new ImageView(ev);
            hotelimg.setFitHeight(150);
            hotelimg.setFitWidth(150);
            hotelimg.setSmooth(true);
            hotelimg.setLayoutX(1);
            hotelimg.setLayoutY(1);
            hotelimg.setCache(true);
            box.getChildren().add(font);
            box.getChildren().add(hotelimg);
        }
        return box;
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
