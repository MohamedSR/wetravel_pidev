/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Views.Login;

import Repositories.UserCrudImpl;
import Services.UserService;
import Utils.DataSource;
import java.awt.Button;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

    public void login() {
        if(!userService.login(email.getText(), password.getText())){
            err.setText("Email ou mot de passe invalid");
        }else{
            System.out.println("Gooood !!");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }
}
