package Entities;

public class Restaurants {
    private int id, capacity, adresse, ville, pays;
    private String name;

    public Restaurants() {
    }

    public Restaurants(int id, int capacity, int adresse, int ville, int pays, String name) {
        this.id = id;
        this.capacity = capacity;
        this.adresse = adresse;
        this.ville = ville;
        this.pays = pays;
        this.name = name;
    }

    public Restaurants(int capacity, int adresse, int ville, int pays, String name) {
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

    public int getAdresse() {
        return adresse;
    }

    public void setAdresse(int adresse) {
        this.adresse = adresse;
    }

    public int getVille() {
        return ville;
    }

    public void setVille(int ville) {
        this.ville = ville;
    }

    public int getPays() {
        return pays;
    }

    public void setPays(int pays) {
        this.pays = pays;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
