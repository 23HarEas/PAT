

import javax.swing.DefaultCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import java.util.EventObject;

import javax.swing.DefaultCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.EventObject;

public class NonBlankCellEditor extends DefaultCellEditor {
    private JTextField textField;

    public NonBlankCellEditor() {
        super(new JTextField());
        textField = (JTextField) getComponent();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        textField.setText((String) value);
        textField.setBorder(new LineBorder(Color.black)); // Reset border color
        return textField;
    }

    @Override
    public boolean stopCellEditing() {
        String value = (String) super.getCellEditorValue();
        if (value.trim().isEmpty()) {
            textField.setBorder(new LineBorder(Color.red));
            return false;
        }
        return super.stopCellEditing();
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