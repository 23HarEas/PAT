
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
public class TableArr {
    
    private Table tableArr[] = new Table[100];
    private int numberTables = 0;
    Connector dbObj = new Connector();
    
    public TableArr() {
        try {
            
            ResultSet tableDB = dbObj.execQuerySet("SELECT Table.TableNumber, Table.CurrentTabID, Staff.Name, Table.Capacity\n" + "FROM Staff INNER JOIN [Table] ON Staff.StaffID = Table.StaffID;");
            while (tableDB.next())
            {
                
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
    
    public void TableDBReload(){
        
        try {
            
            ResultSet tableDB = dbObj.execQuerySet("SELECT Table.TableNumber, Table.CurrentTabID, Staff.Name, Table.Capacity\n" + "FROM Staff INNER JOIN [Table] ON Staff.StaffID = Table.StaffID;");
            while (tableDB.next())
            {
                
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

    public int getNumberTables() {
        return numberTables;
    }

    public int getCurrentTabID(int table)
    {
        return tableArr[table].getCurrentTabID();
    }
    
    public Table getCurrentTableOBJ(int table)
    {
        return tableArr[table];
    }
    
    public void closeTab(int tableNumber)
    {
        dbObj.Insert("UPDATE [Table] SET [Table].CurrentTabID = 0 WHERE (((Table.TableNumber)= " + tableNumber + " ));");
    }
    
}
