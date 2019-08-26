import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**************************************************
 *
 **************************************************/
public class Screen extends JFrame implements ActionListener {

    private ArrayList<String> itemColumn = new ArrayList<>();
    private JComboBox cmbMessageList = new JComboBox(new String[]{"hi", "was", "geht"});
    Autocomplete autocomplete = new Autocomplete();

    public Screen(String title) {


        setTitle(title);
        setLayout(new FlowLayout());

        /* set screen dimension */
        final int screenWidth = 700;
        final int screenHeight = 700;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width - screenWidth) / 2, (screenSize.height - screenHeight) / 2, screenWidth, screenHeight);

        setResizable(false);
        add(cmbMessageList);
        add(autocomplete);
    }

    public void insertItem(String item) {
        itemColumn.add(item);
    }

    class Autocomplete extends JPanel {
        Autocomplete() {
            AutoCompleteDecorator.decorate(cmbMessageList);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
