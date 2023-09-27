
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.layout.*;
import net.miginfocom.swing.*;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/*
 * Created by JFormDesigner on Thu Aug 24 13:34:31 SAST 2023
 */
/**
 * @author harrisoneaster
 */
public class RemoveStaffItem extends JFrame {

    /**
     * Initializes the RemoveStaffItem window.
     *
     * This constructor is responsible for initializing the RemoveStaffItem
     * window by setting up its components. It populates the combo box with
     * staff members loaded from MainScreen's staffArr and decorates it for
     * auto-completion.
     */
    public RemoveStaffItem() {
        initComponents();
        cmbRemoveStaff.setModel(MainScreen.staffArr.staffComboLoad(cmbRemoveStaff));
        AutoCompleteDecorator.decorate(cmbRemoveStaff);
    }

    /**
     * Handles the submit action to remove a staff member.
     *
     * This method is triggered when the "Submit" button is clicked in the
     * RemoveStaffItem window. It retrieves the selected staff member from the
     * combo box, removes the staff member from MainScreen's staffArr, disposes
     * of the current window, and refreshes and saves the JTables in the main
     * screen.
     *
     * @param e The ActionEvent object representing the button click event.
     */
    private void btnRemoveStaffSubmit(ActionEvent e) {
        // TODO add your code here
        String remove = (String) cmbRemoveStaff.getSelectedItem();
        MainScreen.staffArr.staffRemoveItem(remove);
        dispose();
        ScreenBuild.mainScreen.refreshJTables();
        ScreenBuild.mainScreen.saveJTables();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Harrison Easter (MRS CLI EASTER)
        lblRemoveStaff = new JLabel();
        cmbRemoveStaff = new JComboBox();
        btnRemoveStaffSubmit = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setTitle("Remove Staff Member");
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

        //---- lblRemoveStaff ----
        lblRemoveStaff.setText("Staff Member To Remove");
        lblRemoveStaff.setHorizontalAlignment(SwingConstants.LEFT);
        contentPane.add(lblRemoveStaff, new CC().cell(1, 2, 7, 1));
        contentPane.add(cmbRemoveStaff, new CC().cell(1, 3, 7, 1));

        //---- btnRemoveStaffSubmit ----
        btnRemoveStaffSubmit.setText("Remove Staff Member");
        btnRemoveStaffSubmit.addActionListener(e -> btnRemoveStaffSubmit(e));
        contentPane.add(btnRemoveStaffSubmit, new CC().cell(1, 7, 7, 1));
        setSize(500, 500);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Harrison Easter (MRS CLI EASTER)
    private JLabel lblRemoveStaff;
    private JComboBox cmbRemoveStaff;
    private JButton btnRemoveStaffSubmit;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
