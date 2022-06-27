/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Views.Login;

import Exceptions.FailedLoginExecption;
import Exceptions.UserNotAuzorithedException;
import Repositories.UserCrudImpl;
import Services.UserService;
import Entities.User;
import Utils.DataSource;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author m.rhouma
 */
public class LoginController extends Application {
    
    private Stage stage;
    private Scene scene;
    
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private Label err;
    
    UserCrudImpl uscrud = new UserCrudImpl(DataSource.getInstance().getCon());
    private final UserService userService = new UserService(uscrud);
    
    public LoginController(){}
    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) {
       
    }

    public void login(ActionEvent event) throws IOException {
        try {
           User user = userService.login(email.getText(), password.getText());
            if(user.getRole().equals("ADMIN")){
                switchToHome(event);
            }
            else{
                switchToUserHome(event);
            }
        } catch (FailedLoginExecption | UserNotAuzorithedException ex) {
             err.setText(ex.getMessage());
        }       
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }
     public void switchToHome(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("../Home/Home.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(home);
        stage.setScene(scene);
        stage.show();
        }
        public void switchToUserHome(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("../UserHome/UserHome.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(home);
        stage.setScene(scene);
        stage.show();
        }
   public void switchToLogin(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("../User/Add/AddUser.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(home);
        stage.setScene(scene);
        stage.show();
   }
}
