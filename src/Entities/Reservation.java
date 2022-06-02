/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.sql.Date;

/**
 *
 * @author m.rhouma
 */
public class Reservation {

    private int id;
    private User user;
    private Date date ;
    private hotels hotel;
    private Event event;
    private Restaurant restaurant;

    public hotels getHotel() {
        return hotel;
    }

    public void setHotel(hotels hotel) {
        this.hotel = hotel;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    
    public Reservation() {

    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Reservation(User user,Date date) {
        this.user = user;
        this.date = date;
    }

    public Reservation(int id, User user,Date date) {
        this.id = id;
        this.user = user;
        this.date = date;
    }

    public Reservation(int id, User user, Date date, Restaurant restaurant) {
        this.id = id;
        this.user = user;
        this.date = date;
        this.restaurant = restaurant;
    }

    public Reservation(int id, User user, Date date, Event event) {
        this.id = id;
        this.user = user;
        this.date = date;
        this.event = event;
    }

    public Reservation(int id, User user, Date date, hotels hotel) {
        this.id = id;
        this.user = user;
        this.date = date;
        this.hotel = hotel;
    }

}
