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
        label1 = new JLabel();
        comboBox1 = new JComboBox();
        button1 = new JButton();

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

        //---- label1 ----
        label1.setText("Item To Remove");
        label1.setHorizontalAlignment(SwingConstants.LEFT);
        contentPane.add(label1, new CC().cell(1, 2, 7, 1));
        contentPane.add(comboBox1, new CC().cell(1, 3, 7, 1));

        //---- button1 ----
        button1.setText("Remove Item");
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1, new CC().cell(1, 7, 7, 1));
        setSize(500, 500);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Harrison Easter (MRS CLI EASTER)
    private JLabel label1;
    private JComboBox comboBox1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
