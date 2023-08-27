import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import com.formdev.flatlaf.ui.*;
import net.miginfocom.layout.*;
import net.miginfocom.swing.*;
import org.jdesktop.swingx.*;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
        
/*
 * Created by JFormDesigner on Thu Jul 20 19:34:24 CAT 2023
 */



/**
 * @author harri
 */
public class MainScreen extends JFrame {
    
    
    static StaffArr staffArr = new StaffArr(); 
    static MenuArr menuArr = new MenuArr();
    static OrdersArr ordersArr = new OrdersArr();
    static TabArr tabArr = new TabArr();
    static TableArr tableArr = new TableArr();
    static int workingTable = 0;
    static TableScreen tableScreen;
    
    public void reloadTables()
    {
        MainScreen.tabArr.TabDBReload();
        MainScreen.tableArr.TableDBReload();
        MainScreen.menuArr.MenuDBRelod();
        MainScreen.staffArr.StaffDBReload();
        MainScreen.ordersArr.OrderDBReload();
    }
    
    public void refreshJTables()
    {
        tblOrders.setModel(ordersArr.OrdersLoad(tblOrders));
        tblStaff.setModel(staffArr.StaffLoad(tblStaff));
        tblMenu.setModel(menuArr.MenuLoad(tblMenu));
    }
    
    public void saveJTables()
    {
        menuArr.MenuSave(tblMenu);
        staffArr.StaffSave(tblStaff);
        
        
        refreshJTables();
    }
    
    public MainScreen() {
        initComponents();
        refreshJTables();
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
    }

    private void button2(ActionEvent e) {
        // TODO add your code here
        FlatIntelliJLaf.setup();
        new NewMenuItem().setVisible(true); 

    }

    private void createUIComponents() {
        // TODO: add custom component creation code here
    }

    private void button8(ActionEvent e) {
        // TODO add your code here
        tblOrders.setModel(ordersArr.OrdersLoad(tblOrders));
        refreshJTables();
        
    }

    private void button9(ActionEvent e) {
        // TODO add your code here
        refreshJTables();
                
    }

    private void button5(ActionEvent e) {
        // TODO add your code here
        refreshJTables();
    }

    private void button42(ActionEvent e) {
        // TODO add your code here
        workingTable = 1;
        FlatIntelliJLaf.setup();
        tableScreen = new TableScreen();
        tableScreen.setVisible(true);    
    }

    private void button59(ActionEvent e) {
        // TODO add your code here
        workingTable = 2;
        tableScreen = new TableScreen();
        tableScreen.setVisible(true);  
    }

    private void button43(ActionEvent e) {
        // TODO add your code here
        workingTable = 3;
        tableScreen = new TableScreen();
        tableScreen.setVisible(true); 
    }

    private void button61(ActionEvent e) {
        // TODO add your code here
        workingTable = 4;
        tableScreen = new TableScreen();
        tableScreen.setVisible(true); 
    }

    private void button44(ActionEvent e) {
        // TODO add your code here
        workingTable = 5;
        tableScreen = new TableScreen();
        tableScreen.setVisible(true); 
    }

    private void button45(ActionEvent e) {
        // TODO add your code here
        workingTable = 6;
        tableScreen = new TableScreen();
        tableScreen.setVisible(true); 
    }

    private void button46(ActionEvent e) {
        // TODO add your code here
        workingTable = 7;
        tableScreen = new TableScreen();
        tableScreen.setVisible(true);  
    }

    private void button56(ActionEvent e) {
        // TODO add your code here
        workingTable = 8;
        tableScreen = new TableScreen();
        tableScreen.setVisible(true);  
    }

    private void button57(ActionEvent e) {
        // TODO add your code here
        workingTable = 9;
        tableScreen = new TableScreen();
        tableScreen.setVisible(true); 
    }

    private void button50(ActionEvent e) {
        // TODO add your code here
        workingTable = 10;
        tableScreen = new TableScreen();
        tableScreen.setVisible(true);
        
    }

    private void button55(ActionEvent e) {
        // TODO add your code here
        workingTable = 11;
        tableScreen = new TableScreen();
        tableScreen.setVisible(true); 
    }

    private void button47(ActionEvent e) {
        // TODO add your code here
        workingTable = 12;
        tableScreen = new TableScreen();
        tableScreen.setVisible(true); 
    }

    private void button48(ActionEvent e) {
        // TODO add your code here
        workingTable = 13;
        tableScreen = new TableScreen();
        tableScreen.setVisible(true); 
    }

    private void button60(ActionEvent e) {
        // TODO add your code here
        workingTable = 14;
        tableScreen = new TableScreen();
        tableScreen.setVisible(true); 
    }

    private void button51(ActionEvent e) {
        // TODO add your code here
        workingTable = 15;
        tableScreen = new TableScreen();
        tableScreen.setVisible(true); 
    }

    private void button52(ActionEvent e) {
        // TODO add your code here
        workingTable = 16;
        tableScreen = new TableScreen();
        tableScreen.setVisible(true); 
    }

    private void button62(ActionEvent e) {
        // TODO add your code here
        workingTable = 17;
        tableScreen = new TableScreen();
        tableScreen.setVisible(true); 
    }

    private void button53(ActionEvent e) {
        // TODO add your code here
        workingTable = 18;
        tableScreen = new TableScreen();
        tableScreen.setVisible(true); 
    }

    private void button54(ActionEvent e) {
        // TODO add your code here
        workingTable = 19;
        tableScreen = new TableScreen();
        tableScreen.setVisible(true); 
    }

    private void button11(ActionEvent e) {
        // TODO add your code here
        FlatIntelliJLaf.setup();
        new RemoveStaffItem().setVisible(true);
    }

    private void button3(ActionEvent e) {
        // TODO add your code here
        FlatIntelliJLaf.setup();
        new RemoveMenuItem().setVisible(true);
    }

    private void button4(ActionEvent e) {
        // TODO add your code here
        saveJTables();
    }

    private void btnMenuRemove(ActionEvent e) {
        // TODO add your code here
        FlatIntelliJLaf.setup();
        new RemoveMenuItem().setVisible(true);
    }

    private void btnStaffNew(ActionEvent e) {
        // TODO add your code here
        FlatIntelliJLaf.setup();
        new NewStaffItem().setVisible(true); 
        
    }

    private void btnStaffSave(ActionEvent e) {
        // TODO add your code here
        saveJTables();
    }

    public void setBtnIcons()
    {
        
        if (tableArr.getCurrentTabID(1) == 0)
        {
            btnTable1.setIcon(new ImageIcon("Unocupied4Seat.png"));
        }
        else
        {
            btnTable1.setIcon(new ImageIcon("Ocupied4Seat.png"));
        }
        
        if (tableArr.getCurrentTabID(2) == 0)
        {
            btnTable2.setIcon(new ImageIcon("Unocupied4Seat.png"));
        }
        else
        {
            btnTable2.setIcon(new ImageIcon("Ocupied4Seat.png"));
        }
        
        if (tableArr.getCurrentTabID(3) == 0)
        {
            btnTable3.setIcon(new ImageIcon("Unocupied4Seat.png"));
        }
        else
        {
            btnTable3.setIcon(new ImageIcon("Ocupied4Seat.png"));
        }
        
        if (tableArr.getCurrentTabID(4) == 0)
        {
            btnTable4.setIcon(new ImageIcon("Unocupied4Seat.png"));
        }
        else
        {
            btnTable4.setIcon(new ImageIcon("Ocupied4Seat.png"));
        }
        
        if (tableArr.getCurrentTabID(5) == 0)
        {
            btnTable5.setIcon(new ImageIcon("Unocupied4Seat.png"));
        }
        else
        {
            btnTable5.setIcon(new ImageIcon("Ocupied4Seat.png"));
        }
        
        if (tableArr.getCurrentTabID(6) == 0)
        {
            btnTable6.setIcon(new ImageIcon("Unocupied4Seat.png"));
        }
        else
        {
            btnTable6.setIcon(new ImageIcon("Ocupied4Seat.png"));
        }
        
        if (tableArr.getCurrentTabID(7) == 0)
        {
            btnTable7.setIcon(new ImageIcon("Unocupied4Seat.png"));
        }
        else
        {
            btnTable7.setIcon(new ImageIcon("Ocupied4Seat.png"));
        }
        
        if (tableArr.getCurrentTabID(8) == 0)
        {
            btnTable8.setIcon(new ImageIcon("Unocupied8Seat.png"));
        }
        else
        {
            btnTable8.setIcon(new ImageIcon("Ocupied8Seat.png"));
        }
        
        if (tableArr.getCurrentTabID(9) == 0)
        {
            btnTable9.setIcon(new ImageIcon("Unocupied8Seat.png"));
        }
        else
        {
            btnTable9.setIcon(new ImageIcon("Ocupied8Seat.png"));
        }
        
        if (tableArr.getCurrentTabID(10) == 0)
        {
            btnTable10.setIcon(new ImageIcon("Unocupied8Seat.png"));
        }
        else
        {
            btnTable10.setIcon(new ImageIcon("Ocupied8Seat.png"));
        }
        
        if (tableArr.getCurrentTabID(11) == 0)
        {
            btnTable11.setIcon(new ImageIcon("Unocupied8Seat.png"));
        }
        else
        {
            btnTable11.setIcon(new ImageIcon("Ocupied8Seat.png"));
        }
        
        if (tableArr.getCurrentTabID(12) == 0)
        {
            btnTable12.setIcon(new ImageIcon("Unocupied12Seat.png"));
        }
        else
        {
            btnTable12.setIcon(new ImageIcon("Ocupied12Seat.png"));
        }
        
        if (tableArr.getCurrentTabID(13) == 0)
        {
            btnTable13.setIcon(new ImageIcon("Unocupied12Seat.png"));
        }
        else
        {
            btnTable13.setIcon(new ImageIcon("Ocupied12Seat.png"));
        }
        
        if (tableArr.getCurrentTabID(14) == 0)
        {
            btnTable14.setIcon(new ImageIcon("Unocupied4Seat.png"));
        }
        else
        {
            btnTable14.setIcon(new ImageIcon("Ocupied4Seat.png"));
        }
        
        if (tableArr.getCurrentTabID(15) == 0)
        {
            btnTable15.setIcon(new ImageIcon("Unocupied4Seat.png"));
        }
        else
        {
            btnTable15.setIcon(new ImageIcon("Ocupied4Seat.png"));
        }
        
        if (tableArr.getCurrentTabID(16) == 0)
        {
            btnTable16.setIcon(new ImageIcon("Unocupied4Seat.png"));
        }
        else
        {
            btnTable16.setIcon(new ImageIcon("Ocupied4Seat.png"));
        }
        
        if (tableArr.getCurrentTabID(17) == 0)
        {
            btnTable17.setIcon(new ImageIcon("Unocupied4Seat.png"));
        }
        else
        {
            btnTable17.setIcon(new ImageIcon("Ocupied4Seat.png"));
        }
        
        if (tableArr.getCurrentTabID(18) == 0)
        {
            btnTable18.setIcon(new ImageIcon("Unocupied4Seat.png"));
        }
        else
        {
            btnTable18.setIcon(new ImageIcon("Ocupied4Seat.png"));
        }
        
        if (tableArr.getCurrentTabID(19) == 0)
        {
            btnTable19.setIcon(new ImageIcon("Unocupied4Seat.png"));
        }
        else
        {
            btnTable19.setIcon(new ImageIcon("Ocupied4Seat.png"));
        }
    }
    
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Harrison Easter (MRS CLI EASTER)
        tpnMainScreen = new JTabbedPane();
        pnlOrders = new JPanel();
        scrOrdersTbl = new JScrollPane();
        tblOrders = new JTable();
        btnOrdersRefresh = new JButton();
        btnOrdersSave = new JButton();
        pnlStaff = new JPanel();
        scrStaffTbl = new JScrollPane();
        tblStaff = new JTable();
        btnStaffNew = new JButton();
        btnStaffRemove = new JButton();
        btnStaffRefresh = new JButton();
        btnStaffSave = new JButton();
        pnlMenu = new JPanel();
        scrMenuTbl = new JScrollPane();
        tblMenu = new JTable();
        btnMenuNew = new JButton();
        btnMenuRemove = new JButton();
        btnMenuRefresh = new JButton();
        btnMenuSave = new JButton();
        pnlTables = new JPanel();
        btnTable1 = new JButton();
        btnTable2 = new JButton();
        btnTable15 = new JButton();
        btnTable16 = new JButton();
        btnTable3 = new JButton();
        btnTable8 = new JButton();
        btnTable9 = new JButton();
        btnTable14 = new JButton();
        btnTable4 = new JButton();
        btnTable17 = new JButton();
        btnTable18 = new JButton();
        btnTable19 = new JButton();
        btnTable5 = new JButton();
        btnTable6 = new JButton();
        btnTable11 = new JButton();
        btnTable10 = new JButton();
        btnTable7 = new JButton();
        btnTable12 = new JButton();
        btnTable13 = new JButton();
        btnTableNewBooking = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Resturant Managment System");
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            new LC().fill().insets("dialog").hideMode(3).align("center", "center"),
            // columns
            new AC()
                .shrink(0).fill(),
            // rows
            new AC()
                .shrink(0).fill()));

        //======== tpnMainScreen ========
        {

            //======== pnlOrders ========
            {
                pnlOrders.setLayout(new MigLayout(
                    new LC().fill().insets("dialog").hideMode(3).align("center", "center"),
                    // columns
                    new AC()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill(),
                    // rows
                    new AC()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        ));

                //======== scrOrdersTbl ========
                {

                    //---- tblOrders ----
                    tblOrders.setModel(new DefaultTableModel(
                        new Object[][] {
                        },
                        new String[] {
                            "Order ID", "Status", "Order", "Table", "Time", "Staff", "Notes"
                        }
                    ) {
                        Class<?>[] columnTypes = new Class<?>[] {
                            Integer.class, Boolean.class, String.class, Integer.class, Object.class, Object.class, Object.class
                        };
                        boolean[] columnEditable = new boolean[] {
                            false, true, false, false, false, false, false
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
                        cm.getColumn(0).setMaxWidth(75);
                        cm.getColumn(0).setPreferredWidth(75);
                        cm.getColumn(1).setMaxWidth(50);
                        cm.getColumn(1).setPreferredWidth(50);
                    }
                    tblOrders.setAutoCreateRowSorter(true);
                    tblOrders.setShowHorizontalLines(true);
                    tblOrders.setShowVerticalLines(true);
                    scrOrdersTbl.setViewportView(tblOrders);
                }
                pnlOrders.add(scrOrdersTbl, new CC().cell(0, 0, 20, 17).growY());

                //---- btnOrdersRefresh ----
                btnOrdersRefresh.setText("Refresh");
                btnOrdersRefresh.addActionListener(e -> button8(e));
                pnlOrders.add(btnOrdersRefresh, new CC().cell(13, 18, 3, 2).growY());

                //---- btnOrdersSave ----
                btnOrdersSave.setText("Save");
                pnlOrders.add(btnOrdersSave, new CC().cell(17, 18, 3, 2).growY());
            }
            tpnMainScreen.addTab("Orders", pnlOrders);

            //======== pnlStaff ========
            {
                pnlStaff.setLayout(new MigLayout(
                    new LC().fill().insets("dialog").hideMode(3).align("center", "center"),
                    // columns
                    new AC()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill(),
                    // rows
                    new AC()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        ));

                //======== scrStaffTbl ========
                {

                    //---- tblStaff ----
                    tblStaff.setShowHorizontalLines(true);
                    tblStaff.setShowVerticalLines(true);
                    tblStaff.setModel(new DefaultTableModel(
                        new Object[][] {
                        },
                        new String[] {
                            "Staff ID", "Name", "Surname", "CellNo", "Position", "Wage"
                        }
                    ) {
                        Class<?>[] columnTypes = new Class<?>[] {
                            Integer.class, Object.class, Object.class, Object.class, Object.class, Double.class
                        };
                        @Override
                        public Class<?> getColumnClass(int columnIndex) {
                            return columnTypes[columnIndex];
                        }
                    });
                    {
                        TableColumnModel cm = tblStaff.getColumnModel();
                        cm.getColumn(0).setMaxWidth(80);
                        cm.getColumn(0).setPreferredWidth(80);
                    }
                    tblStaff.setAutoCreateRowSorter(true);
                    scrStaffTbl.setViewportView(tblStaff);
                }
                pnlStaff.add(scrStaffTbl, new CC().cell(0, 0, 20, 17).grow());

                //---- btnStaffNew ----
                btnStaffNew.setText("New");
                btnStaffNew.addActionListener(e -> btnStaffNew(e));
                pnlStaff.add(btnStaffNew, new CC().cell(0, 18, 3, 2).growY());

                //---- btnStaffRemove ----
                btnStaffRemove.setText("Remove");
                btnStaffRemove.addActionListener(e -> button11(e));
                pnlStaff.add(btnStaffRemove, new CC().cell(4, 18, 3, 2).growY());

                //---- btnStaffRefresh ----
                btnStaffRefresh.setText("Refresh");
                btnStaffRefresh.addActionListener(e -> button9(e));
                pnlStaff.add(btnStaffRefresh, new CC().cell(13, 18, 3, 2).growY());

                //---- btnStaffSave ----
                btnStaffSave.setText("Save");
                btnStaffSave.addActionListener(e -> btnStaffSave(e));
                pnlStaff.add(btnStaffSave, new CC().cell(17, 18, 3, 2).growY());
            }
            tpnMainScreen.addTab("Staff", pnlStaff);

            //======== pnlMenu ========
            {
                pnlMenu.setLayout(new MigLayout(
                    new LC().fill().insets("dialog").hideMode(3).align("center", "center"),
                    // columns
                    new AC()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill().gap()
                        .fill(),
                    // rows
                    new AC()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        .gap()
                        ));

                //======== scrMenuTbl ========
                {

                    //---- tblMenu ----
                    tblMenu.setAutoCreateRowSorter(true);
                    tblMenu.setModel(new DefaultTableModel(
                        new Object[][] {
                        },
                        new String[] {
                            "Item ID", "Item", "Description", "Price"
                        }
                    ) {
                        Class<?>[] columnTypes = new Class<?>[] {
                            Integer.class, Object.class, Object.class, Double.class
                        };
                        boolean[] columnEditable = new boolean[] {
                            false, true, true, true
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
                        TableColumnModel cm = tblMenu.getColumnModel();
                        cm.getColumn(0).setResizable(false);
                        cm.getColumn(0).setMaxWidth(80);
                        cm.getColumn(0).setPreferredWidth(80);
                        cm.getColumn(3).setMaxWidth(80);
                        cm.getColumn(3).setPreferredWidth(80);
                    }
                    tblMenu.setShowVerticalLines(true);
                    tblMenu.setShowHorizontalLines(true);
                    scrMenuTbl.setViewportView(tblMenu);
                }
                pnlMenu.add(scrMenuTbl, new CC().cell(0, 0, 20, 17).grow());

                //---- btnMenuNew ----
                btnMenuNew.setText("New");
                btnMenuNew.addActionListener(e -> button2(e));
                pnlMenu.add(btnMenuNew, new CC().cell(0, 18, 3, 2).growY());

                //---- btnMenuRemove ----
                btnMenuRemove.setText("Remove");
                btnMenuRemove.addActionListener(e -> button3(e));
                pnlMenu.add(btnMenuRemove, new CC().cell(4, 18, 3, 2).growY());

                //---- btnMenuRefresh ----
                btnMenuRefresh.setText("Refresh");
                btnMenuRefresh.addActionListener(e -> button5(e));
                pnlMenu.add(btnMenuRefresh, new CC().cell(13, 18, 3, 2).growY());

                //---- btnMenuSave ----
                btnMenuSave.setText("Save");
                btnMenuSave.addActionListener(e -> button4(e));
                pnlMenu.add(btnMenuSave, new CC().cell(17, 18, 3, 2).growY());
            }
            tpnMainScreen.addTab("Menu", pnlMenu);

            //======== pnlTables ========
            {
                pnlTables.setLayout(new MigLayout(
                    new LC().fill().insets("dialog").hideMode(3).align("center", "center"),
                    // columns
                    new AC()
                        .shrink(0).fill().gap("para")
                        .shrink(0).fill().gap("para")
                        .shrink(0).fill().gap("para")
                        .shrink(0).fill().gap("para")
                        .shrink(0).fill().gap("para")
                        .shrink(0).fill().gap("para")
                        .shrink(0).fill(),
                    // rows
                    new AC()
                        .shrink(0).fill().gap("para")
                        .shrink(0).fill().gap("para")
                        .shrink(0).fill().gap("para")
                        .shrink(0).fill().gap("para")
                        .shrink(0).fill().gap("para")
                        .size("27").shrink(0).fill()));

                //---- btnTable1 ----
                btnTable1.setIcon(new ImageIcon("D:\\School\\Harrison Easter - PAT\\Layer 2.png"));
                btnTable1.setText("Table 1");
                btnTable1.setHorizontalTextPosition(SwingConstants.CENTER);
                btnTable1.setVerticalTextPosition(SwingConstants.BOTTOM);
                btnTable1.setIconTextGap(0);
                btnTable1.setMargin(new Insets(0, 0, 0, 0));
                btnTable1.setBackground(UIManager.getColor("nb.output.input"));
                btnTable1.addActionListener(e -> button42(e));
                pnlTables.add(btnTable1, new CC().cell(0, 0));

                //---- btnTable2 ----
                btnTable2.setIcon(new ImageIcon("D:\\School\\Harrison Easter - PAT\\Layer 2.png"));
                btnTable2.setText("Table 2");
                btnTable2.setHorizontalTextPosition(SwingConstants.CENTER);
                btnTable2.setIconTextGap(0);
                btnTable2.setMargin(new Insets(0, 0, 0, 0));
                btnTable2.setVerticalTextPosition(SwingConstants.BOTTOM);
                btnTable2.addActionListener(e -> button59(e));
                pnlTables.add(btnTable2, new CC().cell(1, 0));

                //---- btnTable15 ----
                btnTable15.setIcon(new ImageIcon("D:\\School\\Harrison Easter - PAT\\Layer 2.png"));
                btnTable15.setText("Table 15");
                btnTable15.setHorizontalTextPosition(SwingConstants.CENTER);
                btnTable15.setIconTextGap(0);
                btnTable15.setMargin(new Insets(0, 0, 0, 0));
                btnTable15.setVerticalTextPosition(SwingConstants.BOTTOM);
                btnTable15.addActionListener(e -> button51(e));
                pnlTables.add(btnTable15, new CC().cell(5, 0));

                //---- btnTable16 ----
                btnTable16.setIcon(new ImageIcon("D:\\School\\Harrison Easter - PAT\\Layer 2.png"));
                btnTable16.setText("Table 16");
                btnTable16.setHorizontalTextPosition(SwingConstants.CENTER);
                btnTable16.setIconTextGap(0);
                btnTable16.setMargin(new Insets(0, 0, 0, 0));
                btnTable16.setVerticalTextPosition(SwingConstants.BOTTOM);
                btnTable16.addActionListener(e -> button52(e));
                pnlTables.add(btnTable16, new CC().cell(6, 0));

                //---- btnTable3 ----
                btnTable3.setIcon(new ImageIcon("D:\\School\\Harrison Easter - PAT\\Layer 2.png"));
                btnTable3.setText("Table 3");
                btnTable3.setHorizontalTextPosition(SwingConstants.CENTER);
                btnTable3.setIconTextGap(0);
                btnTable3.setMargin(new Insets(0, 0, 0, 0));
                btnTable3.setVerticalTextPosition(SwingConstants.BOTTOM);
                btnTable3.addActionListener(e -> button43(e));
                pnlTables.add(btnTable3, new CC().cell(0, 1));

                //---- btnTable8 ----
                btnTable8.setIcon(new ImageIcon("D:\\School\\Harrison Easter - PAT\\Layer 5 VERT.png"));
                btnTable8.setText("Table 8");
                btnTable8.setHorizontalTextPosition(SwingConstants.CENTER);
                btnTable8.setIconTextGap(7);
                btnTable8.setMargin(new Insets(0, 0, 0, 0));
                btnTable8.setVerticalTextPosition(SwingConstants.BOTTOM);
                btnTable8.addActionListener(e -> button56(e));
                pnlTables.add(btnTable8, new CC().cell(2, 0, 1, 2));

                //---- btnTable9 ----
                btnTable9.setIcon(new ImageIcon("D:\\School\\Harrison Easter - PAT\\Layer 5 VERT.png"));
                btnTable9.setText("Table 9");
                btnTable9.setHorizontalTextPosition(SwingConstants.CENTER);
                btnTable9.setIconTextGap(7);
                btnTable9.setMargin(new Insets(0, 0, 0, 0));
                btnTable9.setVerticalTextPosition(SwingConstants.BOTTOM);
                btnTable9.addActionListener(e -> button57(e));
                pnlTables.add(btnTable9, new CC().cell(3, 0, 1, 2));

                //---- btnTable14 ----
                btnTable14.setIcon(new ImageIcon("D:\\School\\Harrison Easter - PAT\\Layer 2.png"));
                btnTable14.setText("Table 14");
                btnTable14.setHorizontalTextPosition(SwingConstants.CENTER);
                btnTable14.setIconTextGap(0);
                btnTable14.setMargin(new Insets(0, 0, 0, 0));
                btnTable14.setVerticalTextPosition(SwingConstants.BOTTOM);
                btnTable14.addActionListener(e -> button60(e));
                pnlTables.add(btnTable14, new CC().cell(4, 0));

                //---- btnTable4 ----
                btnTable4.setIcon(new ImageIcon("D:\\School\\Harrison Easter - PAT\\Layer 2.png"));
                btnTable4.setText("Table 4");
                btnTable4.setHorizontalTextPosition(SwingConstants.CENTER);
                btnTable4.setIconTextGap(0);
                btnTable4.setMargin(new Insets(0, 0, 0, 0));
                btnTable4.setVerticalTextPosition(SwingConstants.BOTTOM);
                btnTable4.addActionListener(e -> button61(e));
                pnlTables.add(btnTable4, new CC().cell(1, 1));

                //---- btnTable17 ----
                btnTable17.setIcon(new ImageIcon("D:\\School\\Harrison Easter - PAT\\Layer 2.png"));
                btnTable17.setText("Table 17");
                btnTable17.setHorizontalTextPosition(SwingConstants.CENTER);
                btnTable17.setIconTextGap(0);
                btnTable17.setMargin(new Insets(0, 0, 0, 0));
                btnTable17.setVerticalTextPosition(SwingConstants.BOTTOM);
                btnTable17.addActionListener(e -> button62(e));
                pnlTables.add(btnTable17, new CC().cell(4, 1));

                //---- btnTable18 ----
                btnTable18.setIcon(new ImageIcon("D:\\School\\Harrison Easter - PAT\\Layer 2.png"));
                btnTable18.setText("Table 18");
                btnTable18.setHorizontalTextPosition(SwingConstants.CENTER);
                btnTable18.setIconTextGap(0);
                btnTable18.setMargin(new Insets(0, 0, 0, 0));
                btnTable18.setVerticalTextPosition(SwingConstants.BOTTOM);
                btnTable18.addActionListener(e -> button53(e));
                pnlTables.add(btnTable18, new CC().cell(5, 1));

                //---- btnTable19 ----
                btnTable19.setIcon(new ImageIcon("D:\\School\\Harrison Easter - PAT\\Layer 2.png"));
                btnTable19.setText("Table 19");
                btnTable19.setHorizontalTextPosition(SwingConstants.CENTER);
                btnTable19.setIconTextGap(0);
                btnTable19.setMargin(new Insets(0, 0, 0, 0));
                btnTable19.setVerticalTextPosition(SwingConstants.BOTTOM);
                btnTable19.addActionListener(e -> button54(e));
                pnlTables.add(btnTable19, new CC().cell(6, 1));

                //---- btnTable5 ----
                btnTable5.setIcon(new ImageIcon("D:\\School\\Harrison Easter - PAT\\Layer 2.png"));
                btnTable5.setText("Table 5");
                btnTable5.setHorizontalTextPosition(SwingConstants.CENTER);
                btnTable5.setIconTextGap(0);
                btnTable5.setMargin(new Insets(0, 0, 0, 0));
                btnTable5.setVerticalTextPosition(SwingConstants.BOTTOM);
                btnTable5.addActionListener(e -> button44(e));
                pnlTables.add(btnTable5, new CC().cell(0, 2));

                //---- btnTable6 ----
                btnTable6.setIcon(new ImageIcon("D:\\School\\Harrison Easter - PAT\\Layer 2.png"));
                btnTable6.setText("Table 6");
                btnTable6.setHorizontalTextPosition(SwingConstants.CENTER);
                btnTable6.setIconTextGap(0);
                btnTable6.setMargin(new Insets(0, 0, 0, 0));
                btnTable6.setVerticalTextPosition(SwingConstants.BOTTOM);
                btnTable6.addActionListener(e -> button45(e));
                pnlTables.add(btnTable6, new CC().cell(0, 3));

                //---- btnTable11 ----
                btnTable11.setIcon(new ImageIcon("D:\\School\\Harrison Easter - PAT\\Layer 5 VERT.png"));
                btnTable11.setText("Table 11");
                btnTable11.setHorizontalTextPosition(SwingConstants.CENTER);
                btnTable11.setIconTextGap(7);
                btnTable11.setMargin(new Insets(0, 0, 0, 0));
                btnTable11.setVerticalTextPosition(SwingConstants.BOTTOM);
                btnTable11.addActionListener(e -> button55(e));
                pnlTables.add(btnTable11, new CC().cell(3, 2, 1, 2));

                //---- btnTable10 ----
                btnTable10.setIcon(new ImageIcon("D:\\School\\Harrison Easter - PAT\\Layer 5 VERT.png"));
                btnTable10.setText("Table 10");
                btnTable10.setHorizontalTextPosition(SwingConstants.CENTER);
                btnTable10.setIconTextGap(7);
                btnTable10.setMargin(new Insets(0, 0, 0, 0));
                btnTable10.setVerticalTextPosition(SwingConstants.BOTTOM);
                btnTable10.addActionListener(e -> button50(e));
                pnlTables.add(btnTable10, new CC().cell(2, 2, 1, 2));

                //---- btnTable7 ----
                btnTable7.setIcon(new ImageIcon("D:\\School\\Harrison Easter - PAT\\Layer 2.png"));
                btnTable7.setText("Table 7");
                btnTable7.setHorizontalTextPosition(SwingConstants.CENTER);
                btnTable7.setIconTextGap(0);
                btnTable7.setMargin(new Insets(0, 0, 0, 0));
                btnTable7.setVerticalTextPosition(SwingConstants.BOTTOM);
                btnTable7.addActionListener(e -> button46(e));
                pnlTables.add(btnTable7, new CC().cell(0, 4));

                //---- btnTable12 ----
                btnTable12.setIcon(new ImageIcon("D:\\School\\Harrison Easter - PAT\\Layer 6.png"));
                btnTable12.setText("Table 12");
                btnTable12.setIconTextGap(7);
                btnTable12.setHorizontalTextPosition(SwingConstants.LEFT);
                btnTable12.setMargin(new Insets(0, 0, 0, 0));
                btnTable12.addActionListener(e -> button47(e));
                pnlTables.add(btnTable12, new CC().cell(1, 4, 3, 1));

                //---- btnTable13 ----
                btnTable13.setIcon(new ImageIcon("D:\\School\\Harrison Easter - PAT\\Layer 6.png"));
                btnTable13.setText("Table 13");
                btnTable13.setIconTextGap(7);
                btnTable13.setHorizontalTextPosition(SwingConstants.LEFT);
                btnTable13.setMargin(new Insets(0, 0, 0, 0));
                btnTable13.addActionListener(e -> button48(e));
                pnlTables.add(btnTable13, new CC().cell(4, 4, 3, 1));

                //---- btnTableNewBooking ----
                btnTableNewBooking.setText("New Booking");
                btnTableNewBooking.setMargin(null);
                pnlTables.add(btnTableNewBooking, new CC().cell(0, 5, 2, 1));
            }
            tpnMainScreen.addTab("Tables", pnlTables);
        }
        contentPane.add(tpnMainScreen, new CC().cell(0, 0));
        setSize(960, 740);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Harrison Easter (MRS CLI EASTER)
    private JTabbedPane tpnMainScreen;
    private JPanel pnlOrders;
    private JScrollPane scrOrdersTbl;
    private JTable tblOrders;
    private JButton btnOrdersRefresh;
    private JButton btnOrdersSave;
    private JPanel pnlStaff;
    private JScrollPane scrStaffTbl;
    private JTable tblStaff;
    private JButton btnStaffNew;
    private JButton btnStaffRemove;
    private JButton btnStaffRefresh;
    private JButton btnStaffSave;
    private JPanel pnlMenu;
    private JScrollPane scrMenuTbl;
    private JTable tblMenu;
    private JButton btnMenuNew;
    private JButton btnMenuRemove;
    private JButton btnMenuRefresh;
    private JButton btnMenuSave;
    private JPanel pnlTables;
    private JButton btnTable1;
    private JButton btnTable2;
    private JButton btnTable15;
    private JButton btnTable16;
    private JButton btnTable3;
    private JButton btnTable8;
    private JButton btnTable9;
    private JButton btnTable14;
    private JButton btnTable4;
    private JButton btnTable17;
    private JButton btnTable18;
    private JButton btnTable19;
    private JButton btnTable5;
    private JButton btnTable6;
    private JButton btnTable11;
    private JButton btnTable10;
    private JButton btnTable7;
    private JButton btnTable12;
    private JButton btnTable13;
    private JButton btnTableNewBooking;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
