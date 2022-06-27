/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Views.User.Add;


import Entities.SendMail;
import Entities.User;

import Entities.Restaurant;
import Repositories.UserCrudImpl;
import Services.UserService;
import Utils.DataSource;
import Utils.Navigator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author m.rhouma
 */
public class AddUserController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private ComboBox<String> roles;

    @FXML
    private TextField Email;
    @FXML
    private TextField Password;
    @FXML
    private TextField Phone;
    
    @FXML
    private Label successMsg;
    @FXML
    private Label errMsg;
    @FXML
    private AnchorPane addUserPane;
    UserCrudImpl userCrud = new UserCrudImpl(DataSource.getInstance().getCon());
    UserService userService = new UserService(userCrud);
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String roles_array[] ={ "ADMIN", "CLIENT"};
        ObservableList<String> data = FXCollections.<String>observableArrayList();
        data.addAll(roles_array);
        roles.setItems(data);
    }

    public void addUser(){
        User user= new User(name.getText(),roles.getValue(),Email.getText(),Password.getText(),Phone.getText());
        try {
            SendMail.mailing(user);
            userService.create(user);
            successMsg.setText("L'utilisateur a été ajouté avec succès");

        } catch (Exception ex) {
            errMsg.setText("Une erreur a été rencontrée lors de l'ajout");
            Logger.getLogger(AddUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    public void backToList(ActionEvent event) throws IOException{
        Navigator.goToView(getClass(), event,addUserPane,"../List/UserList.fxml");
    }
    public void backToLogin(ActionEvent event) throws IOException{
        Navigator.goToView(getClass(), event,"../../Login/Login.fxml");
    }
}
