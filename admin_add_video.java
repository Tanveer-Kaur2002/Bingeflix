
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author HP
 */
public class admin_add_video extends javax.swing.JFrame {

    File f1, f2;
    /**
     * Creates new form admin_add_video
     */

    ArrayList<videoClass> al;
    mytablemodel tm;

    public admin_add_video() {
        initComponents();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        al = new ArrayList<>();
        tm = new mytablemodel();
        getCategories();
        getVideos();
        table.setModel(tm);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lb1 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        cb1 = new javax.swing.JComboBox<>();
        cb2 = new javax.swing.JComboBox<>();
        lb4 = new javax.swing.JLabel();
        lb5 = new javax.swing.JLabel();
        lb6 = new javax.swing.JLabel();
        lb7 = new javax.swing.JLabel();
        lb8 = new javax.swing.JLabel();
        lb9 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        tf2 = new javax.swing.JTextField();
        lb10 = new javax.swing.JLabel();
        tf3 = new javax.swing.JTextField();
        bt1 = new javax.swing.JButton();
        bt3 = new javax.swing.JButton();
        bt2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lb1.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        lb1.setForeground(new java.awt.Color(255, 255, 255));
        lb1.setText("Add New Video");
        getContentPane().add(lb1);
        lb1.setBounds(590, 10, 350, 40);

        lb2.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lb2.setText("Select Category ");
        getContentPane().add(lb2);
        lb2.setBounds(150, 90, 130, 20);

        lb3.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lb3.setText("Select Movies");
        getContentPane().add(lb3);
        lb3.setBounds(150, 140, 120, 20);

        cb1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb1ItemStateChanged(evt);
            }
        });
        getContentPane().add(cb1);
        cb1.setBounds(320, 90, 650, 20);

        getContentPane().add(cb2);
        cb2.setBounds(320, 140, 650, 20);

        lb4.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lb4.setText("Enter Episode Number");
        getContentPane().add(lb4);
        lb4.setBounds(150, 190, 170, 20);

        lb5.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lb5.setText("Title");
        getContentPane().add(lb5);
        lb5.setBounds(150, 250, 130, 20);

        lb6.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lb6.setText("Duration");
        getContentPane().add(lb6);
        lb6.setBounds(150, 300, 100, 20);

        lb7.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lb7.setText("Thumbnail");
        getContentPane().add(lb7);
        lb7.setBounds(150, 360, 80, 20);

        lb8.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lb8.setText("Select Series");
        getContentPane().add(lb8);
        lb8.setBounds(150, 450, 110, 20);

        lb9.setText("jLabel10");
        getContentPane().add(lb9);
        lb9.setBounds(310, 430, 160, 60);
        getContentPane().add(tf1);
        tf1.setBounds(320, 190, 210, 20);
        getContentPane().add(tf2);
        tf2.setBounds(320, 250, 210, 20);

        lb10.setText("jLabel11");
        getContentPane().add(lb10);
        lb10.setBounds(320, 350, 130, 60);
        getContentPane().add(tf3);
        tf3.setBounds(320, 300, 210, 20);

        bt1.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        bt1.setText(" ADD VIDEO");
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt1);
        bt1.setBounds(380, 630, 170, 50);

        bt3.setFont(new java.awt.Font("Segoe UI Light", 1, 11)); // NOI18N
        bt3.setText("Browse");
        bt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt3ActionPerformed(evt);
            }
        });
        getContentPane().add(bt3);
        bt3.setBounds(500, 360, 80, 23);

        bt2.setFont(new java.awt.Font("Segoe UI Light", 1, 11)); // NOI18N
        bt2.setText("Browse");
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });
        getContentPane().add(bt2);
        bt2.setBounds(500, 440, 80, 23);

        table.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(table);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(660, 200, 490, 380);

        jButton1.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jButton1.setText("DELETE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(860, 630, 100, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hd.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1370, 770);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
        String cs = (String) cb1.getSelectedItem();
        String sm = (String) cb2.getSelectedItem();

        String en = tf1.getText();
        String tl = tf2.getText();
        String dt = tf3.getText();

        if (cs.isEmpty() || sm.isEmpty() || en.isEmpty() || tl.isEmpty() || dt.isEmpty() || f1 == null || f2 == null) {
            JOptionPane.showMessageDialog(this, "All fields are reqiured...");
        } else {
            try {
                HttpResponse<String> res = Unirest.post("http://localhost:9000/addvideos")
                        .queryString("category_select", cs)
                        .queryString("select_movie", sm)
                        .queryString("episode_number", en)
                        .queryString("title", tl)
                        .queryString("duration", dt)
                        .field("thumbnail", f1)
                        .field("video", f2)
                        .asString();
                if (res.getStatus() == 200) {
                    String ans = res.getBody();
                    System.out.println("-----------------" + ans);
                    if (ans.equals("success")) {
                        JOptionPane.showMessageDialog(this, "Video Added Successfully");
                        getVideos();
                        tm.fireTableDataChanged();

                    } else {
                        JOptionPane.showMessageDialog(this, "  An Error Occured...");
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }


    }//GEN-LAST:event_bt1ActionPerformed

    private void bt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt3ActionPerformed
        JFileChooser chooser = new JFileChooser();
        int ans = chooser.showOpenDialog(this);
        if (ans == JFileChooser.APPROVE_OPTION) {
            f1 = chooser.getSelectedFile();
        }
        ImageIcon icon = new ImageIcon(f1.getPath());
        Image img = icon.getImage().getScaledInstance(lb10.getWidth(), lb10.getHeight(), Image.SCALE_SMOOTH);
        lb10.setIcon(new ImageIcon(img));

    }//GEN-LAST:event_bt3ActionPerformed

    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2ActionPerformed
        JFileChooser chooser = new JFileChooser();
        int ans = chooser.showOpenDialog(this);
        if (ans == JFileChooser.APPROVE_OPTION) {
            f2 = chooser.getSelectedFile();
        }
        lb9.setText(f2.getPath());

    }//GEN-LAST:event_bt2ActionPerformed

    private void cb1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb1ItemStateChanged
        String cat = cb1.getSelectedItem().toString();
        try {
            HttpResponse<String> res = Unirest.get("http://localhost:9000/getMoviesFromCategory")
                    .queryString("cat", cat)
                    .asString();

            if (res.getStatus() == 200) {
                String ans = res.getBody();
                System.out.println("ans-----------------" + ans);
                StringTokenizer st = new StringTokenizer(ans, "#$#");
                cb2.removeAllItems();
                while (st.hasMoreTokens()) {
                    cb2.addItem(st.nextToken());
                }
            }
            tm.fireTableDataChanged();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cb1ItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int index = table.getSelectedRow();

        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Please Select a Row");
        } else {
            String video_id = al.get(index).video_id;
            try {
                HttpResponse<String> res = Unirest.get("http://localhost:9000/admindeletevideo")
                        .queryString("vidoe_id", video_id)
                        .asString();

                if (res.getStatus() == 200) {
                    String ans = res.getBody();
                    System.out.println("-----------------" + ans);
                    if (ans.equals("success")) {
                        JOptionPane.showMessageDialog(this, "Video Deleted Successfully");
                        getVideos();
                        tm.fireTableDataChanged();

                    } else {
                        JOptionPane.showMessageDialog(this, " Error Occurred");
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public void getVideos() {

        String cs = (String) cb1.getSelectedItem();
        String sm = (String) cb2.getSelectedItem();
        try {
            HttpResponse<String> res = Unirest.get("http://localhost:9000/getAllVideos")
                    .queryString("category_select", cs)
                    .queryString("select_movie", sm)
                    .asString();

            if (res.getStatus() == 200) {
                String ans = res.getBody();

                if (ans.equals("")) {
                  //  JOptionPane.showMessageDialog(this, "no videos yet!!");
                } else {

                    StringTokenizer st = new StringTokenizer(ans, "#$#");
                    // cb1.addItem("Select a Category");
                    while (st.hasMoreTokens()) {
                        String video = st.nextToken();
                        StringTokenizer st2 = new StringTokenizer(ans, "**");

                        al.add(new videoClass(st2.nextToken(), st2.nextToken(), st2.nextToken(), st2.nextToken(), st2.nextToken(), st2.nextToken(), st2.nextToken(), st2.nextToken()));

                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getCategories() {
        try {
            HttpResponse<String> res = Unirest.get("http://localhost:9000/getCategory")
                    .asString();

            if (res.getStatus() == 200) {
                String ans = res.getBody();
                StringTokenizer st = new StringTokenizer(ans, "**");
                // cb1.addItem("Select a Category");
                while (st.hasMoreTokens()) {
                    String c = st.nextToken();
                    cb1.addItem(c);
                    cb1.addItem(c);

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class mytablemodel extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return al.size();
        }

        @Override
        public int getColumnCount() {
            return 8;
        }

        @Override
        public String getColumnName(int j) {
            String c[] = {"video_id", "category ", "movie", "episode_number", "title", "duration", "thumbnail", "video"};
            return c[j];
        }

        @Override
        public Object getValueAt(int i, int j) {
            videoClass st = al.get(i);

            if (j == 0) {
                return st.video_id;
            } else if (j == 1) {
                return st.category;
            } else if (j == 2) {
                return st.movie;
            } else if (j == 3) {
                return st.episode_number;
            } else if (j == 4) {
                return st.title;
            } else if (j == 5) {
                return st.duration;
            } else if (j == 6) {
                return st.thumbnail;
            } else {
                return st.video;
            }
        }
    }

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
            java.util.logging.Logger.getLogger(admin_add_video.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin_add_video.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin_add_video.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin_add_video.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_add_video().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt1;
    private javax.swing.JButton bt2;
    private javax.swing.JButton bt3;
    private javax.swing.JComboBox<String> cb1;
    private javax.swing.JComboBox<String> cb2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb10;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb4;
    private javax.swing.JLabel lb5;
    private javax.swing.JLabel lb6;
    private javax.swing.JLabel lb7;
    private javax.swing.JLabel lb8;
    private javax.swing.JLabel lb9;
    private javax.swing.JTable table;
    private javax.swing.JTextField tf1;
    private javax.swing.JTextField tf2;
    private javax.swing.JTextField tf3;
    // End of variables declaration//GEN-END:variables
}
