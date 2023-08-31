
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
public class MenuArr {

    private Menu menuArr[] = new Menu[100];
    private int numberMenu = 0;
    Connector dbObj = new Connector();

    public MenuArr() {
        try {

            ResultSet menueDB = dbObj.readQuery("SELECT Menu.ItemID, Menu.Name, Menu.Description, Menu.Price\n" + "FROM Menu;");
            while (menueDB.next()) {

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

    /**
     * Reloads menu data from the database into the menuArr array.
     */
    public void menuDBReload() {
        try {

            int i = 0;
            ResultSet menueDB = dbObj.readQuery("SELECT Menu.ItemID, Menu.Name, Menu.Description, Menu.Price\n" + "FROM Menu;");

            while (menueDB.next()) {

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

    /**
     * Loads menu data into a DefaultTableModel for display in a JTable.
     *
     * @param table The JTable in which to display the menu data.
     * @return The DefaultTableModel containing the loaded menu data.
     */
    public DefaultTableModel menuTableLoad(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setNumRows(0);
        for (int i = 0; i < numberMenu; i++) {
            model.addRow(new Object[]{menuArr[i].getMenueID(), menuArr[i].getName(), menuArr[i].getDescription(), (int) Math.round(menuArr[i].getPrice())});
        }
        return model;
    }

    /**
     * Saves changes made in the menuTable back to the database and updates the
     * menuArr array.
     *
     * @param menuTable The JTable containing the edited menu data.
     */
    public void menuTableSave(JTable menuTable) {

        for (int i = 0; i < numberMenu; i++) {

            int menuID = Integer.parseInt("" + menuTable.getValueAt(i, 0));
            String name = (String) menuTable.getValueAt(i, 1);
            String description = (String) menuTable.getValueAt(i, 2);
            Double price = Double.parseDouble("" + menuTable.getValueAt(i, 3));

            for (int j = 0; j < numberMenu; j++) {

                if (menuArr[j].getMenueID() == menuID) {
                    menuArr[j] = new Menu(menuID, name, description, price);

                    if (menuArr[j].getMenueID() == -1) {

                        dbObj.writeQuery("INSERT INTO Menu ( Name, Price, Description ) VALUES( \"" + menuArr[j].getName() + "\", " + menuArr[j].getPrice() + ", \"" + menuArr[j].getDescription() + "\");");
                    } else {

                        dbObj.writeQuery("UPDATE Menu SET Menu.Name = \"" + menuArr[j].getName() + "\", Menu.Description = \"" + menuArr[j].getDescription() + "\", Menu.Price = " + menuArr[j].getPrice() + " WHERE (Menu.ItemID=" + menuArr[j].getMenueID() + ");");
                    }
                }
            }

            menuDBReload();

        }
    }

    /**
     * Loads menu data into a DefaultComboBoxModel for display in a JComboBox.
     *
     * @param comboBox The JComboBox in which to display the menu data.
     * @return The DefaultComboBoxModel containing the loaded menu data.
     */
    public DefaultComboBoxModel menuComboLoad(JComboBox comboBox) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) comboBox.getModel();
        model.removeAllElements();
        for (int i = 0; i < numberMenu; i++) {
            model.addElement(menuArr[i].getMenueID() + " " + menuArr[i].getName());
        }
        return model;
    }

    /**
     * Retrieves the number of menu items stored in the system.
     *
     * @return The total number of menu items.
     */
    public int getNumberMenu() {
        return numberMenu;
    }

    /**
     * Finds and returns the total price of a menu item with the given item ID.
     *
     * @param itemID The item ID of the menu item to find the price for.
     * @return The total price of the menu item with the specified item ID.
     */
    public double findPrice(int itemID) {
        double price = 0;

        for (int i = 0; i < numberMenu; i++) {
            if (menuArr[i].getMenueID() == itemID) {
                price += menuArr[i].getPrice();
            }
        }

        return price;
    }

    /**
     * Adds a new menu item to the menuArr array and increments the total number
     * of menu items.
     *
     * @param name The name of the new menu item.
     * @param description The description of the new menu item.
     * @param price The price of the new menu item.
     */
    public void menuNewItem(String name, String description, Double price) {
        menuArr[numberMenu] = new Menu(-1, name, description, price);
        numberMenu++;
    }

    /**
     * Removes a menu item from the menuArr array and the database based on the
     * provided item.
     *
     * @param item The menu item to be removed (format: "MenuID Name").
     */
    public void menuRemoveItem(String item) {

        int idToRemove = Integer.parseInt(new Scanner(item).useDelimiter(" ").next());
        boolean found = false;

        for (int i = 0; i < numberMenu; i++) {

            if (menuArr[i].getMenueID() == idToRemove || found) {
                found = true;
                menuArr[i] = menuArr[i + 1];
            }

        }

        if (found) {
            numberMenu--;
            dbObj.writeQuery("DELETE * FROM Menu WHERE (Menu.ItemID=" + idToRemove + ");");
        }

    }

}
