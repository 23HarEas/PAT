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
public class NewStaffItem {
    public NewStaffItem() {
        initComponents();
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Harrison Easter (MRS CLI EASTER)
        NewStaff = new JFrame();
        lblNewStaffName = new JLabel();
        txtNewStaffName = new JTextField();
        lblNewStaffSurname = new JLabel();
        txtNewStaffSurname = new JTextField();
        lblNewStaffCell = new JLabel();
        txtNewStaffCell = new JTextField();
        lblNewStaffPosition = new JLabel();
        txtNewStaffPosition = new JTextField();
        lblNewStaffWage = new JLabel();
        txtNewStaffWage = new JTextField();
        btnNewStaffSubmit = new JButton();

        //======== NewStaff ========
        {
            NewStaff.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            NewStaff.setAlwaysOnTop(true);
            NewStaff.setTitle("New Staff Member");
            Container NewStaffContentPane = NewStaff.getContentPane();
            NewStaffContentPane.setLayout(new MigLayout(
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

            //---- lblNewStaffName ----
            lblNewStaffName.setText("Name");
            NewStaffContentPane.add(lblNewStaffName, "cell 1 1 4 1,grow");
            NewStaffContentPane.add(txtNewStaffName, "cell 4 1 4 1");

            //---- lblNewStaffSurname ----
            lblNewStaffSurname.setText("Surname");
            NewStaffContentPane.add(lblNewStaffSurname, "cell 1 2 3 1,grow");
            NewStaffContentPane.add(txtNewStaffSurname, "cell 4 2 4 1");

            //---- lblNewStaffCell ----
            lblNewStaffCell.setText("Cellphone");
            NewStaffContentPane.add(lblNewStaffCell, "cell 1 3 5 1");
            NewStaffContentPane.add(txtNewStaffCell, "cell 4 3 4 1");

            //---- lblNewStaffPosition ----
            lblNewStaffPosition.setText("Position");
            NewStaffContentPane.add(lblNewStaffPosition, "cell 1 4 3 1,grow");
            NewStaffContentPane.add(txtNewStaffPosition, "cell 4 4 4 1");

            //---- lblNewStaffWage ----
            lblNewStaffWage.setText("Wage");
            NewStaffContentPane.add(lblNewStaffWage, "cell 1 5 4 1");
            NewStaffContentPane.add(txtNewStaffWage, "cell 4 5 4 1");

            //---- btnNewStaffSubmit ----
            btnNewStaffSubmit.setText("Add Staff Member");
            btnNewStaffSubmit.addActionListener(e -> button1(e));
            NewStaffContentPane.add(btnNewStaffSubmit, "cell 1 7 7 1");
            NewStaff.setSize(500, 500);
            NewStaff.setLocationRelativeTo(null);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Harrison Easter (MRS CLI EASTER)
    private JFrame NewStaff;
    private JLabel lblNewStaffName;
    private JTextField txtNewStaffName;
    private JLabel lblNewStaffSurname;
    private JTextField txtNewStaffSurname;
    private JLabel lblNewStaffCell;
    private JTextField txtNewStaffCell;
    private JLabel lblNewStaffPosition;
    private JTextField txtNewStaffPosition;
    private JLabel lblNewStaffWage;
    private JTextField txtNewStaffWage;
    private JButton btnNewStaffSubmit;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
