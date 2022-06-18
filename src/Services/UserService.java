/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Repositories.Interfaces.UserCrudInterface;
import java.sql.SQLException;
import Entities.User;
import Exceptions.FailedLoginExecption;
import Exceptions.UserNotAuzorithedException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author m.rhouma
 */
public class UserService {

    private final UserCrudInterface userCrud;

    public UserService(UserCrudInterface userCrud) {
        this.userCrud = userCrud;
    }

    public ArrayList getAll() throws SQLException {
        return userCrud.findAll();
    }

    public User get(int id) throws SQLException {
        return userCrud.find(id);
    }
    
    public void create(User user) throws SQLException {
        userCrud.create(user);
    }
    
    public void update(int id,User user) throws SQLException {
        userCrud.update(id,user);
    }

    public void delete(int id) throws SQLException {
        userCrud.delete(id);
    }
    
    public void login(String email,String password) throws FailedLoginExecption, UserNotAuzorithedException{
        User user;
        try {
            user = userCrud.getByLogin(email);
            if (user.equals(new User())){
                throw new FailedLoginExecption();
            }
            if (!user.getPassword().equals(password)){
                throw new FailedLoginExecption();
            }
             if (!user.getRole().equals("ADMIN")){
                throw new UserNotAuzorithedException();
            }
        } catch (SQLException ex) {
            throw new FailedLoginExecption();
        }

    }
}
