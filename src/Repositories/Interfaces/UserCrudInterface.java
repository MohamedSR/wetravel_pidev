/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories.Interfaces;

import Entities.User;

import java.sql.SQLException;
/**
 *
 * @author m.rhouma
 */
public interface UserCrudInterface extends CrudRepository<User> {
     public User getByLogin(String login) throws SQLException;
     void createWithImage(User t) throws SQLException;

}
