
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author harri
 */
public class TableArr {

    private Table tableArr[] = new Table[100];
    private int numberTables = 0;
    Connector dbObj = new Connector();

    public TableArr() {
        try {

            ResultSet tableDB = dbObj.readQuery("SELECT Table.TableNumber, Table.CurrentTabID, Staff.Name, Table.Capacity\n" + "FROM Staff INNER JOIN [Table] ON Staff.StaffID = Table.StaffID;");
            while (tableDB.next()) {

                int tableNumber = tableDB.getInt(1);
                int currentTabID = tableDB.getInt(2);
                String staff = tableDB.getString(3);
                int capacity = tableDB.getInt(4);

                tableArr[tableNumber] = new Table(tableNumber, currentTabID, staff, capacity);
                numberTables++;

            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffArr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Reloads the table data from the database and updates the internal
     * representation of tables.
     */
    public void TableDBReload() {

        try {

            ResultSet tableDB = dbObj.readQuery("SELECT Table.TableNumber, Table.CurrentTabID, Staff.Name, Table.Capacity\n" + "FROM Staff INNER JOIN [Table] ON Staff.StaffID = Table.StaffID;");
            while (tableDB.next()) {

                int tableNumber = tableDB.getInt(1);
                int currentTabID = tableDB.getInt(2);
                String staff = tableDB.getString(3);
                int capacity = tableDB.getInt(4);

                tableArr[tableNumber] = new Table(tableNumber, currentTabID, staff, capacity);

            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffArr.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Returns the total number of tables in the restaurant.
     *
     * @return The total number of tables.
     */
    public int getNumberTables() {
        return numberTables;
    }

    /**
     * Returns the ID of the current tab associated with a specific table.
     *
     * @param table The table number for which to retrieve the current tab ID.
     * @return The ID of the current tab associated with the specified table.
     */
    public int getCurrentTabID(int table) {
        return tableArr[table].getCurrentTabID();
    }

    /**
     * Returns the current Table object associated with a specific table number.
     *
     * @param table The table number for which to retrieve the Table object.
     * @return The Table object associated with the specified table number.
     */
    public Table getCurrentTableOBJ(int table) {
        return tableArr[table];
    }

    /**
     * Closes the tab associated with the specified table number.
     *
     * @param tableNumber The table number for which to close the tab.
     */
    public void closeTab(int tableNumber) {
        dbObj.writeQuery("UPDATE [Table] SET [Table].CurrentTabID = 0 WHERE (((Table.TableNumber)= " + tableNumber + " ));");
    }

    /**
     * Loads table numbers into a combo box.
     *
     * @param comboBox The combo box to load the table numbers into.
     * @return The updated DefaultComboBoxModel.
     */
    public DefaultComboBoxModel TableComboLoad(JComboBox comboBox) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) comboBox.getModel();
        model.removeAllElements();
        for (int i = 0; i < numberTables; i++) {

            if (!(tableArr[i] == null)) {
                model.addElement(tableArr[i].getTableNumber());

            }
        }
        return model;
    }

    /**
     * Loads available pax options for a specific table into a combo box.
     *
     * @param comboBox The combo box to load the pax options into.
     * @param table The table for which to load the pax options.
     * @return The updated DefaultComboBoxModel.
     */
    public DefaultComboBoxModel TablePax(JComboBox comboBox, int table) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) comboBox.getModel();
        model.removeAllElements();

        for (int i = 0; i < tableArr[table].getCapacity(); i++) {
            model.addElement(i + 1);
        }

        return model;
    }

}
