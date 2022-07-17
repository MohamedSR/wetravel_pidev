package Repositories.Interfaces;
import Entities.Event;
import Entities.EventStat;

import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.SQLException;


public interface EventCrudInterface extends CrudRepository<Event> {
    void update(String name, Event t) throws SQLException;

    void createWithImage(Event t) throws SQLException;

    ArrayList<Event> findTopEvents() throws SQLException;

    ArrayList<EventStat> findEventsParPays() throws SQLException;
    void delete(String name) throws SQLException;


}
