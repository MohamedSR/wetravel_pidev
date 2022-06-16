package Services;

import java.sql.SQLException;
import java.util.ArrayList;

import Entities.Hotel;
import Repositories.Interfaces.HotelCrudInterface;



/**
*
* @author T.adel
*/
public class HotelsService {
	
	 private final HotelCrudInterface hotelCrud;
	
	    public HotelsService(HotelCrudInterface hotelCrud) {
		super();
		this.hotelCrud = hotelCrud;
	    }


	public ArrayList getAll() throws SQLException {
	        return hotelCrud.findAll();
	    }

	    public Hotel get(int id) throws SQLException {
	        return hotelCrud.find(id);
	    }
	    
	    public void create(Hotel hotel) throws SQLException {
	    	hotelCrud.create(hotel);
	    }
	    
	    public void update(int id,Hotel hotel) throws SQLException {
	    	hotelCrud.update(id,hotel);
	    }

	    public void delete(int id) throws SQLException {
	    	hotelCrud.delete(id);
	    }
}
