package Repositories;

import Entities.Hotel;
import Repositories.Interfaces.HotelCrudInterface;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
*
* @author T.adel
*/
public class HotelCrudImpl implements HotelCrudInterface{

	private Connection con;
    private Statement ste;
    private PreparedStatement prs;
    
    public Connection getCon() {
        return con;
    }
    
    public HotelCrudImpl(Connection con) {
        this.con = con;
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(UserCrudImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void create(Hotel h) throws SQLException {
        String req="INSERT INTO hotels ( name, stars, capacity, adresse,ville,pays) VALUES(?,?,?,?,?,?)";
        prs = con.prepareStatement(req);
        prs.setString(1, h.getName());
        prs.setInt(2, h.getStars());
        prs.setInt(3, h.getCapacity());
        prs.setString(4, h.getAdresse());
        prs.setString(5, h.getVille());
        prs.setString(6, h.getPays());
        prs.executeUpdate();
    }
	@Override
    public void createWithImage(Hotel h) throws SQLException {
        String req="INSERT INTO hotels ( name, stars, capacity, adresse,ville,pays,image) VALUES(?,?,?,?,?,?,?)";
        prs = con.prepareStatement(req);
        prs.setString(1, h.getName());
        prs.setInt(2, h.getStars());
        prs.setInt(3, h.getCapacity());
        prs.setString(4, h.getAdresse());
        prs.setString(5, h.getVille());
        prs.setString(6, h.getPays());
        prs.setString(7, h.getImage());
        prs.executeUpdate();
    }

	@Override
	public Hotel find(int id) throws SQLException {
		   String query = "select * from hotels where id = ?";
	        prs = con.prepareStatement(query);
	        prs.setInt(1, id);
	        ResultSet rs  = prs.executeQuery();
	        Hotel hotel = new Hotel();
	        while(rs.next()){
	        	hotel = new Hotel(rs.getInt("id"),rs.getString("name"),rs.getInt("stars"),rs.getInt("capacity"), rs.getString("adresse"), rs.getString("ville"), rs.getString("pays"),rs.getString("image"));
	        }
	         return hotel;
	}

	@Override
	public ArrayList<Hotel> findAll() throws SQLException {
	    String query = "select * from hotels";
        ArrayList<Hotel> list = new ArrayList<>();
        ResultSet rs = ste.executeQuery(query);
        while(rs.next()){
            list.add(new Hotel(rs.getInt("id"),rs.getString("name"),rs.getInt("stars"),rs.getInt("capacity"), rs.getString("adresse"), rs.getString("ville"), rs.getString("pays")));
        }
        return list;
	}

	@Override
	public void delete(int id) throws SQLException {
		  String query = "delete from hotels where id = ?";
	        prs = con.prepareStatement(query);
	        prs.setInt(1, id);
	        prs.execute();
		
	}

	@Override
	public void update(int id, Hotel h) throws SQLException {
		   String query = "UPDATE hotels SET name= ?,stars=?,capacity=?,adresse=?,ville=?,pays=? where id = ?";
	        prs = con.prepareStatement(query);
	        prs.setString(1, h.getName());
	        prs.setInt(2, h.getStars());
	        prs.setInt(3, h.getCapacity());
	        prs.setString(4, h.getAdresse());
	        prs.setString(5, h.getVille());
	        prs.setString(6, h.getPays());
	        prs.setInt(7, id);
	        prs.execute();
	}
	@Override
	public ArrayList<Hotel> findByVille(String ville) throws SQLException{
		ArrayList<Hotel> list = new ArrayList<>();
		String query ="select * from restaurants where ville = ?;";
		prs = con.prepareStatement(query);
		prs.setString(1,ville);
		ResultSet rs = prs.executeQuery();

		while (rs.next()){
			list.add(new Hotel(
					rs.getInt("id"),rs.getString("name"),rs.getInt("stars"),rs.getInt("capacity")
					,rs.getString("adresse"),rs.getString("ville"),rs.getString("pays")));
		}

		return list;
	}

}
