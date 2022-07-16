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
import Views.Restaurants.List.RestaurantsListController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


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
    @FXML
    private AnchorPane usersPane;
    @FXML
    private TableColumn actionsCol;

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

            Callback<TableColumn<User, String>, TableCell<User, String>> cellFactory = (param) -> {
                final TableCell<User, String> cell = new TableCell<User, String>() {
                    @Override
                    public void updateItem(String u, boolean empty) {
                        super.updateItem(u, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            final Button editBtn = new Button("Edit");
                            editBtn.setOnAction(ae -> {
                                User us = getTableView().getItems().get(getIndex());
                                try {
                                    Navigator.goToUpdateUserScreen(getClass(), ae, usersPane, "../Update/UpdateUser.fxml", us);
                                } catch (IOException ex) {
                                    Logger.getLogger(UserListController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            });

                            final Button deleteBtn = new Button("Supprimer");
                            deleteBtn.setOnAction(ae -> {
                                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Êtes-vous sûr?", ButtonType.YES, ButtonType.CANCEL);
                                alert.showAndWait();

                                if (alert.getResult() == ButtonType.YES) {
                                    User us = getTableView().getItems().get(getIndex());
                                    try {
                                        userService.delete(us.getId());
                                        getTableView().getItems().remove(us);

                                    } catch (SQLException ex) {
                                        Logger.getLogger(RestaurantsListController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            });
                            HBox pane = new HBox(deleteBtn, editBtn);
                            setGraphic(pane);
                            setText(null);
                        }

                    }
                };
                return cell;
            };
            actionsCol.setCellFactory(cellFactory);
            try {
                users = userService.getAll();
            } catch (SQLException ex) {
                Logger.getLogger(UserListController.class.getName()).log(Level.SEVERE, null, ex);
            }
            ObservableList<User> data = FXCollections.<User>observableArrayList();
            data.addAll(users);
            UserList.setItems(data);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void goToAddUser(ActionEvent event) throws IOException{
        Navigator.goToView(getClass(), event,usersPane,"../Add/AddUser.fxml");
    }
}
