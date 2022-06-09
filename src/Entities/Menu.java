package Entities;

public class Menu {
    private int id;
    private Restaurant restaurant;
    private String name;

    public Menu(int id, Restaurant restaurant, String name) {
        this.id = id;
        this.restaurant = restaurant;
        this.name = name;
    }

    public Menu(Restaurant restaurant, String name) {
        this.restaurant = restaurant;
        this.name = name;
    }

    public Menu() {}

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", restaurant=" + restaurant +
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
        return restaurant;
    }

    public void setRestaurants(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
