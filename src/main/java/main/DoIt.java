package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JTable;

public class DoIt {

    public String getDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now();
        return dtf.format(localDate);
    }

    public double totalPoint(JTable table) {
        double total = 0;
        String point;
        for (int i = 0; i < table.getRowCount(); i++) {
            for (int j = 2; j < table.getColumnCount() && j < table.getColumnCount() - 4; j++) {
                point = (String) table.getValueAt(i, j);
                if (point.equals("5") || point.equals("4") || point.equals("3") || point.equals("2") || point.equals("н/а")) {
                    total++;
                }
            }
        }
        return total;
    }

    public double fiveAndFour(JTable table) {
        double fif = 0;
        String point;
        for (int i = 0; i < table.getRowCount(); i++) {
            for (int j = 2; j < table.getColumnCount() && j < table.getColumnCount() - 4; j++) {
                point = (String) table.getValueAt(i, j);
                if (point.equals("5") || point.equals("4")) {
                    fif++;
                }
            }
        }
        return fif;
    }

    public double negative(JTable table) {
        double neg = 0;
        String point;
        for (int i = 0; i < table.getRowCount(); i++) {
            for (int j = 2; j < table.getColumnCount() && j < table.getColumnCount() - 4; j++) {
                point = (String) table.getValueAt(i, j);
                if (point.equals("2") || point.equals("н/а")) {
                    neg++;
                }
            }
        }
        return neg;
    }

    public void averageScore(JTable table) {
        double sum = 0;
        int cols = 0;
        int l = table.getColumnCount() - 1;
        String s;
        for (int i = 0; i < table.getRowCount(); i++) {
            for (int j = 2; j < table.getColumnCount() && j < table.getColumnCount() - 4; j++) {
                s = table.getValueAt(i, j).toString();
                if (s.equals(" ") || s.equals("2") || s.equals("-") || s.equals("н/а") || s.isEmpty()) {
                    sum = 0;
                    String u = String.valueOf(sum);
                    table.setValueAt(u, i, l);
                } else {
                    sum += Integer.parseInt(table.getValueAt(i, j).toString());
                    cols++;
                    double t = sum / cols;
                    String u = String.valueOf(t);
                    table.setValueAt(u, i, l);
                    if (j < cols && cols == table.getColumnCount() - 4) {
                        cols = 0;
                        sum = 0;
                    }
                }
            }
        }
    }

    public void truancy(JTable table) {
        int a = getc("З поважних причин", table);
        int b = getc("Всього", table);

        int sum = 0;
        int count = 0;
        for (int i = 0; i < table.getRowCount(); i++) {
            for (int j = a; j < table.getColumnCount() && j < table.getColumnCount() - 2; j++) {
                sum += Integer.parseInt(table.getValueAt(i, j).toString());
                count++;
                table.setValueAt(String.valueOf(sum), i, b);
                if (count == 2) {
                    count = 0;
                    sum = 0;
                }
            }
        }
    }

    private int getc(String s, JTable table) {
        int a = 0;
        for (int i = 0; i < table.getColumnCount(); i++) {
            if (table.getColumnName(i).equals(s)) {
                a = i;
            }
        }
        return a;
    }

}
