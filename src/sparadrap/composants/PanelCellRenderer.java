package sparadrap.composants;
import javax.swing.*;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.EventObject;
public class PanelCellRenderer extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
    @Override
    public boolean shouldSelectCell(EventObject anEvent) {
        return true;
    }
    @Override
    public boolean stopCellEditing() {
        return true;
    }
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return (JComponent) table.getValueAt(row, column);
    }
    @Override
    public Object getCellEditorValue() {
        return "";
    }
    @Override
    public boolean isCellEditable(EventObject anEvent) {
        return true;
    }
    @Override
    public Component getTableCellRendererComponent(JTable table,
                                                   Object value,
                                                   boolean isSelected,
                                                   boolean hasFocus,
                                                   int row,
                                                   int column) {
        return (JComponent) table.getValueAt(row, column);
    }
}