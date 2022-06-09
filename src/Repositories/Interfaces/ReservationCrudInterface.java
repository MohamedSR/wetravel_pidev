/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories.Interfaces;
import Entities.Reservation;
import java.sql.SQLException;
import java.sql.Date;
/**
 *
 * @author m.rhouma
 */
public interface ReservationCrudInterface extends CrudRepository<Reservation>{
 public int CountHotelReservationByDate(int hotel_id,Date date) throws SQLException;
 public int CountRestaurantReservationByDate(int restaurant_id,Date date) throws SQLException;
 public int CountEventReservationByDate(int event_id,Date date) throws SQLException;
}
