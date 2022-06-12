package Entities;

public class Produit {
    private int id;
    private Menu menu;
    private String name;

    public Produit() {
    }

    public Produit(int id, Menu menu, String name) {
        this.id = id;
        this.menu = menu;
        this.name = name;
    }

    public Produit(Menu menu, String name) {
        this.menu = menu;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", menu=" + menu +
                ", name='" + name + '\'' +
                '}';
    }
}
