/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Views.UserHotel;

import Entities.Hotel;
import Repositories.HotelCrudImpl;
import Services.HotelsService;
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


public class UserHotelController implements Initializable {

    @FXML
    private ImageView hotelimg;
    @FXML
    private ImageView hotelimg1;
    @FXML
    private ImageView hotelimg2;
    @FXML
    private TextFlow Hotel;
    @FXML
    private TextFlow Hotel1;
    @FXML
    private TextFlow Hotel2;
    @FXML
    private Pane pane;
    final String HOME_VIEW = "../UserHome/UserHome.fxml";
    final String RESTAURANT_VIEW = "../UserRestaurant/UserRestaurant.fxml";
    final String EVENT_VIEW = "../UserEvent/UserEvent.fxml";
    HotelCrudImpl hcrud = new HotelCrudImpl(DataSource.getInstance().getCon());
    HotelsService hotelService = new HotelsService(hcrud);
    Entities.Hotel hotel = new Hotel();

     public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("UserHotel.fxml"));
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            int id = getRandomNumberUsingNextInt(1,5);
            hotel = hotelService.get(id);
            Text textR = new Text(hotel.toString());
            Hotel.getChildren().add(textR);
            String link="@../../assets/"+hotel.getName()+".PNG";
            Image rest = new Image(link);
            hotelimg = new ImageView(rest);
            pane.getChildren().add(hotelimg);

            int id1 = getRandomNumberUsingNextInt(1,5);

            while (id1==id){
                id1 = getRandomNumberUsingNextInt(1,5);
            }
            hotel = hotelService.get(id1);
            textR = new Text(hotel.toString());
            Hotel1.getChildren().add(textR);
            link="@../../assets/"+hotel.getName()+".PNG";
            Image rest1 = new Image(link);
            hotelimg1 = new ImageView(rest1);
            pane.getChildren().add(hotelimg1);
            int id2 = getRandomNumberUsingNextInt(1,5);

            while (id2==id){
                id2 = getRandomNumberUsingNextInt(1,5);
            }

            hotel = hotelService.get(id2);
            textR = new Text(hotel.toString());
            Hotel2.getChildren().add(textR);
            link="@../../assets/"+hotel.getName()+".PNG";
            Image rest2 = new Image(link);
            hotelimg2 = new ImageView(rest2);
            pane.getChildren().add(hotelimg2);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
    public void gotoRestaurant(ActionEvent event) throws IOException{
        this.goToView(event, RESTAURANT_VIEW);
    }
    public void goToEvent(ActionEvent event) throws IOException{
        this.goToView(event, EVENT_VIEW);
    }
    public void goToHome(ActionEvent event) throws IOException{
        this.goToView(event, HOME_VIEW);
    }
    public void goToView(ActionEvent event,String view) throws IOException {
         Navigator.goToView(getClass(), event, view);
   }
}
