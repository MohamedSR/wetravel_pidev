package Entities;

public class Menu {
    private int id;
    private Restaurant restaurants;
    private String name;

    public Menu(int id, Restaurant restaurants, String name) {
        this.id = id;
        this.restaurants = restaurants;
        this.name = name;
    }

    public Menu(Restaurant restaurants, String name) {
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

    public Restaurant getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(Restaurant restaurants) {
        this.restaurants = restaurants;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
