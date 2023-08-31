
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import javax.swing.*;
import net.miginfocom.layout.*;
import net.miginfocom.swing.*;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/*
 * Created by JFormDesigner on Sat Aug 26 15:19:29 CAT 2023
 */
/**
 * @author harri
 */
public class NewOrder extends JFrame {

    public NewOrder() {
        initComponents();
        cmbNewOrderItem.setModel(MainScreen.menuArr.menuComboLoad(cmbNewOrderItem));
        AutoCompleteDecorator.decorate(cmbNewOrderItem);
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
        int itemID = Integer.parseInt(new Scanner(cmbNewOrderItem.getSelectedItem() + "").useDelimiter(" ").next());
        String notes = txtNewOrderNotes.getText();
        int tabID = MainScreen.tableArr.getCurrentTabID(MainScreen.workingTable);

        MainScreen.ordersArr.ordersNewItem(itemID, tabID, notes);
        MainScreen.tableScreen.refreshTable();
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Harrison Easter (MRS CLI EASTER)
        lblNewOrderItem = new JLabel();
        cmbNewOrderItem = new JComboBox();
        lblNewOrderNotes = new JLabel();
        txtNewOrderNotes = new JTextField();
        btnNewOrderSubmit = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setTitle("New Order");
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

        //---- lblNewOrderItem ----
        lblNewOrderItem.setText("Item");
        lblNewOrderItem.setHorizontalAlignment(SwingConstants.LEFT);
        contentPane.add(lblNewOrderItem, new CC().cell(1, 2));
        contentPane.add(cmbNewOrderItem, new CC().cell(2, 2, 6, 1));

        //---- lblNewOrderNotes ----
        lblNewOrderNotes.setText("Notes");
        contentPane.add(lblNewOrderNotes, new CC().cell(1, 4));
        contentPane.add(txtNewOrderNotes, new CC().cell(2, 4, 6, 1));

        //---- btnNewOrderSubmit ----
        btnNewOrderSubmit.setText("Place Order");
        btnNewOrderSubmit.addActionListener(e -> button1(e));
        contentPane.add(btnNewOrderSubmit, new CC().cell(1, 7, 7, 1));
        setSize(500, 500);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Harrison Easter (MRS CLI EASTER)
    private JLabel lblNewOrderItem;
    private JComboBox cmbNewOrderItem;
    private JLabel lblNewOrderNotes;
    private JTextField txtNewOrderNotes;
    private JButton btnNewOrderSubmit;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
