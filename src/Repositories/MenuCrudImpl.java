package Repositories;

import Entities.Menu;
import Repositories.Interfaces.MenuCrudInterface;

import java.sql.SQLException;
import java.util.ArrayList;

public class MenuCrudImpl implements MenuCrudInterface {

    @Override
    public void create(Menu menu) throws SQLException {

    }

    @Override
    public Menu find(int id) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<Menu> findAll() throws SQLException {
        return null;
    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public void update(int id, Menu menu) throws SQLException {

    }
}
