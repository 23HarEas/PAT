
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.github.lgooddatepicker.components.TimePickerSettings;
import com.github.lgooddatepicker.tableeditors.DateTimeTableEditor;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import javax.swing.*;
import javax.swing.table.*;
import net.miginfocom.layout.*;
import net.miginfocom.swing.*;

/*
 * Created by JFormDesigner on Mon Aug 28 15:59:27 CAT 2023
 */
/**
 * @author harri
 */
public class ViewBookings extends JFrame {

    /**
     * Initializes the ViewBookings form, configures table column cell editors
     * and renderers, and refreshes the booking table.
     */
    public ViewBookings() {
        initComponents();

        tblBookings.getColumnModel().getColumn(1).setCellEditor(new NonBlankCellEditor());
        tblBookings.getColumnModel().getColumn(2).setCellEditor(new NonBlankCellEditor());
        tblBookings.getColumnModel().getColumn(3).setCellEditor(new NonBlankIntegerCellEditor());
        tblBookings.getColumnModel().getColumn(5).setCellEditor(new NonBlankIntegerCellEditor());

        DateTimeTableEditor dateTimeCellEditor = new DateTimeTableEditor();
        dateTimeCellEditor.getTimePickerSettings().use24HourClockFormat();
        dateTimeCellEditor.getDatePickerSettings().setAllowKeyboardEditing(false);
        dateTimeCellEditor.getTimePickerSettings().setAllowKeyboardEditing(false);
        dateTimeCellEditor.getDatePickerSettings().setAllowEmptyDates(false);
        dateTimeCellEditor.getTimePickerSettings().setAllowEmptyTimes(false);
        dateTimeCellEditor.getTimePickerSettings().generatePotentialMenuTimes(TimePickerSettings.TimeIncrement.FifteenMinutes, null, null);
        dateTimeCellEditor.getDatePickerSettings().setDateRangeLimits(LocalDate.now(), LocalDate.MAX);

        DateTimeTableEditor dateTimeRenderer = new DateTimeTableEditor();
        dateTimeRenderer.getTimePickerSettings().use24HourClockFormat();

        tblBookings.getColumnModel().getColumn(4).setCellRenderer(dateTimeRenderer);
        tblBookings.getColumnModel().getColumn(4).setCellEditor(dateTimeCellEditor);
        refreshBookingTable();

    }

    /**
     * Handles the "Remove Booking" button click event. Opens the RemoveBooking
     * form to remove a booking.
     *
     * @param e The ActionEvent triggered by the button click.
     */
    private void btnBookingsRemove(ActionEvent e) {
        // TODO add your code here
        FlatIntelliJLaf.setup();
        new RemoveBooking().setVisible(true);
    }

    /**
     * Refreshes the booking table. Reloads the database data and updates the
     * booking table with the latest information.
     */
    public void refreshBookingTable() {
        ScreenBuild.mainScreen.reloadDBs();
        tblBookings.setModel(MainScreen.tabArr.bookingTableLoad(tblBookings));
    }

    /**
     * Event handler for the "Refresh" button in the bookings view. Calls the
     * refreshBookingTable method to update the booking table with the latest
     * data.
     *
     * @param e The ActionEvent triggered by clicking the "Refresh" button.
     */
    private void btnBookingsRefresh(ActionEvent e) {
        // TODO add your code here
        refreshBookingTable();
    }

    /**
     * Event handler for the "Save" button in the bookings view. Calls the
     * bookingTableSave method to save changes made in the booking table,
     * reloads the database, and refreshes the booking table with updated data.
     *
     * @param e The ActionEvent triggered by clicking the "Save" button.
     */
    private void btnBookingsSave(ActionEvent e) {
        // TODO add your code here
        MainScreen.tabArr.bookingTableSave(tblBookings);
        ScreenBuild.mainScreen.reloadDBs();
        refreshBookingTable();
    }

    /**
     * Event handler for the "New" button in the bookings view. Opens a new
     * booking form for creating a new booking when the button is clicked.
     *
     * @param e The ActionEvent triggered by clicking the "New" button.
     */
    private void btnBookingsNew(ActionEvent e) {
        // TODO add your code here
        FlatIntelliJLaf.setup();
        new NewBooking().setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Harrison Easter (MRS CLI EASTER)
        scrBookings = new JScrollPane();
        tblBookings = new JTable();
        btnBookingsSave = new JButton();
        btnBookingsRefresh = new JButton();
        btnBookingsRemove = new JButton();
        btnBookingsNew = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setTitle("Upcoming Bookings");
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            new LC().fill().insets("dialog").hideMode(3).align("center", "center"),
            // columns
            new AC()
                .size("150").shrink(0).fill().gap()
                .size("150").shrink(0).fill().gap()
                .size("150").shrink(0).fill().gap()
                .size("150").shrink(0).fill().gap()
                .shrink(0).fill().gap()
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
                .size("392").shrink(0).fill().gap()
                .size("14").shrink(0).fill()));

        //======== scrBookings ========
        {

            //---- tblBookings ----
            tblBookings.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                },
                new String[] {
                    "Booking ID", "Name", "Cellphone", "Pax", "Time", "Table"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    Integer.class, Object.class, Object.class, Integer.class, Object.class, Integer.class
                };
                boolean[] columnEditable = new boolean[] {
                    false, true, true, true, true, true
                };
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
                }
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            {
                TableColumnModel cm = tblBookings.getColumnModel();
                cm.getColumn(0).setResizable(false);
                cm.getColumn(0).setMaxWidth(65);
                cm.getColumn(2).setMinWidth(150);
                cm.getColumn(2).setMaxWidth(150);
                cm.getColumn(3).setMaxWidth(65);
                cm.getColumn(3).setPreferredWidth(65);
                cm.getColumn(4).setMinWidth(250);
                cm.getColumn(4).setMaxWidth(250);
                cm.getColumn(4).setPreferredWidth(250);
                cm.getColumn(5).setMaxWidth(65);
            }
            tblBookings.setShowHorizontalLines(true);
            tblBookings.setShowVerticalLines(true);
            tblBookings.setAutoCreateRowSorter(true);
            scrBookings.setViewportView(tblBookings);
        }
        contentPane.add(scrBookings, new CC().cell(0, 0, 15, 1));

        //---- btnBookingsSave ----
        btnBookingsSave.setText("Save");
        btnBookingsSave.addActionListener(e -> btnBookingsSave(e));
        contentPane.add(btnBookingsSave, new CC().cell(0, 1));

        //---- btnBookingsRefresh ----
        btnBookingsRefresh.setText("Refresh");
        btnBookingsRefresh.addActionListener(e -> btnBookingsRefresh(e));
        contentPane.add(btnBookingsRefresh, new CC().cell(1, 1));

        //---- btnBookingsRemove ----
        btnBookingsRemove.setText("Remove Booking");
        btnBookingsRemove.addActionListener(e -> btnBookingsRemove(e));
        contentPane.add(btnBookingsRemove, new CC().cell(2, 1));

        //---- btnBookingsNew ----
        btnBookingsNew.setText("New Booking");
        btnBookingsNew.addActionListener(e -> btnBookingsNew(e));
        contentPane.add(btnBookingsNew, new CC().cell(3, 1));
        setSize(1000, 500);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Harrison Easter (MRS CLI EASTER)
    private JScrollPane scrBookings;
    private JTable tblBookings;
    private JButton btnBookingsSave;
    private JButton btnBookingsRefresh;
    private JButton btnBookingsRemove;
    private JButton btnBookingsNew;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
