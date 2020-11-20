package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

public class MainFrame extends JFrame {

    private static final Logger LOGGER = Logger.getLogger(MainFrame.class);
    private JPanel panel;
    private JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9, label10;
    private JButton button1, button2, button3, button4, button5;
    private JTable table;

    public MainFrame() {
        getForm();
    }

    private void getForm() {
        label1 = new JLabel(FIO());
        label2 = new JLabel("ТРЗВ - 17/1");
        label3 = new JLabel("Загальна кількість оцінок: " + allPoints());
        label4 = new JLabel("Кількість оцінок '5' та '4': " + FAF());
        label5 = new JLabel("Кількість незадовільних оцінок: " + last());
        label6 = new JLabel("% успішності: " + ysp());
        label7 = new JLabel("% якості: " + yak());
        label8 = new JLabel("% прогулів: " + prog());
        label9 = new JLabel("Дата заповнення: ");
        label10 = new JLabel("Керівник групи: " + FIO());
        button1 = new JButton("Add Group");
        button2 = new JButton("Remove Group");
        button3 = new JButton("SAVE");
        button4 = new JButton("Go Print!");
        button5 = new JButton("Send Message");
        panel = new JPanel();

        setTitle("Main Form");
        setSize(706, 500);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(panel);

        panel.setLayout(null);

        label1.setBounds(10, 10, 120, 25);
        panel.add(label1);

        label2.setBounds(10, 30, 120, 25);
        panel.add(label2);

        button1.setBounds(100, 20, 100, 30);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnAct1(e);
            }
        });
        panel.add(button1);

        button2.setBounds(210, 20, 125, 30);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnAct2(e);
            }
        });
        panel.add(button2);

        button3.setBounds(345, 20, 80, 30);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnAct3(e);
            }
        });
        panel.add(button3);

        button4.setBounds(435, 20, 110, 30);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnAct4(e);
            }
        });
        panel.add(button4);

        button5.setBounds(555, 20, 125, 30);
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnAct5(e);
            }
        });
        panel.add(button5);

        String[] columns = new String[]{
            "№ п/п", "П.І.Б.", "ТОЗП", "Економіка", "Укр. мова"
        };

        Object[][] data = new Object[][]{
            {1, "Афанасенко", "", "", ""},
            {2, "Богданов", "", "", ""},
            {3, "Зленко", "", "", ""},
            {4, "Іпатов", "", "", ""},
            {5, "Панчик", "", "", ""},
            {6, "Пінчук", "", "", ""},
            {7, "Семенченков", "", "", ""},
            {8, "Ткаченко", "", "", ""},
            {9, "Чупряк", "", "", ""},
            {10, "Щербина", "", "", ""},};

        final Class[] columnClass = new Class[]{
            Integer.class, String.class, String.class, String.class, String.class
        };

        DefaultTableModel model = new DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnClass[columnIndex];
            }
        };

        table = new JTable(model);
        // http://java-online.ru/swing-jtable.xhtml
        table.setBounds(10, 60, 668, 300);
        panel.add(table);

        label3.setBounds(25, 365, 200, 25);
        panel.add(label3);

        label4.setBounds(25, 385, 200, 25);
        panel.add(label4);

        label5.setBounds(25, 405, 250, 25);
        panel.add(label5);

        label6.setBounds(25, 425, 200, 25);
        panel.add(label6);

        label7.setBounds(440, 365, 200, 25);
        panel.add(label7);

        label8.setBounds(440, 385, 200, 25);
        panel.add(label8);

        label9.setBounds(440, 405, 200, 25);
        panel.add(label9);

        label10.setBounds(440, 425, 200, 25);
        panel.add(label10);

        setLocationRelativeTo(null);
    }

    private void btnAct1(ActionEvent e) {
        LOGGER.info(e);
    }

    private void btnAct2(ActionEvent e) {
        LOGGER.info(e);
    }

    private void btnAct3(ActionEvent e) {
        LOGGER.info(e);
    }

    private void btnAct4(ActionEvent e) {
        LOGGER.info(e);
    }

    private void btnAct5(ActionEvent e) {
        LOGGER.info(e);
    }

    private int allPoints() {
        return 1111;
    }

    private int FAF() {
        return 1111;
    }

    private int last() {
        return 1111;
    }

    private double ysp() {
        return 1111;
    }

    private double yak() {
        return 1111;
    }

    private double prog() {
        return 1111;
    }

    private void dataMod() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();
        System.out.println(dtf.format(localDate));
    }

    private String FIO() {
        return "І.М. Богданов";
    }
}
