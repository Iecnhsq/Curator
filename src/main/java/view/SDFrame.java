package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import org.apache.log4j.Logger;

public class SDFrame extends JFrame {

    private static final Logger LOGGER = Logger.getLogger(SDFrame.class);
    private JPanel panel;

    public SDFrame() {
        getForm();
    }

    private void getForm() {
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
