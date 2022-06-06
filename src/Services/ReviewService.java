/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;
import Entities.Review;
import Repositories.Interfaces.ReviewCrudInterface;
import java.util.ArrayList;
import java.sql.SQLException;

/**
 *
 * @author m.rhouma
 */
public class ReviewService {
    private final ReviewCrudInterface reviewCrud;

    public ReviewService(ReviewCrudInterface reviewCrud) {
        this.reviewCrud = reviewCrud;
    }
    
    public void createRestaurant(Review review) throws SQLException {
        reviewCrud.create(review);
    }

    public Review findMenu(int id) throws SQLException {
        return reviewCrud.find(id);
    }

    public ArrayList<Review> findAllMenu() throws SQLException {
        return reviewCrud.findAll();
    }

    public void deleteMenu(int id) throws SQLException {
        reviewCrud.delete(id);
    }

    public void updateMenu(int id, Review review) throws SQLException {
        reviewCrud.update(id, review);
    }
}
