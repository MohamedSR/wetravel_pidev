/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Entities.Reservation;
import Repositories.Interfaces.ReservationCrudInterface;
import Repositories.Interfaces.UserCrudInterface;
import java.sql.SQLException;
import java.sql.Date;
import Entities.User;
import Entities.Event;
import Entities.Hotel;
import Entities.Restaurant;
import Repositories.Interfaces.EventCrudInterface;
import Repositories.Interfaces.HotelCrudInterface;
import Repositories.Interfaces.RestaurantCrudInterface;

/**
 *
 * @author m.rhouma
 */
public class ReservationService {

    private ReservationCrudInterface reservationDao;
    private HotelCrudInterface hotelDao;
    private UserCrudInterface userDao;
    private RestaurantCrudInterface restaurantDao;
    private EventCrudInterface eventDao;
    public ReservationService(ReservationCrudInterface reservationDao,
            HotelCrudInterface hotelDao, UserCrudInterface userDao,
     RestaurantCrudInterface restaurantDao,EventCrudInterface eventDao) {
        this.reservationDao = reservationDao;
        this.hotelDao = hotelDao;
        this.userDao = userDao;
        this.restaurantDao = restaurantDao;
        this.eventDao= eventDao;
    }

    public void createHotelReservation(int hotel_id, int user_id, Date date) throws SQLException, Exception {
        // check if hotel exists
        Hotel hotel = this.hotelDao.find(hotel_id);
        // check if user exisits
        User user = this.userDao.find(user_id);
        // TO VERIFY: check capacity per day or hotel total capacity ?? 
        if (this.reservationDao.CountHotelReservationByDate(hotel_id, date) >= hotel.getCapacity()) {
            // TODO: Create custom expection
            throw new Exception("Aucune chambre disponible");
        }
        Reservation reservation = new Reservation(user, date, hotel);
        this.reservationDao.create(reservation);
    }

    public void createRestaurantReservation(int restaurant_id, int user_id, Date date) throws SQLException, Exception  {
        // check if restaurant exists
        Restaurant restaurant = this.restaurantDao.find(restaurant_id);
        // check if user exisits
        User user = this.userDao.find(user_id);
        // TO VERIFY: check capacity per day or hotel total capacity ?? 
        if (this.reservationDao.CountRestaurantReservationByDate(restaurant_id, date) >= restaurant.getCapacity()) {
            // TODO: Create custom expection
            throw new Exception("Aucune place disponible");
        }
        Reservation reservation = new Reservation(user, date, restaurant);
        this.reservationDao.create(reservation);
    }

    public void createEventReservation(int event_id, int user_id, Date date) throws SQLException, Exception  {
        // check if event exists
        Event event = this.eventDao.find(event_id);
        // check if user exisits
        User user = this.userDao.find(user_id);
        // TO VERIFY: check capacity per day or hotel total capacity ?? 
        if (this.reservationDao.CountRestaurantReservationByDate(event_id, date) >= event.getCapacity()) {
            // TODO: Create custom expection
            throw new Exception("Aucune place disponible");
        }
        Reservation reservation = new Reservation(user, date, event);
        this.reservationDao.create(reservation);
    }

}
