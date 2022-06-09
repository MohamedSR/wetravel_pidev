package Entities;

import java.util.Date;

public class Event {
    public Event() {
    }

    private int id;

    public Event(int id, String name, int capacity, java.sql.Date date, String adresse, String ville, String pays) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    private String name, adresse, ville, pays;
    private Date date;
    private int capacity;

    public Event(String name, String adresse, String ville, String pays, Date date, int capacity) {
        this.name = name;
        this.adresse = adresse;
        this.ville = ville;
        this.pays = pays;
        this.date = date;
        this.capacity = capacity;
    }

    public Event(int id, String name, String adresse, String ville, String pays, Date date, int capacity) {
        this.id = id;
        this.name = name;
        this.adresse = adresse;
        this.ville = ville;
        this.pays = pays;
        this.date = date;
        this.capacity = capacity;
    }

}
