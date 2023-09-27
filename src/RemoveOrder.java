
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.layout.*;
import net.miginfocom.swing.*;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/*
 * Created by JFormDesigner on Sun Aug 27 11:34:11 CAT 2023
 */
/**
 * @author harri
 */
public class RemoveOrder extends JFrame {

    /**
     * Initializes the RemoveOrder window.
     *
     * This constructor is responsible for initializing the RemoveOrder window
     * components. It populates the combo box with orders using the
     * ordersComboLoad method from MainScreen's ordersArr and decorates the
     * combo box with AutoComplete functionality. This window allows users to
     * select and remove specific orders.
     */
    public RemoveOrder() {
        initComponents();
        cmbRemoveOrder.setModel(MainScreen.ordersArr.ordersComboLoad(cmbRemoveOrder));
        AutoCompleteDecorator.decorate(cmbRemoveOrder);
    }

    /**
     * Handles the removal of a selected order.
     *
     * This method is triggered when the user clicks the submit button to remove
     * an order. It retrieves the selected order from the combo box, passes it
     * to the ordersRemoveItem method in MainScreen's ordersArr to remove the
     * order from the database, refreshes the table display, and closes the
     * RemoveOrder window.
     *
     * @param e The ActionEvent triggered by clicking the submit button.
     */
    private void btnRemoveOrderSubmit(ActionEvent e) {
        // TODO add your code here
        String remove = (String) cmbRemoveOrder.getSelectedItem();
        MainScreen.ordersArr.ordersRemoveItem(remove);
        MainScreen.tableScreen.refreshTable();
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Harrison Easter (MRS CLI EASTER)
        lblRemoveOrder = new JLabel();
        cmbRemoveOrder = new JComboBox();
        btnRemoveOrderSubmit = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setTitle("Remove Order");
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

        //---- lblRemoveOrder ----
        lblRemoveOrder.setText("Order To Remove");
        lblRemoveOrder.setHorizontalAlignment(SwingConstants.LEFT);
        contentPane.add(lblRemoveOrder, new CC().cell(1, 2, 7, 1));
        contentPane.add(cmbRemoveOrder, new CC().cell(1, 3, 7, 1));

        //---- btnRemoveOrderSubmit ----
        btnRemoveOrderSubmit.setText("Remove Order");
        btnRemoveOrderSubmit.addActionListener(e -> btnRemoveOrderSubmit(e));
        contentPane.add(btnRemoveOrderSubmit, new CC().cell(1, 7, 7, 1));
        setSize(500, 500);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Harrison Easter (MRS CLI EASTER)
    private JLabel lblRemoveOrder;
    private JComboBox cmbRemoveOrder;
    private JButton btnRemoveOrderSubmit;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
