
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.GetRequest;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.security.interfaces.RSAKey;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.*;

public class manage_category_frame extends javax.swing.JFrame {

    File f;
    ArrayList<CategoryClass> al;
    mytablemodel tm;

    public manage_category_frame() {
        initComponents();
        Dimension d = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
        setSize(d);
        getContentPane().setBackground(Color.WHITE);
        tm = new mytablemodel();
        System.out.println(d);
        al = new ArrayList<>();
        setVisible(true);
//        setSize(1000, 550);
        setLocationRelativeTo(null);
        loadCategories();
       // jScrollPane2.setBounds(600,100,400,500);
        jTable1.setModel(tm);
        jTable1.getColumnModel().getColumn(2).setCellRenderer(new ImageRenderer());
        jTable1.setRowHeight(50);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb1 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        lb4 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta = new javax.swing.JTextArea();
        bt1 = new javax.swing.JButton();
        bt2 = new javax.swing.JButton();
        jphotolb = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().setLayout(null);

        lb1.setBackground(new java.awt.Color(255, 255, 255));
        lb1.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        lb1.setForeground(new java.awt.Color(255, 255, 255));
        lb1.setText("ADD CATEGORY");
        getContentPane().add(lb1);
        lb1.setBounds(510, 20, 470, 50);

        lb2.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        lb2.setText("Category Name");
        getContentPane().add(lb2);
        lb2.setBounds(150, 160, 200, 25);

        lb3.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        lb3.setText("Description");
        getContentPane().add(lb3);
        lb3.setBounds(150, 300, 120, 25);

        lb4.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        lb4.setText("Photo");
        getContentPane().add(lb4);
        lb4.setBounds(160, 410, 70, 25);

        tf1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf1ActionPerformed(evt);
            }
        });
        getContentPane().add(tf1);
        tf1.setBounds(300, 160, 230, 30);

        ta.setColumns(20);
        ta.setRows(5);
        ta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.setViewportView(ta);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(290, 290, 230, 50);

        bt1.setText("Browse");
        bt1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt1);
        bt1.setBounds(250, 510, 80, 20);

        bt2.setBackground(new java.awt.Color(255, 255, 255));
        bt2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        bt2.setText("ADD CATEGORY");
        bt2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });
        getContentPane().add(bt2);
        bt2.setBounds(290, 560, 210, 40);

        jphotolb.setBackground(new java.awt.Color(255, 255, 204));
        getContentPane().add(jphotolb);
        jphotolb.setBounds(300, 400, 220, 90);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jButton1.setText("Delete");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(870, 560, 90, 40);

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\OneDrive\\Pictures\\b1.jpg")); // NOI18N
        jLabel4.setText("jLabel4");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel4);
        jLabel4.setBounds(220, 510, 30, 20);

        jTable1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Category Name", "Description", "Photo"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(51, 51, 51));
        jScrollPane3.setViewportView(jTable1);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(660, 140, 490, 390);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hd.jpg"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 1370, 770);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2ActionPerformed
        String cn = tf1.getText();

        String des = ta.getText();

        if (cn.isEmpty() || des.isEmpty() || f == null) {
            JOptionPane.showMessageDialog(this, "All fields are reqiured...");
        } else {
            try {
                HttpResponse<String> res = Unirest.post("http://localhost:9000/admin_add_category")
                        .queryString("category_name", cn)
                        .queryString("description", des)
                        .field("photo", f)
                        .asString();
                if (res.getStatus() == 200) {
                    String ans = res.getBody();
                    System.out.println("-----------------" + ans);
                    if (ans.equals("success")) {
                        JOptionPane.showMessageDialog(this, "Category Added Successfully");
                        loadCategories();
                    } else {
                        JOptionPane.showMessageDialog(this, "Category Already Exists...");
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }


    }//GEN-LAST:event_bt2ActionPerformed

    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
        //chooser code will go here 
        JFileChooser chooser = new JFileChooser();
        int ans = chooser.showOpenDialog(this);
        if (ans == JFileChooser.APPROVE_OPTION) {
            f = chooser.getSelectedFile();
        }
        ImageIcon icon = new ImageIcon(f.getPath());
        Image img = icon.getImage().getScaledInstance(jphotolb.getWidth(), jphotolb.getHeight(), Image.SCALE_SMOOTH);
        jphotolb.setIcon(new ImageIcon(img));

    }//GEN-LAST:event_bt1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int index = jTable1.getSelectedRow();
        {
            if (index == -1) {
                JOptionPane.showMessageDialog(this, "Please Select a Row");
            } else {
                String category_name = al.get(index).category_name;
                try {
                    HttpResponse<String> res = Unirest.get("http://localhost:9000/admindeletecategory")
                            .queryString("catname", category_name)
                            .asString();

                    if (res.getStatus() == 200) {
                        String ans = res.getBody();
                        System.out.println("-----------------" + ans);
                        if (ans.equals("success")) {
                            JOptionPane.showMessageDialog(this, "Category Deleted Successfully");
                            loadCategories();

                        } else {
                            JOptionPane.showMessageDialog(this, " Error Occurred");
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void tf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf1ActionPerformed
    public void loadCategories() {
        String ans = " ";
        try {
            HttpResponse<String> res = Unirest.get("http://localhost:9000/getAllCategories")
                    .asString();

            if (res.getStatus() == 200) {
                String ans2 = res.getBody();
                System.out.println("-----------------" + ans2);
                StringTokenizer st = new StringTokenizer(ans2, "#$#");
                al.clear();
                while (st.hasMoreTokens()) {
                    String catDetails = st.nextToken();
                    System.out.println("categoryDetails   " + catDetails);
                    StringTokenizer st2 = new StringTokenizer(catDetails, "**");
                    String catName = st2.nextToken();
                    String desc = st2.nextToken();
                    String photo = st2.nextToken();
                    CategoryClass obj = new CategoryClass(catName, desc, photo);
                    al.add(obj);

                }
                tm.fireTableDataChanged();

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    class mytablemodel extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return al.size();
        }

        @Override
        public int getColumnCount() {
            return 3;
        }

        @Override
        public String getColumnName(int j) {
            String c[] = {"category_name", "description", "photo"};
            return c[j];
        }

        @Override
        public Object getValueAt(int i, int j) {
            CategoryClass st = al.get(i);

            if (j == 0) {
                return st.category_name;
            } else if (j == 1) {
                return st.description;
            } else {
                return st.photo;
            }
        }

    }

    class ImageRenderer extends DefaultTableCellRenderer {

        JLabel lbl = new JLabel();

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {

            try {
                URL url = new URL("http://localhost:9000/getresource/" + al.get(row).photo);
                BufferedImage img = ImageIO.read(url);
                Image newimg = img.getScaledInstance(80, 50, Image.SCALE_SMOOTH);
                lbl.setIcon(new ImageIcon(newimg));

            } catch (Exception ex) {
                ex.printStackTrace();
            }

            return lbl;

        }

    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new manage_category_frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt1;
    private javax.swing.JButton bt2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jphotolb;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb4;
    private javax.swing.JTextArea ta;
    private javax.swing.JTextField tf1;
    // End of variables declaration//GEN-END:variables
}
