package Repositories.Interfaces;
import Entities.Event;

import java.sql.SQLException;

public interface EventCrudInterface extends CrudRepository<Event> {
    void createWithImage(Event t) throws SQLException;
}
