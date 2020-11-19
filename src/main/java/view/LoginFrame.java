package view;

import data.Master;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.apache.log4j.Logger;

public class LoginFrame extends JFrame {

    private static final Logger LOGGER = Logger.getLogger(LoginFrame.class);
    private final Master M = new Master();
    private JLabel label1, label2, label3;
    private JTextField text1, text2;
    private JButton button;
    private JPanel panel;
    
    private String login;
    private String password;

    public LoginFrame() {
        getForm();
    }

    private void getForm() {

        label1 = new JLabel("Login");
        label2 = new JLabel("Password");
        label3 = new JLabel();
        text1 = new JTextField(10);
        text2 = new JTextField(10);
        button = new JButton("Access");
        panel = new JPanel();

        setTitle("Login Form");
        setSize(290, 200);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(panel);

        panel.setLayout(null);

        label1.setBounds(10, 20, 80, 25);
        panel.add(label1);

        text1.setBounds(100, 20, 165, 25);
        panel.add(text1);

        label2.setBounds(10, 50, 80, 25);
        panel.add(label2);

        text2.setBounds(100, 50, 165, 25);
        panel.add(text2);

        button.setBounds(10, 90, 254, 25);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnAct(e);
            }
        });
        panel.add(button);

        label3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label3.setBounds(10, 130, 254, 25);
        panel.add(label3);

        setLocationRelativeTo(null);
    }

    private void btnAct(ActionEvent e) {
        login = String.valueOf(text1.getText());
        password = String.valueOf(text2.getText());
        if (login.isEmpty() || password.isEmpty()) {
            LOGGER.info(e);
            LOGGER.info("Get login: " + login);
            LOGGER.info("Get password: " + password);
            label3.setForeground(Color.red);
            label3.setText("Somesing went wrong...");
        } else {
            if (!M.getLogin().equals(login)) {
                LOGGER.info("Get login: " + login);
                LOGGER.info("Get password: " + password);
                label3.setForeground(Color.red);
                label3.setText("Somesing went wrong...");
            } else {
                if (!M.getPassword().equals(password)) {
                    LOGGER.info("Get login: " + login);
                    LOGGER.info("Get password: " + password);
                    label3.setForeground(Color.red);
                    label3.setText("Somesing went wrong...");
                } else {
                    new Main().setVisible(true);
                    this.dispose();
                }
            }
        }
    }
}
