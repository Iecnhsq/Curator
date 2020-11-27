package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import org.apache.log4j.Logger;

public class SendFrame extends JFrame {

    private static final Logger LOGGER = Logger.getLogger(SendFrame.class);
    private JPanel panel;

    public SendFrame() {
        getForm();
    }

    private void getForm() {
        panel = new JPanel();
    }

}
