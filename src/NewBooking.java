
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.github.lgooddatepicker.components.*;
import com.github.lgooddatepicker.components.TimePickerSettings.TimeIncrement;
import java.time.LocalDate;
import java.time.LocalTime;
import net.miginfocom.layout.*;
import net.miginfocom.swing.*;

/*
 * Created by JFormDesigner on Mon Aug 28 20:31:37 CAT 2023
 */
/**
 * @author harri
 */
public class NewBooking extends JFrame {

    public NewBooking() {
        initComponents();
        cmbNewBookingTable.setModel(MainScreen.tableArr.TableComboLoad(cmbNewBookingTable));
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
        MainScreen.tabArr.bookingNewItem(Integer.parseInt("" + cmbNewBookingTable.getSelectedItem()), dtpNewBookingTime.getDateTimePermissive(), txtNewBookingName.getText(), txtNewBookingCellphone.getText(), Integer.parseInt("" + cmbNewBookingPax.getSelectedItem()));
        dispose();
        ScreenBuild.mainScreen.reloadDBs();
        MainScreen.viewBookings.refreshBookingTable();

    }

    private void createUIComponents() {
        // TODO: add custom component creation code here
        DatePickerSettings dateSettings = new DatePickerSettings();
        TimePickerSettings timeSettings = new TimePickerSettings();
        timeSettings.use24HourClockFormat();
        timeSettings.initialTime = LocalTime.now();
        dateSettings.setAllowKeyboardEditing(false);
        timeSettings.setAllowKeyboardEditing(false);
        timeSettings.generatePotentialMenuTimes(TimeIncrement.FifteenMinutes, null, null);
        dtpNewBookingTime = new DateTimePicker(dateSettings, timeSettings);
        dateSettings.setDateRangeLimits(LocalDate.now(), LocalDate.MAX);
        dtpNewBookingTime.datePicker.setDateToToday();

    }

    private void cmbNewBookingTableItemStateChanged(ItemEvent e) {
        // TODO add your code here
        cmbNewBookingPax.setModel(MainScreen.tableArr.TablePax(cmbNewBookingPax, Integer.parseInt("" + cmbNewBookingTable.getSelectedItem())));
        ScreenBuild.mainScreen.reloadDBs();
        MainScreen.viewBookings.refreshBookingTable();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Harrison Easter (MRS CLI EASTER)
        createUIComponents();

        lblNewBookingTable = new JLabel();
        cmbNewBookingTable = new JComboBox();
        lblNewBookingName = new JLabel();
        txtNewBookingName = new JTextField();
        lblNewBookingCellphone = new JLabel();
        txtNewBookingCellphone = new JTextField();
        lblNewBookingPax = new JLabel();
        cmbNewBookingPax = new JComboBox();
        lblNewBookingTime = new JLabel();
        btnNewBookingSubmit = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setTitle("New Booking");
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

        //---- lblNewBookingTable ----
        lblNewBookingTable.setText("Table");
        contentPane.add(lblNewBookingTable, new CC().cell(1, 1, 2, 1).grow());

        //---- cmbNewBookingTable ----
        cmbNewBookingTable.addItemListener(e -> cmbNewBookingTableItemStateChanged(e));
        contentPane.add(cmbNewBookingTable, new CC().cell(3, 1, 5, 1));

        //---- lblNewBookingName ----
        lblNewBookingName.setText("Name");
        contentPane.add(lblNewBookingName, new CC().cell(1, 2, 2, 1).grow());
        contentPane.add(txtNewBookingName, new CC().cell(3, 2, 5, 1));

        //---- lblNewBookingCellphone ----
        lblNewBookingCellphone.setText("Cellphone");
        contentPane.add(lblNewBookingCellphone, new CC().cell(1, 3, 2, 1));
        contentPane.add(txtNewBookingCellphone, new CC().cell(3, 3, 5, 1));

        //---- lblNewBookingPax ----
        lblNewBookingPax.setText("Pax");
        contentPane.add(lblNewBookingPax, new CC().cell(1, 4, 2, 1).grow());
        contentPane.add(cmbNewBookingPax, new CC().cell(3, 4, 5, 1));

        //---- lblNewBookingTime ----
        lblNewBookingTime.setText("Time");
        contentPane.add(lblNewBookingTime, new CC().cell(1, 5, 2, 1));

        //---- dtpNewBookingTime ----
        dtpNewBookingTime.setPreferredSize(new Dimension(0, 0));
        dtpNewBookingTime.setMinimumSize(new Dimension(0, 0));
        contentPane.add(dtpNewBookingTime, new CC().cell(3, 5, 5, 1));

        //---- btnNewBookingSubmit ----
        btnNewBookingSubmit.setText("Add Booking");
        btnNewBookingSubmit.addActionListener(e -> button1(e));
        contentPane.add(btnNewBookingSubmit, new CC().cell(1, 7, 7, 1));
        setSize(500, 500);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Harrison Easter (MRS CLI EASTER)
    private JLabel lblNewBookingTable;
    private JComboBox cmbNewBookingTable;
    private JLabel lblNewBookingName;
    private JTextField txtNewBookingName;
    private JLabel lblNewBookingCellphone;
    private JTextField txtNewBookingCellphone;
    private JLabel lblNewBookingPax;
    private JComboBox cmbNewBookingPax;
    private JLabel lblNewBookingTime;
    private DateTimePicker dtpNewBookingTime;
    private JButton btnNewBookingSubmit;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
