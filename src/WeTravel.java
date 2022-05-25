
import Entities.User;
import Repositories.UserCrudImpl;
import Services.UserService;
import Utils.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author m.rhouma
 */
public class WeTravel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // Init Data source
        DataSource ds =  DataSource.getInstance();
        
        // Init repositories
        UserCrudImpl userCrud = new UserCrudImpl(ds.getCon());
        
        // Init services
        UserService userService = new UserService(userCrud);
        
        // Tests
        User user = new User("Mohamed","ADMIN","moihamed@wetravel.com","mohamed123","22001002");
        userService.create(user);
        ArrayList users = userService.getAll();
        System.out.println(users);
    }
    
}
