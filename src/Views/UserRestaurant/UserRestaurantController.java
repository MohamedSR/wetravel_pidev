/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Views.UserRestaurant;

import Entities.Restaurant;
import Repositories.RestaurantCrudImpl;
import Services.RestaurantService;
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

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UserRestaurantController implements Initializable {

    @FXML
    private ImageView getRestimg;
    @FXML
    private ImageView imageView;
    @FXML
    private ImageView restimg;
    @FXML
    private TextFlow Restaurant;
    @FXML
    private TextFlow Restaurant1;
    @FXML
    private TextFlow Restaurant2;
    @FXML
    private Pane pane;


    Entities.Restaurant restaurant = new Restaurant();
    RestaurantCrudImpl restaurantCrud = new RestaurantCrudImpl(DataSource.getInstance().getCon());
    RestaurantService restaurantService = new RestaurantService(restaurantCrud);
    List<Restaurant> restaurantList = restaurantService.findAllRestaurants();
    Object[] restos = restaurantList.toArray();
    final String HOME_VIEW = "../UserHome/UserHome.fxml";
    final String HOTEL_VIEW = "../UserHotel/UserHotel.fxml";
    final String EVENT_VIEW = "../UserEvent/UserEvent.fxml";

    public UserRestaurantController() throws SQLException {
    }


    public void start(Stage stage) throws Exception {
        Pagination pagination = new Pagination(restos.length/3, 0);
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
        Scene scene = new Scene(anchor, 400, 450);
        stage.setScene(scene);
        stage.setTitle("PaginationSample");
        stage.show();
    }

    public VBox createPage(int pageIndex) throws SQLException {
        VBox box = new VBox(5);
        int page = pageIndex * 3+1;
        for (int i = page; i < page + 3; i++) {
            restaurant = restaurantService.findRestaurants(i);
            Label font = new Label(restaurant.toString());

            String link="File:"+restaurant.getImage();
            Image rest = new Image(link);
            ImageView hotelimg = new ImageView(rest);
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
            // TODO service that returns array contains ids of first and last restaurant
            int id = getRandomNumberUsingNextInt(1,7);
            restaurant = restaurantService.findRestaurants(id);
            Text textR = new Text(restaurant.toString());
            Restaurant.getChildren().add(textR);
            String link=restaurant.getImage();
            File file = new File(link);
            String localUrl = file.toURI().toURL().toString();
            Image rest = new Image(localUrl);
            restimg = new ImageView(rest);
            restimg.setFitHeight(150);
            restimg.setFitWidth(150);
            restimg.setSmooth(true);
            restimg.setLayoutX(1);
            restimg.setLayoutY(1);
            restimg.setCache(true);
            pane.getChildren().add(restimg);

            int id1 = getRandomNumberUsingNextInt(1,7);

            while (id1==id){
                id1 = getRandomNumberUsingNextInt(1,7);
            }
            restaurant = restaurantService.findRestaurants(id1);
            textR = new Text(restaurant.toString());
            Restaurant1.getChildren().add(textR);
            link=restaurant.getImage();
            file = new File(link);
            localUrl = file.toURI().toURL().toString();
            Image rest1 = new Image(localUrl);
            getRestimg = new ImageView(rest1);
            getRestimg.setFitHeight(150);
            getRestimg.setFitWidth(150);
            getRestimg.setLayoutX(1);
            getRestimg.setLayoutY(150);
            getRestimg.setSmooth(true);
            getRestimg.setCache(true);
            pane.getChildren().add(getRestimg);
            int id2 = getRandomNumberUsingNextInt(1,7);

            while (id2==id){
                id2 = getRandomNumberUsingNextInt(1,7);
            }

            restaurant = restaurantService.findRestaurants(id2);
            textR = new Text(restaurant.toString());
            Restaurant2.getChildren().add(textR);
            link=restaurant.getImage();
            file = new File(link);
            localUrl = file.toURI().toURL().toString();
            Image rest2 = new Image(localUrl);
            imageView = new ImageView(rest2);
            imageView.setFitHeight(150);
            imageView.setFitWidth(150);
            imageView.setLayoutX(1);
            imageView.setLayoutY(300);
            imageView.setSmooth(true);
            imageView.setCache(true);
            pane.getChildren().add(imageView);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (MalformedURLException ex) {
            Logger.getLogger(UserRestaurantController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public void gotoHome(ActionEvent event) throws IOException{
        this.goToView(event, HOME_VIEW);
    }
    public void goToEvent(ActionEvent event) throws IOException{
        this.goToView(event, EVENT_VIEW);
    }
    public void goToHotel(ActionEvent event) throws IOException{
        this.goToView(event, HOTEL_VIEW);
    }
    public void goToView(ActionEvent event,String view) throws IOException {
         Navigator.goToScreen(getClass(), event, view);
   }
}
