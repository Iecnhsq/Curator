package view;

import data.UDAO;
import data.User;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import org.apache.log4j.Logger;

public class RegisterFrame extends JFrame {

    private static final Logger LOGGER = Logger.getLogger(RegisterFrame.class);
    private final UDAO udao = new UDAO();
    private JLabel label1, label2, label3, label4, label5;
    private JTextField text1, text2, text3, text4;
    private JButton button;
    private JPanel panel;

    private String login;
    private String pass;
    private String confirmpass;
    private String mail;

    public RegisterFrame() {
        getForm();
    }

    private void getForm() {

        label1 = new JLabel("Login");
        label2 = new JLabel("Password");
        label3 = new JLabel("Confirm Password");
        label4 = new JLabel("E - Mail");
        label5 = new JLabel();
        text1 = new JTextField(25);
        text2 = new JTextField(25);
        text3 = new JTextField(25);
        text4 = new JTextField(25);
        button = new JButton("Sign In");
        panel = new JPanel();

        setTitle("Register Form");
        setSize(322, 250);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(panel);

        panel.setLayout(null);

        label1.setBounds(10, 20, 80, 25);
        panel.add(label1);

        text1.setBounds(130, 20, 165, 25);
        panel.add(text1);

        label2.setBounds(10, 50, 80, 25);
        panel.add(label2);

        text2.setBounds(130, 50, 165, 25);
        panel.add(text2);

        label3.setBounds(10, 80, 110, 25);
        panel.add(label3);

        text3.setBounds(130, 80, 165, 25);
        panel.add(text3);

        label4.setBounds(10, 110, 80, 25);
        panel.add(label4);

        text4.setBounds(130, 110, 165, 25);
        panel.add(text4);

        button.setBounds(10, 150, 284, 25);
        button.addActionListener((ActionEvent e) -> {
            btnAct(e);
        });
        panel.add(button);

        label5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label5.setBounds(10, 180, 284, 25);
        panel.add(label5);

        setLocationRelativeTo(null);
    }

    private void btnAct(ActionEvent e) {
        login = String.valueOf(text1.getText());
        pass = String.valueOf(text2.getText());
        confirmpass = String.valueOf(text3.getText());
        mail = String.valueOf(text4.getText());
        if (login.isEmpty() || isLogin(login) != null || login.length() < 5) {
            LOGGER.info(e);
            LOGGER.info("Login = " + login);
            label5.setForeground(Color.red);
            label5.setText("Somesing went wrong...");
        } else {
            if (pass.isEmpty() || pass.length() < 5 || !pass.equals(confirmpass)) {
                LOGGER.info("Password = " + pass);
                label5.setForeground(Color.red);
                label5.setText("Somesing went wrong...");
            } else {
                if (mail.isEmpty() || isMail(mail) != null) {
                    LOGGER.info("Mail = " + mail);
                    label5.setForeground(Color.red);
                    label5.setText("Somesing went wrong...");
                } else {
                    new AccountFrame().setVisible(true);
                    this.dispose();
                }
            }
        }
    }

    private User isLogin(String login) {
        User u;
        u = udao.getUserByLogin(login);
        return u;
    }

    private User isMail(String mail) {
        User u;
        u = udao.getUserByMail(mail);
        return u;
    }

}
