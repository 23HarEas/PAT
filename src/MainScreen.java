import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import com.formdev.flatlaf.ui.*;
import net.miginfocom.layout.*;
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

    private void createUIComponents() {
        // TODO: add custom component creation code here
    }

    private void button7(ActionEvent e) {
        // TODO add your code here
        String[] test = new String[]{"1", "2", "3"};
         String input = (String)JOptionPane.showInputDialog(null, "Filter Orders By", "Order Filters", JOptionPane.PLAIN_MESSAGE, null, test, "1");
    }

    private void button8(ActionEvent e) {
        // TODO add your code here
        
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Harrison Easter (MRS CLI EASTER)
        tabbedPane1 = new JTabbedPane();
        panel4 = new JPanel();
        scrollPane2 = new JScrollPane();
        table2 = new JTable();
        button8 = new JButton();
        button6 = new JButton();
        panel1 = new JPanel();
        scrollPane3 = new JScrollPane();
        table3 = new JTable();
        button10 = new JButton();
        button11 = new JButton();
        button9 = new JButton();
        button1 = new JButton();
        panel3 = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button2 = new JButton();
        button3 = new JButton();
        button5 = new JButton();
        button4 = new JButton();
        panel2 = new JPanel();
        button42 = new JButton();
        button59 = new JButton();
        button51 = new JButton();
        button52 = new JButton();
        button43 = new JButton();
        button56 = new JButton();
        button57 = new JButton();
        button60 = new JButton();
        button61 = new JButton();
        button62 = new JButton();
        button53 = new JButton();
        button54 = new JButton();
        button44 = new JButton();
        button45 = new JButton();
        button50 = new JButton();
        button55 = new JButton();
        button46 = new JButton();
        button47 = new JButton();
        button48 = new JButton();
        button12 = new JButton();

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

        //======== tabbedPane1 ========
        {

            //======== panel4 ========
            {
                panel4.setLayout(new MigLayout(
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

                //======== scrollPane2 ========
                {

                    //---- table2 ----
                    table2.setModel(new DefaultTableModel(
                        new Object[][] {
                            {null, true, null, null, "", null, null},
                        },
                        new String[] {
                            "Order ID", "Status", "Order", "Table", "Time", "Staff", "Notes"
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
                    {
                        TableColumnModel cm = table2.getColumnModel();
                        cm.getColumn(0).setMaxWidth(75);
                        cm.getColumn(0).setPreferredWidth(75);
                        cm.getColumn(1).setMaxWidth(50);
                        cm.getColumn(1).setPreferredWidth(50);
                        cm.getColumn(4).setMaxWidth(75);
                        cm.getColumn(4).setPreferredWidth(75);
                    }
                    table2.setAutoCreateRowSorter(true);
                    table2.setShowHorizontalLines(true);
                    table2.setShowVerticalLines(true);
                    scrollPane2.setViewportView(table2);
                }
                panel4.add(scrollPane2, new CC().cell(0, 0, 20, 17).growY());

                //---- button8 ----
                button8.setText("Refresh");
                button8.addActionListener(e -> button8(e));
                panel4.add(button8, new CC().cell(13, 18, 3, 2).growY());

                //---- button6 ----
                button6.setText("Save");
                panel4.add(button6, new CC().cell(17, 18, 3, 2).growY());
            }
            tabbedPane1.addTab("Orders", panel4);

            //======== panel1 ========
            {
                panel1.setLayout(new MigLayout(
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

                //======== scrollPane3 ========
                {

                    //---- table3 ----
                    table3.setShowHorizontalLines(true);
                    table3.setShowVerticalLines(true);
                    table3.setModel(new DefaultTableModel(
                        new Object[][] {
                            {null, null, null, null, null, null},
                        },
                        new String[] {
                            "Staff ID", "Name", "Surname", "CellNo", "Position", "Wage"
                        }
                    ));
                    {
                        TableColumnModel cm = table3.getColumnModel();
                        cm.getColumn(0).setMaxWidth(80);
                        cm.getColumn(0).setPreferredWidth(80);
                    }
                    table3.setAutoCreateRowSorter(true);
                    scrollPane3.setViewportView(table3);
                }
                panel1.add(scrollPane3, new CC().cell(0, 0, 20, 17).grow());

                //---- button10 ----
                button10.setText("New");
                panel1.add(button10, new CC().cell(0, 18, 3, 2).growY());

                //---- button11 ----
                button11.setText("Remove");
                panel1.add(button11, new CC().cell(4, 18, 3, 2).growY());

                //---- button9 ----
                button9.setText("Refresh");
                panel1.add(button9, new CC().cell(13, 18, 3, 2).growY());

                //---- button1 ----
                button1.setText("Save");
                panel1.add(button1, new CC().cell(17, 18, 3, 2).growY());
            }
            tabbedPane1.addTab("Staff", panel1);

            //======== panel3 ========
            {
                panel3.setLayout(new MigLayout(
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

                //======== scrollPane1 ========
                {

                    //---- table1 ----
                    table1.setAutoCreateRowSorter(true);
                    table1.setModel(new DefaultTableModel(
                        new Object[][] {
                            {null, null, null, null},
                            {null, null, null, null},
                        },
                        new String[] {
                            "Item ID", "Item", "Description", "Price"
                        }
                    ));
                    {
                        TableColumnModel cm = table1.getColumnModel();
                        cm.getColumn(0).setMaxWidth(80);
                        cm.getColumn(0).setPreferredWidth(80);
                        cm.getColumn(3).setMaxWidth(80);
                        cm.getColumn(3).setPreferredWidth(80);
                    }
                    table1.setShowVerticalLines(true);
                    table1.setShowHorizontalLines(true);
                    scrollPane1.setViewportView(table1);
                }
                panel3.add(scrollPane1, new CC().cell(0, 0, 20, 17).grow());

                //---- button2 ----
                button2.setText("New");
                panel3.add(button2, new CC().cell(0, 18, 3, 2).growY());

                //---- button3 ----
                button3.setText("Remove");
                panel3.add(button3, new CC().cell(4, 18, 3, 2).growY());

                //---- button5 ----
                button5.setText("Refresh");
                panel3.add(button5, new CC().cell(13, 18, 3, 2).growY());

                //---- button4 ----
                button4.setText("Save");
                panel3.add(button4, new CC().cell(17, 18, 3, 2).growY());
            }
            tabbedPane1.addTab("Menu", panel3);

            //======== panel2 ========
            {
                panel2.setLayout(new MigLayout(
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

                //---- button42 ----
                button42.setIcon(new ImageIcon("D:\\School\\Harrison Easter - PAT\\Layer 2.png"));
                panel2.add(button42, new CC().cell(0, 0));

                //---- button59 ----
                button59.setIcon(new ImageIcon("D:\\School\\Harrison Easter - PAT\\Layer 2.png"));
                panel2.add(button59, new CC().cell(1, 0));

                //---- button51 ----
                button51.setIcon(new ImageIcon("D:\\School\\Harrison Easter - PAT\\Layer 2.png"));
                panel2.add(button51, new CC().cell(5, 0));

                //---- button52 ----
                button52.setIcon(new ImageIcon("D:\\School\\Harrison Easter - PAT\\Layer 2.png"));
                panel2.add(button52, new CC().cell(6, 0));

                //---- button43 ----
                button43.setIcon(new ImageIcon("D:\\School\\Harrison Easter - PAT\\Layer 2.png"));
                panel2.add(button43, new CC().cell(0, 1));

                //---- button56 ----
                button56.setIcon(new ImageIcon("D:\\School\\Harrison Easter - PAT\\Layer 5 VERT.png"));
                panel2.add(button56, new CC().cell(2, 0, 1, 2));

                //---- button57 ----
                button57.setIcon(new ImageIcon("D:\\School\\Harrison Easter - PAT\\Layer 5 VERT.png"));
                panel2.add(button57, new CC().cell(3, 0, 1, 2));

                //---- button60 ----
                button60.setIcon(new ImageIcon("D:\\School\\Harrison Easter - PAT\\Layer 2.png"));
                panel2.add(button60, new CC().cell(4, 0));

                //---- button61 ----
                button61.setIcon(new ImageIcon("D:\\School\\Harrison Easter - PAT\\Layer 2.png"));
                panel2.add(button61, new CC().cell(1, 1));

                //---- button62 ----
                button62.setIcon(new ImageIcon("D:\\School\\Harrison Easter - PAT\\Layer 2.png"));
                panel2.add(button62, new CC().cell(4, 1));

                //---- button53 ----
                button53.setIcon(new ImageIcon("D:\\School\\Harrison Easter - PAT\\Layer 2.png"));
                panel2.add(button53, new CC().cell(5, 1));

                //---- button54 ----
                button54.setIcon(new ImageIcon("D:\\School\\Harrison Easter - PAT\\Layer 2.png"));
                panel2.add(button54, new CC().cell(6, 1));

                //---- button44 ----
                button44.setIcon(new ImageIcon("D:\\School\\Harrison Easter - PAT\\Layer 2.png"));
                panel2.add(button44, new CC().cell(0, 2));

                //---- button45 ----
                button45.setIcon(new ImageIcon("D:\\School\\Harrison Easter - PAT\\Layer 2.png"));
                panel2.add(button45, new CC().cell(0, 3));

                //---- button50 ----
                button50.setIcon(new ImageIcon("D:\\School\\Harrison Easter - PAT\\Layer 5 VERT.png"));
                panel2.add(button50, new CC().cell(2, 2, 1, 2));

                //---- button55 ----
                button55.setIcon(new ImageIcon("D:\\School\\Harrison Easter - PAT\\Layer 5 VERT.png"));
                panel2.add(button55, new CC().cell(3, 2, 1, 2));

                //---- button46 ----
                button46.setIcon(new ImageIcon("D:\\School\\Harrison Easter - PAT\\Layer 2.png"));
                panel2.add(button46, new CC().cell(0, 4));

                //---- button47 ----
                button47.setIcon(new ImageIcon("D:\\School\\Harrison Easter - PAT\\Layer 6.png"));
                panel2.add(button47, new CC().cell(1, 4, 3, 1));

                //---- button48 ----
                button48.setIcon(new ImageIcon("D:\\School\\Harrison Easter - PAT\\Layer 6.png"));
                panel2.add(button48, new CC().cell(4, 4, 3, 1));

                //---- button12 ----
                button12.setText("New Booking");
                button12.setMargin(null);
                panel2.add(button12, new CC().cell(0, 5, 2, 1));
            }
            tabbedPane1.addTab("Tables", panel2);
        }
        contentPane.add(tabbedPane1, new CC().cell(0, 0));
        setSize(960, 740);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Harrison Easter (MRS CLI EASTER)
    private JTabbedPane tabbedPane1;
    private JPanel panel4;
    private JScrollPane scrollPane2;
    private JTable table2;
    private JButton button8;
    private JButton button6;
    private JPanel panel1;
    private JScrollPane scrollPane3;
    private JTable table3;
    private JButton button10;
    private JButton button11;
    private JButton button9;
    private JButton button1;
    private JPanel panel3;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button2;
    private JButton button3;
    private JButton button5;
    private JButton button4;
    private JPanel panel2;
    private JButton button42;
    private JButton button59;
    private JButton button51;
    private JButton button52;
    private JButton button43;
    private JButton button56;
    private JButton button57;
    private JButton button60;
    private JButton button61;
    private JButton button62;
    private JButton button53;
    private JButton button54;
    private JButton button44;
    private JButton button45;
    private JButton button50;
    private JButton button55;
    private JButton button46;
    private JButton button47;
    private JButton button48;
    private JButton button12;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
