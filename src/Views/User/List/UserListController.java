/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Views.User.List;

import Entities.User;
import Repositories.UserCrudImpl;
import Services.UserService;
import Utils.DataSource;
import Utils.Navigator;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;


public class UserListController implements Initializable {
    @FXML
    private TableView UserList;
    private ArrayList<User> users =  new ArrayList() ;
    UserCrudImpl userCrud = new UserCrudImpl(DataSource.getInstance().getCon());
    UserService userService = new UserService(userCrud);
    @FXML
    private TableColumn<User, String> nameCol;
    @FXML
    private TableColumn<User, String> roleCol;
    @FXML
    private TableColumn<User, String> emailCol;
    @FXML
    private TableColumn<User, String> phoneCol;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            nameCol.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
            roleCol.setCellValueFactory(new PropertyValueFactory<User, String>("role"));
            emailCol.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
            phoneCol.setCellValueFactory(new PropertyValueFactory<User, String>("phone"));
            users = userService.getAll();
            ObservableList<User> data = FXCollections.<User>observableArrayList();
            data.addAll(users);
            UserList.setItems(data);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }    
    public void backToHome(ActionEvent event) throws IOException{
        Navigator.goToView(getClass(), event,"../../Home/Home.fxml");
    }
    public void goToAddUser(ActionEvent event) throws IOException{
        Navigator.goToView(getClass(), event,"../Add/AddUser.fxml");
    }
}
