/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author harri
 */
import javax.swing.DefaultCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.util.EventObject;

public class NonBlankIntegerCellEditor extends DefaultCellEditor {

    private JTextField textField;
    private Border defaultBorder;

    public NonBlankIntegerCellEditor() {
        super(new JTextField());
        textField = (JTextField) getComponent();
        defaultBorder = textField.getBorder();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        textField.setText(value == null ? "" : String.valueOf(value));
        textField.setBorder(defaultBorder); // Reset border color
        return textField;
    }

    @Override
    public boolean stopCellEditing() {
        String text = textField.getText();
        if (text.trim().isEmpty()) {
            textField.setBorder(new LineBorder(Color.red));
            return false;
        }

        try {
            int intValue = Integer.parseInt(text);
            textField.setBorder(defaultBorder);
            return super.stopCellEditing();
        } catch (NumberFormatException e) {
            textField.setBorder(new LineBorder(Color.red));
            return false;
        }
    }

    @Override
    public boolean shouldSelectCell(EventObject anEvent) {
        if (anEvent instanceof KeyEvent) {
            KeyEvent ke = (KeyEvent) anEvent;
            return ke.getID() != KeyEvent.KEY_PRESSED || ke.getKeyCode() == KeyEvent.VK_ENTER;
        }
        return true;
    }
}
