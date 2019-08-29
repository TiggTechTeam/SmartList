import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**************************************************
 *
 **************************************************/
public class AutoComplete extends JPanel {
    public AutoComplete(JComboBox cmbMessageList) {
        try {
            Statement stat = database.createStatement();
            ResultSet rs = stat.executeQuery("Select * from items");
            ArrayList<String> help = new ArrayList<String>();
            while (rs.next()) {
                help.add(rs.getString("item"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        AutoCompleteDecorator.decorate(cmbMessageList);
    }
}
