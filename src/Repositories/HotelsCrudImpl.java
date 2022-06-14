package Repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import Entities.Hotels;
import Repositories.Interfaces.HotelsCrudInterface;

/**
*
* @author T.adel
*/
public class HotelsCrudImpl implements HotelsCrudInterface{

	private Connection con;
    private Statement ste;
    private PreparedStatement prs;
    
    public Connection getCon() {
        return con;
    }
    
    public HotelsCrudImpl(Connection con) {
        this.con = con;
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(UserCrudImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void create(Hotels h) throws SQLException {
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
	public Hotels find(int id) throws SQLException {
		   String query = "select * from hotels where id = ?";
	        prs = con.prepareStatement(query);
	        prs.setInt(1, id);
	        ResultSet rs  = prs.executeQuery();
	        Hotels hotel = new Hotels();
	        while(rs.next()){
	        	hotel = new Hotels(rs.getInt("id"),rs.getString("name"),rs.getInt("stars"),rs.getInt("capacity"), rs.getString("adresse"), rs.getString("ville"), rs.getString("pays"));
	        }
	         return hotel;
	}

	@Override
	public ArrayList<Hotels> findAll() throws SQLException {
	    String query = "select * from hotels";
        ArrayList<Hotels> list = new ArrayList<>();
        ResultSet rs = ste.executeQuery(query);
        while(rs.next()){
            list.add(new Hotels(rs.getInt("id"),rs.getString("name"),rs.getInt("stars"),rs.getInt("capacity"), rs.getString("adresse"), rs.getString("ville"), rs.getString("pays")));
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
	public void update(int id, Hotels h) throws SQLException {
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
	public ArrayList<Hotels> findByVille(String ville) throws SQLException{
		ArrayList<Hotels> list = new ArrayList<>();
		String query ="select * from hotels where ville = ?;";
		prs = con.prepareStatement(query);
		prs.setString(1,ville);
		ResultSet rs = prs.executeQuery();

		while (rs.next()){
			list.add(new Hotels(
					rs.getInt("id"),rs.getString("name"),rs.getInt("stars"),rs.getInt("capacity"),rs.getString("adresse")
					,rs.getString("ville"),rs.getString("pays")));
		}

		return list;
	}


}
