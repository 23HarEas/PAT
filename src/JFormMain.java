import java.awt.*;
import javax.swing.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Mon Jul 10 21:09:25 CAT 2023
 */



/**
 * @author harri
 */
public class JFormMain extends JFrame {
    public JFormMain() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Harrison Easter (MRS CLI EASTER)
        label1 = new JLabel();
        label2 = new JLabel();
        formattedTextField1 = new JFormattedTextField();
        label3 = new JLabel();
        passwordField1 = new JPasswordField();
        button1 = new JButton();

        //======== this ========
        setTitle("Login");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
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

        //---- label1 ----
        label1.setText("Please Login");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setFont(new Font("Segoe UI", Font.BOLD, 42));
        contentPane.add(label1, "cell 4 3 13 4");

        //---- label2 ----
        label2.setText("Username");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label2, "cell 4 7 3 1,align left center,grow 0 0");
        contentPane.add(formattedTextField1, "cell 7 7 10 1");

        //---- label3 ----
        label3.setText("Password");
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label3, "cell 4 9 3 1,alignx left,growx 0");
        contentPane.add(passwordField1, "cell 7 9 10 1");

        //---- button1 ----
        button1.setText("Submit");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getStyle() | Font.BOLD, button1.getFont().getSize() + 23f));
        contentPane.add(button1, "cell 4 11 13 3,grow");
        setSize(500, 500);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Harrison Easter (MRS CLI EASTER)
    private JLabel label1;
    private JLabel label2;
    private JFormattedTextField formattedTextField1;
    private JLabel label3;
    private JPasswordField passwordField1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
