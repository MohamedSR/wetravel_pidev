package Entities;

public class EventStat {
    private int total;
    private String name;
    private String pays;

    public EventStat(int total, String name, String pays) {
        this.total = total;
        this.name = name;
        this.pays = pays;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public EventStat(int total) {
        this.total = total;
    }
}
