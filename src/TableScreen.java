

import java.awt.*;
import java.awt.event.*;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import javax.swing.table.*;
import net.miginfocom.layout.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Sun Jul 23 19:19:41 CAT 2023
 */



/**
 * @author harri
 */
public class TableScreen extends JFrame {
    public TableScreen() {
        initComponents();
        refreshTable();
    }

    private void refreshTable(){
        int workingTable = MainScreen.workingTable;
        int currentTabID = MainScreen.tableArr.getCurrentTabID(workingTable);
        Tab currentTabObj = MainScreen.tabArr.getTabObj(currentTabID);
        Table currentTableObj = MainScreen.tableArr.getCurrentTableOBJ(workingTable);
        
        
        setTitle("Table " + workingTable + " current tab");
        textField1.setText("" + currentTabID);
        textField2.setText(currentTableObj.getStaff());
        textField3.setText("" + currentTabObj.getPax() + "/" + currentTableObj.getCapacity());
        textField4.setText("" + currentTabObj.getTime().format(DateTimeFormatter.ofPattern("dd MMM hh:mm")));
        textField8.setText("R" + MainScreen.ordersArr.CalcTabTotal(currentTabID, MainScreen.menuArr));
        if (currentTabObj instanceof BookingTab)
        {
           textField5.setText("Booking");
           
           label6.setVisible(true);
           label7.setVisible(true);
           textField6.setVisible(true);
           textField7.setVisible(true);
           
           textField6.setText(((BookingTab) currentTabObj).getName());
           textField7.setText(((BookingTab) currentTabObj).getCellphoneNumber());
           
        }
            
        else
        {
            textField5.setText("Walk In");
            
            label6.setVisible(false);
            label7.setVisible(false);
            textField6.setVisible(false);
            textField7.setVisible(false);
            
        }
            
        
        OrdersArr orderArr = MainScreen.ordersArr;
        table1.setModel(orderArr.TabOrdersLoad(table1,currentTabID));
    }
    
    private void button1(ActionEvent e) {
        // TODO add your code here
        
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Harrison Easter (MRS CLI EASTER)
        lblTab = new JLabel();
        txtTab = new JTextField();
        scrOrders = new JScrollPane();
        tblOrders = new JTable();
        lblStaff = new JLabel();
        txtStaff = new JTextField();
        lblPax = new JLabel();
        txtPax = new JTextField();
        lblTime = new JLabel();
        txtTime = new JTextField();
        lblType = new JLabel();
        txtType = new JTextField();
        lblBookingName = new JLabel();
        txtBookingName = new JTextField();
        lblBookingPhone = new JLabel();
        txtBookingPhone = new JTextField();
        btnNewOrder = new JButton();
        btnRemoveOrder = new JButton();
        btnCloseTab = new JButton();
        lblTotal = new JLabel();
        txtTotal = new JTextField();

        //======== this ========
        setTitle("Table 0 Current Tab");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            new LC().fill().insets("dialog").hideMode(3).align("center", "center"),
            // columns
            new AC()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill(),
            // rows
            new AC()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill().gap()
                .shrink(0).fill()));

        //---- lblTab ----
        lblTab.setText("Tab ID");
        contentPane.add(lblTab, new CC().cell(1, 1, 3, 1));

        //---- txtTab ----
        txtTab.setEditable(false);
        contentPane.add(txtTab, new CC().cell(4, 1, 4, 1));

        //======== scrOrders ========
        {

            //---- tblOrders ----
            tblOrders.setModel(new DefaultTableModel(
                new Object[][] {
                    {"", null, null, null},
                    {null, null, null, null},
                },
                new String[] {
                    "Order ID", "Order", "Time", "Status"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    Object.class, Object.class, Object.class, Boolean.class
                };
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
                }
            });
            scrOrders.setViewportView(tblOrders);
        }
        contentPane.add(scrOrders, new CC().cell(9, 1, 17, 18));

        //---- lblStaff ----
        lblStaff.setText("Staff");
        contentPane.add(lblStaff, new CC().cell(1, 2, 3, 1));

        //---- txtStaff ----
        txtStaff.setEditable(false);
        contentPane.add(txtStaff, new CC().cell(4, 2, 4, 1));

        //---- lblPax ----
        lblPax.setText("Pax");
        contentPane.add(lblPax, new CC().cell(1, 3, 3, 1));

        //---- txtPax ----
        txtPax.setEditable(false);
        contentPane.add(txtPax, new CC().cell(4, 3, 4, 1));

        //---- lblTime ----
        lblTime.setText("Time");
        contentPane.add(lblTime, new CC().cell(1, 4, 3, 1));

        //---- txtTime ----
        txtTime.setEditable(false);
        contentPane.add(txtTime, new CC().cell(4, 4, 4, 1));

        //---- lblType ----
        lblType.setText("Type");
        contentPane.add(lblType, new CC().cell(1, 5, 3, 1));

        //---- txtType ----
        txtType.setEditable(false);
        contentPane.add(txtType, new CC().cell(4, 5, 4, 1));

        //---- lblBookingName ----
        lblBookingName.setText("Booking Name");
        contentPane.add(lblBookingName, new CC().cell(1, 6, 3, 1));

        //---- txtBookingName ----
        txtBookingName.setEditable(false);
        contentPane.add(txtBookingName, new CC().cell(4, 6, 4, 1));

        //---- lblBookingPhone ----
        lblBookingPhone.setText("Phone Number");
        contentPane.add(lblBookingPhone, new CC().cell(1, 7, 3, 1));

        //---- txtBookingPhone ----
        txtBookingPhone.setEditable(false);
        contentPane.add(txtBookingPhone, new CC().cell(4, 7, 4, 1));

        //---- btnNewOrder ----
        btnNewOrder.setText("New Order");
        contentPane.add(btnNewOrder, new CC().cell(1, 11, 7, 2));

        //---- btnRemoveOrder ----
        btnRemoveOrder.setText("Remove Order");
        contentPane.add(btnRemoveOrder, new CC().cell(1, 13, 7, 2).grow());

        //---- btnCloseTab ----
        btnCloseTab.setText("Close Tab");
        contentPane.add(btnCloseTab, new CC().cell(1, 15, 7, 2).grow());

        //---- lblTotal ----
        lblTotal.setText("Total");
        contentPane.add(lblTotal, new CC().cell(1, 18, 3, 1).growY());

        //---- txtTotal ----
        txtTotal.setEditable(false);
        contentPane.add(txtTotal, new CC().cell(4, 18, 4, 1).growY());
        setSize(960, 740);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Harrison Easter (MRS CLI EASTER)
    private JLabel lblTab;
    private JTextField txtTab;
    private JScrollPane scrOrders;
    private JTable tblOrders;
    private JLabel lblStaff;
    private JTextField txtStaff;
    private JLabel lblPax;
    private JTextField txtPax;
    private JLabel lblTime;
    private JTextField txtTime;
    private JLabel lblType;
    private JTextField txtType;
    private JLabel lblBookingName;
    private JTextField txtBookingName;
    private JLabel lblBookingPhone;
    private JTextField txtBookingPhone;
    private JButton btnNewOrder;
    private JButton btnRemoveOrder;
    private JButton btnCloseTab;
    private JLabel lblTotal;
    private JTextField txtTotal;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}


