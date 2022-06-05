package Services;

import java.sql.SQLException;
import java.util.ArrayList;

import Entities.Hotels;
import Repositories.Interfaces.HotelsCrudInterface;



/**
*
* @author T.adel
*/
public class HotelsService {
	
	 private final HotelsCrudInterface hotelCrud;
	
	    public HotelsService(HotelsCrudInterface hotelCrud) {
		super();
		this.hotelCrud = hotelCrud;
	    }

		public ArrayList getAll() throws SQLException {
	        return hotelCrud.findAll();
	    }

	    public Hotels get(int id) throws SQLException {
	        return hotelCrud.find(id);
	    }
	    
	    public void create(Hotels hotel) throws SQLException {
	    	hotelCrud.create(hotel);
	    }
	    
	    public void update(int id,Hotels hotel) throws SQLException {
	    	hotelCrud.update(id,hotel);
	    }

	    public void delete(int id) throws SQLException {
	    	hotelCrud.delete(id);
	    }
}
