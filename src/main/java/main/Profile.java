package main;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

public class Profile extends javax.swing.JFrame {

    private static final Logger LOGGER = Logger.getLogger(Profile.class);
    private final String status = "Стан виконання: ";

    public Profile() {
        initComponents();

        Object[][] data = new String[][]{{"1", "Афанасенко", "123", "i@i"},
        {"2", "Богданов", "123", "i@i"},
        {"3", "Зленко", "123", "i@i"},
        {"4", "Іпатов", "123", "i@i"}};
        Object[] columns = new String[]{"№ п/п", "П. І. Б.", "Телефон батьків", "Пошта батьків"};

        DefaultTableModel model = new DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return true;
            }
        };
        jTable1.setModel(model);
        jTable1.setRowHeight(20);

        jButton1.addActionListener((var e) -> {
            int gsr = jTable1.getSelectedRow();
            model.insertRow(gsr + 1, new String[]{"№ п/п", "П. І. Б.", "Телефон батьків", "Пошта батьків"});
            jLabel1.setText("Додано рядок");
            LOGGER.info("Додано рядок" + e);
        });

        jButton2.addActionListener((var e) -> {
            int gsr = jTable1.getSelectedRow();
            model.removeRow(gsr);
            jLabel1.setText("Видалено рядок");
            LOGGER.info("Видалено рядок" + e);
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Куратор групи");

        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("Група");

        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("Робоча пошта");

        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setText("Пароль до пошти");

        jButton1.setText("Додати рядок");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Видалити рядок");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("! ЗБЕРЕГТИ !");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Стан виконання:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(jTextField1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField4)
                            .addComponent(jTextField3)))
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String curatorGroup = String.valueOf(jTextField1.getText());
        String group = String.valueOf(jTextField2.getText());
        String mail = String.valueOf(jTextField3.getText());
        String passMail = String.valueOf(jTextField4.getText());

        if (curatorGroup.isEmpty() || curatorGroup.length() < 6) {
            jTextField1.setForeground(Color.red);
            jLabel1.setForeground(Color.red);
            jLabel1.setText(status + "Увага!");
            LOGGER.info("Увага!" + evt);
        } else {
            if (group.isEmpty() || group.length() < 5) {
                jTextField2.setForeground(Color.red);
                jLabel1.setForeground(Color.red);
                jLabel1.setText(status + "Увага!");
                LOGGER.info("Увага!" + evt);
            } else {
                if (mail.isEmpty() || mail.length() < 10) {
                    jTextField3.setForeground(Color.red);
                    jLabel1.setForeground(Color.red);
                    jLabel1.setText(status + "Увага!");
                    LOGGER.info("Увага!" + evt);
                } else {
                    if (passMail.isEmpty() || passMail.length() < 10) {
                        jTextField4.setForeground(Color.red);
                        jLabel1.setForeground(Color.red);
                        jLabel1.setText(status + "Увага!");
                        LOGGER.info("Увага!" + evt);
                    } else {
                        String nullRow;
                        boolean isTrueNull = false;
                        for (int i = 0; i < jTable1.getRowCount(); i++) {
                            for (int j = 2; j < jTable1.getColumnCount() && j < jTable1.getColumnCount() - 1; j++) {
                                nullRow = (String) jTable1.getValueAt(i, j);
                                if (nullRow.equals("") || nullRow.isEmpty()) {
                                    isTrueNull = true;
                                    break;
                                }
                            }
                        }
                        if (isTrueNull == true) {
                            jLabel1.setForeground(Color.red);
                            jLabel1.setText(status + "Увага!");
                            LOGGER.info("Увага!" + evt);
                        } else {
                            try {
                                BufferedWriter writer = new BufferedWriter(new FileWriter(new File("C://Users//gmill//Pictures//notes.txt")));
                                writer.write("Куратор групи: " + curatorGroup);
                                writer.newLine();
                                writer.write("Група: " + group);
                                writer.newLine();
                                writer.write("Пошта: " + mail);
                                writer.newLine();
                                writer.write("Пароль: " + passMail);
                                writer.newLine();
                                for (int i = 0; i < jTable1.getRowCount(); i++) {
                                    writer.newLine();
                                    for (int j = 0; j < jTable1.getColumnCount(); j++) {
                                        writer.write((jTable1.getValueAt(i, j).toString()));
                                        writer.write("\t");
                                    }
                                }
                                writer.flush();
                                jLabel1.setText(status + "Файл записано успішно!");
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
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
