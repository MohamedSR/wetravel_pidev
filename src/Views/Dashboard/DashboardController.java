package Views.Dashboard;

import Entities.EventStat;
import Repositories.EventCrudImpl;
import Services.EventService;
import Utils.DataSource;
import Views.Event.EventController;
import java.net.URL;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class DashboardController extends Application implements Initializable {

    EventCrudImpl eventCrud = new EventCrudImpl(DataSource.getInstance().getCon());
    EventService eventService = new EventService(eventCrud);
    public ArrayList<EventStat> events = new ArrayList();

    @FXML
    private AnchorPane statsPane;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            events = eventService.findEventsParPays();
            for (int i = 0; i < events.size(); i++) {
                System.out.println(events.get(i).getTotal());
            }
            System.out.println("goooooooooooooooood");

        } catch (SQLException ex) {
            System.out.println("errorrrrr");
            Logger.getLogger(EventController.class.getName()).log(Level.SEVERE, null, ex);
        }
        PieChart pieChart = new PieChart();
        for (int i = 0; i < events.size(); i++) {
            System.out.println(events.get(i).getTotal());
            PieChart.Data slice = new PieChart.Data(events.get(i).getPays(), events.get(i).getTotal());
            pieChart.getData().add(slice);

        }

        pieChart.setLegendSide(Side.LEFT);

        final Label caption = new Label("");
        caption.setTextFill(Color.WHITE);
        caption.setStyle("-fx-font: 12 arial;");

        for (final PieChart.Data data : pieChart.getData()) {
            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    caption.setTranslateX(e.getSceneX());
                    caption.setTranslateY(e.getSceneY());

                    caption.setText(String.valueOf(data.getPieValue()));
                }
            });
        }
        statsPane.getChildren().addAll(pieChart, caption);
    }
}
