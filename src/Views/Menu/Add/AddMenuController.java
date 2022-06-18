/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Views.Menu.Add;


import Entities.Menu;
import Entities.User;
import Repositories.MenuCrudImpl;
import Repositories.RestaurantCrudImpl;
import Services.MenuService;
import Utils.DataSource;
import Utils.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
public class AddMenuController implements Initializable {

    @FXML
    private TextField name;

    @FXML
    private TextField RestaurantID;

    
    @FXML
    private Label successMsg;
    @FXML
    private Label errMsg;
    
    RestaurantCrudImpl restaurantCrud = new RestaurantCrudImpl(DataSource.getInstance().getCon());
    MenuCrudImpl menuCrud = new MenuCrudImpl(DataSource.getInstance().getCon(),restaurantCrud);

    MenuService menuService = new MenuService(menuCrud);
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void addMenu() throws SQLException {

        Menu menu = new Menu(restaurantCrud.find(Integer.parseInt(RestaurantID.getText())),name.getText());
        try {
            menuService.createMenu(menu);
            successMsg.setText("Le Menu a été ajouté avec succès");

        } catch (SQLException ex) {
            errMsg.setText("Une erreur a été rencontrée lors de l'ajout");
            Logger.getLogger(AddMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    public void backToList(ActionEvent event) throws IOException{
        Navigator.goToView(getClass(), event,"../Add/AddMenu.fxml");
    }
}
