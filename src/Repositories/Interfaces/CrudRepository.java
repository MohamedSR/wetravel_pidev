/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories.Interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author m.rhouma
 */
public interface CrudRepository<T> {
 public void create(T t) throws SQLException;
 public T find(int id) throws SQLException;
 public ArrayList<T> findAll()throws SQLException;
 public void delete(int id) throws SQLException;
 public void update(int id,T t) throws SQLException;
}
