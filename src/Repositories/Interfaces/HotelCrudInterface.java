package Repositories.Interfaces;

import Entities.Hotel;

import java.sql.SQLException;
import java.util.ArrayList;

/**
*
* @author T.adel
*/
public interface HotelCrudInterface extends CrudRepository<Hotel>{


    ArrayList<Hotel> findByVille(String ville) throws SQLException;
}
