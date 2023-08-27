import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
    Connector dbObj = new Connector();
    
    public MenuArr() {
        try {
            
            ResultSet menueDB = dbObj.execQuerySet("SELECT Menu.ItemID, Menu.Name, Menu.Description, Menu.Price\n" + "FROM Menu;");
            while (menueDB.next())
            {
                
                int menuID = menueDB.getInt(1);
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
    
    public void MenuDBRelod() {
        try {
            
            int i = 0;
            ResultSet menueDB = dbObj.execQuerySet("SELECT Menu.ItemID, Menu.Name, Menu.Description, Menu.Price\n" + "FROM Menu;");
            
            
            while(menueDB.next()) {
                
                
                int menuID = menueDB.getInt(1);
                String name = menueDB.getString(2);
                String description = menueDB.getString(3);
                Double price = menueDB.getDouble(4);
                
                
                menuArr[i] = new Menu(menuID, name, description, price);
                i++;
                
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

    public void MenuSave(JTable menuTable)
    {
        
        
        for (int i = 0; i < numberMenu; i++) {

            int menuID = Integer.parseInt(""+menuTable.getValueAt(i, 0));
            String name = (String)menuTable.getValueAt(i, 1);
            String description = (String)menuTable.getValueAt(i, 2);
            Double price = Double.parseDouble(""+menuTable.getValueAt(i, 3));
            
            for (int j = 0; j < numberMenu; j++) {
                
                if (menuArr[j].getMenueID() == menuID)
                {
                    menuArr[j] = new Menu(menuID, name, description, price);
                    
                    if (menuArr[j].getMenueID() == -1)
                    {
                        
                        dbObj.Insert("INSERT INTO Menu ( Name, Price, Description ) VALUES( \""+ menuArr[j].getName() +"\", "+ menuArr[j].getPrice() +", \""+ menuArr[j].getDescription() +"\");");
                    }
                    else
                    {
                        
                        dbObj.Update("UPDATE Menu SET Menu.Name = \"" + menuArr[j].getName() +"\", Menu.Description = \"" + menuArr[j].getDescription() + "\", Menu.Price = " + menuArr[j].getPrice() + " WHERE (Menu.ItemID=" + menuArr[j].getMenueID() + ");");
                    }
                }
            }
            
            MenuDBRelod();
            
        }
    }
    
    public DefaultComboBoxModel MenuComboLoad(JComboBox comboBox)
    {
        DefaultComboBoxModel model = (DefaultComboBoxModel) comboBox.getModel();
        model.removeAllElements();
        for (int i = 0; i < numberMenu; i++) {
            model.addElement(menuArr[i].getMenueID() + " " + menuArr[i].getName());
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
            if (menuArr[i].getMenueID() == itemID)
            {
                price += menuArr[i].getPrice();
            }
        }
        
        return price;
    }
    
    public void newMenuItem(String name, String description, Double price)
    {
        menuArr[numberMenu] = new Menu(-1, name, description, price);
        numberMenu++;
    }
    
    public void removeMenuItem(String item)
    {
       
        int idToRemove = Integer.parseInt(new Scanner(item).useDelimiter(" ").next());
        boolean found = false;
        
        for (int i = 0; i < numberMenu; i++) {
            
            if (menuArr[i].getMenueID() == idToRemove || found)
            {
                found = true;
                menuArr[i] = menuArr[i+1];
            }
            
        }
        
        if (found)
        {
            numberMenu--;
            dbObj.Insert("DELETE * FROM Menu WHERE (Menu.ItemID=" + idToRemove + ");");
        }
        
    }
    
    
    
}
