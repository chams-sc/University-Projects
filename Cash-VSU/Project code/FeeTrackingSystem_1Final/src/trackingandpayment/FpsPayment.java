
package trackingandpayment;

import java.awt.geom.RoundRectangle2D;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;





public class FpsPayment extends javax.swing.JFrame {
    

    int positionX = 0, positionY = 0;
    
    public FpsPayment() {       
        setUndecorated(true);       
        initComponents();             
        setLocationRelativeTo(null);      
        setShape(new RoundRectangle2D. Double(0,0, getWidth(), getHeight(), 20, 20));
    }
    
    private int studNum;
    private String studName;
    public FpsPayment(int studNum, String studName) { 
        this.studNum = studNum;
        this.studName = studName;
        setUndecorated(true);       
        initComponents();             
        setLocationRelativeTo(null);      
        setShape(new RoundRectangle2D. Double(0,0, getWidth(), getHeight(), 20, 20));
    }
    
    private boolean verifyFields(){
        return !(txtFeeCode.getText().isEmpty() || String.valueOf(jPassword.getPassword()).isEmpty());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        CVSU_LOGO = new javax.swing.JLabel();
        HomeButton = new javax.swing.JRadioButton();
        iconViewFees = new javax.swing.JRadioButton();
        iconPay = new javax.swing.JRadioButton();
        iconReceipt = new javax.swing.JRadioButton();
        iconTranHistory = new javax.swing.JRadioButton();
        epay = new javax.swing.JLabel();
        exitbtn = new javax.swing.JButton();
        minibtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtFeeCode = new javax.swing.JTextField();
        btnConfirmPay = new javax.swing.JButton();
        jPassword = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        CVSU_LOGO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/24.png"))); // NOI18N

        HomeButton.setBackground(new java.awt.Color(255, 255, 255));
        HomeButton.setToolTipText("Home");
        HomeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        HomeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/home.png"))); // NOI18N
        HomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeButtonActionPerformed(evt);
            }
        });

        iconViewFees.setBackground(new java.awt.Color(255, 255, 255));
        iconViewFees.setToolTipText("View Fees");
        iconViewFees.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconViewFees.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ViewFees.png"))); // NOI18N
        iconViewFees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iconViewFeesActionPerformed(evt);
            }
        });

        iconPay.setBackground(new java.awt.Color(255, 255, 255));
        iconPay.setToolTipText("Pay");
        iconPay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconPay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/PayFees.png"))); // NOI18N
        iconPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iconPayActionPerformed(evt);
            }
        });

        iconReceipt.setBackground(new java.awt.Color(255, 255, 255));
        iconReceipt.setToolTipText("Receipt");
        iconReceipt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconReceipt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconReceipt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/student (2).png"))); // NOI18N
        iconReceipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iconReceiptActionPerformed(evt);
            }
        });

        iconTranHistory.setBackground(new java.awt.Color(255, 255, 255));
        iconTranHistory.setToolTipText("Transaction History");
        iconTranHistory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconTranHistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/TransactionHistory.png"))); // NOI18N
        iconTranHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iconTranHistoryActionPerformed(evt);
            }
        });

        epay.setBackground(new java.awt.Color(255, 255, 255));
        epay.setFont(new java.awt.Font("Timeline", 1, 24)); // NOI18N
        epay.setForeground(new java.awt.Color(30, 0, 110));
        epay.setText("Cash-VSU");

        exitbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/exit button.png"))); // NOI18N
        exitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbtnActionPerformed(evt);
            }
        });

        minibtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/minimize.png"))); // NOI18N
        minibtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minibtnActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(249, 249, 249));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(249, 249, 249), 50, true));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 61, -1, -1));

        jPanel4.setBackground(new java.awt.Color(249, 249, 249));
        jPanel4.setForeground(new java.awt.Color(186, 186, 186));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Front Page Neue", 0, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(30, 0, 110));
        jLabel5.setText("PAYMENT");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, -1, -1));

        jLabel1.setFont(new java.awt.Font("Front Page Neue", 0, 24)); // NOI18N
        jLabel1.setText("PASSWORD:");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, -1, -1));

        jLabel2.setFont(new java.awt.Font("Front Page Neue", 0, 24)); // NOI18N
        jLabel2.setText("FEE CODE:");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, -1, -1));

        txtFeeCode.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        jPanel4.add(txtFeeCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, 290, 50));

        btnConfirmPay.setBackground(new java.awt.Color(30, 0, 110));
        btnConfirmPay.setFont(new java.awt.Font("Front Page Neue", 1, 24)); // NOI18N
        btnConfirmPay.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirmPay.setText("CONFIRM");
        btnConfirmPay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirmPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmPayActionPerformed(evt);
            }
        });
        jPanel4.add(btnConfirmPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 510, 160, 40));

        jPassword.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        jPanel4.add(jPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 370, 290, 50));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 910, 720));

        jButton1.setBackground(new java.awt.Color(30, 0, 110));
        jButton1.setFont(new java.awt.Font("Front Page Neue", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("LOGOUT");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(HomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(iconViewFees, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(iconReceipt, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(iconTranHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(iconPay, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(CVSU_LOGO)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(epay)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(minibtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exitbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(exitbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CVSU_LOGO)
                            .addComponent(minibtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(epay)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(HomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(iconViewFees, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(iconPay, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(iconReceipt, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(iconTranHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)))
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
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
    }// </editor-fold>//GEN-END:initComponents

    private void HomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeButtonActionPerformed
        new FpsHomeSection(studNum, studName).setVisible(true);
        dispose();
    }//GEN-LAST:event_HomeButtonActionPerformed

    private void iconViewFeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconViewFeesActionPerformed
        new FpsViewFees(studNum, studName).setVisible(true);
        dispose();
    }//GEN-LAST:event_iconViewFeesActionPerformed

    private void iconPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconPayActionPerformed
        // do nothing
    }//GEN-LAST:event_iconPayActionPerformed

    private void iconReceiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconReceiptActionPerformed
        new FpsGenReceipt(studNum, studName).setVisible(true);
        dispose();
    }//GEN-LAST:event_iconReceiptActionPerformed

    private void iconTranHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconTranHistoryActionPerformed
        new FpsTransactionHistory(studNum, studName).setVisible(true);
        dispose();
    }//GEN-LAST:event_iconTranHistoryActionPerformed

    private void exitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_exitbtnActionPerformed

    private void minibtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minibtnActionPerformed
        this.setExtendedState(FpsPayment.ICONIFIED);
    }//GEN-LAST:event_minibtnActionPerformed

    private void btnConfirmPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmPayActionPerformed
        FpsHashing h = new FpsHashing();
        String pw = String.valueOf(jPassword.getPassword());
        String algorithm = "SHA-256";
        String hashed = null;
        try {
            hashed = h.hashPassword(pw, algorithm);
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }

        Connection conn = null;

        if (verifyFields() == false){
            JOptionPane.showMessageDialog(this, "Missing Information!");
        }
        else{
            try{
                // connect to database
                conn = FpsDBConnection.dbConnect();

                String query = "SELECT f.FeeCode, s.Password FROM tbl_fee_list f "
                + "JOIN tbl_user s ON f.StudentNum = s.StudentNum WHERE f.StudentNum =? AND f.feeCode = ?;";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, studNum);
                ps.setString(2, txtFeeCode.getText());
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    if(rs.getString(2).equals(hashed)){
                        String passRequest = "INSERT INTO tbl_pending(FeeCode, DateRequested) VALUES ('"+txtFeeCode.getText()+"',CURDATE())";
                        PreparedStatement ps2 = conn.prepareStatement(passRequest);
                        ps2.execute();

                        JOptionPane.showMessageDialog(this,  "Transaction is being processed. \nPlease check transaction history from time to time.");
                        Clear();
                    }
                    else{
                        JOptionPane.showMessageDialog(this,  "Password Mismatch!");
                        jPassword.setText("");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(this,  "Invalid Fee Code.");
                    txtFeeCode.setText("");
                }
            }
            catch(SQLException ex) {
                JOptionPane.showMessageDialog(this, ex);
                Clear();
            }
        }

    }//GEN-LAST:event_btnConfirmPayActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FpsLogin lg = new FpsLogin();
        lg.frame.setVisible(true);
        lg.frame.setLocationRelativeTo(this);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Clear(){
        txtFeeCode.setText("");
        jPassword.setText("");
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
            java.util.logging.Logger.getLogger(FpsPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FpsPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FpsPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FpsPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FpsPayment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CVSU_LOGO;
    private javax.swing.JRadioButton HomeButton;
    private javax.swing.JButton btnConfirmPay;
    private javax.swing.JLabel epay;
    private javax.swing.JButton exitbtn;
    private javax.swing.JRadioButton iconPay;
    private javax.swing.JRadioButton iconReceipt;
    private javax.swing.JRadioButton iconTranHistory;
    private javax.swing.JRadioButton iconViewFees;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JButton minibtn;
    private javax.swing.JTextField txtFeeCode;
    // End of variables declaration//GEN-END:variables
}

