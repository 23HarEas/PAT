
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
public class MenuArr {
    private Menu menuArr[] = new Menu[100];
    private int numberMenu = 0;
    
    public MenuArr() {
        try {
            Connector dbObj = new Connector();
            ResultSet staffDB = dbObj.execQuerySet("SELECT Menu.ItemID, Menu.Name, Menu.Description, Menu.Price\n" + "FROM Menu;");
            while (staffDB.next())
            {
                
                String menuID = staffDB.getString(1);
                String name = staffDB.getString(2);
                String description = staffDB.getString(3);
                Double price = staffDB.getDouble(4);
                
                
                menuArr[numberMenu] = new Menu(menuID, name, description, price);
                numberMenu++;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffArr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DefaultTableModel MenuLoad(JTable table)
    {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setNumRows(0);
        for (int i = 0; i < numberMenu; i++) {
            model.addRow(new Object[]{menuArr[i].getMenueID(), menuArr[i].getName(), menuArr[i].getDescription(), menuArr[i].getPrice()});
        }
        return model;
    }
    
}
