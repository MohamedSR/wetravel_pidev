package Services;


import Entities.Produit;
import Repositories.Interfaces.ProduitCrudInterface;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProduitService {
    private final ProduitCrudInterface produitCrud;


    public ProduitService(ProduitCrudInterface produitCrud) {
        this.produitCrud = produitCrud;
    }

    public void createProduit(Produit produit) throws SQLException {
        produitCrud.create(produit);
    }

    public Produit findProduit(int id) throws SQLException{
        return produitCrud.find(id);
    }

    public ArrayList<Produit> findAll() throws SQLException{
        return produitCrud.findAll();
    }

    public void update(int id, Produit produit) throws SQLException{
        produitCrud.update(id, produit);
    }

    public void delete(int id) throws SQLException{
        produitCrud.delete(id);
    }
}
