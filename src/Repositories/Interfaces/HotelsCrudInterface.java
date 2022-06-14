package Repositories.Interfaces;

import Entities.Hotels;

import java.sql.SQLException;
import java.util.ArrayList;

/**
*
* @author T.adel
*/
public interface HotelsCrudInterface extends CrudRepository<Hotels>{

    public ArrayList<Hotels> findByVille(String ville) throws SQLException;
}
