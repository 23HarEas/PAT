
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
            ResultSet ordersDB = dbObj.execQuerySet("SELECT Order.OrderID, Menu.Name, Order.Status, Tab.TableNumber, Order.Time, Staff.Name, Order.Notes, Tab.TabID, Order.ItemID\n" + "FROM (Staff INNER JOIN ([Table] INNER JOIN Tab ON Table.TableNumber = Tab.TableNumber) ON Staff.StaffID = Table.StaffID) INNER JOIN (Menu INNER JOIN [Order] ON Menu.ItemID = Order.ItemID) ON Tab.TabID = Order.TabID ORDER BY Order.OrderID;");
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

    public void OrderDBReload() {

        try {
            int i = 0;
            ResultSet ordersDB = dbObj.execQuerySet("SELECT Order.OrderID, Menu.Name, Order.Status, Tab.TableNumber, Order.Time, Staff.Name, Order.Notes, Tab.TabID, Order.ItemID\n" + "FROM (Staff INNER JOIN ([Table] INNER JOIN Tab ON Table.TableNumber = Tab.TableNumber) ON Staff.StaffID = Table.StaffID) INNER JOIN (Menu INNER JOIN [Order] ON Menu.ItemID = Order.ItemID) ON Tab.TabID = Order.TabID ORDER BY Order.OrderID;");
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

    public DefaultTableModel OrdersLoad(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setNumRows(0);
        for (int i = 0; i < numberOrders; i++) {
            model.addRow(new Object[]{ordersArr[i].getOrderID(), ordersArr[i].getStatus(), ordersArr[i].getItem(), ordersArr[i].getTable(), ordersArr[i].getTime().format(DateTimeFormatter.ofPattern("HH:mm:ss")), ordersArr[i].getStaff(), ordersArr[i].getNotes()});
        }
        return model;
    }

    public DefaultTableModel TabOrdersLoad(JTable table, int tabID) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setNumRows(0);
        for (int i = 0; i < numberOrders; i++) {

            if (ordersArr[i].getTabID() == tabID) {
                model.addRow(new Object[]{ordersArr[i].getOrderID(), ordersArr[i].getItem(), ordersArr[i].getTime().format(DateTimeFormatter.ofPattern("HH:mm:ss")), ordersArr[i].getStatus()});
            }

        }

        return model;
    }

    public double CalcTabTotal(int tabID, MenuArr menuArr) {

        int total = 0;

        for (int i = 0; i < numberOrders; i++) {

            if (ordersArr[i].getTabID() == tabID) {
                total += menuArr.findPrice(ordersArr[i].getItemID());
            }

        }
        return total;

    }

    public void NewOrder(int itemID, int tabID, String notes) {
        dbObj.Insert("INSERT INTO [Order] (ItemID, [Time], TabID, Notes, Status) VALUES (" + itemID + ", NOW(), " + tabID + ", \"" + notes + "\", FALSE);");
        numberOrders++;
        OrderDBReload();

    }

    public void removeOrder(String order) {
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
            dbObj.Insert("DELETE * FROM [Order] WHERE (OrderID=" + idToRemove + ");");
        }
    }

    public DefaultComboBoxModel OrderComboLoad(JComboBox comboBox) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) comboBox.getModel();
        model.removeAllElements();
        for (int i = 0; i < numberOrders; i++) {

            if (ordersArr[i].getTabID() == MainScreen.tableArr.getCurrentTabID(MainScreen.workingTable)) {
                model.addElement(ordersArr[i].getOrderID() + " " + ordersArr[i].getItem());
            }
        }

        return model;
    }

    public void saveOrders(JTable ordersTable) {
        for (int i = 0; i < numberOrders; i++) {

            int orderID = Integer.parseInt("" + ordersTable.getValueAt(i, 0));
            boolean stauts = (boolean) ordersTable.getValueAt(i, 1);

            for (int j = 0; j < numberOrders; j++) {

                if (ordersArr[j].getOrderID() == orderID) {

                    ordersArr[j].setStatus(stauts);
                    dbObj.Update("UPDATE Order SET Status = \"" + stauts + "\" WHERE (OrderID=" + orderID + ");");
                }
            }

            OrderDBReload();

        }
    }

}
