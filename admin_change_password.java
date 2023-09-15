
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;


public class admin_change_password extends javax.swing.JFrame {

    
    public admin_change_password(String user) {
        initComponents();
        Dimension d = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
        setSize(d);
        getContentPane().setBackground(Color.WHITE);
        jp1.setText("");
        jp2.setText("");
        jp3.setText("");
        
        tf.setEditable(false);
        
        tf.setText(user);
        
        
        setSize(800,800);
        setVisible(true);
         setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb1 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        lb4 = new javax.swing.JLabel();
        tf = new javax.swing.JTextField();
        jp1 = new javax.swing.JPasswordField();
        jp2 = new javax.swing.JPasswordField();
        jp3 = new javax.swing.JPasswordField();
        bt = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(null);

        lb1.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        lb1.setText("USERNAME");
        getContentPane().add(lb1);
        lb1.setBounds(240, 170, 90, 16);

        lb2.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        lb2.setText("OLD PASSWORD");
        getContentPane().add(lb2);
        lb2.setBounds(240, 220, 160, 16);

        lb3.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        lb3.setText("NEW PASSWORD");
        getContentPane().add(lb3);
        lb3.setBounds(240, 270, 170, 16);

        lb4.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        lb4.setText("CONFIRM PASSWORD");
        getContentPane().add(lb4);
        lb4.setBounds(240, 320, 190, 16);

        tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfActionPerformed(evt);
            }
        });
        getContentPane().add(tf);
        tf.setBounds(270, 190, 230, 20);
        getContentPane().add(jp1);
        jp1.setBounds(270, 240, 230, 20);

        jp2.setText("jPasswordField2");
        getContentPane().add(jp2);
        jp2.setBounds(270, 290, 230, 20);

        jp3.setText("jPasswordField3");
        getContentPane().add(jp3);
        jp3.setBounds(270, 340, 230, 20);

        bt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bt.setText("CHANGE PASSWORD");
        bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActionPerformed(evt);
            }
        });
        getContentPane().add(bt);
        bt.setBounds(380, 380, 170, 25);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/t2.png"))); // NOI18N
        jLabel4.setText("jLabel2");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(240, 190, 30, 20);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/t2.png"))); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(237, 240, 30, 20);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/t2.png"))); // NOI18N
        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(240, 290, 30, 20);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/t2.png"))); // NOI18N
        jLabel7.setText("jLabel7");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(240, 340, 30, 20);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/k1.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(110, 140, 40, 40);

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel3.setText("SET PASSWORD");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(150, 150, 200, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cmptr screen.png"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(640, 500));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(60, -30, 650, 670);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActionPerformed

        String op = jp1.getText();

        String np = jp2.getText();
        String cp = jp3.getText();
        String u = tf.getText();

        if (op.isEmpty() || np.isEmpty() || cp.isEmpty() || u.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are reqiured...");
        } else if (!np.equals(cp)) {
            JOptionPane.showMessageDialog(this, "New Password and Confirm Password must match...");
        } else {
            try {
                HttpResponse<String> res = Unirest.get("http://localhost:9000/admin_change_password")
                        .queryString("old_password", op)
                        .queryString("new_password", np)
                        .queryString("username", u)
                        .asString();

                if (res.getStatus() == 200) {
                    String ans = res.getBody();
                    System.out.println("-----------------" + ans);
                    if (ans.equals("success")) {
                        JOptionPane.showMessageDialog(this, "Password changed successfully");
                        dispose();
                        admin_home obj = new admin_home(u);
                    } else {
                        JOptionPane.showMessageDialog(this, " Old password is incorrect");
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btActionPerformed

    private void tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(admin_change_password.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin_change_password.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin_change_password.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin_change_password.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_change_password("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField jp1;
    private javax.swing.JPasswordField jp2;
    private javax.swing.JPasswordField jp3;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb4;
    private javax.swing.JTextField tf;
    // End of variables declaration//GEN-END:variables
}
