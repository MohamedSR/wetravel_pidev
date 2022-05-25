/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 *
 * @author m.rhouma
 */
public class Reservation {

    private int id;
    private User user;

    public Reservation() {

    }

    public Reservation(User user) {
        this.user = user;
    }

    public Reservation(int id, User user) {
        this.id = id;
        this.user = user;
    }

}
