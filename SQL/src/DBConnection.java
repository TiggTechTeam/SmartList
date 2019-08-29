import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**************************************************
 *
 **************************************************/
public class DBConnection {
    static Connection dbConnection;

    static {
        try {
            dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/grocery_list?serverTimezone=Europe/Vienna", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
