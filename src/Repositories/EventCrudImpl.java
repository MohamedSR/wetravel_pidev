package Repositories;

import Entities.Event;
import Repositories.Interfaces.EventCrudInterface;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author m.rhouma
 */
public class EventCrudImpl implements EventCrudInterface {

    private Connection con;
    private Statement ste;
    private PreparedStatement prs;

    public Connection getCon() {
        return con;
    }

    public EventCrudImpl(Connection con) {
        this.con = con;
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(EventCrudImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void create(Event t) throws SQLException {
        String req="INSERT INTO events ( name, capacity, date, adresse, ville, pays) VALUES(?,?,?,?,?,?)";
        prs = con.prepareStatement(req);
        prs.setString(1, t.getName());
        prs.setInt(2, t.getCapacity());
        prs.setDate(3, (Date) t.getDate());
        prs.setString(4, t.getAdresse());
        prs.setString(5, t.getVille());
        prs.setString(6, t.getPays());
        prs.executeUpdate();
    }

    @Override
    public Event find(int id) throws SQLException{
        String query = "select * from events where id = ?";
        prs = con.prepareStatement(query);
        prs.setInt(1, id);
        ResultSet rs  = prs.executeQuery();
        Event event = new Event();
        while(rs.next()){
            event = new Event(rs.getInt("id"), rs.getString("name"), rs.getInt("capacity"), rs.getDate("date"), rs.getString("adresse"), rs.getString("ville"), rs.getString("pays"));
        }
        return event;
    }

    @Override
    public ArrayList<Event> findAll() throws SQLException{
        String query = "select * from events";
        ArrayList<Event> list = new ArrayList<>();
        ResultSet rs = ste.executeQuery(query);
        while(rs.next()){
            list.add(new Event(rs.getInt("id"), rs.getString("name"), rs.getInt("capacity"), rs.getDate("date"), rs.getString("adresse"), rs.getString("ville"), rs.getString("pays")));
        }
        return list;
    }

    @Override
    public void delete(int id) throws SQLException{
        String query = "delete from events where id = ?";
        prs = con.prepareStatement(query);
        prs.setInt(1, id);
        prs.execute();
    }

    @Override
    public void update(int id, Event t) throws SQLException{
        String query = "UPDATE events SET name= ?,capacity=?,date=?,adresse=?,ville=?, pays=? where id = ?";
        prs = con.prepareStatement(query);
        prs.setString(1, t.getName());
        prs.setInt(2, t.getCapacity());
        prs.setDate(3, (Date) t.getDate());
        prs.setString(4, t.getAdresse());
        prs.setString(5, t.getVille());
        prs.setString(5, t.getPays());
        prs.setInt(1, id);
        prs.execute();
    }
}

