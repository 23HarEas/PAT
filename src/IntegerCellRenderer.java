/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author harri
 */
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.text.DecimalFormat;

public class IntegerCellRenderer extends DefaultTableCellRenderer {

    private DecimalFormat integerFormat;

    public IntegerCellRenderer() {
        integerFormat = new DecimalFormat("#");
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (value instanceof Number) {
            Number number = (Number) value;
            int intValue = number.intValue();
            setText(integerFormat.format(intValue));
        }

        return component;
    }
}
