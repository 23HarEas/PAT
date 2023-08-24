import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Thu Aug 24 13:25:06 SAST 2023
 */



/**
 * @author harrisoneaster
 */
public class NewStaffItem extends JFrame {
    public NewStaffItem() {
        initComponents();
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Harrison Easter (MRS CLI EASTER)
        label1 = new JLabel();
        textField1 = new JTextField();
        label4 = new JLabel();
        textField5 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label5 = new JLabel();
        textField4 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();
        button1 = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setTitle("New Staff Member");
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
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
            "[shrink 0,fill]"));

        //---- label1 ----
        label1.setText("Name");
        contentPane.add(label1, "cell 1 1 4 1,grow");
        contentPane.add(textField1, "cell 4 1 4 1");

        //---- label4 ----
        label4.setText("Surname");
        contentPane.add(label4, "cell 1 2 3 1,grow");
        contentPane.add(textField5, "cell 4 2 4 1");

        //---- label2 ----
        label2.setText("Cellphone");
        contentPane.add(label2, "cell 1 3 5 1");
        contentPane.add(textField2, "cell 4 3 4 1");

        //---- label5 ----
        label5.setText("Position");
        contentPane.add(label5, "cell 1 4 3 1,grow");
        contentPane.add(textField4, "cell 4 4 4 1");

        //---- label3 ----
        label3.setText("Wage");
        contentPane.add(label3, "cell 1 5 4 1");
        contentPane.add(textField3, "cell 4 5 4 1");

        //---- button1 ----
        button1.setText("Add Staff Member");
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1, "cell 1 7 7 1");
        setSize(500, 500);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Harrison Easter (MRS CLI EASTER)
    private JLabel label1;
    private JTextField textField1;
    private JLabel label4;
    private JTextField textField5;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label5;
    private JTextField textField4;
    private JLabel label3;
    private JTextField textField3;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
