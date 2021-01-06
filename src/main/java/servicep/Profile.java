package servicep;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

public class Profile extends javax.swing.JFrame {

    private static final Logger LOGGER = Logger.getLogger(Profile.class);
    private JButton button1, button2, button3;
    private JLabel label1;
    private JPanel panel;
    private JScrollPane scrollPane;
    private JTable table;
    private JTextField text1, text2, text3, text4;
    private DefaultTableModel model;

    private final String status = "Стан виконання: ";

    public Profile() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        panel = new JPanel();
        text1 = new JTextField("Куратор групи");
        text2 = new JTextField("Група");
        text3 = new JTextField("Робоча пошта");
        text4 = new JTextField("Пароль до пошти");
        button1 = new JButton("Додати рядок");
        button2 = new JButton("Видалити рядок");
        button3 = new JButton("! ЗБЕРЕГТИ !");
        scrollPane = new JScrollPane();
        table = new JTable();
        label1 = new JLabel(status);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        text1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        text2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        text3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        text4.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        button1.addActionListener((java.awt.event.ActionEvent evt) -> {
            jButton1ActionPerformed(evt);
        });

        button2.addActionListener((java.awt.event.ActionEvent evt) -> {
            jButton2ActionPerformed(evt);
        });

        Object[][] data = new String[][]{{"1", "Афанасенко", "123", "i@i"},
        {"2", "Богданов", "123", "i@i"},
        {"3", "Зленко", "123", "i@i"},
        {"4", "Іпатов", "123", "i@i"}};
        Object[] columns = new String[]{"№ п/п", "П. І. Б.", "Телефон батьків", "Пошта батьків"};

        model = new DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return true;
            }
        };

        table.setModel(model);
        table.setRowHeight(20);
        scrollPane.setViewportView(table);

        button3.setFont(new java.awt.Font("Tahoma", 1, 12));
        button3.addActionListener((java.awt.event.ActionEvent evt) -> {
            jButton3ActionPerformed(evt);
        });

        label1.setFont(new java.awt.Font("Tahoma", 1, 12));
        label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(panel);
        panel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                                                .addComponent(text1))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(text2, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                                                .addComponent(button2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(text4)
                                                .addComponent(text3)))
                                .addComponent(button3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(text1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(text2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(text3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(text4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(label1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(button1)
                                .addComponent(button2))
                        .addGap(18, 18, 18)
                        .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(button3)
                        .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        String curatorGroup = String.valueOf(text1.getText());
        String group = String.valueOf(text2.getText());
        String mail = String.valueOf(text3.getText());
        String passMail = String.valueOf(text4.getText());

        if (curatorGroup.isEmpty() || curatorGroup.length() < 6) {
            text1.setForeground(Color.red);
            label1.setForeground(Color.red);
            label1.setText(status + "Увага!");
            LOGGER.info("Увага!" + evt);
        } else {
            if (group.isEmpty() || group.length() < 5) {
                text2.setForeground(Color.red);
                label1.setForeground(Color.red);
                label1.setText(status + "Увага!");
                LOGGER.info("Увага!" + evt);
            } else {
                if (mail.isEmpty() || mail.length() < 10) {
                    text3.setForeground(Color.red);
                    label1.setForeground(Color.red);
                    label1.setText(status + "Увага!");
                    LOGGER.info("Увага!" + evt);
                } else {
                    if (passMail.isEmpty() || passMail.length() < 10) {
                        text4.setForeground(Color.red);
                        label1.setForeground(Color.red);
                        label1.setText(status + "Увага!");
                        LOGGER.info("Увага!" + evt);
                    } else {
                        String nullRow;
                        boolean isTrueNull = false;
                        for (int i = 0; i < table.getRowCount(); i++) {
                            for (int j = 2; j < table.getColumnCount() && j < table.getColumnCount() - 1; j++) {
                                nullRow = (String) table.getValueAt(i, j);
                                if (nullRow.equals("") || nullRow.isEmpty()) {
                                    isTrueNull = true;
                                    break;
                                }
                            }
                        }
                        if (isTrueNull == true) {
                            label1.setForeground(Color.red);
                            label1.setText(status + "Увага!");
                            LOGGER.info("Увага!" + evt);
                        } else {
                            try {
                                // "C://Users//ivans//Music//notes.txt"
                                // "C://Users//gmill//Pictures//notes.txt"
                                BufferedWriter writer = new BufferedWriter(new FileWriter(new File("C://Users//ivans//Music//notes.txt")));
                                writer.write("Куратор групи: " + curatorGroup);
                                writer.newLine();
                                writer.write("Група: " + group);
                                writer.newLine();
                                writer.write("Пошта: " + mail);
                                writer.newLine();
                                writer.write("Пароль: " + passMail);
                                writer.newLine();
                                for (int i = 0; i < table.getRowCount(); i++) {
                                    writer.newLine();
                                    for (int j = 1; j < table.getColumnCount(); j++) {
                                        writer.write((table.getValueAt(i, j).toString()));
                                        writer.write("\t");
                                    }
                                }
                                writer.flush();
                                label1.setText(status + "Файл записано успішно!");
                                LOGGER.info("Файл записано успішно!");
                            } catch (IOException ex) {
                                LOGGER.info(ex);
                            }
                            this.dispose();
                        }
                    }
                }
            }
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        int gsr = table.getSelectedRow();
        model.insertRow(gsr + 1, new String[]{"№ п/п", "П. І. Б.", "Телефон батьків", "Пошта батьків"});
        label1.setText("Додано рядок");
        LOGGER.info("Додано рядок" + evt);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        int gsr = table.getSelectedRow();
        model.removeRow(gsr);
        label1.setText("Видалено рядок");
        LOGGER.info("Видалено рядок" + evt);
    }

}
