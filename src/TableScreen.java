

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
public class TableScreen {
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
        TableView = new JFrame();
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

        //======== TableView ========
        {
            TableView.setTitle("Table 0 Current Tab");
            TableView.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            Container TableViewContentPane = TableView.getContentPane();
            TableViewContentPane.setLayout(new MigLayout(
                "fill,insets dialog,hidemode 3,align center center",
                // columns
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]",
                // rows
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]" +
                "[shrink 0,fill]"));

            //---- lblTab ----
            lblTab.setText("Tab ID");
            TableViewContentPane.add(lblTab, "cell 1 1 3 1");

            //---- txtTab ----
            txtTab.setEditable(false);
            TableViewContentPane.add(txtTab, "cell 4 1 4 1");

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
            TableViewContentPane.add(scrOrders, "cell 9 1 17 18");

            //---- lblStaff ----
            lblStaff.setText("Staff");
            TableViewContentPane.add(lblStaff, "cell 1 2 3 1");

            //---- txtStaff ----
            txtStaff.setEditable(false);
            TableViewContentPane.add(txtStaff, "cell 4 2 4 1");

            //---- lblPax ----
            lblPax.setText("Pax");
            TableViewContentPane.add(lblPax, "cell 1 3 3 1");

            //---- txtPax ----
            txtPax.setEditable(false);
            TableViewContentPane.add(txtPax, "cell 4 3 4 1");

            //---- lblTime ----
            lblTime.setText("Time");
            TableViewContentPane.add(lblTime, "cell 1 4 3 1");

            //---- txtTime ----
            txtTime.setEditable(false);
            TableViewContentPane.add(txtTime, "cell 4 4 4 1");

            //---- lblType ----
            lblType.setText("Type");
            TableViewContentPane.add(lblType, "cell 1 5 3 1");

            //---- txtType ----
            txtType.setEditable(false);
            TableViewContentPane.add(txtType, "cell 4 5 4 1");

            //---- lblBookingName ----
            lblBookingName.setText("Booking Name");
            TableViewContentPane.add(lblBookingName, "cell 1 6 3 1");

            //---- txtBookingName ----
            txtBookingName.setEditable(false);
            TableViewContentPane.add(txtBookingName, "cell 4 6 4 1");

            //---- lblBookingPhone ----
            lblBookingPhone.setText("Phone Number");
            TableViewContentPane.add(lblBookingPhone, "cell 1 7 3 1");

            //---- txtBookingPhone ----
            txtBookingPhone.setEditable(false);
            TableViewContentPane.add(txtBookingPhone, "cell 4 7 4 1");

            //---- btnNewOrder ----
            btnNewOrder.setText("New Order");
            TableViewContentPane.add(btnNewOrder, "cell 1 11 7 2");

            //---- btnRemoveOrder ----
            btnRemoveOrder.setText("Remove Order");
            TableViewContentPane.add(btnRemoveOrder, "cell 1 13 7 2,grow");

            //---- btnCloseTab ----
            btnCloseTab.setText("Close Tab");
            TableViewContentPane.add(btnCloseTab, "cell 1 15 7 2,grow");

            //---- lblTotal ----
            lblTotal.setText("Total");
            TableViewContentPane.add(lblTotal, "cell 1 18 3 1,growy");

            //---- txtTotal ----
            txtTotal.setEditable(false);
            TableViewContentPane.add(txtTotal, "cell 4 18 4 1,growy");
            TableView.setSize(960, 740);
            TableView.setLocationRelativeTo(null);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Harrison Easter (MRS CLI EASTER)
    private JFrame TableView;
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


