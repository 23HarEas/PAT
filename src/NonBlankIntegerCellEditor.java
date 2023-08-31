/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author harri
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class NonBlankIntegerCellEditor extends AbstractCellEditor implements TableCellEditor {

    private JTextField textField;
    private Pattern integerPattern;
    private boolean isValidInput = true;

    public NonBlankIntegerCellEditor() {
        textField = new JTextField();
        integerPattern = Pattern.compile("^-?\\d+$"); // Regular expression for integer values

        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopCellEditing(); // Commit the edited value when Enter is pressed
            }
        });

        textField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                validateInput();
            }
        });
    }

    private void validateInput() {
        String editedValue = textField.getText();
        isValidInput = !editedValue.isEmpty() && integerPattern.matcher(editedValue).matches() && Integer.parseInt(editedValue) >= 0;
        textField.setForeground(isValidInput ? Color.black : Color.red);
    }

    @Override
    public Object getCellEditorValue() {
        return textField.getText();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        textField.setText(value != null ? value.toString() : "");
        validateInput();
        return textField;
    }

    @Override
    public boolean stopCellEditing() {
        if (!isValidInput) {
            return false;
        }
        return super.stopCellEditing(); // Call the default implementation to commit the value
    }
}
