package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import org.apache.log4j.Logger;
import service.ServiceImpl;

public class SendFrame extends JFrame {

    private static final Logger LOGGER = Logger.getLogger(SendFrame.class);
    private final ServiceImpl src = new ServiceImpl();
    private JPanel panel;

    public SendFrame() {
        getForm();
    }

    private void getForm() {
        panel = new JPanel();

        setTitle("Send Mail Form");
        setSize(1050, 500);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(panel);

        panel.setLayout(null);

        setLocationRelativeTo(null);
    }

}
