import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Thu Aug 24 13:34:31 SAST 2023
 */



/**
 * @author harrisoneaster
 */
public class RemoveStaffItem extends JPanel {
    public RemoveStaffItem() {
        initComponents();
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
        
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Harrison Easter (MRS CLI EASTER)
        RemoveStaff = new JFrame();
        lblRemoveStaff = new JLabel();
        cmbRemoveStaff = new JComboBox();
        btnRemoveStaffSubmit = new JButton();

        //======== RemoveStaff ========
        {
            RemoveStaff.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            RemoveStaff.setAlwaysOnTop(true);
            RemoveStaff.setTitle("Remove Staff Member");
            Container RemoveStaffContentPane = RemoveStaff.getContentPane();
            RemoveStaffContentPane.setLayout(new MigLayout(
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

            //---- lblRemoveStaff ----
            lblRemoveStaff.setText("Staff Member To Remove");
            lblRemoveStaff.setHorizontalAlignment(SwingConstants.LEFT);
            RemoveStaffContentPane.add(lblRemoveStaff, "cell 1 2 7 1");
            RemoveStaffContentPane.add(cmbRemoveStaff, "cell 1 3 7 1");

            //---- btnRemoveStaffSubmit ----
            btnRemoveStaffSubmit.setText("Remove Staff Member");
            btnRemoveStaffSubmit.addActionListener(e -> button1(e));
            RemoveStaffContentPane.add(btnRemoveStaffSubmit, "cell 1 7 7 1");
            RemoveStaff.setSize(500, 500);
            RemoveStaff.setLocationRelativeTo(null);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Harrison Easter (MRS CLI EASTER)
    private JFrame RemoveStaff;
    private JLabel lblRemoveStaff;
    private JComboBox cmbRemoveStaff;
    private JButton btnRemoveStaffSubmit;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
