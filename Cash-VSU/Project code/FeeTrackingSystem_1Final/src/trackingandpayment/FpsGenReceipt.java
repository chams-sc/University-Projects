/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package trackingandpayment;

import java.awt.geom.RoundRectangle2D;
import java.awt.print.PrinterException;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author dell
 */
public class FpsGenReceipt extends javax.swing.JFrame {

    /**
     * Creates new form FpsGenReceipt
     */
    int positionX = 0, positionY = 0;
    
    public FpsGenReceipt() {       
        setUndecorated(true);        
        initComponents();               
        setLocationRelativeTo(null);       
        setShape(new RoundRectangle2D. Double(0,0, getWidth(), getHeight(), 20, 20));
    }
    private String studName;
    private int studNum;
    public FpsGenReceipt(int studNum, String studName) { 
        this.studNum = studNum;
        this.studName = studName;
        setUndecorated(true);        
        initComponents();
        setLocationRelativeTo(null);       
        setShape(new RoundRectangle2D. Double(0,0, getWidth(), getHeight(), 20, 20));
        grabName();
    }
    
    private void grabName(){
        Connection conn = null;
        try{
            // connect to database
            conn = FpsDBConnection.dbConnect();
            String query = "SELECt FirstName, LastName FROM tbl_user WHERE StudentNum = '"+studNum+"'";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                fullName = rs.getString("FirstName") + " " + rs.getString("LastName");
            }
            conn.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    private String fromDate, toDate, fullName;
    private void getDate(){
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            fromDate = sdf.format(dcFromDate.getDate());
            toDate = sdf.format(dcToDate.getDate());
        }
        catch(Exception e) {
            fromDate = null;
            toDate = null;
        }
    }
    
    private boolean verifyFields(){
        return !(fromDate == null || toDate == null);
    }
    
     private boolean dataExist(){
        Connection conn = null;
        
         try{
            // connect to database
            conn = FpsDBConnection.dbConnect();
            String query = "SELECt * FROM transaction_history WHERE StudentNum = ? AND DatePaid BETWEEN ? AND ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, studNum);
            ps.setString(2, fromDate);
            ps.setString(3, toDate);
            
            // Get the result
            ResultSet rs = ps.executeQuery();
            
            // check results
            return rs.next();           
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this, "Problem connecting to database.");
        }
        return false;
    }
    
    private float totalPrice = 0;
    private void grabData(){
        Connection conn = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        
        String format = "%-12s %-10.2f %-8s";
        String formatF = "%.2f";
        
        try{
            // connect to database
            conn = FpsDBConnection.dbConnect();
            String query = "SELECt * FROM transaction_history WHERE StudentNum = ? AND DatePaid BETWEEN ? AND ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, studNum);
            ps.setString(2, fromDate);
            ps.setString(3, toDate);
            
            // Get the result
            ResultSet rs = ps.executeQuery();
            
            // check first if there are results
            if (rs.next()){
                // point cursor back to not escape the first row
                rs.previous();
                
                // will now point back on first row again
                while (rs.next()){
                String category = rs.getString("Category");
                float price = rs.getFloat("Amount");
                String datePaid = rs.getString("DatePaid");
                String line = String.format(format, category, price, datePaid);
                
                totalPrice += price;
                txt_area.append("\n" + line);
                }
                
                String pTotalPrice = String.format(formatF, totalPrice);
                txt_area.append("\n\nTOTAL:       " +pTotalPrice);
                conn.close();
            }
            // if no transactions
            else{
                JOptionPane.showMessageDialog(this, "No recorded transactions.");
            }  
            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this, e);
        }
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
        iconHome = new javax.swing.JRadioButton();
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
        receipt = new javax.swing.JLabel();
        lblFromDate = new javax.swing.JLabel();
        lblToDate = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_area = new javax.swing.JTextArea();
        dcToDate = new com.toedter.calendar.JDateChooser();
        dcFromDate = new com.toedter.calendar.JDateChooser();
        lblInstruction = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        CVSU_LOGO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/24.png"))); // NOI18N

        iconHome.setBackground(new java.awt.Color(255, 255, 255));
        iconHome.setToolTipText("Home");
        iconHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/home.png"))); // NOI18N
        iconHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iconHomeActionPerformed(evt);
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
        jPanel3.setEnabled(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 61, -1, -1));

        jPanel4.setBackground(new java.awt.Color(249, 249, 249));
        jPanel4.setForeground(new java.awt.Color(186, 186, 186));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        receipt.setFont(new java.awt.Font("Front Page Neue", 0, 48)); // NOI18N
        receipt.setForeground(new java.awt.Color(30, 0, 110));
        receipt.setText("RECEIPT");
        receipt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(receipt, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, -1, -1));

        lblFromDate.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblFromDate.setText("From Date :");
        jPanel4.add(lblFromDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        lblToDate.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblToDate.setText("To Date     : ");
        jPanel4.add(lblToDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));

        jButton2.setBackground(new java.awt.Color(30, 0, 110));
        jButton2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("PRINT RECEIPT");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 570, 170, 60));

        jButton3.setBackground(new java.awt.Color(30, 0, 110));
        jButton3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("GENERATE");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 570, 140, 60));

        jButton4.setBackground(new java.awt.Color(30, 0, 110));
        jButton4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("RESET");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 570, 140, 60));

        txt_area.setEditable(false);
        txt_area.setColumns(20);
        txt_area.setFont(new java.awt.Font("Cascadia Mono", 1, 18)); // NOI18N
        txt_area.setRows(5);
        jScrollPane1.setViewportView(txt_area);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, 420, 390));
        jPanel4.add(dcToDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 250, 40));
        jPanel4.add(dcFromDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 250, 40));

        lblInstruction.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblInstruction.setText("From Date - To Date will generate all transactions made from that date range.");
        jPanel4.add(lblInstruction, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 430, 120));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 930, 720));

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
                .addGap(17, 17, 17)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(iconHome, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(iconViewFees, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(iconReceipt, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(iconTranHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(iconPay, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 972, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(CVSU_LOGO)
                        .addGap(18, 18, 18)
                        .addComponent(epay)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(minibtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(exitbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                        .addComponent(iconHome, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(23, 23, 23))
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

    private void iconHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconHomeActionPerformed
        new FpsHomeSection(studNum, studName).setVisible(true);
        dispose();
    }//GEN-LAST:event_iconHomeActionPerformed

    private void iconViewFeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconViewFeesActionPerformed
        new FpsViewFees(studNum, studName).setVisible(true);
        dispose();
    }//GEN-LAST:event_iconViewFeesActionPerformed

    private void iconPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconPayActionPerformed
        new FpsPayment(studNum, studName).setVisible(true);
        dispose ();
    }//GEN-LAST:event_iconPayActionPerformed

    private void iconReceiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconReceiptActionPerformed
        // do nothing
    }//GEN-LAST:event_iconReceiptActionPerformed

    private void iconTranHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconTranHistoryActionPerformed
        new FpsTransactionHistory(studNum, studName).setVisible(true);
        dispose();
    }//GEN-LAST:event_iconTranHistoryActionPerformed

    private void exitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_exitbtnActionPerformed

    private void minibtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minibtnActionPerformed
        this.setExtendedState(FpsGenReceipt.ICONIFIED);
    }//GEN-LAST:event_minibtnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (verifyFields() == false) {
            JOptionPane.showMessageDialog(this, "Please enter complete date range.");
        }
        else {
            try
            {
                txt_area.print();
            }
            catch(PrinterException e)
            {
                JOptionPane.showMessageDialog(this, "Something went wrong with the printing.");
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // make sure date is not null
        getDate();
        if (verifyFields() == false) {
            JOptionPane.showMessageDialog(this, "Please enter complete appropriate date range.");
        }
        else if (dataExist() == false){
            JOptionPane.showMessageDialog(this, "No recorded transactions.");
        }
        else {
        txt_area.append("*******************************************\n");
        txt_area.append("     ---- CASH-VSU RECEIPT SYSTEM ----\n");
        txt_area.append("*******************************************\n");

        Date obj = new Date ();

        String date = obj.toString();
        String format = "%-12s %-10s %-1s";
        String line = String.format(format, "CATEGORY", "PRICE", "DATE PAID");
        txt_area.append("\t" + date+"\n\n");
       
        txt_area.append("Student No.  : " + studNum +"\n");
        txt_area.append("Student Name : " + fullName+ "\n");
        txt_area.append("\n" +line+ "\n");
        
        // perform getting of data from db
        grabData();
        
        txt_area.append("\n\n                         Signature");
        txt_area.append("\n*******************************************");
        txt_area.append("\n   --- THANKYOU FOR USING CASH-VSU ---");
        totalPrice = 0;
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        txt_area.setText("");
        totalPrice = 0;
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FpsLogin lg = new FpsLogin();
        lg.frame.setVisible(true);
        lg.frame.setLocationRelativeTo(this);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FpsGenReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FpsGenReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FpsGenReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FpsGenReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FpsGenReceipt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CVSU_LOGO;
    private com.toedter.calendar.JDateChooser dcFromDate;
    private com.toedter.calendar.JDateChooser dcToDate;
    private javax.swing.JLabel epay;
    private javax.swing.JButton exitbtn;
    private javax.swing.JRadioButton iconHome;
    private javax.swing.JRadioButton iconPay;
    private javax.swing.JRadioButton iconReceipt;
    private javax.swing.JRadioButton iconTranHistory;
    private javax.swing.JRadioButton iconViewFees;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFromDate;
    private javax.swing.JLabel lblInstruction;
    private javax.swing.JLabel lblToDate;
    private javax.swing.JButton minibtn;
    private javax.swing.JLabel receipt;
    private javax.swing.JTextArea txt_area;
    // End of variables declaration//GEN-END:variables
}
