package servicep;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ServiceP {

    private final String status = "Стан виконання: ";

    public void b1A(JTable table, JLabel label1, DefaultTableModel model) {
        int gsr = table.getSelectedRow();
        model.insertRow(gsr + 1, new String[]{"№ п/п", "П. І. Б.", "Телефон батьків", "Пошта батьків"});
        label1.setText(status + "Додано рядок");
    }

    public void b2A(JTable table, JLabel label1, DefaultTableModel model) {
        int gsr = table.getSelectedRow();
        model.removeRow(gsr);
        label1.setText(status + "Видалено рядок");
    }

    public void notValid(JLabel label1) {
        label1.setForeground(Color.red);
        label1.setText(status + "Увага, не вірно введені дані!");
    }

}
