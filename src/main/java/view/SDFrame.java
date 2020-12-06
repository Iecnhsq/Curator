package view;

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

    public SDFrame() {
        getForm();
    }

    private void getForm() {
        table = new JTable();
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

        setLocationRelativeTo(null);
    }

}
