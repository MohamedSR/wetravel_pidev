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
    List<Hotel> hotelList = hotelService.findAllHotels();
    Object[] hotels = hotelList.toArray();

    public UserHotelController() throws SQLException {
    }

    public void start(Stage stage) throws Exception {
         Pagination pagination = new Pagination(hotels.length/3, 0);
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
            hotel = hotelService.get(i);
            Label font = new Label(hotel.toString());

            String link="File:"+hotel.getImage();
            Image hotl = new Image(link);
            ImageView hotelimg = new ImageView(hotl);
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            int id = getRandomNumberUsingNextInt(1,5);
            hotel = hotelService.get(id);
            Text textR = new Text(hotel.toString());
            Hotel.getChildren().add(textR);
            String link="File:"+hotel.getImage();
            Image rest = new Image(link);
            hotelimg = new ImageView(rest);
            hotelimg.setFitHeight(150);
            hotelimg.setFitWidth(150);
            hotelimg.setSmooth(true);
            hotelimg.setLayoutX(1);
            hotelimg.setLayoutY(1);
            hotelimg.setCache(true);
            pane.getChildren().add(hotelimg);

            int id1 = getRandomNumberUsingNextInt(1,5);

            while (id1==id){
                id1 = getRandomNumberUsingNextInt(1,5);
            }
            hotel = hotelService.get(id1);
            textR = new Text(hotel.toString());
            Hotel1.getChildren().add(textR);
            link="File:"+hotel.getImage();
            Image rest1 = new Image(link);
            hotelimg1 = new ImageView(rest1);
            hotelimg1.setFitHeight(150);
            hotelimg1.setFitWidth(150);
            hotelimg1.setSmooth(true);
            hotelimg1.setLayoutX(1);
            hotelimg1.setLayoutY(150);
            hotelimg1.setCache(true);
            pane.getChildren().add(hotelimg1);
            int id2 = getRandomNumberUsingNextInt(1,5);

            while (id2==id){
                id2 = getRandomNumberUsingNextInt(1,5);
            }

            hotel = hotelService.get(id2);
            textR = new Text(hotel.toString());
            Hotel2.getChildren().add(textR);
            link="File:"+hotel.getImage();
            Image rest2 = new Image(link);
            hotelimg2 = new ImageView(rest2);
            hotelimg2.setFitHeight(150);
            hotelimg2.setFitWidth(150);
            hotelimg2.setSmooth(true);
            hotelimg2.setLayoutX(1);
            hotelimg2.setLayoutY(300);
            hotelimg2.setCache(true);
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
         Navigator.goToScreen(getClass(), event, view);
   }
}
