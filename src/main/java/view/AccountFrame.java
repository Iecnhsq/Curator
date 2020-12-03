package view;

import data.Holder;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import org.apache.log4j.Logger;
import service.ServiceImpl;

public class AccountFrame extends JFrame {

    private static final Logger LOGGER = Logger.getLogger(AccountFrame.class);
    private final ServiceImpl src = new ServiceImpl();
    private JTextField text1, text2, text3, text4, text5, text6;
    private JLabel label;
    private JButton b1, b2, b3, b4, b5, b6;
    private JTable table;
    private JPanel panel;

    private String fio;
    private String log;
    private String pass;
    private String mail;
    private String tel;
    private String grp;

    public AccountFrame() {
        getForm();
    }

    private void getForm() {
        text1 = new JTextField(25);
        text2 = new JTextField(25);
        text3 = new JTextField(25);
        text4 = new JTextField(25);
        text5 = new JTextField(25);
        text6 = new JTextField(25);
        label = new JLabel("Status");
        b1 = new JButton("Change!");
        b2 = new JButton("Add Row");
        b3 = new JButton("Remove Row");
        b4 = new JButton("Sheet Term");
        b5 = new JButton("Sheet Month");
        b6 = new JButton("Add DIS/SUB");
        table = new JTable();
        panel = new JPanel();

        setTitle("Account Form");
        setSize(1050, 500);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(panel);

        panel.setLayout(null);

        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setBounds(10, 5, 1020, 25);
        panel.add(label);

        text1.setEditable(false);
        text2.setEditable(false);
        text3.setEditable(false);
        text4.setEditable(false);
        text5.setEditable(false);
        text6.setEditable(false);

        text1.setBounds(10, 30, 165, 25);
        text1.setText(src.isLogin(Holder.getLogin()).getFio());
        panel.add(text1);

        text2.setBounds(180, 30, 165, 25);
        text2.setText(src.isLogin(Holder.getLogin()).getLogin());
        panel.add(text2);

        text3.setBounds(350, 30, 165, 25);
        text3.setText(src.isLogin(Holder.getLogin()).getPassword());
        panel.add(text3);

        text4.setBounds(520, 30, 165, 25);
        text4.setText(src.isLogin(Holder.getLogin()).getMail());
        panel.add(text4);

        text5.setBounds(690, 30, 165, 25);
        text5.setText(src.isLogin(Holder.getLogin()).getPhone());
        panel.add(text5);

        text6.setBounds(860, 30, 165, 25);
        text6.setText(src.isLogin(Holder.getLogin()).getGroup_u());
        panel.add(text6);

        b1.setBounds(50, 70, 100, 30);
        b1.addActionListener((ActionEvent e) -> {
            btnAct1(e);
        });
        panel.add(b1);

        b2.setBounds(220, 70, 100, 30);
        b2.addActionListener((ActionEvent e) -> {
            btnAct2(e);
        });
        panel.add(b2);

        b3.setBounds(340, 70, 130, 30);
        b3.addActionListener((ActionEvent e) -> {
            btnAct3(e);
        });
        panel.add(b3);

        b4.setBounds(520, 70, 130, 30);
        b4.addActionListener((ActionEvent e) -> {
            btnAct4(e);
        });
        panel.add(b4);

        b5.setBounds(670, 70, 130, 30);
        b5.addActionListener((ActionEvent e) -> {
            btnAct5(e);
        });
        panel.add(b5);

        b6.setBounds(850, 70, 130, 30);
        b6.addActionListener((ActionEvent e) -> {
            btnAct6(e);
        });
        panel.add(b6);

        table.setBounds(65, 120, 900, 300);
        panel.add(table);

        setLocationRelativeTo(null);

    }

    private void btnAct1(ActionEvent e) {
        LOGGER.info(e);
        text1.setEditable(true);
        text2.setEditable(true);
        text3.setEditable(true);
        text4.setEditable(true);
        text5.setEditable(true);
        text6.setEditable(true);
        b1.setText("Apply!");

        fio = String.valueOf(text1.getText());
        log = String.valueOf(text2.getText());
        pass = String.valueOf(text3.getText());
        mail = String.valueOf(text4.getText());
        tel = String.valueOf(text5.getText());
        grp = String.valueOf(text6.getText());

        if (fio.isEmpty() || fio.length() < 5 || fio.equals(text1.getText())) {
            label.setForeground(Color.red);
            label.setText("Oopsss... Somesing went wrong...");
        } else {
            if (log.isEmpty() || log.length() < 5 || log.equals(text2.getText())) {
                label.setForeground(Color.red);
                label.setText("Oopsss... Somesing went wrong...");
            } else {
                if (pass.isEmpty() || pass.length() < 5 || pass.equals(text3.getText())) {
                    label.setForeground(Color.red);
                    label.setText("Oopsss... Somesing went wrong...");
                } else {
                    if (mail.isEmpty() || mail.length() < 5 || mail.equals(text4.getText())) {
                        label.setForeground(Color.red);
                        label.setText("Oopsss... Somesing went wrong...");
                    } else {
                        if (tel.isEmpty() || tel.length() < 13 || tel.equals(text5.getText())) {
                            label.setForeground(Color.red);
                            label.setText("Oopsss... Somesing went wrong...");
                        } else {
                            if (grp.isEmpty() || grp.length() < 5 || grp.equals(text6.getText())) {
                                label.setForeground(Color.red);
                                label.setText("Oopsss... Somesing went wrong...");
                            } else {
                                label.setText("Is OK! Update!");
                                text1.setEditable(false);
                                text2.setEditable(false);
                                text3.setEditable(false);
                                text4.setEditable(false);
                                text5.setEditable(false);
                                text6.setEditable(false);
                                b1.setText("Change!");
                            }
                        }
                    }
                }
            }
        }
    }

    private void btnAct2(ActionEvent e) {
        LOGGER.info(e);
    }

    private void btnAct3(ActionEvent e) {
        LOGGER.info(e);
    }

    private void btnAct4(ActionEvent e) {
        if (b1.getText().equals("Change!")) {
            LOGGER.info(e);
            new MainFrame().setVisible(true);
            this.dispose();
        }
    }

    private void btnAct5(ActionEvent e) {
        if (b1.getText().equals("Change!")) {
            LOGGER.info(e);
            new MainFrame().setVisible(true);
            this.dispose();
        }
    }

    private void btnAct6(ActionEvent e) {
        if (b1.getText().equals("Change!")) {
            LOGGER.info(e);
            new SDFrame().setVisible(true);
            this.dispose();
        }
    }

}
