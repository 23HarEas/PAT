
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author harri
 */
public class StaffArr {
    private Staff staffArr[];
    private int numberStaff = 0;

    public StaffArr(ResultSet staffDB) {
        try {
            while (staffDB.next())
            {
                String staffID = staffDB.getString(1);
                String name = staffDB.getString(2);
                String surname = staffDB.getString(1);
                String cellphoneNumber = staffDB.getString(3);
                String position = staffDB.getString(4);
                Double salary = staffDB.getDouble(5);
                numberStaff++;
                staffArr[numberStaff] = new Staff(staffID, name, surname, cellphoneNumber, position, salary);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffArr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Staff[] getStaffArr() {
        return staffArr;
    }

    public int getNumberStaff() {
        return numberStaff;
    }

    public void setStaffArr(Staff[] staffArr) {
        this.staffArr = staffArr;
    }

    public void setNumberStaff(int numberStaff) {
        this.numberStaff = numberStaff;
    }
    
    
    
}
