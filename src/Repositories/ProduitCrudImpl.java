package Repositories;

import Entities.Menu;
import Entities.Produit;
import Entities.Restaurant;
import Repositories.Interfaces.ProduitCrudInterface;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProduitCrudImpl implements ProduitCrudInterface {

    private Connection con;
    private Statement ste;
    private PreparedStatement prs;
    private MenuCrudImpl menuCrud;

    public Connection getCon() {
        return con;
    }

    public ProduitCrudImpl(Connection con, MenuCrudImpl menuCrud) {
        this.con = con;
        this.menuCrud = menuCrud;
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(RestaurantCrudImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void create(Produit produit) throws SQLException {
        String query="insert into produits (name,menu_category_id) values(?,?)";
        prs = con.prepareStatement(query);
        prs.setString(1, produit.getName());
        prs.setInt(2,produit.getMenu().getId());
        prs.executeUpdate();
    }

    @Override
    public Produit find(int id) throws SQLException {
        String query="select * from produits where id = ?";
        prs = con.prepareStatement(query);
        prs.setInt(1,id);
        ResultSet rs = prs.executeQuery();

        Produit produit = new Produit();
        while(rs.next()){
            Menu menu = menuCrud.find(rs.getInt("menu_category_id"));
            new Produit(
                    rs.getInt("id"),menu,rs.getString("name"));
        }
        return produit;
    }

    @Override
    public ArrayList<Produit> findAll() throws SQLException {
        String query = "select * from produits";
        ArrayList<Produit> list = new ArrayList<>();
        prs = con.prepareStatement(query);

        ResultSet rs = prs.executeQuery();
        while (rs.next()){
            Menu menu = menuCrud.find(rs.getInt("menu_category_id"));
            list.add(
                    new Produit(rs.getInt("id"),menu,rs.getString("name")));
        }
        return list;
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = "delete from produits where id = ?";
        prs = con.prepareStatement(query);
        prs.setInt(1, id);
        prs.execute();
    }

    @Override
    public void update(int id, Produit produit) throws SQLException {
        String query = "UPDATE produits SET name= ?,menu_category_id=?";
        prs = con.prepareStatement(query);
        prs.setString(1, produit.getName());
        prs.setInt(2, produit.getMenu().getId());
        prs.setInt(1, id);
        prs.execute();
    }
}
