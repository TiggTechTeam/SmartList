/**************************************************
 * Drop correct_items schema, if it already exists.
 * Create a new correct_items schema.
 * Insert items into database.
 **************************************************/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertAll_Items {
    public static void main(String[] args) {
        try (BufferedReader file = new BufferedReader(new FileReader("SQL/resources/InsertAll_Items.sql"))) {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/grocery_list?serverTimezone=Europe/Vienna", "root", "root");

            Statement stat = con.createStatement();
            stat.executeUpdate("drop table if exists grocery_list.items cascade;");
            stat.executeUpdate("CREATE TABLE grocery_list.items (ID INT(5) NOT NULL AUTO_INCREMENT, Item VARCHAR(45) NOT NULL, PRIMARY KEY (ID), UNIQUE INDEX Item_UNIQUE (Item ASC) VISIBLE);\n");

            String insert = file.readLine();
            while (insert != null) {
                stat.executeUpdate("insert into grocery_list.items (item) values ('" + insert + "');");
                insert = file.readLine();
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
