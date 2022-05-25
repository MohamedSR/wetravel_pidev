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

}
