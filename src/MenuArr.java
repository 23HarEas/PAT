
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class MenuArr {
    private Menu menuArr[] = new Menu[100];
    private int numberMenu = 0;
    
    public MenuArr() {
        try {
            Connector dbObj = new Connector();
            ResultSet menueDB = dbObj.execQuerySet("SELECT Menu.ItemID, Menu.Name, Menu.Description, Menu.Price\n" + "FROM Menu;");
            while (menueDB.next())
            {
                
                String menuID = menueDB.getString(1);
                String name = menueDB.getString(2);
                String description = menueDB.getString(3);
                Double price = menueDB.getDouble(4);
                
                
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

    public DefaultComboBoxModel MenuComboLoad(JComboBox comboBox)
    {
        DefaultComboBoxModel model = (DefaultComboBoxModel) comboBox.getModel();
        model.removeAllElements();
        for (int i = 0; i < numberMenu; i++) {
            model.addElement(menuArr[i].getName());
        }
        return model;
    }
    
    public int getNumberMenu() {
        return numberMenu;
    }
    
    public double findPrice(int itemID)
    {
        double price = 0;
        
        for (int i = 0; i < numberMenu; i++) {
            if (Integer.parseInt(menuArr[i].getMenueID()) == itemID)
            {
                price += menuArr[i].getPrice();
            }
        }
        
        return price;
    }
    
    public void newMenuItem(String name, String description, Double price)
    {
        menuArr[numberMenu] = new Menu("", name, description, price);
        numberMenu++;
    }
    
    public void removeMenuItem(String item)
    {
        boolean found = false;
        
        for (int i = 0; i < numberMenu; i++) {
            
            if (menuArr[i].getName().equals(item) || found)
            {
                found = true;
                menuArr[i] = menuArr[i+1];
            }
            
        }
        
        if (found)
        {
            numberMenu--;
        }
        
    }
    
}
