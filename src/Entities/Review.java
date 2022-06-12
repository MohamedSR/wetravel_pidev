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
public class Review {
    private int id;
    private User user;
    private Date date ;
    private Hotel hotel;
    private Event event;
    private Restaurant restaurant;
    private String content;

    public Review(int id, User user, Date date) {
        this.id = id;
        this.user = user;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public Review() {
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

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Review(User user, Date date, Hotel hotel, String content) {
        this.user = user;
        this.date = date;
        this.hotel = hotel;
        this.content = content;
    }

    public Review(User user, Date date, Event event, String content) {
        this.user = user;
        this.date = date;
        this.event = event;
        this.content = content;
    }

    public Review(User user, Date date, Restaurant restaurant, String content) {
        this.user = user;
        this.date = date;
        this.restaurant = restaurant;
        this.content = content;
    }
    
}
