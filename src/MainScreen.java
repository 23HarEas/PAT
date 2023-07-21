import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Thu Jul 20 19:34:24 CAT 2023
 */



/**
 * @author harri
 */
public class MainScreen extends JFrame {
    public MainScreen() {
        initComponents();
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
    }

    private void button2(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Harrison Easter (MRS CLI EASTER)
        tabbedPane1 = new JTabbedPane();
        panel4 = new JPanel();
        scrollPane2 = new JScrollPane();
        table2 = new JTable();
        button7 = new JButton();
        button8 = new JButton();
        button6 = new JButton();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button2 = new JButton();
        button3 = new JButton();
        button5 = new JButton();
        button4 = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Resturant Managment System");
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "fill,insets dialog,hidemode 3,align leading center",
            // columns
            "[fill]",
            // rows
            "[fill]"));

        //======== tabbedPane1 ========
        {

            //======== panel4 ========
            {
                panel4.setLayout(new MigLayout(
                    "fill,insets dialog,hidemode 3,align center center",
                    // columns
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]",
                    // rows
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]"));

                //======== scrollPane2 ========
                {

                    //---- table2 ----
                    table2.setModel(new DefaultTableModel(
                        new Object[][] {
                            {null, null, null, null, null, null, null},
                        },
                        new String[] {
                            "Number", "Status", "Order", "Table", "Time", "Staff", "Notes"
                        }
                    ) {
                        Class<?>[] columnTypes = new Class<?>[] {
                            Object.class, Boolean.class, Object.class, Object.class, Object.class, Object.class, Object.class
                        };
                        @Override
                        public Class<?> getColumnClass(int columnIndex) {
                            return columnTypes[columnIndex];
                        }
                    });
                    table2.setAutoCreateRowSorter(true);
                    scrollPane2.setViewportView(table2);
                }
                panel4.add(scrollPane2, "cell 0 0 20 17,growy");

                //---- button7 ----
                button7.setText("Filter");
                panel4.add(button7, "cell 0 18 3 2,growy");

                //---- button8 ----
                button8.setText("Refresh");
                panel4.add(button8, "cell 13 18 3 2,growy");

                //---- button6 ----
                button6.setText("Save");
                panel4.add(button6, "cell 17 18 3 2,growy");
            }
            tabbedPane1.addTab("Orders", panel4);

            //======== panel1 ========
            {
                panel1.setLayout(new MigLayout(
                    "fill,insets dialog,hidemode 3,align center center",
                    // columns
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]",
                    // rows
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]"));
            }
            tabbedPane1.addTab("Tables", panel1);

            //======== panel2 ========
            {
                panel2.setLayout(new MigLayout(
                    "fill,insets dialog,hidemode 3,align center center",
                    // columns
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]",
                    // rows
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]"));
            }
            tabbedPane1.addTab("Staff", panel2);

            //======== panel3 ========
            {
                panel3.setLayout(new MigLayout(
                    "fill,insets dialog,hidemode 3,align center center",
                    // columns
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]",
                    // rows
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]"));

                //======== scrollPane1 ========
                {

                    //---- table1 ----
                    table1.setAutoCreateRowSorter(true);
                    table1.setModel(new DefaultTableModel(
                        new Object[][] {
                            {null, null, null},
                        },
                        new String[] {
                            "Item", "Description", "Price"
                        }
                    ));
                    scrollPane1.setViewportView(table1);
                }
                panel3.add(scrollPane1, "cell 0 0 19 17,grow");

                //---- button2 ----
                button2.setText("New");
                panel3.add(button2, "cell 0 18 3 2,growy");

                //---- button3 ----
                button3.setText("Delete");
                panel3.add(button3, "cell 4 18 3 2,growy");

                //---- button5 ----
                button5.setText("Refresh");
                panel3.add(button5, "cell 12 18 3 2,growy");

                //---- button4 ----
                button4.setText("Save");
                panel3.add(button4, "cell 16 18 3 2,growy");
            }
            tabbedPane1.addTab("Menu", panel3);
        }
        contentPane.add(tabbedPane1, "cell 0 0");
        setSize(915, 640);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Harrison Easter (MRS CLI EASTER)
    private JTabbedPane tabbedPane1;
    private JPanel panel4;
    private JScrollPane scrollPane2;
    private JTable table2;
    private JButton button7;
    private JButton button8;
    private JButton button6;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button2;
    private JButton button3;
    private JButton button5;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
