
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.layout.*;
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
        String name = txtNewStaffName.getText();
        String surname = txtNewStaffSurname.getText();
        String cellphone = txtNewStaffCell.getText();
        String position = txtNewStaffPosition.getText();
        Double wage = Double.parseDouble(txtNewStaffWage.getText());

        MainScreen.staffArr.newStaffItem(name, surname, cellphone, position, wage);
        dispose();
        ScreenBuild.mainScreen.refreshJTables();
        ScreenBuild.mainScreen.saveJTables();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Harrison Easter (MRS CLI EASTER)
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

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setTitle("New Staff Member");
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
                .shrink(0).fill()));

        //---- lblNewStaffName ----
        lblNewStaffName.setText("Name");
        contentPane.add(lblNewStaffName, new CC().cell(1, 1, 4, 1).grow());
        contentPane.add(txtNewStaffName, new CC().cell(4, 1, 4, 1));

        //---- lblNewStaffSurname ----
        lblNewStaffSurname.setText("Surname");
        contentPane.add(lblNewStaffSurname, new CC().cell(1, 2, 3, 1).grow());
        contentPane.add(txtNewStaffSurname, new CC().cell(4, 2, 4, 1));

        //---- lblNewStaffCell ----
        lblNewStaffCell.setText("Cellphone");
        contentPane.add(lblNewStaffCell, new CC().cell(1, 3, 5, 1));
        contentPane.add(txtNewStaffCell, new CC().cell(4, 3, 4, 1));

        //---- lblNewStaffPosition ----
        lblNewStaffPosition.setText("Position");
        contentPane.add(lblNewStaffPosition, new CC().cell(1, 4, 3, 1).grow());
        contentPane.add(txtNewStaffPosition, new CC().cell(4, 4, 4, 1));

        //---- lblNewStaffWage ----
        lblNewStaffWage.setText("Wage");
        contentPane.add(lblNewStaffWage, new CC().cell(1, 5, 4, 1));
        contentPane.add(txtNewStaffWage, new CC().cell(4, 5, 4, 1));

        //---- btnNewStaffSubmit ----
        btnNewStaffSubmit.setText("Add Staff Member");
        btnNewStaffSubmit.addActionListener(e -> button1(e));
        contentPane.add(btnNewStaffSubmit, new CC().cell(1, 7, 7, 1));
        setSize(500, 500);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Harrison Easter (MRS CLI EASTER)
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
