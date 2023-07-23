

import java.awt.*;
import java.awt.event.*;
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
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
        String[] test = new String[]{"1", "2", "3"};
         String input = (String)JOptionPane.showInputDialog(null, "Item", "New Order", JOptionPane.PLAIN_MESSAGE, null, test, "1");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Harrison Easter (MRS CLI EASTER)
        label1 = new JLabel();
        textField1 = new JTextField();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();
        label4 = new JLabel();
        textField4 = new JTextField();
        label5 = new JLabel();
        textField5 = new JTextField();
        label6 = new JLabel();
        textField6 = new JTextField();
        label7 = new JLabel();
        textField7 = new JTextField();
        button4 = new JButton();
        button1 = new JButton();
        button2 = new JButton();
        label8 = new JLabel();
        textField8 = new JTextField();

        //======== this ========
        setTitle("Table 4 Current Tab");
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

        //---- label1 ----
        label1.setText("Tab ID");
        contentPane.add(label1, new CC().cell(1, 1, 3, 1));

        //---- textField1 ----
        textField1.setEditable(false);
        contentPane.add(textField1, new CC().cell(4, 1, 4, 1));

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
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
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1, new CC().cell(9, 1, 17, 18));

        //---- label2 ----
        label2.setText("Staff");
        contentPane.add(label2, new CC().cell(1, 2, 3, 1));

        //---- textField2 ----
        textField2.setEditable(false);
        contentPane.add(textField2, new CC().cell(4, 2, 4, 1));

        //---- label3 ----
        label3.setText("Pax");
        contentPane.add(label3, new CC().cell(1, 3, 3, 1));

        //---- textField3 ----
        textField3.setEditable(false);
        contentPane.add(textField3, new CC().cell(4, 3, 4, 1));

        //---- label4 ----
        label4.setText("Time");
        contentPane.add(label4, new CC().cell(1, 4, 3, 1));

        //---- textField4 ----
        textField4.setEditable(false);
        contentPane.add(textField4, new CC().cell(4, 4, 4, 1));

        //---- label5 ----
        label5.setText("Type");
        contentPane.add(label5, new CC().cell(1, 5, 3, 1));

        //---- textField5 ----
        textField5.setEditable(false);
        contentPane.add(textField5, new CC().cell(4, 5, 4, 1));

        //---- label6 ----
        label6.setText("Booking Name");
        contentPane.add(label6, new CC().cell(1, 6, 3, 1));

        //---- textField6 ----
        textField6.setEditable(false);
        contentPane.add(textField6, new CC().cell(4, 6, 4, 1));

        //---- label7 ----
        label7.setText("Phone Number");
        contentPane.add(label7, new CC().cell(1, 7, 3, 1));

        //---- textField7 ----
        textField7.setEditable(false);
        contentPane.add(textField7, new CC().cell(4, 7, 4, 1));

        //---- button4 ----
        button4.setText("New Order");
        contentPane.add(button4, new CC().cell(1, 11, 7, 2));

        //---- button1 ----
        button1.setText("Remove Order");
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1, new CC().cell(1, 13, 7, 2).grow());

        //---- button2 ----
        button2.setText("Close Tab");
        contentPane.add(button2, new CC().cell(1, 15, 7, 2).grow());

        //---- label8 ----
        label8.setText("Total");
        contentPane.add(label8, new CC().cell(1, 18, 3, 1).growY());

        //---- textField8 ----
        textField8.setEditable(false);
        contentPane.add(textField8, new CC().cell(4, 18, 4, 1).growY());
        setSize(960, 740);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Harrison Easter (MRS CLI EASTER)
    private JLabel label1;
    private JTextField textField1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JTextField textField3;
    private JLabel label4;
    private JTextField textField4;
    private JLabel label5;
    private JTextField textField5;
    private JLabel label6;
    private JTextField textField6;
    private JLabel label7;
    private JTextField textField7;
    private JButton button4;
    private JButton button1;
    private JButton button2;
    private JLabel label8;
    private JTextField textField8;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
