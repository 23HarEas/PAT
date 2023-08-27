
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
    
    public void StaffDBReload() {
        try {
            ResultSet staffDB = dbObj.execQuerySet("SELECT Staff.StaffID, Staff.Name, Staff.Surname, Staff.CellphoneNumber, Staff.Position, Staff.Salary\n" + "FROM Staff;");
            int i = 0;
            
            while (staffDB.next())
            {
                
                int staffID = staffDB.getInt(1);
                String name = staffDB.getString(2);
                String surname = staffDB.getString(3);
                String cellphoneNumber = staffDB.getString(4);
                String position = staffDB.getString(5);
                Double salary = staffDB.getDouble(6);
                
                staffArr[i] = new Staff(staffID, name, surname, cellphoneNumber, position, salary);
                i++;
                
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
    
    public void newStaffItem(String name, String surname, String cellNO, String position, Double wage){
        staffArr[numberStaff] = new Staff(-1, name, surname, cellNO, position, wage);
        numberStaff++;
    }
    
    public DefaultComboBoxModel StaffComboLoad(JComboBox comboBox)
    {
        DefaultComboBoxModel model = (DefaultComboBoxModel) comboBox.getModel();
        model.removeAllElements();
        for (int i = 0; i < numberStaff; i++) {
            model.addElement(staffArr[i].getStaffID() + " " + staffArr[i].getName() + " " + staffArr[i].getSurname());
        }
        return model;
    }
    
    public void removeStaffItem(String item)
    {
       
        int idToRemove = Integer.parseInt(new Scanner(item).useDelimiter(" ").next());
        boolean found = false;
        
        for (int i = 0; i < numberStaff; i++) {
            
            if (staffArr[i].getStaffID()== idToRemove || found)
            {
                found = true;
                staffArr[i] = staffArr[i+1];
            }
            
        }
        
        if (found)
        {
            numberStaff--;
            dbObj.Insert("DELETE FROM Staff WHERE (Staff.StaffID=" + idToRemove + ");");
        }
        
    }
    
    public void StaffSave(JTable staffTable)
    {
        for (int i = 0; i < numberStaff; i++) {

            int staffID = Integer.parseInt(""+staffTable.getValueAt(i, 0));
            String name = (String)staffTable.getValueAt(i, 1);
            String surname = (String)staffTable.getValueAt(i, 2);
            String cellphone = (String)staffTable.getValueAt(i, 3);
            String position = (String)staffTable.getValueAt(i, 4);
            Double wage = Double.parseDouble(""+staffTable.getValueAt(i, 5));
            
            for (int j = 0; j < numberStaff; j++) {
                
                if (staffArr[j].getStaffID() == staffID)
                {
                    staffArr[j] = new Staff(staffID, name, surname, cellphone, position, wage);
                    
                    if (staffArr[j].getStaffID() == -1)
                    {
                        
                        dbObj.Insert("INSERT INTO Staff (Name, Surname, CellphoneNumber, Position, Salary) VALUES (\""+name+"\", \""+surname+"\", \""+cellphone+"\", \""+position+"\", "+wage+");");
                    }
                    else
                    {
                        
                        dbObj.Update("UPDATE Staff SET Name = \"" + name +"\", Surname = \"" + surname + "\", CellphoneNumber = \"" + cellphone + "\", Position = \"" + position + "\", Salary = " + wage + " WHERE (StaffID=" +staffID + ");");
                    }
                }
            }
            
            StaffDBReload();
            
        }
    }
    
    
}
