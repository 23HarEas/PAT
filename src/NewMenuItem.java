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
public class NewMenuItem extends JFrame {
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
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();
        button1 = new JButton();

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

        //---- label1 ----
        label1.setText("Item Name");
        contentPane.add(label1, new CC().cell(1, 1, 4, 1).grow());
        contentPane.add(textField1, new CC().cell(4, 1, 5, 1));

        //---- label2 ----
        label2.setText("Item Description");
        contentPane.add(label2, new CC().cell(1, 3, 4, 1));
        contentPane.add(textField2, new CC().cell(4, 3, 5, 1));

        //---- label3 ----
        label3.setText("Item Price");
        contentPane.add(label3, new CC().cell(1, 5, 4, 1));
        contentPane.add(textField3, new CC().cell(4, 5, 5, 1));

        //---- button1 ----
        button1.setText("Add Item");
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1, new CC().cell(1, 7, 8, 1));
        setSize(500, 500);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Harrison Easter (MRS CLI EASTER)
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JTextField textField3;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
