package Entities;

public class Restaurants {
    private int id, capacity;
    private String name, adresse, ville, pays;

    public Restaurants() {
    }

    public Restaurants(int id, int capacity, String adresse, String ville, String pays, String name) {
        this.id = id;
        this.capacity = capacity;
        this.adresse = adresse;
        this.ville = ville;
        this.pays = pays;
        this.name = name;
    }

    public Restaurants(int capacity, String adresse, String ville, String pays, String name) {
        this.capacity = capacity;
        this.adresse = adresse;
        this.ville = ville;
        this.pays = pays;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
