/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Views.User.Add;


import Repositories.UserCrudImpl;
import Services.UserService;
import Entities.User;
import Utils.DataSource;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * FXML Controller class
 *
 * @author m.rhouma
 */
public class AddUserController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private ComboBox<String> Role;

    @FXML
    private TextField Email;
    @FXML
    private TextField Password;
    @FXML
    private TextField Phone;
    
    UserCrudImpl userCrud = new UserCrudImpl(DataSource.getInstance().getCon());
    UserService userService = new UserService(userCrud);
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void addUser(){
        User user= new User(name.getText(),"Admin",Email.getText(),Password.getText(),Phone.getText());
        try {
            userService.create(user);
        } catch (SQLException ex) {
            Logger.getLogger(AddUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
