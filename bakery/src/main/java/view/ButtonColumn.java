package view;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import controller.OrderController; 
public class ButtonColumn extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, ActionListener {
    private JButton renderButton;
    private JButton editButton;
    private JTable table;
    private String text;
    private OrderController controller = new OrderController();

    public ButtonColumn(JTable table, int column) {
        this.table = table;
        this.renderButton = new JButton();
        this.editButton = new JButton();
        this.editButton.setFocusPainted(false);
        this.editButton.addActionListener(this);

        // 將此類別綁定到 JTable 指定的欄位
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(column).setCellRenderer(this);
        columnModel.getColumn(column).setCellEditor(this);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        renderButton.setText("刪除");
        return renderButton;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        text = "刪除";
        editButton.setText(text);
        return editButton;
    }

    @Override
    public Object getCellEditorValue() {
        return text;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 取得正確的資料模型索引 (避免排序後刪錯行)
        int row = table.convertRowIndexToModel(table.getEditingRow());
        
        // 必須先停止編輯狀態，否則會發生 UI 渲染衝突
        fireEditingStopped();

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Object idValue = model.getValueAt(row, 0); // 取得索引 0 (ID 或 "待送出")

        // 判斷邏輯：若是數字 ID 則呼叫 Controller 刪除資料庫，若是字串則僅移除 UI
        if (idValue instanceof Integer) {
            int id = (int) idValue;
            int confirm = JOptionPane.showConfirmDialog(null, "確定要刪除資料庫中的訂單 (ID: " + id + ") 嗎？", "刪除確認", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                controller.removeOrder(id); // 呼叫 Controller 邏輯
                model.removeRow(row);
            }
        } else {
            // 純粹移除 JTable 上的暫存資料
            model.removeRow(row);
        }
    }
}