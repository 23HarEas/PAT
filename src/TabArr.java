
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author harri
 */
public class TabArr {

    private int tabArrSize = 100;
    private Tab tabArr[] = new Tab[tabArrSize];
    private int numberTab = 0;
    private Connector dbObj = new Connector();

    /**
     * Initializes a new TabArr object by retrieving tab information from the
     * database and creating Tab or BookingTab objects. The retrieved data
     * includes tab ID, table number, pax, booking status, timestamp, name, and
     * cellphone number (for bookings). If a tab is not a booking, a Tab object
     * is created; otherwise, a BookingTab object is created.
     */
    public TabArr() {
        try {

            ResultSet tabDB = dbObj.readQuery("SELECT Tab.TabID, Tab.TableNumber, Tab.Time, Tab.Pax, Tab.Booking, Tab.Name, Tab.CellphoneNumber\n" + "FROM (Staff INNER JOIN [Table] ON Staff.StaffID = Table.StaffID) INNER JOIN Tab ON Table.TableNumber = Tab.TableNumber;");
            while (tabDB.next()) {

                int tabID = tabDB.getInt(1);
                int tableNumber = tabDB.getInt(2);
                int pax = tabDB.getInt(4);
                boolean booking = tabDB.getBoolean(5);
                LocalDateTime time = LocalDateTime.parse(tabDB.getString(3), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS"));
                String name = tabDB.getString(6);
                String cellphoneNumber = tabDB.getString(7);

                if (!booking) {
                    tabArr[tabID] = new Tab(tabID, tableNumber, pax, booking, time);
                    numberTab++;
                } else {
                    tabArr[tabID] = new BookingTab(name, cellphoneNumber, tabID, tableNumber, pax, booking, time);
                    numberTab++;
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffArr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Reloads tab data from the database into the tabArr array.
     */
    public void tabDBReload() {

        for (int i = 0; i < tabArrSize; i++) {
            tabArr[i] = null;
        }

        try {
            ResultSet tabDB = dbObj.readQuery("SELECT Tab.TabID, Tab.TableNumber, Tab.Time, Tab.Pax, Tab.Booking, Tab.Name, Tab.CellphoneNumber\n" + "FROM (Staff INNER JOIN [Table] ON Staff.StaffID = Table.StaffID) INNER JOIN Tab ON Table.TableNumber = Tab.TableNumber;");
            while (tabDB.next()) {

                int tabID = tabDB.getInt(1);
                int tableNumber = tabDB.getInt(2);
                int pax = tabDB.getInt(4);
                boolean booking = tabDB.getBoolean(5);
                LocalDateTime time = LocalDateTime.parse(tabDB.getString(3), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS"));
                String name = tabDB.getString(6);
                String cellphoneNumber = tabDB.getString(7);

                if (!booking) {
                    tabArr[tabID] = new Tab(tabID, tableNumber, pax, booking, time);
                } else {
                    tabArr[tabID] = new BookingTab(name, cellphoneNumber, tabID, tableNumber, pax, booking, time);
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffArr.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Retrieves a Tab object from the tabArr array based on the given tab ID.
     *
     * @param currentTabID The ID of the tab to retrieve.
     * @return The Tab object corresponding to the given tab ID.
     */
    public Tab getTabObj(int currentTabID) {
        return tabArr[currentTabID];
    }

    /**
     * Creates a new tab for the specified table number and updates relevant
     * database entries.
     *
     * @param tableNumber The number of the table for which the new tab is
     * created.
     */
    public void tabNewItem(int tableNumber) {

        dbObj.writeQuery("INSERT INTO [Tab] (TableNumber, [Time], Booking, Pax) VALUES (" + tableNumber + ", NOW(), FALSE, -1);");
        try {
            ResultSet tabDB = dbObj.readQuery("SELECT Tab.TabID FROM Tab WHERE (((Tab.Pax)=-1));");
            tabDB.next();
            int newTabID = tabDB.getInt(1);
            dbObj.writeQuery("UPDATE [Table] SET [Table].CurrentTabID = " + newTabID + " WHERE (((Table.TableNumber)= " + tableNumber + " ));");
            dbObj.writeQuery("UPDATE Tab SET Tab.Pax = 0 WHERE (((Tab.Pax)=-1));");
        } catch (SQLException ex) {
            Logger.getLogger(TabArr.class.getName()).log(Level.SEVERE, null, ex);
        }

        numberTab++;
    }

    /**
     * Loads booking tab information into the specified JTable model.
     *
     * @param table The JTable model to load booking tab information into.
     * @return The updated JTable model with booking tab information.
     */
    public DefaultTableModel bookingTableLoad(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setNumRows(0);
        for (int i = 0; i < tabArrSize; i++) {

            if (!(tabArr[i] == null) && tabArr[i].isBooking() && tabArr[i].getTime().isAfter(LocalDateTime.now().minusHours(1))) {
                model.addRow(new Object[]{tabArr[i].getTabID(), ((BookingTab) tabArr[i]).getName(), ((BookingTab) tabArr[i]).getCellphoneNumber(), tabArr[i].getPax(), tabArr[i].getTime(), tabArr[i].getTableNumber()});

            }
        }
        return model;
    }

    /**
     * Loads booking tab information into the specified JComboBox model.
     *
     * @param comboBox The JComboBox model to load booking tab information into.
     * @return The updated JComboBox model with booking tab information.
     */
    public DefaultComboBoxModel bookingComboLoad(JComboBox comboBox) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) comboBox.getModel();
        model.removeAllElements();
        for (int i = 0; i < tabArrSize; i++) {

            if (!(tabArr[i] == null) && tabArr[i].isBooking() && tabArr[i].getTime().isAfter(LocalDateTime.now().minusHours(1))) {
                model.addElement(tabArr[i].getTabID() + " " + ((BookingTab) tabArr[i]).getName() + ", Table: " + tabArr[i].getTableNumber());

            }
        }
        return model;
    }

    /**
     * Removes a booking tab based on the provided item identifier.
     *
     * @param item The item identifier string containing the tab ID.
     */
    public void bookingeRemoveItem(String item) {

        int idToRemove = Integer.parseInt(new Scanner(item).useDelimiter(" ").next());
        boolean found = false;

        for (int i = 0; i < tabArrSize; i++) {

            if (!(tabArr[i] == null) && tabArr[i].getTabID() == idToRemove) {
                dbObj.writeQuery("DELETE * FROM Tab WHERE (Tab.TabID=" + idToRemove + ");");
            }

        }

    }

    /**
     * Creates a new booking tab with the provided information.
     *
     * @param tableNumber The table number for the booking.
     * @param time The time of the booking.
     * @param name The name of the booking.
     * @param cellphone The cellphone number of the booking.
     * @param pax The number of people for the booking.
     */
    public void bookingNewItem(int tableNumber, LocalDateTime time, String name, String cellphone, int pax) {
        dbObj.writeQuery("INSERT INTO [Tab] (TableNumber, [Time], Name, CellphoneNumber, Booking, Pax) VALUES (" + tableNumber + ", \"" + time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\",  \"" + name + "\"  , \"" + cellphone + "\", TRUE, " + pax + " );");
        numberTab++;
    }

    /**
     * Saves changes to booking tabs based on the provided JTable.
     *
     * @param bookingTable The JTable containing updated booking information.
     */
    public void bookingTableSave(JTable bookingTable) {

        for (int i = 0; i < bookingTable.getModel().getRowCount(); i++) {

            int bookingID = Integer.parseInt("" + bookingTable.getValueAt(i, 0));
            String name = (String) bookingTable.getValueAt(i, 1);
            String cellphone = (String) bookingTable.getValueAt(i, 2);
            int pax = Integer.parseInt("" + bookingTable.getValueAt(i, 3));
            LocalDateTime time = (LocalDateTime) bookingTable.getValueAt(i, 4);
            int table = Integer.parseInt("" + bookingTable.getValueAt(i, 5));

            dbObj.writeQuery("UPDATE [Tab] SET TableNumber = " + table + ", Time = \"" + time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\" , Name = \"" + name + "\", CellphoneNumber = \"" + cellphone + "\" , Pax = \"" + pax + "\"  WHERE (TabID = " + bookingID + ");");

        }

    }

    public void bookingLoad(String item) {
        /**
         * Loads a booking by updating the corresponding table with the provided
         * item information.
         *
         * @param item The item string containing booking details.
         */
        Scanner sc = new Scanner(item).useDelimiter(" ");
        int tabID = Integer.parseInt(sc.next());
        sc.next();
        sc.next();
        int table = Integer.parseInt(sc.next());

        if (MainScreen.tableArr.getCurrentTabID(table) == 0) {
            dbObj.writeQuery("UPDATE [Table] SET [Table].CurrentTabID = " + tabID + " WHERE (((Table.TableNumber)= " + table + " ));");
            ScreenBuild.mainScreen.reloadDBs();
            ScreenBuild.mainScreen.setBtnIcons();
        } else {
            JOptionPane.showMessageDialog(null, "Please close existing tab for Table: " + table);
        }

    }

}
