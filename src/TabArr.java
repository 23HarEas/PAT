
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
public class TabArr {
    
    private int tabArrSize = 100;
    private Tab tabArr[] = new Tab[tabArrSize];
    private int numberTab = 0;
    Connector dbObj = new Connector();
    
    public TabArr() {
        try {
            
            ResultSet tabDB = dbObj.execQuerySet("SELECT Tab.TabID, Tab.TableNumber, Tab.Time, Tab.Pax, Tab.Booking, Tab.Name, Tab.CellphoneNumber\n" + "FROM (Staff INNER JOIN [Table] ON Staff.StaffID = Table.StaffID) INNER JOIN Tab ON Table.TableNumber = Tab.TableNumber;");
            while (tabDB.next())
            {
                
                int tabID = tabDB.getInt(1);
                int tableNumber = tabDB.getInt(2);
                int pax = tabDB.getInt(4);
                boolean booking = tabDB.getBoolean(5);
                LocalDateTime time = LocalDateTime.parse(tabDB.getString(3), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS"));
                String name = tabDB.getString(6);
                String cellphoneNumber = tabDB.getString(7);
                
                
                if(!booking)
                {
                    tabArr[tabID] = new Tab(tabID, tableNumber, pax, booking, time) ;
                    numberTab++;
                }
                
                else
                {
                    tabArr[tabID] = new BookingTab(name, cellphoneNumber, tabID, tableNumber, pax, booking, time) ;
                    numberTab++;
                }
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffArr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void TabDBReload(){
        
            for (int i = 0; i < tabArrSize; i++) {
            tabArr[i] = null;
        }
        
        try {
            ResultSet tabDB = dbObj.execQuerySet("SELECT Tab.TabID, Tab.TableNumber, Tab.Time, Tab.Pax, Tab.Booking, Tab.Name, Tab.CellphoneNumber\n" + "FROM (Staff INNER JOIN [Table] ON Staff.StaffID = Table.StaffID) INNER JOIN Tab ON Table.TableNumber = Tab.TableNumber;");
            while (tabDB.next())
            {
                
                int tabID = tabDB.getInt(1);
                int tableNumber = tabDB.getInt(2);
                int pax = tabDB.getInt(4);
                boolean booking = tabDB.getBoolean(5);
                LocalDateTime time = LocalDateTime.parse(tabDB.getString(3), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS"));
                String name = tabDB.getString(6);
                String cellphoneNumber = tabDB.getString(7);
                
                
                if(!booking)
                {
                    tabArr[tabID] = new Tab(tabID, tableNumber, pax, booking, time) ;
                }
                
                else
                {
                    tabArr[tabID] = new BookingTab(name, cellphoneNumber, tabID, tableNumber, pax, booking, time) ;
                }
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffArr.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Tab getTabObj(int currentTabID)
    {
        return tabArr[currentTabID];
    }
    
    public void newTab(int tableNumber)
    {

        dbObj.Insert("INSERT INTO [Tab] (TableNumber, [Time], Booking, Pax) VALUES ("+ tableNumber +", NOW(), FALSE, -1);");
        try {
            ResultSet tabDB = dbObj.execQuerySet("SELECT Tab.TabID FROM Tab WHERE (((Tab.Pax)=-1));");
            tabDB.next();
            int newTabID = tabDB.getInt(1);
            dbObj.Insert("UPDATE [Table] SET [Table].CurrentTabID = " + newTabID + " WHERE (((Table.TableNumber)= " + tableNumber + " ));");
            dbObj.Insert("UPDATE Tab SET Tab.Pax = 0 WHERE (((Tab.Pax)=-1));");
        } catch (SQLException ex) {
            Logger.getLogger(TabArr.class.getName()).log(Level.SEVERE, null, ex);
        }

        numberTab++;
    }
    
    public DefaultTableModel BookingLoad(JTable table)
    {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setNumRows(0);
        for (int i = 0; i < tabArrSize; i++) {
            
            if (!(tabArr[i] == null) && tabArr[i].isBooking() && tabArr[i].getTime().isAfter(LocalDateTime.now().minusHours(1)))
            {
                model.addRow(new Object[]{tabArr[i].getTabID(), ((BookingTab)tabArr[i]).getName(), ((BookingTab)tabArr[i]).getCellphoneNumber(), tabArr[i].getPax(), tabArr[i].getTime().format(DateTimeFormatter.ofPattern("dd MMM HH:mm")), tabArr[i].getTableNumber()});
            
            }
        }
        return model;
    }
    
    public DefaultComboBoxModel BookingComboLoad(JComboBox comboBox)
    {
        DefaultComboBoxModel model = (DefaultComboBoxModel) comboBox.getModel();
        model.removeAllElements();
        for (int i = 0; i < tabArrSize; i++) {
            
            if (!(tabArr[i] == null) && tabArr[i].isBooking() && tabArr[i].getTime().isAfter(LocalDateTime.now().minusHours(1)))
            {
                System.out.println("123");
                model.addElement(tabArr[i].getTabID() + " " + ((BookingTab)tabArr[i]).getName() + ", Table: " + tabArr[i].getTableNumber());
            
            }
        }
        return model;
    }
    
    public void removeBooking(String item)
    {
       
        int idToRemove = Integer.parseInt(new Scanner(item).useDelimiter(" ").next());
        boolean found = false;
        
        for (int i = 0; i < tabArrSize; i++) {
            
            if (!(tabArr[i] == null) && tabArr[i].getTabID() == idToRemove)
            {
                dbObj.Insert("DELETE * FROM Tab WHERE (Tab.TabID=" + idToRemove + ");");
            }
            
        }
        
    }
    
    public void newBooking()
    {
        
    }
    
    
}
