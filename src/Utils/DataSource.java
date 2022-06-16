
package Utils;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataSource {

    private static DataSource instance;

    private Connection con;

    private String url = "jdbc:mysql://localhost:3306/wetravel";

    private String login = "root";
    private String pwd = "";

    private DataSource() {
        try {
            con=DriverManager.getConnection(url, login, pwd);
        } catch (SQLException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getCon() {
        return con;
    }

    public static DataSource getInstance() {
        if (instance == null) {
            instance = new DataSource();
        }
        return instance;
    }

}
