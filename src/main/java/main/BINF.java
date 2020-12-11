package main;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

public class BINF extends JFrame {

    private static final Logger LOGGER = Logger.getLogger(BINF.class);
    private JTextField text1, text2;
    private JLabel label;
    private JButton b1, b2, b3, b4, b5, b6;
    private JTable table;
    //private Box contents;
    //private JPanel panel1, panel2;
    private DefaultTableModel model;

    public BINF() {
        getForm();
    }

    private void getForm() {
        text1 = new JTextField(50);
        text2 = new JTextField(70);
        label = new JLabel("Status: ");
        b1 = new JButton("Add Row");
        b2 = new JButton("Add Coll");
        b3 = new JButton("Remove Row");
        b4 = new JButton("Remove Coll");
        b5 = new JButton("Send Message");
        b6 = new JButton("Print!");
        //contents = new Box(BoxLayout.Y_AXIS);
        //panel1 = new JPanel();
        //panel2 = new JPanel();

        setTitle("KMTK - BIN");
        setSize(1050, 500);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel pane = new JPanel(new GridBagLayout());
        setContentPane(pane);

        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.HORIZONTAL;

        label = label = new JLabel("Status: ");
        c.gridx = 0;
        c.gridwidth = 10;
        c.gridy = 0;
        pane.add(label, c);

        JButton buttonA = new JButton("Button A");
        c.gridx = 0;
        c.gridwidth = 1;
        c.gridy = 1;
        pane.add(buttonA, c);

        JButton buttonB = new JButton("Button B");
        c.gridx = 1;
        c.gridwidth = 1;
        c.gridy = 1;
        pane.add(buttonB, c);

        JButton buttonC = new JButton("Button C");
        c.gridx = 2;
        c.gridwidth = 1;
        c.gridy = 1;
        pane.add(buttonC, c);

        Object[][] data = new String[][]{{"1", "Афанасенко", ""},
        {"2", "Богданов", ""},
        {"3", "Зленко", ""},
        {"4", "Іпатов", ""},
        {"5", "Панчик", ""},
        {"6", "Пінчук", ""},
        {"7", "Семенченков", ""},
        {"8", "Ткаченко", ""},
        {"9", "Чупряк", ""},
        {"10", "Щербина", ""}};

        Object[] columns = new String[]{"Id", "F., S. Name",
            "ТОЗП"};

        final Class[] columnClass = new Class[]{
            Integer.class, String.class, String.class
        };
        model = new DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return true;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnClass[columnIndex];
            }
        };

        table = new JTable(model);
        table.setRowHeight(22);

        c.gridx = 0;
        c.gridwidth = 0;
        c.gridy = 0;
        pane.add(table, c);

        /*
        b1 = new JButton("Add Row");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idx = table.getSelectedRow();
                model.insertRow(idx + 1, new String[]{
                    "Id" + String.valueOf(table.getRowCount()),
                    "FS Name", "Point"});
            }
        });
        b3 = new JButton("Remove Row");
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idx = table.getSelectedRow();
                model.removeRow(idx);
            }
        });

//        contents.add(new JScrollPane(table));
       // getContentPane().add(contents);

        panel1.add(b1);
        panel1.add(b2);
        panel1.add(b3);
        panel1.add(b4);
        panel1.add(b5);
        panel1.add(b6);
//        getContentPane().add(panel1, "South");

        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setBounds(10, 5, 1020, 30);
        panel2.add(label);

        text1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        text1.setBounds(10, 100, 1020, 30);
        panel2.add(text1);
      //  getContentPane().add(panel2, "North");

         */
        setLocationRelativeTo(null);
    }

}
