
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
public class TabArr {
    
    private Tab tabArr[] = new Tab[100];
    private int numberTab = 0;
        
    public TabArr() {
        try {
            Connector dbObj = new Connector();
            ResultSet tabDB = dbObj.execQuerySet("SELECT Tab.TabID, Tab.TableNumber, Tab.Time, Tab.Pax, Tab.Booking, Tab.Name, Tab.CellphoneNumber\n" + "FROM (Staff INNER JOIN [Table] ON Staff.StaffID = Table.StaffID) INNER JOIN Tab ON Table.TableNumber = Tab.TableNumber;");
            while (tabDB.next())
            {
                
                int tabID = tabDB.getInt(1);
                int tableNumber = tabDB.getInt(2);
                int pax = tabDB.getInt(4);
                boolean booking = tabDB.getBoolean(5);
                LocalDateTime time = LocalDateTime.parse(tabDB.getString(3), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS"));;
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
    
    public Tab getTabObj(int currentTabID)
    {
        return tabArr[currentTabID];
    }
    
}
