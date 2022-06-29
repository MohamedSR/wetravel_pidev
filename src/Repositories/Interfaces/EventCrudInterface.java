package Repositories.Interfaces;
import Entities.Event;
import Entities.EventStat;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EventCrudInterface extends CrudRepository<Event> {

    ArrayList<Event> findTopEvents() throws SQLException;

    ArrayList<EventStat> findEventsParPays() throws SQLException;
}
