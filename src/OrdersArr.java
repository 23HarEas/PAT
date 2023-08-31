
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
public class OrdersArr {

    private Orders ordersArr[] = new Orders[100];
    private int numberOrders = 0;
    Connector dbObj = new Connector();

    public OrdersArr() {
        try {
            ResultSet ordersDB = dbObj.readQuery("SELECT Order.OrderID, Menu.Name, Order.Status, Tab.TableNumber, Order.Time, Staff.Name, Order.Notes, Tab.TabID, Order.ItemID\n" + "FROM (Staff INNER JOIN ([Table] INNER JOIN Tab ON Table.TableNumber = Tab.TableNumber) ON Staff.StaffID = Table.StaffID) INNER JOIN (Menu INNER JOIN [Order] ON Menu.ItemID = Order.ItemID) ON Tab.TabID = Order.TabID ORDER BY Order.OrderID;");
            while (ordersDB.next()) {

                int orderID = ordersDB.getInt(1);
                Boolean status = ordersDB.getBoolean(3);
                String item = ordersDB.getString(2);
                int table = ordersDB.getInt(4);
                LocalDateTime time = LocalDateTime.parse(ordersDB.getString(5), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS"));
                String staff = ordersDB.getString(6);
                String notes = ordersDB.getString(7);
                int tabID = ordersDB.getInt(8);
                int itemID = ordersDB.getInt(9);

                ordersArr[numberOrders] = new Orders(orderID, status, item, table, time, staff, notes, tabID, itemID);
                numberOrders++;

            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffArr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Reloads orders data from the database into the ordersArr array.
     */
    public void ordersDBReload() {

        try {
            int i = 0;
            ResultSet ordersDB = dbObj.readQuery("SELECT Order.OrderID, Menu.Name, Order.Status, Tab.TableNumber, Order.Time, Staff.Name, Order.Notes, Tab.TabID, Order.ItemID\n" + "FROM (Staff INNER JOIN ([Table] INNER JOIN Tab ON Table.TableNumber = Tab.TableNumber) ON Staff.StaffID = Table.StaffID) INNER JOIN (Menu INNER JOIN [Order] ON Menu.ItemID = Order.ItemID) ON Tab.TabID = Order.TabID ORDER BY Order.OrderID;");
            while (ordersDB.next()) {

                int orderID = ordersDB.getInt(1);
                Boolean status = ordersDB.getBoolean(3);
                String item = ordersDB.getString(2);
                int table = ordersDB.getInt(4);
                LocalDateTime time = LocalDateTime.parse(ordersDB.getString(5), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS"));
                String staff = ordersDB.getString(6);
                String notes = ordersDB.getString(7);
                int tabID = ordersDB.getInt(8);
                int itemID = ordersDB.getInt(9);

                ordersArr[i] = new Orders(orderID, status, item, table, time, staff, notes, tabID, itemID);
                i++;

            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffArr.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Loads orders data into a DefaultTableModel for display in a JTable.
     *
     * @param table The JTable in which to display the orders data.
     * @return The DefaultTableModel containing the loaded orders data.
     */
    public DefaultTableModel ordersTableLoad(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setNumRows(0);
        for (int i = 0; i < numberOrders; i++) {
            model.addRow(new Object[]{ordersArr[i].getOrderID(), ordersArr[i].getStatus(), ordersArr[i].getItem(), ordersArr[i].getTable(), ordersArr[i].getTime().format(DateTimeFormatter.ofPattern("HH:mm:ss")), ordersArr[i].getStaff(), ordersArr[i].getNotes()});
        }
        return model;
    }

    /**
     * Loads orders data for a specific tab into a DefaultTableModel for display
     * in a JTable.
     *
     * @param table The JTable in which to display the orders data.
     * @param tabID The ID of the tab for which to load orders data.
     * @return The DefaultTableModel containing the loaded orders data for the
     * specific tab.
     */
    public DefaultTableModel ordersTabTableLoad(JTable table, int tabID) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setNumRows(0);
        for (int i = 0; i < numberOrders; i++) {

            if (ordersArr[i].getTabID() == tabID) {
                model.addRow(new Object[]{ordersArr[i].getOrderID(), ordersArr[i].getItem(), ordersArr[i].getTime().format(DateTimeFormatter.ofPattern("HH:mm:ss")), ordersArr[i].getStatus()});
            }

        }

        return model;
    }

    /**
     * Calculates the total cost of orders associated with a specific tab.
     *
     * @param tabID The ID of the tab for which to calculate the total cost.
     * @param menuArr The MenuArr object containing menu item information.
     * @return The calculated total cost of orders for the specified tab.
     */
    public double calcTab(int tabID, MenuArr menuArr) {

        int total = 0;

        for (int i = 0; i < numberOrders; i++) {

            if (ordersArr[i].getTabID() == tabID) {
                total += menuArr.findPrice(ordersArr[i].getItemID());
            }

        }
        return total;

    }

    /**
     * Adds a new order to the database and updates the ordersArr array.
     *
     * @param itemID The ID of the menu item for the new order.
     * @param tabID The ID of the tab for which the new order is placed.
     * @param notes Any additional notes for the new order.
     */
    public void ordersNewItem(int itemID, int tabID, String notes) {
        dbObj.writeQuery("INSERT INTO [Order] (ItemID, [Time], TabID, Notes, Status) VALUES (" + itemID + ", NOW(), " + tabID + ", \"" + notes + "\", FALSE);");
        numberOrders++;
        ordersDBReload();

    }

    /**
     * Removes an order from the ordersArr array and the database based on the
     * provided order ID.
     *
     * @param order The order to be removed (format: "OrderID ...").
     */
    public void ordersRemoveItem(String order) {
        int idToRemove = Integer.parseInt(new Scanner(order).useDelimiter(" ").next());
        boolean found = false;

        for (int i = 0; i < numberOrders; i++) {

            if (ordersArr[i].getOrderID() == idToRemove || found) {
                found = true;
                ordersArr[i] = ordersArr[i + 1];
            }

        }

        if (found) {
            numberOrders--;
            dbObj.writeQuery("DELETE * FROM [Order] WHERE (OrderID=" + idToRemove + ");");
        }
    }

    /**
     * Loads order information into a DefaultComboBoxModel for display in a
     * JComboBox.
     *
     * @param comboBox The JComboBox in which to display the order information.
     * @return The DefaultComboBoxModel containing the loaded order information.
     */
    public DefaultComboBoxModel ordersComboLoad(JComboBox comboBox) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) comboBox.getModel();
        model.removeAllElements();
        for (int i = 0; i < numberOrders; i++) {

            if (ordersArr[i].getTabID() == MainScreen.tableArr.getCurrentTabID(MainScreen.workingTable)) {
                model.addElement(ordersArr[i].getOrderID() + " " + ordersArr[i].getItem());
            }
        }

        return model;
    }

    /**
     * Saves updated order statuses from a JTable back to the database and
     * updates the ordersArr array.
     *
     * @param ordersTable The JTable containing the updated order statuses.
     */
    public void ordersTableSave(JTable ordersTable) {
        for (int i = 0; i < numberOrders; i++) {

            int orderID = Integer.parseInt("" + ordersTable.getValueAt(i, 0));
            boolean stauts = (boolean) ordersTable.getValueAt(i, 1);

            for (int j = 0; j < numberOrders; j++) {

                if (ordersArr[j].getOrderID() == orderID) {

                    ordersArr[j].setStatus(stauts);
                    dbObj.writeQuery("UPDATE Order SET Status = \"" + stauts + "\" WHERE (OrderID=" + orderID + ");");
                }
            }

            ordersDBReload();

        }
    }

}
