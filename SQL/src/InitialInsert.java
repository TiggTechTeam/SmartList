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

public class InitialInsert {
    /**
     * Insert all items from Item.txt
     */
    static class Items {
        public static void main(String[] args) {
            try (BufferedReader file = new BufferedReader(new FileReader("SQL/resources/Items.txt"))) {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/grocery_list?serverTimezone=Europe/Vienna", "root", "root");

                Statement stat = con.createStatement();
                stat.executeUpdate("drop table if exists grocery_list.items cascade;");
                stat.executeUpdate("CREATE TABLE grocery_list.items (" +
                        "ID INT(5) NOT NULL AUTO_INCREMENT," +
                        "Name VARCHAR(45) NOT NULL," +
                        "Price DOUBLE NULL," +
                        "PRIMARY KEY (ID)," +
                        "UNIQUE INDEX Name_UNIQUE (Name DESC) VISIBLE);");

                String insert = file.readLine();
                insert.replaceAll("\\s", "");  // TODO
                String[] insertSplit = insert.split(";");
                while (insert != null) {
                    stat.executeUpdate("insert into grocery_list.items (name, price) values ('" + insertSplit[0] + "', " + insertSplit[1] + ");");
                    insert = file.readLine();
                    insertSplit = insert.split(";");
                }
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class Measures {
        public static void main(String[] args) {
            try (BufferedReader file = new BufferedReader(new FileReader("SQL/resources/Measures.txt"))) {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/grocery_list?serverTimezone=Europe/Vienna", "root", "root");

                Statement stat = con.createStatement();
                stat.executeUpdate("drop table if exists grocery_list.measures cascade;");

                stat.executeUpdate("CREATE TABLE grocery_list.measures (" +
                        "Name VARCHAR(10) NOT NULL," +
                        "PRIMARY KEY (Name)," +
                        "UNIQUE INDEX Name_UNIQUE (Name ASC) VISIBLE);");


                String insert = file.readLine();
                while (insert != null) {
                    stat.executeUpdate("insert into grocery_list.measures (name) values ('" + insert + "');");
                    insert = file.readLine();
                }
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }
    }


}
