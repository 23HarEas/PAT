
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
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
public class StaffArr {

    private Staff staffArr[] = new Staff[100];
    private int numberStaff = 0;
    Connector dbObj = new Connector();

    public StaffArr() {
        try {
            ResultSet staffDB = dbObj.readQuery("SELECT Staff.StaffID, Staff.Name, Staff.Surname, Staff.CellphoneNumber, Staff.Position, Staff.Wage\n" + "FROM Staff;");
            while (staffDB.next()) {

                int staffID = staffDB.getInt(1);
                String name = staffDB.getString(2);
                String surname = staffDB.getString(3);
                String cellphoneNumber = staffDB.getString(4);
                String position = staffDB.getString(5);
                Double wage = staffDB.getDouble(6);

                staffArr[numberStaff] = new Staff(staffID, name, surname, cellphoneNumber, position, wage);
                numberStaff++;

            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffArr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Reloads staff data from the database into the staffArr array.
     */
    public void staffDBReload() {
        try {
            ResultSet staffDB = dbObj.readQuery("SELECT Staff.StaffID, Staff.Name, Staff.Surname, Staff.CellphoneNumber, Staff.Position, Staff.Wage\n" + "FROM Staff;");
            int i = 0;

            while (staffDB.next()) {

                int staffID = staffDB.getInt(1);
                String name = staffDB.getString(2);
                String surname = staffDB.getString(3);
                String cellphoneNumber = staffDB.getString(4);
                String position = staffDB.getString(5);
                Double wage = staffDB.getDouble(6);

                staffArr[i] = new Staff(staffID, name, surname, cellphoneNumber, position, wage);
                i++;

            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffArr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Loads staff data into a DefaultTableModel for display in a JTable.
     *
     * @param table The JTable in which to display the staff data.
     * @return The DefaultTableModel containing the loaded staff data.
     */
    public DefaultTableModel staffTableLoad(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setNumRows(0);
        for (int i = 0; i < numberStaff; i++) {
            model.addRow(new Object[]{staffArr[i].getStaffID(), staffArr[i].getName(), staffArr[i].getSurname(), staffArr[i].getCellphoneNumber(), staffArr[i].getPosition(), (int) Math.round(staffArr[i].getWage())});
        }
        return model;
    }

    /**
     * Adds a new staff member to the staffArr array.
     *
     * @param name The name of the new staff member.
     * @param surname The surname of the new staff member.
     * @param cellNO The cellphone number of the new staff member.
     * @param position The position of the new staff member.
     * @param wage The wage of the new staff member.
     */
    public void staffNewItem(String name, String surname, String cellNO, String position, Double wage) {
        staffArr[numberStaff] = new Staff(-1, name, surname, cellNO, position, wage);
        numberStaff++;
    }

    /**
     * Loads staff information into a DefaultComboBoxModel for display in a
     * JComboBox.
     *
     * @param comboBox The JComboBox in which to display the staff information.
     * @return The DefaultComboBoxModel containing the loaded staff information.
     */
    public DefaultComboBoxModel staffComboLoad(JComboBox comboBox) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) comboBox.getModel();
        model.removeAllElements();
        for (int i = 0; i < numberStaff; i++) {
            model.addElement(staffArr[i].getStaffID() + " " + staffArr[i].getName() + " " + staffArr[i].getSurname());
        }
        return model;
    }

    /**
     * Removes a staff member from the staffArr array and database.
     *
     * @param item The item representing the staff member to be removed (staff
     * ID).
     */
    public void staffRemoveItem(String item) {

        int idToRemove = Integer.parseInt(new Scanner(item).useDelimiter(" ").next());
        boolean found = false;

        for (int i = 0; i < numberStaff; i++) {

            if (staffArr[i].getStaffID() == idToRemove || found) {
                found = true;
                staffArr[i] = staffArr[i + 1];
            }

        }

        if (found) {
            numberStaff--;
            dbObj.writeQuery("DELETE FROM Staff WHERE (Staff.StaffID=" + idToRemove + ");");
        }

    }

    /**
     * Saves changes made to staff data in the staffTable to both the staffArr
     * array and the database.
     *
     * @param staffTable The JTable containing the staff data to be saved.
     */
    public void staffTableSave(JTable staffTable) {
        for (int i = 0; i < numberStaff; i++) {

            int staffID = Integer.parseInt("" + staffTable.getValueAt(i, 0));
            String name = (String) staffTable.getValueAt(i, 1);
            String surname = (String) staffTable.getValueAt(i, 2);
            String cellphone = (String) staffTable.getValueAt(i, 3);
            String position = (String) staffTable.getValueAt(i, 4);
            Double wage = Double.parseDouble("" + staffTable.getValueAt(i, 5));

            for (int j = 0; j < numberStaff; j++) {

                if (staffArr[j].getStaffID() == staffID) {
                    staffArr[j] = new Staff(staffID, name, surname, cellphone, position, wage);

                    if (staffArr[j].getStaffID() == -1) {

                        dbObj.writeQuery("INSERT INTO Staff (Name, Surname, CellphoneNumber, Position, Wage) VALUES (\"" + name + "\", \"" + surname + "\", \"" + cellphone + "\", \"" + position + "\", " + wage + ");");
                    } else {

                        dbObj.writeQuery("UPDATE Staff SET Name = \"" + name + "\", Surname = \"" + surname + "\", CellphoneNumber = \"" + cellphone + "\", Position = \"" + position + "\", Wage = " + wage + " WHERE (StaffID=" + staffID + ");");
                    }
                }
            }

            staffDBReload();

        }
    }

}
