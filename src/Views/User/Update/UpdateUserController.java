/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Views.User.Update;

import Entities.Restaurant;
import Entities.User;
import Repositories.RestaurantCrudImpl;
import Repositories.UserCrudImpl;
import Services.RestaurantService;
import Services.UserService;
import Utils.DataSource;
import Utils.Navigator;
import Utils.UploadImage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
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
public class UpdateUserController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private TextField Password;
    @FXML
    private TextField Email;
    @FXML
    private TextField Phone;
    @FXML
    private Label successMsg;
    @FXML
    private Label errMsg;
    @FXML
    private Button updateUserBtn;
    @FXML
    private Button backToListBtn;
    @FXML
    private AnchorPane updateUserPane;
    @FXML
    private Button imgInput;
    
    @FXML
    private Label imgPath;

    private User user;
    UserCrudImpl ucrud = new UserCrudImpl(DataSource.getInstance().getCon());
    UserService userService = new UserService(ucrud);

    public User getUser() {
        return user;
    }
    public void setUser(User user){this.user=user;}

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    public void initData(User user){
        this.setUser(user);
        Password.setText(user.getPassword());
        Phone.setText(user.getPhone());
        Email.setText(user.getEmail());
        name.setText(user.getName());
        imgPath.setText(user.getImage());
    }

        public void selectImage(ActionEvent event){
            String path="";
            path = UploadImage.selectImage(event,path);
            imgPath.setText(path);

        }

    public void updateUser(){
        try {
            user.setName(name.getText());
            user.setEmail(Email.getText());
            user.setPassword(Password.getText());
            user.setPhone(Phone.getText());
            user.setImage(imgPath.getText());
            
            updateUserBtn.setDisable(true);
            backToListBtn.setDisable(true);
            System.out.println("id: "+user);
            userService.update(user.getId(),user);
            successMsg.setText("Le restaurant a été modifié avec succès");
            updateUserBtn.setDisable(false);
            backToListBtn.setDisable(false);
        } catch (SQLException ex) {
            updateUserBtn.setDisable(false);
            backToListBtn.setDisable(false);
            Logger.getLogger(UpdateUserController.class.getName()).log(Level.SEVERE, null, ex);
            errMsg.setText("Une erreur a été rencontré lors de l'ajout");
        }
    }    
    
    public void backToList(ActionEvent event) throws IOException{
        Navigator.goToView(getClass(), event,updateUserPane,"../List/UserList.fxml");
    }
    
}
