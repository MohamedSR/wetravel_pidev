package Entities;

public class Menu {
    private int id;
    private Restaurants restaurants;
    private String name;

    public Menu(int id, Restaurants restaurants, String name) {
        this.id = id;
        this.restaurants = restaurants;
        this.name = name;
    }

    public Menu(Restaurants restaurants, String name) {
        this.restaurants = restaurants;
        this.name = name;
    }

    public Menu() {}

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", restaurants=" + restaurants +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Restaurants getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(Restaurants restaurants) {
        this.restaurants = restaurants;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
