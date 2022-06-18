package Views.hotel;


import Entities.Hotel;
import Repositories.HotelCrudImpl;
import Services.EventService;
import Services.HotelsService;
import Utils.DataSource;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class HotelView extends Application {
    DataSource ds = DataSource.getInstance();
    HotelCrudImpl hotelCrud = new HotelCrudImpl(ds.getCon());
    HotelsService hotelService = new HotelsService(hotelCrud);
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Hotel.fxml"));
         ArrayList<Hotel> hotels = hotelService.getAll();
        primaryStage.setTitle(hotels.get(0).getName().toString());

        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void login(ActionEvent actionEvent) {
    }
}
