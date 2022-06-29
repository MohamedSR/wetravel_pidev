package Views.Dashboard;
import Entities.Event;
import Entities.EventStat;
import Repositories.EventCrudImpl;
import Services.EventService;
import Utils.DataSource;
import Views.Event.EventController;
import javafx.application.Application;
        import javafx.geometry.Side;
        import javafx.scene.Scene;
        import javafx.scene.chart.PieChart;
        import javafx.scene.layout.StackPane;
        import javafx.stage.Stage;
        import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DashboardController extends Application {

    EventCrudImpl eventCrud = new EventCrudImpl(DataSource.getInstance().getCon());
    EventService eventService = new EventService(eventCrud);
    public ArrayList<EventStat> events =  new ArrayList() ;


    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            events = eventService.findEventsParPays();
            for (int i = 0; i < events.size();i++)
            {
                System.out.println(events.get(i).getTotal());
            }
            System.out.println("goooooooooooooooood");

        } catch (SQLException ex) {
            System.out.println("errorrrrr");
            Logger.getLogger(EventController.class.getName()).log(Level.SEVERE, null, ex);
        }
        PieChart pieChart = new PieChart();
        for (int i = 0; i < events.size();i++)
        {
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

        primaryStage.setTitle("Statistiques");
        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(pieChart, caption);


        Scene scene = new Scene(root, 400, 200);

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
