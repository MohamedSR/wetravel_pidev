package Services;

import Entities.Event;
import Repositories.Interfaces.EventCrudInterface;

import java.sql.SQLException;
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
    public void createEventWithImage(Event event) throws SQLException {
        eventCrud.createWithImage(event);
    }

    public ArrayList findTopEvents() throws SQLException {
        return eventCrud.findTopEvents();
    }
    public ArrayList findEventsParPays() throws SQLException {
        return eventCrud.findEventsParPays();
    }

    public void updateEvent(String name,Event event) throws SQLException {
        eventCrud.update(name,event);
    }

    public void deleteEvent(String id) throws SQLException {
        eventCrud.delete(id);
    }
}
