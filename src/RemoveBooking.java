
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.layout.*;
import net.miginfocom.swing.*;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/*
 * Created by JFormDesigner on Mon Aug 28 17:03:27 CAT 2023
 */
/**
 * @author harri
 */
public class RemoveBooking extends JFrame {

    public RemoveBooking() {
        initComponents();
        cmbRemoveBooking.setModel(MainScreen.tabArr.BookingComboLoad(cmbRemoveBooking));
        AutoCompleteDecorator.decorate(cmbRemoveBooking);
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
        String remove = (String) cmbRemoveBooking.getSelectedItem();
        MainScreen.tabArr.removeBooking(remove);
        dispose();
        ScreenBuild.mainScreen.reloadTables();
        MainScreen.viewBookings.refreshBookingTable();

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Harrison Easter (MRS CLI EASTER)
        lblRemoveBooking = new JLabel();
        cmbRemoveBooking = new JComboBox();
        btnRemoveBookingSubmit = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setTitle("Remove Booking");
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

        //---- lblRemoveBooking ----
        lblRemoveBooking.setText("Booking to Remove");
        lblRemoveBooking.setHorizontalAlignment(SwingConstants.LEFT);
        contentPane.add(lblRemoveBooking, new CC().cell(1, 2, 7, 1));
        contentPane.add(cmbRemoveBooking, new CC().cell(1, 3, 7, 1));

        //---- btnRemoveBookingSubmit ----
        btnRemoveBookingSubmit.setText("Remove Item");
        btnRemoveBookingSubmit.addActionListener(e -> button1(e));
        contentPane.add(btnRemoveBookingSubmit, new CC().cell(1, 7, 7, 1));
        setSize(500, 500);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Harrison Easter (MRS CLI EASTER)
    private JLabel lblRemoveBooking;
    private JComboBox cmbRemoveBooking;
    private JButton btnRemoveBookingSubmit;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
