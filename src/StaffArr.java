
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public StaffArr() {
        try {
            Connector dbObj = new Connector();
            ResultSet staffDB = dbObj.execQuerySet("SELECT Staff.StaffID, Staff.Name, Staff.Surname, Staff.CellphoneNumber, Staff.Position, Staff.Salary\n" + "FROM Staff;");
            while (staffDB.next())
            {
                
                int staffID = staffDB.getInt(1);
                String name = staffDB.getString(2);
                String surname = staffDB.getString(3);
                String cellphoneNumber = staffDB.getString(4);
                String position = staffDB.getString(5);
                Double salary = staffDB.getDouble(6);
                
                staffArr[numberStaff] = new Staff(staffID, name, surname, cellphoneNumber, position, salary);
                numberStaff++;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffArr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DefaultTableModel StaffLoad(JTable table)
    {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setNumRows(0);
        for (int i = 0; i < numberStaff; i++) {
            model.addRow(new Object[]{staffArr[i].getStaffID(), staffArr[i].getName(), staffArr[i].getSurname(), staffArr[i].getCellphoneNumber(), staffArr[i].getPosition(), staffArr[i].getSalary()});
        }
        return model;
    }
    
 
}
