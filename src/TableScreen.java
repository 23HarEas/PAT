import com.formdev.flatlaf.FlatIntelliJLaf;
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
        
        if (MainScreen.tableArr.getCurrentTabID(MainScreen.workingTable) == 0)
        {
            JOptionPane.showMessageDialog(rootPane, "No Active Tab, Creating New Tab");
            MainScreen.tabArr.newTab(MainScreen.workingTable);
        }    
        
        initComponents();
        refreshTable();
        ScreenBuild.mainScreen.setBtnIcons();
    }

    public void refreshTable(){
        
        ScreenBuild.mainScreen.reloadTables();
        
        int workingTable = MainScreen.workingTable;
        int currentTabID = MainScreen.tableArr.getCurrentTabID(workingTable);
        Tab currentTabObj = MainScreen.tabArr.getTabObj(currentTabID);
        Table currentTableObj = MainScreen.tableArr.getCurrentTableOBJ(workingTable);
        
        setTitle("Table " + workingTable + " current tab");
        txtTab.setText("" + currentTabID);
        txtStaff.setText(currentTableObj.getStaff());
        txtPax.setText("" + currentTabObj.getPax() + "/" + currentTableObj.getCapacity());
        txtTime.setText("" + currentTabObj.getTime().format(DateTimeFormatter.ofPattern("dd MMM HH:mm")));
        txtTotal.setText("R" + MainScreen.ordersArr.CalcTabTotal(currentTabID, MainScreen.menuArr));
        if (currentTabObj instanceof BookingTab)
        {
           txtType.setText("Booking");
           
           txtBookingName.setVisible(true);
           txtBookingPhone.setVisible(true);
           lblBookingName.setVisible(true);
           lblBookingPhone.setVisible(true);
           
           txtBookingName.setText(((BookingTab) currentTabObj).getName());
           txtBookingPhone.setText(((BookingTab) currentTabObj).getCellphoneNumber());
           
        }
            
        else
        {
           txtType.setText("Walk In");
            
           txtBookingName.setVisible(false);
           txtBookingPhone.setVisible(false);
           lblBookingName.setVisible(false);
           lblBookingPhone.setVisible(false);
            
        }
            
        
        OrdersArr orderArr = MainScreen.ordersArr;
        tblOrders.setModel(orderArr.TabOrdersLoad(tblOrders,currentTabID));
    }
    
    private void button1(ActionEvent e) {
        // TODO add your code here
        
    }

    private void btnNewOrder(ActionEvent e) {
        // TODO add your code here
        FlatIntelliJLaf.setup();
        new NewOrder().setVisible(true);
    }

    private void btnRemoveOrder(ActionEvent e) {
        // TODO add your code here
        FlatIntelliJLaf.setup();
        new RemoveOrder().setVisible(true);
    }

    private void btnCloseTab(ActionEvent e) {
        // TODO add your code here
        
        int option = JOptionPane.showConfirmDialog(null, "Close Current Tab for Table " + MainScreen.workingTable , "Close Tab", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
        
        if (option == 0)
        {
            MainScreen.tableArr.closeTab(MainScreen.workingTable);
            ScreenBuild.mainScreen.reloadTables();
        }
        
        dispose();
        ScreenBuild.mainScreen.setBtnIcons();
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
                    {"", null, null, false},
                    {null, null, null, null},
                },
                new String[] {
                    "Order ID", "Order", "Time", "Status"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    Object.class, Object.class, Object.class, Boolean.class
                };
                boolean[] columnEditable = new boolean[] {
                    false, false, false, false
                };
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
                }
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            {
                TableColumnModel cm = tblOrders.getColumnModel();
                cm.getColumn(0).setPreferredWidth(70);
                cm.getColumn(2).setPreferredWidth(100);
                cm.getColumn(3).setPreferredWidth(70);
            }
            tblOrders.setShowHorizontalLines(true);
            tblOrders.setShowVerticalLines(true);
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
        btnNewOrder.addActionListener(e -> btnNewOrder(e));
        contentPane.add(btnNewOrder, new CC().cell(1, 11, 7, 2));

        //---- btnRemoveOrder ----
        btnRemoveOrder.setText("Remove Order");
        btnRemoveOrder.addActionListener(e -> btnRemoveOrder(e));
        contentPane.add(btnRemoveOrder, new CC().cell(1, 13, 7, 2).grow());

        //---- btnCloseTab ----
        btnCloseTab.setText("Close Tab");
        btnCloseTab.addActionListener(e -> btnCloseTab(e));
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


