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
public class RemoveMenuItem {
    public RemoveMenuItem() {
        initComponents();
        comboBox1.setModel(MainScreen.menuArr.MenuComboLoad(comboBox1));
        AutoCompleteDecorator.decorate(comboBox1);
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
        String remove = (String)comboBox1.getSelectedItem();
        MainScreen.menuArr.removeMenuItem(remove);
        dispose();
        ScreenBuild.mainScreen.refreshJTables();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Harrison Easter (MRS CLI EASTER)
        RemoveMenu = new JFrame();
        lblRemoveMenu = new JLabel();
        cmbRemoveMenu = new JComboBox();
        btnRemoveMenuSubmit = new JButton();

        //======== RemoveMenu ========
        {
            RemoveMenu.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            RemoveMenu.setAlwaysOnTop(true);
            RemoveMenu.setTitle("Remove Menu Item");
            Container RemoveMenuContentPane = RemoveMenu.getContentPane();
            RemoveMenuContentPane.setLayout(new MigLayout(
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

            //---- lblRemoveMenu ----
            lblRemoveMenu.setText("Item To Remove");
            lblRemoveMenu.setHorizontalAlignment(SwingConstants.LEFT);
            RemoveMenuContentPane.add(lblRemoveMenu, "cell 1 2 7 1");
            RemoveMenuContentPane.add(cmbRemoveMenu, "cell 1 3 7 1");

            //---- btnRemoveMenuSubmit ----
            btnRemoveMenuSubmit.setText("Remove Item");
            btnRemoveMenuSubmit.addActionListener(e -> button1(e));
            RemoveMenuContentPane.add(btnRemoveMenuSubmit, "cell 1 7 7 1");
            RemoveMenu.setSize(500, 500);
            RemoveMenu.setLocationRelativeTo(null);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Harrison Easter (MRS CLI EASTER)
    private JFrame RemoveMenu;
    private JLabel lblRemoveMenu;
    private JComboBox cmbRemoveMenu;
    private JButton btnRemoveMenuSubmit;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
