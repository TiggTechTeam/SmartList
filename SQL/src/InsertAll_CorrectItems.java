/**************************************************
 * Drop correct_items schema, if it already exists.
 * Create a new correct_items schema.
 * Insert items into database.
 **************************************************/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class InsertAll_CorrectItems {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/grocery_list?serverTimezone=Europe/Vienna", "root", "root");
            BufferedReader file = new BufferedReader(new FileReader("SQL/resources/InsertAll_CorrectItems.sql"));

            Statement stat = con.createStatement();
            String sql = file.readLine();
            while (sql != null) {
                stat.executeUpdate(sql);
                sql = file.readLine();
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
