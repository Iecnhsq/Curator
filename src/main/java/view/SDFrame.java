package view;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import org.apache.log4j.Logger;
import service.ServiceImpl;

public class SDFrame extends JFrame {

    private static final Logger LOGGER = Logger.getLogger(SDFrame.class);
    private final ServiceImpl src = new ServiceImpl();
    private JPanel panel;
    private JTable table;
    private JButton b1, b2, b3, b4;
    private JLabel label;

    private final Object[][] array = new String[][]{{"1", "ТОЗП", "5", "3", "3"},
    {"1", "ТОЗП", "5", "3", "3"},
    {"1", "ТОЗП", "5", "3", "3"}};

    private final Object[] columnsHeader = new String[]{"Id", "Name", "Point", "Term", "Course"};

    public SDFrame() {
        getForm();
    }

    private void getForm() {
        table = new JTable(array, columnsHeader);
        b1 = new JButton("Add Row");
        b2 = new JButton("Remove Row");
        b3 = new JButton("Accept");
        b4 = new JButton("Go Back");
        label = new JLabel("Status");
        panel = new JPanel();

        setTitle("Add Discipline And Subject Form");
        setSize(1050, 500);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(panel);

        panel.setLayout(null);

        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setBounds(10, 5, 1020, 25);
        panel.add(label);

        b1.setBounds(100, 40, 120, 30);
        b1.addActionListener((ActionEvent e) -> {
            btnAct1(e);
        });
        panel.add(b1);

        b2.setBounds(250, 40, 120, 30);
        b2.addActionListener((ActionEvent e) -> {
            btnAct2(e);
        });
        panel.add(b2);

        b3.setBounds(400, 40, 120, 30);
        b3.addActionListener((ActionEvent e) -> {
            btnAct3(e);
        });
        panel.add(b3);

        b4.setBounds(805, 40, 120, 30);
        b4.addActionListener((ActionEvent e) -> {
            btnAct4(e);
        });
        panel.add(b4);

        table.setBounds(65, 100, 900, 320);
        panel.add(table);

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
        new AccountFrame().setVisible(true);
        this.dispose();
    }

}
