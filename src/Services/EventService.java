package Services;

import Repositories.Interfaces.EventCrudInterface;
import java.sql.SQLException;
import Entities.Event;
import java.util.ArrayList;


public class EventService {

    private final EventCrudInterface eventCrud;

    public EventService(EventCrudInterface eventCrud) {
        this.eventCrud = eventCrud;
    }

    public ArrayList getAllEvents() throws SQLException {
        return eventCrud.findAll();
    }

    public Event getEvent(int id) throws SQLException {
        return eventCrud.find(id);
    }

    public void createEvent(Event event) throws SQLException {
        eventCrud.create(event);
    }

    public ArrayList findTopEvents() throws SQLException {
        return eventCrud.findTopEvents();
    }
    public ArrayList findEventsParPays() throws SQLException {
        return eventCrud.findEventsParPays();
    }

    public void updateEvent(int id,Event event) throws SQLException {
        eventCrud.update(id,event);
    }

    public void deleteEvent(int id) throws SQLException {
        eventCrud.delete(id);
    }
}
