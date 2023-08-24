import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.layout.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Mon Jul 31 20:41:09 CAT 2023
 */



/**
 * @author harri
 */
public class NewMenuItem {
    public NewMenuItem() {
        initComponents();
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
        String name = textField1.getText();
        String description = textField2.getText();
        Double price = Double.parseDouble(textField3.getText());
        MainScreen.menuArr.newMenuItem(name, description, price);
        dispose();
        ScreenBuild.mainScreen.refreshJTables();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Harrison Easter (MRS CLI EASTER)
        NewMenu = new JFrame();
        lblNewMenuName = new JLabel();
        txtNewMenuName = new JTextField();
        lblNewMenuDescription = new JLabel();
        txtNewMenuDescription = new JTextField();
        lblNewMenuPrice = new JLabel();
        txtNewMenuPrice = new JTextField();
        btnNewMenuSubmit = new JButton();

        //======== NewMenu ========
        {
            NewMenu.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            NewMenu.setAlwaysOnTop(true);
            NewMenu.setTitle("New Menu Item");
            Container NewMenuContentPane = NewMenu.getContentPane();
            NewMenuContentPane.setLayout(new MigLayout(
                "fill,insets dialog,hidemode 3,align center center",
                // columns
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]",
                // rows
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]"));

            //---- lblNewMenuName ----
            lblNewMenuName.setText("Item Name");
            NewMenuContentPane.add(lblNewMenuName, "cell 1 1 4 1,grow");
            NewMenuContentPane.add(txtNewMenuName, "cell 4 1 4 1");

            //---- lblNewMenuDescription ----
            lblNewMenuDescription.setText("Item Description");
            NewMenuContentPane.add(lblNewMenuDescription, "cell 1 3 4 1");
            NewMenuContentPane.add(txtNewMenuDescription, "cell 4 3 4 1");

            //---- lblNewMenuPrice ----
            lblNewMenuPrice.setText("Item Price");
            NewMenuContentPane.add(lblNewMenuPrice, "cell 1 5 4 1");
            NewMenuContentPane.add(txtNewMenuPrice, "cell 4 5 4 1");

            //---- btnNewMenuSubmit ----
            btnNewMenuSubmit.setText("Add Item");
            btnNewMenuSubmit.addActionListener(e -> button1(e));
            NewMenuContentPane.add(btnNewMenuSubmit, "cell 1 7 7 1");
            NewMenu.setSize(500, 500);
            NewMenu.setLocationRelativeTo(null);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Harrison Easter (MRS CLI EASTER)
    private JFrame NewMenu;
    private JLabel lblNewMenuName;
    private JTextField txtNewMenuName;
    private JLabel lblNewMenuDescription;
    private JTextField txtNewMenuDescription;
    private JLabel lblNewMenuPrice;
    private JTextField txtNewMenuPrice;
    private JButton btnNewMenuSubmit;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
