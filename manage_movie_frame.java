
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

public class manage_movie_frame extends javax.swing.JFrame {

    ArrayList<MovieClass> al = new ArrayList<>();
    mytablemodel tm;

    /**
     * Creates new form manage_movie_frame
     */
    File f1, f2, f3;

    public manage_movie_frame() {

        initComponents();
        Dimension d = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
        setSize(d);
        getContentPane().setBackground(Color.WHITE);
        tf1.setText("");
        tf2.setText("");

        al = new ArrayList<>();
        tm = new mytablemodel();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        jTable1.setModel(tm);
        jTable1.getColumnModel().getColumn(3).setCellRenderer(new ImageRenderer());
        jTable1.getColumnModel().getColumn(4).setCellRenderer(new ImageRenderer1());

        jTable1.setRowHeight(50);
        getCategories();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lb1 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        lb4 = new javax.swing.JLabel();
        lb5 = new javax.swing.JLabel();
        lb6 = new javax.swing.JLabel();
        lb7 = new javax.swing.JLabel();
        lb8 = new javax.swing.JLabel();
        cb = new javax.swing.JComboBox<>();
        tf1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta = new javax.swing.JTextArea();
        lb9 = new javax.swing.JLabel();
        lb10 = new javax.swing.JLabel();
        lb11 = new javax.swing.JLabel();
        tf2 = new javax.swing.JTextField();
        bt1 = new javax.swing.JButton();
        bt2 = new javax.swing.JButton();
        bt3 = new javax.swing.JButton();
        bt4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        cb1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lb1.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        lb1.setForeground(new java.awt.Color(255, 255, 255));
        lb1.setText("ADD MOVIE HERE");
        getContentPane().add(lb1);
        lb1.setBounds(470, 40, 240, 26);

        lb2.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lb2.setText("CATEGORY");
        getContentPane().add(lb2);
        lb2.setBounds(150, 90, 100, 20);

        lb3.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lb3.setText("MOVIE");
        getContentPane().add(lb3);
        lb3.setBounds(150, 140, 130, 20);

        lb4.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lb4.setText("DESCRIPTION");
        getContentPane().add(lb4);
        lb4.setBounds(150, 180, 110, 30);

        lb5.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lb5.setText("SQUARE PHOTO");
        getContentPane().add(lb5);
        lb5.setBounds(150, 270, 140, 20);

        lb6.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lb6.setText("WIDE PHOTO");
        getContentPane().add(lb6);
        lb6.setBounds(150, 360, 120, 20);

        lb7.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lb7.setText("VIDEO");
        getContentPane().add(lb7);
        lb7.setBounds(150, 470, 90, 20);

        lb8.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lb8.setText("AMOUNT");
        getContentPane().add(lb8);
        lb8.setBounds(150, 600, 120, 14);

        cb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbItemStateChanged(evt);
            }
        });
        cb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbActionPerformed(evt);
            }
        });
        getContentPane().add(cb);
        cb.setBounds(640, 90, 430, 20);

        tf1.setText("jTextField1");
        tf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf1ActionPerformed(evt);
            }
        });
        getContentPane().add(tf1);
        tf1.setBounds(250, 140, 260, 20);

        ta.setColumns(20);
        ta.setRows(5);
        jScrollPane1.setViewportView(ta);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(250, 190, 230, 60);

        lb9.setText("jLabel9");
        getContentPane().add(lb9);
        lb9.setBounds(260, 280, 210, 60);

        lb10.setText("jLabel10");
        getContentPane().add(lb10);
        lb10.setBounds(270, 370, 220, 70);

        lb11.setText("jLabel11");
        getContentPane().add(lb11);
        lb11.setBounds(260, 470, 210, 80);

        tf2.setText("jTextField2");
        getContentPane().add(tf2);
        tf2.setBounds(270, 600, 260, 20);

        bt1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt1.setText("Browse");
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt1);
        bt1.setBounds(150, 320, 90, 23);

        bt2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt2.setText("Browse");
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });
        getContentPane().add(bt2);
        bt2.setBounds(150, 410, 100, 23);

        bt3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt3.setText("Browse");
        bt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt3ActionPerformed(evt);
            }
        });
        getContentPane().add(bt3);
        bt3.setBounds(150, 530, 100, 23);

        bt4.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        bt4.setText("ADD MOVIE");
        bt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt4ActionPerformed(evt);
            }
        });
        getContentPane().add(bt4);
        bt4.setBounds(280, 650, 210, 50);

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

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
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(600, 210, 590, 360);

        cb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb1ActionPerformed(evt);
            }
        });
        getContentPane().add(cb1);
        cb1.setBounds(250, 90, 260, 20);

        jButton1.setText("DELETE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(780, 610, 90, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hd.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1370, 770);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    class mytablemodel extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return al.size();
        }

        @Override
        public int getColumnCount() {
            return 7;
        }

        @Override
        public String getColumnName(int j) {
            String c[] = {"category", "movie_name", "description", "square_photo", "wide_photo", "sample_video", "amount"};
            return c[j];
        }

        @Override
        public Object getValueAt(int i, int j) {
            MovieClass st = al.get(i);

            if (j == 0) {
                return st.movieid;
            } else if (j == 1) {
                return st.movie_name;
            } else if (j == 2) {
                return st.description;
            } else if (j == 3) {
                return st.square_photo;
            } else if (j == 4) {
                return st.wide_photo;
            } else if (j == 5) {
                return st.sample_photo1;
            } else {
                return st.amount1;
            }
        }

    }

    class ImageRenderer extends DefaultTableCellRenderer {

        JLabel lbl = new JLabel();

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {

            try {
                URL url = new URL("http://localhost:9000/getresource/" + al.get(row).square_photo);
                BufferedImage img = ImageIO.read(url);
                Image newimg = img.getScaledInstance(80, 50, Image.SCALE_SMOOTH);
                lbl.setIcon(new ImageIcon(newimg));

            } catch (Exception ex) {
                ex.printStackTrace();
            }

            return lbl;

        }

    }

    class ImageRenderer1 extends DefaultTableCellRenderer {

        JLabel lbl = new JLabel();

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {

            try {
                URL url = new URL("http://localhost:9000/getresource/" + al.get(row).wide_photo);
                BufferedImage img = ImageIO.read(url);
                Image newimg = img.getScaledInstance(80, 50, Image.SCALE_SMOOTH);
                lbl.setIcon(new ImageIcon(newimg));

            } catch (Exception ex) {
                ex.printStackTrace();
            }

            return lbl;

        }

    }


    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
        JFileChooser chooser = new JFileChooser();
        int ans = chooser.showOpenDialog(this);
        if (ans == JFileChooser.APPROVE_OPTION) {
            f1 = chooser.getSelectedFile();
        }
        ImageIcon icon = new ImageIcon(f1.getPath());
        Image img = icon.getImage().getScaledInstance(lb9.getWidth(), lb9.getHeight(), Image.SCALE_SMOOTH);
        lb9.setIcon(new ImageIcon(img));

    }//GEN-LAST:event_bt1ActionPerformed

    private void bt4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt4ActionPerformed
        //get all data
        String cat = cb1.getSelectedItem().toString();
        String mn = tf1.getText();
        String desc = ta.getText();
        String amt = tf2.getText();
        if (cat.isEmpty() || mn.isEmpty() || desc.isEmpty() || f1 == null || f2 == null || f3 == null || amt.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are reqiured...");
        } else {
            try {
                HttpResponse<String> res = Unirest.post("http://localhost:9000/addmovie")
                        .queryString("category", cat)
                        .queryString("movie_name", mn)
                        .queryString("description", desc)
                        .queryString("amount", amt)
                        .field("square_photo", f1)
                        .field("wide_photo", f2)
                        .field("sample_video", f3)
                        .asString();
                if (res.getStatus() == 200) {
                    String ans = res.getBody();
                    System.out.println("-----------------" + ans);
                    if (ans.equals("success")) {
                        JOptionPane.showMessageDialog(this, "Movie Added Successfully");
                        getCategories();
                    } else {
                        JOptionPane.showMessageDialog(this, "Movie Already Exists...");
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_bt4ActionPerformed

    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2ActionPerformed
        JFileChooser chooser = new JFileChooser();
        int ans = chooser.showOpenDialog(this);
        if (ans == JFileChooser.APPROVE_OPTION) {
            f2 = chooser.getSelectedFile();
        }
        ImageIcon icon = new ImageIcon(f2.getPath());
        Image img = icon.getImage().getScaledInstance(lb10.getWidth(), lb10.getHeight(), Image.SCALE_SMOOTH);
        lb10.setIcon(new ImageIcon(img));
    }//GEN-LAST:event_bt2ActionPerformed

    private void bt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt3ActionPerformed
        JFileChooser chooser = new JFileChooser();
        int ans = chooser.showOpenDialog(this);
        if (ans == JFileChooser.APPROVE_OPTION) {
            f3 = chooser.getSelectedFile();
        }
        lb11.setText(f3.getPath());
    }//GEN-LAST:event_bt3ActionPerformed

    private void cbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbItemStateChanged
        String cat = cb.getSelectedItem().toString();
        if (!cat.equals("Select a Category")) {
            getMovies(cat);
        }
    }//GEN-LAST:event_cbItemStateChanged

    private void cb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb1ActionPerformed

    private void cbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbActionPerformed

    private void tf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int index = jTable1.getSelectedRow();

        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Please Select a Row");
        } else {
            String movieID = al.get(index).movieid;
            try {
                HttpResponse<String> res = Unirest.get("http://localhost:9000/admindeletemovie")
                        .queryString("movieId", movieID)
                        .asString();

                if (res.getStatus() == 200) {
                    String ans = res.getBody();
                    System.out.println("-----------------" + ans);
                    if (ans.equals("success")) {
                        JOptionPane.showMessageDialog(this, "Movie Deleted Successfully");
                        String cat = cb.getSelectedItem().toString();
                        if (!cat.equals("Select a Category")) {
                            getMovies(cat);
                        }
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

    /**
     * @param args the command line arguments
     */
    public void getMovies(String cat) {
        //send Unirest get request on server and fetch all categories  from database
        try {
            HttpResponse<String> res = Unirest.get("http://localhost:9000/getAllMovies")
                    .queryString("cat", cat)
                    .asString();

            if (res.getStatus() == 200) {
                String ans = res.getBody();
                System.out.println("ans-----------------" + ans);
                StringTokenizer st = new StringTokenizer(ans, "#$#");
                al.clear();
                while (st.hasMoreTokens()) {
                    String movieDetails = st.nextToken();
                    System.out.println("categoryDetails   " + movieDetails);
                    StringTokenizer st2 = new StringTokenizer(movieDetails, "**");
                    String movieid = st2.nextToken();
                    String movieName = st2.nextToken();
                    String description = st2.nextToken();
                    String squarePhoto = st2.nextToken();
                    String wide_photo = st2.nextToken();
                    String sample_video = st2.nextToken();
                    String amount = st2.nextToken();
                    MovieClass obj = new MovieClass(movieid, description, squarePhoto, wide_photo, sample_video, amount, movieName);
                    al.add(obj);
                }
            }
            tm.fireTableDataChanged();

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
                cb.addItem("Select a Category");
                while (st.hasMoreTokens()) {
                    String c = st.nextToken();
                    cb1.addItem(c);
                    cb.addItem(c);

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new manage_movie_frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt1;
    private javax.swing.JButton bt2;
    private javax.swing.JButton bt3;
    private javax.swing.JButton bt4;
    private javax.swing.JComboBox<String> cb;
    private javax.swing.JComboBox<String> cb1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb10;
    private javax.swing.JLabel lb11;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb4;
    private javax.swing.JLabel lb5;
    private javax.swing.JLabel lb6;
    private javax.swing.JLabel lb7;
    private javax.swing.JLabel lb8;
    private javax.swing.JLabel lb9;
    private javax.swing.JTextArea ta;
    private javax.swing.JTextField tf1;
    private javax.swing.JTextField tf2;
    // End of variables declaration//GEN-END:variables
}
