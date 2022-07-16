package Entities;

public class Restaurant {
    private int id, capacity;
    private String name, adresse, ville, pays,image;

    public Restaurant() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Restaurant(int id, int capacity, String adresse, String ville, String pays, String name) {
        this.id = id;
        this.capacity = capacity;
        this.adresse = adresse;
        this.ville = ville;
        this.pays = pays;
        this.name = name;
    }
    public Restaurant(int capacity, String adresse, String ville, String pays, String name) {
        this.capacity = capacity;
        this.adresse = adresse;
        this.ville = ville;
        this.pays = pays;
        this.name = name;
    }
    public Restaurant(int id, int capacity, String name, String adresse, String ville, String pays, String image) {
        this.id = id;
        this.capacity = capacity;
        this.name = name;
        this.adresse = adresse;
        this.ville = ville;
        this.pays = pays;
        this.image = image;
    }
    public Restaurant(int capacity, String name, String adresse, String ville, String pays, String image) {
        this.capacity = capacity;
        this.name = name;
        this.adresse = adresse;
        this.ville = ville;
        this.pays = pays;
        this.image = image;
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

    @Override
    public String toString() {
        return "ceci le Restaurant: " + name + "Numero" +
                id +",qui a la capacity de" + capacity +
                "personnes, localisé à" + adresse +
                ",de la ville " + ville +
                ",à ce extraordinaire pays " + pays;
    }
}
