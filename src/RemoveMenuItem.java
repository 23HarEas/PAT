
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.layout.*;
import net.miginfocom.swing.*;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/*
 * Created by JFormDesigner on Mon Jul 31 22:01:19 CAT 2023
 */
/**
 * @author harri
 */
public class RemoveMenuItem extends JFrame {

    public RemoveMenuItem() {
        initComponents();
        cmbRemoveMenu.setModel(MainScreen.menuArr.menuComboLoad(cmbRemoveMenu));
        AutoCompleteDecorator.decorate(cmbRemoveMenu);
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
        String remove = (String) cmbRemoveMenu.getSelectedItem();
        MainScreen.menuArr.menuRemoveItem(remove);
        dispose();
        ScreenBuild.mainScreen.refreshJTables();
        ScreenBuild.mainScreen.saveJTables();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Harrison Easter (MRS CLI EASTER)
        lblRemoveMenu = new JLabel();
        cmbRemoveMenu = new JComboBox();
        btnRemoveMenuSubmit = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setTitle("Remove Menu Item");
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

        //---- lblRemoveMenu ----
        lblRemoveMenu.setText("Item To Remove");
        lblRemoveMenu.setHorizontalAlignment(SwingConstants.LEFT);
        contentPane.add(lblRemoveMenu, new CC().cell(1, 2, 7, 1));
        contentPane.add(cmbRemoveMenu, new CC().cell(1, 3, 7, 1));

        //---- btnRemoveMenuSubmit ----
        btnRemoveMenuSubmit.setText("Remove Item");
        btnRemoveMenuSubmit.addActionListener(e -> button1(e));
        contentPane.add(btnRemoveMenuSubmit, new CC().cell(1, 7, 7, 1));
        setSize(500, 500);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Harrison Easter (MRS CLI EASTER)
    private JLabel lblRemoveMenu;
    private JComboBox cmbRemoveMenu;
    private JButton btnRemoveMenuSubmit;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
