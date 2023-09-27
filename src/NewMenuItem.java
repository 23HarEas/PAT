
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.github.lgooddatepicker.zinternaltools.*;
import net.miginfocom.layout.*;
import net.miginfocom.swing.*;

/*
 * Created by JFormDesigner on Mon Jul 31 20:41:09 CAT 2023
 */
/**
 * @author harri
 */
public class NewMenuItem extends JFrame {

    /**
     * Constructs a new NewMenuItem window. This constructor initializes and
     * displays the components of the NewMenuItem window.
     */
    public NewMenuItem() {
        initComponents();
    }

    /**
     * Handles the submit button click event in the NewMenuItem window. This
     * method retrieves the menu item's name, description, and price from the
     * input fields, creates a new menu item with this information, and adds it
     * to the menuArr. Then, it disposes of the window, refreshes the tables on
     * the main screen, and saves the changes.
     *
     * @param e The ActionEvent object representing the button click event.
     */
    private void btnNewMenuSubmit(ActionEvent e) {
        // TODO add your code here
        String name = txtNewMenuName.getText();
        String description = txtNewMenuDescription.getText();
        double price = Double.parseDouble(txtNewMenuPrice.getText());
        MainScreen.menuArr.menuNewItem(name, description, price);
        dispose();
        ScreenBuild.mainScreen.refreshJTables();
        ScreenBuild.mainScreen.saveJTables();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Harrison Easter (MRS CLI EASTER)
        lblNewMenuName = new JLabel();
        txtNewMenuName = new JTextField();
        lblNewMenuDescription = new JLabel();
        txtNewMenuDescription = new JTextField();
        lblNewMenuPrice = new JLabel();
        txtNewMenuPrice = new JIntegerTextField();
        btnNewMenuSubmit = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setTitle("New Menu Item");
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            new LC().fill().insets("dialog").hideMode(3).align("center", "center"),
            // columns
            new AC()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill(),
            // rows
            new AC()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill()));

        //---- lblNewMenuName ----
        lblNewMenuName.setText("Item Name");
        contentPane.add(lblNewMenuName, new CC().cell(1, 1, 4, 1).grow());
        contentPane.add(txtNewMenuName, new CC().cell(4, 1, 4, 1));

        //---- lblNewMenuDescription ----
        lblNewMenuDescription.setText("Item Description");
        contentPane.add(lblNewMenuDescription, new CC().cell(1, 3, 4, 1));
        contentPane.add(txtNewMenuDescription, new CC().cell(4, 3, 4, 1));

        //---- lblNewMenuPrice ----
        lblNewMenuPrice.setText("Item Price");
        contentPane.add(lblNewMenuPrice, new CC().cell(1, 5, 4, 1));
        contentPane.add(txtNewMenuPrice, new CC().cell(4, 5, 4, 1));

        //---- btnNewMenuSubmit ----
        btnNewMenuSubmit.setText("Add Item");
        btnNewMenuSubmit.addActionListener(e -> btnNewMenuSubmit(e));
        contentPane.add(btnNewMenuSubmit, new CC().cell(1, 7, 7, 1));
        setSize(500, 500);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Harrison Easter (MRS CLI EASTER)
    private JLabel lblNewMenuName;
    private JTextField txtNewMenuName;
    private JLabel lblNewMenuDescription;
    private JTextField txtNewMenuDescription;
    private JLabel lblNewMenuPrice;
    private JIntegerTextField txtNewMenuPrice;
    private JButton btnNewMenuSubmit;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
