
public class CategoryPanelDesign extends javax.swing.JPanel {

    
    public CategoryPanelDesign() {
        initComponents();
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesc = new javax.swing.JLabel();
        jPhoto = new javax.swing.JLabel();
        jCatName = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 102, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setLayout(null);

        jDesc.setText("jLabel1");
        add(jDesc);
        jDesc.setBounds(180, 60, 510, 60);

        jPhoto.setText("jLabel1");
        add(jPhoto);
        jPhoto.setBounds(180, 140, 430, 270);

        jCatName.setText("jLabel1");
        add(jCatName);
        jCatName.setBounds(180, 20, 180, 30);

        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CATEGORY NAME");
        add(jLabel1);
        jLabel1.setBounds(10, 20, 140, 26);

        jLabel2.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("DESCRIPTION");
        add(jLabel2);
        jLabel2.setBounds(10, 70, 110, 26);

        jLabel3.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PHOTO");
        add(jLabel3);
        jLabel3.setBounds(10, 140, 90, 24);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel jCatName;
    public javax.swing.JLabel jDesc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jPhoto;
    // End of variables declaration//GEN-END:variables
}
