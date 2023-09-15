
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.StringTokenizer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author HP
 */
public class UserMovieDetailFrame extends javax.swing.JFrame {

    /**
     * Creates new form UserMovieDetailFrame
     */
    public static String moviename = "";
    String cat = "";
    public static String user = GlobalClass.username;
    static boolean status = false;
    Dimension d;

    public UserMovieDetailFrame(String moviename, String cat) {
        initComponents();
        this.moviename = moviename;
        this.cat = cat;
        d = Toolkit.getDefaultToolkit().getScreenSize();

        jmovie.setText(moviename);
        getMovieDetail();
        setSize(d.getSize());
        checkSubscription();
        getVideos();
        jLabel1.setSize(d.width - 60, 200);
       // jLabel1.setBounds(d.width / 2, 0, d.width / 2, d.height);
        jPanel3.setBounds(20, 210, d.width - 60, 200);
        jScrollPane1.setBounds(20, 420, d.width - 60, d.height - 480);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jphoto = new javax.swing.JLabel();
        jmovie = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jdesc = new javax.swing.JTextArea();
        bt1 = new javax.swing.JButton();
        bt2 = new javax.swing.JButton();
        jamount = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 20, 580, 200);

        mainPanel.setBackground(new java.awt.Color(153, 255, 204));
        mainPanel.setLayout(null);
        jScrollPane1.setViewportView(mainPanel);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 310, 560, 220);

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setLayout(null);

        jphoto.setText("jLabel2");
        jPanel3.add(jphoto);
        jphoto.setBounds(20, 40, 80, 80);

        jmovie.setText("jLabel3");
        jPanel3.add(jmovie);
        jmovie.setBounds(110, 6, 380, 30);

        jdesc.setColumns(20);
        jdesc.setRows(5);
        jScrollPane2.setViewportView(jdesc);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(120, 40, 160, 60);

        bt1.setText("Play");
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        jPanel3.add(bt1);
        bt1.setBounds(100, 120, 80, 23);

        bt2.setText("Buy");
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });
        jPanel3.add(bt2);
        bt2.setBounds(231, 120, 80, 23);

        jamount.setText("jLabel2");
        jPanel3.add(jamount);
        jamount.setBounds(350, 60, 120, 40);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(30, 140, 530, 150);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void getMovieDetail() {
        try {
            HttpResponse<String> res = Unirest.get("http://localhost:9000/getMovieDetail")
                    .queryString("moviename", moviename)
                    .asString();
            if (res.getStatus() == 200) {
                String ans = res.getBody();
                if (ans.equals("fails")) {
                    System.out.println("fails");
                } else {
                    StringTokenizer st = new StringTokenizer(ans, "~~");
                    String description = st.nextToken();
                    String square_photo = st.nextToken();
                    String wide_photo = st.nextToken();
                    String amount = st.nextToken();
                    jdesc.setText(description);
                    jamount.setText("Rs." + amount);
                    URL url = new URL("http://localhost:9000/getresource/" + wide_photo);
                    BufferedImage img = ImageIO.read(url);
                    Image newimg = img.getScaledInstance(d.width - 60, jLabel1.getHeight(), Image.SCALE_SMOOTH);
                    jLabel1.setIcon(new ImageIcon(newimg));

                    URL url2 = new URL("http://localhost:9000/getresource/" + square_photo);
                    BufferedImage img2 = ImageIO.read(url2);
                    Image newimg2 = img2.getScaledInstance(jphoto.getWidth(), jphoto.getHeight(), Image.SCALE_SMOOTH);
                    jphoto.setIcon(new ImageIcon(newimg2));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void checkSubscription() {
        try {
            HttpResponse<String> res = Unirest.get("http://localhost:9000/check_subscription")
                    .queryString("username", user)
                    .queryString("movie", moviename)
                    .asString();
            if (res.getStatus() == 200) {
                String ans = res.getBody();
                if (ans.equals("success")) {
                    status = true;

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    HttpResponse httpresponse = Unirest.get("http://localhost:9000/getsamplevideo")
                            .queryString("movie", moviename)
                            .asString();
                    if (httpresponse.getStatus() == 200) {
                        System.out.println("course sample video");
                        String svideo = httpresponse.getBody().toString();
                        System.out.println(svideo);
                        //   String name=svideo.substring((svideo.lastIndexOf("/")+1));
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                JavaFXMediaPlayerFrame obj = new JavaFXMediaPlayerFrame(svideo);
                            }
                        }).start();
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        }).start();


    }//GEN-LAST:event_bt1ActionPerformed

    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2ActionPerformed

        //payment gateway
        vmm1 obj = new vmm1();

        checkSubscription();
        getVideos();

    }//GEN-LAST:event_bt2ActionPerformed

    public void getVideos() {

        new Thread(new Runnable() {
            @Override
            public void run() {

                //your logic goes here 
                try {
                    HttpResponse<String> res = Unirest.get("http://localhost:9000/getAllVideos")
                            .queryString("category_select", cat)
                            .queryString("select_movie", moviename)
                            .asString();

                    if (res.getStatus() == 200) {
                        String ans = res.getBody();

                        if (ans.equals("")) {
                            JOptionPane.showMessageDialog(rootPane, "no videos yet!!");
                        } else {

                            StringTokenizer st = new StringTokenizer(ans, "#$#");

                            int count = st.countTokens();
                            video_panel obj[] = new video_panel[count];
                            int i = 0;
                            int x = 20, y = 20;

                            mainPanel.setPreferredSize(new Dimension(count * 450, 400));

                            // cb1.addItem("Select a Category");
                            while (st.hasMoreTokens()) {
                                obj[i] = new video_panel();

                                String video = st.nextToken();
                                System.out.println("video           " + video);
                                StringTokenizer st2 = new StringTokenizer(video, "**");
                                //getdata 
                                String id = st2.nextToken();
                                String cat = st2.nextToken();
                                String movie = st2.nextToken();
                                String eno = st2.nextToken();
                                String title = st2.nextToken();
                                String duration = st2.nextToken();

                                String photo = st2.nextToken();
                                String video2 = st2.nextToken();

                                obj[i].jtitle.setText(title);
                                obj[i].thumbnail.setText(photo);
                                URL url = new URL("http://localhost:9000/getresource/" + photo);
                                BufferedImage img = ImageIO.read(url);
                                Image newimg = img.getScaledInstance(obj[i].thumbnail.getWidth(), obj[i].thumbnail.getHeight(), Image.SCALE_SMOOTH);
                                obj[i].thumbnail.setIcon(new ImageIcon(newimg));
                                obj[i].jduration.setText(duration);
                                obj[i].jvideo.setText(eno);
                                obj[i].bt1.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {

                                        if (status == false) {
                                            JOptionPane.showMessageDialog(rootPane, "please subscribe to watch the movie ");
                                        } else {
                                            bt2.setText("Already Bought");
                                            bt2.setEnabled(false);

                                            new Thread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    JavaFXMediaPlayerFrame obj = new JavaFXMediaPlayerFrame(video2);
                                                }
                                            }).start();
                                        }

                                    }
                                });

                                obj[i].bt2.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {

                                        if (status == false) {
                                            JOptionPane.showMessageDialog(rootPane, "please subscribe to download the movie ");
                                        } else {
                                            bt2.setText("Already Bought");
                                            bt2.setEnabled(false);
                                            new Thread(new Runnable() {
                                                public void run() {
                                                    try {
                                                        HttpResponse<InputStream> httpresponse = Unirest.get("http://localhost:9000/getresource/" + video2)
                                                                .asBinary();
                                                        if (httpresponse.getStatus() == 200) {
                                                            InputStream is = httpresponse.getBody();
                                                            long filesize = Integer.parseInt(httpresponse.getHeaders().getFirst("Content-Length"));
                                                            int index = video.lastIndexOf("/");
                                                            String name = video.substring(index + 1);
                                                            System.out.println("Video name" + name);
                                                            FileOutputStream fos = new FileOutputStream("E:\\BingeFlixVideos\\" + name);
                                                            byte b[] = new byte[100];
                                                            int count = 0;
                                                            int r, per;
                                                            VideoProgressBar obj = new VideoProgressBar();
                                                            obj.jProgressBar1.setStringPainted(true);
                                                            while (true) {
                                                                r = is.read(b, 0, b.length);
                                                                fos.write(b, 0, r);
                                                                count = count + r;
                                                                per = (int) ((count * 100.0) / filesize);

                                                                obj.jProgressBar1.setValue(per);
                                                                obj.jProgressBar1.setString(per + " % complete");

                                                                if (count == filesize) {
                                                                    obj.dispose();
                                                                    break;

                                                                }
                                                            }
                                                            fos.close();
                                                            int ans = JOptionPane.showConfirmDialog(rootPane, "Do you want to open file ?", "Confirmation !", JOptionPane.YES_NO_OPTION);
                                                            if (ans == JOptionPane.YES_OPTION) {
                                                                Desktop d = Desktop.getDesktop();
                                                                d.open(new File("E:\\BingeFlixVideos\\" + name));
                                                            }

                                                        }
                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                }
                                            }).start();
                                        }

                                    }
                                });
                                obj[i].setBounds(x, y, 425, 385);
                                mainPanel.add(obj[i]);
                                x += 450;
                                i++;
                            }
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }

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
            java.util.logging.Logger.getLogger(UserMovieDetailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserMovieDetailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserMovieDetailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserMovieDetailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserMovieDetailFrame("", "").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt1;
    private javax.swing.JButton bt2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jamount;
    private javax.swing.JTextArea jdesc;
    private javax.swing.JLabel jmovie;
    private javax.swing.JLabel jphoto;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}
