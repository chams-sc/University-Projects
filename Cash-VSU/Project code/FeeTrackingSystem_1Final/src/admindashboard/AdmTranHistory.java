/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admindashboard;

import trackingandpayment.*;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author User
 */
public class AdmTranHistory extends JFrame {

    /**
     * Creates new form AddFees
     */
    public AdmTranHistory() {        
        initComponents();  
        grabData();      
        setTitle("Cash-VSU");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons/MainIcon.png")));
    }
    
    private String adminPass;
    public AdmTranHistory(String adminPass) {
        this.adminPass = adminPass;
        initComponents(); 
        grabData();      
        setTitle("Cash-VSU");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons/MainIcon.png")));
    }
    
    private  void grabData(){
        Connection conn = null;
        try{
            conn = FpsDBConnection.dbConnect();
            String query = "SELECT FeeCode AS 'Fee Code', StudentNum AS 'Student No.', Category, Amount, DueDate AS 'Due Date', DatePaid AS 'Date Paid' FROM transaction_history";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            tblTranHis.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(SQLException ex){
            ex.printStackTrace();
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

        panelsideBar = new javax.swing.JPanel();
        cvsu_logo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panelLogout = new javax.swing.JPanel();
        btn_Logout = new javax.swing.JLabel();
        panelBack = new javax.swing.JPanel();
        btn_Back = new javax.swing.JLabel();
        panelViewAllRecord = new javax.swing.JPanel();
        TransactionHistory = new javax.swing.JLabel();
        panelCoursesList = new javax.swing.JPanel();
        btn_ConfirmTransaction = new javax.swing.JLabel();
        panelEditCourses = new javax.swing.JPanel();
        btn_StudentRecord = new javax.swing.JLabel();
        panelSearchRec = new javax.swing.JPanel();
        btn_SearchRecord = new javax.swing.JLabel();
        panelHome = new javax.swing.JPanel();
        btn_Home = new javax.swing.JLabel();
        panelParent = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTranHis = new javax.swing.JTable();
        lblTranHis = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelsideBar.setBackground(new java.awt.Color(0, 102, 102));
        panelsideBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cvsu_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/24.png"))); // NOI18N
        panelsideBar.add(cvsu_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 80, 80));

        jLabel3.setFont(new java.awt.Font("Timeline", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 153));
        jLabel3.setText("Cash-VSU");
        panelsideBar.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

        panelLogout.setBackground(new java.awt.Color(0, 102, 102));
        panelLogout.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        btn_Logout.setFont(new java.awt.Font("Sylfaen", 0, 20)); // NOI18N
        btn_Logout.setForeground(new java.awt.Color(255, 255, 255));
        btn_Logout.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btn_Logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit2.png"))); // NOI18N
        btn_Logout.setText("Logout                          ");
        btn_Logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_LogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_LogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_LogoutMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelLogoutLayout = new javax.swing.GroupLayout(panelLogout);
        panelLogout.setLayout(panelLogoutLayout);
        panelLogoutLayout.setHorizontalGroup(
            panelLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_Logout, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
        );
        panelLogoutLayout.setVerticalGroup(
            panelLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLogoutLayout.createSequentialGroup()
                .addComponent(btn_Logout)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        panelsideBar.add(panelLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 640, 270, -1));

        panelBack.setBackground(new java.awt.Color(0, 102, 102));
        panelBack.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        btn_Back.setFont(new java.awt.Font("Sylfaen", 0, 20)); // NOI18N
        btn_Back.setForeground(new java.awt.Color(255, 255, 255));
        btn_Back.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btn_Back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/left-arrow.png"))); // NOI18N
        btn_Back.setText("Back                              ");
        btn_Back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_BackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_BackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_BackMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelBackLayout = new javax.swing.GroupLayout(panelBack);
        panelBack.setLayout(panelBackLayout);
        panelBackLayout.setHorizontalGroup(
            panelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_Back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelBackLayout.setVerticalGroup(
            panelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBackLayout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addComponent(btn_Back))
        );

        panelsideBar.add(panelBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, 270, 70));

        panelViewAllRecord.setBackground(new java.awt.Color(0, 102, 102));
        panelViewAllRecord.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        TransactionHistory.setFont(new java.awt.Font("Sylfaen", 0, 20)); // NOI18N
        TransactionHistory.setForeground(new java.awt.Color(255, 255, 255));
        TransactionHistory.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        TransactionHistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/view all record.png"))); // NOI18N
        TransactionHistory.setText("Transaction History    ");
        TransactionHistory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TransactionHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TransactionHistoryMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TransactionHistoryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TransactionHistoryMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelViewAllRecordLayout = new javax.swing.GroupLayout(panelViewAllRecord);
        panelViewAllRecord.setLayout(panelViewAllRecordLayout);
        panelViewAllRecordLayout.setHorizontalGroup(
            panelViewAllRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TransactionHistory, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
        );
        panelViewAllRecordLayout.setVerticalGroup(
            panelViewAllRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelViewAllRecordLayout.createSequentialGroup()
                .addComponent(TransactionHistory)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        panelsideBar.add(panelViewAllRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 270, 70));

        panelCoursesList.setBackground(new java.awt.Color(0, 102, 102));
        panelCoursesList.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        btn_ConfirmTransaction.setFont(new java.awt.Font("Sylfaen", 0, 20)); // NOI18N
        btn_ConfirmTransaction.setForeground(new java.awt.Color(255, 255, 255));
        btn_ConfirmTransaction.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btn_ConfirmTransaction.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/list_1.png"))); // NOI18N
        btn_ConfirmTransaction.setText("Confirm Transaction");
        btn_ConfirmTransaction.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ConfirmTransaction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ConfirmTransactionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_ConfirmTransactionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_ConfirmTransactionMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelCoursesListLayout = new javax.swing.GroupLayout(panelCoursesList);
        panelCoursesList.setLayout(panelCoursesListLayout);
        panelCoursesListLayout.setHorizontalGroup(
            panelCoursesListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCoursesListLayout.createSequentialGroup()
                .addComponent(btn_ConfirmTransaction, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelCoursesListLayout.setVerticalGroup(
            panelCoursesListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCoursesListLayout.createSequentialGroup()
                .addComponent(btn_ConfirmTransaction)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        panelsideBar.add(panelCoursesList, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 270, 70));

        panelEditCourses.setBackground(new java.awt.Color(0, 102, 102));
        panelEditCourses.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        btn_StudentRecord.setFont(new java.awt.Font("Sylfaen", 0, 20)); // NOI18N
        btn_StudentRecord.setForeground(new java.awt.Color(255, 255, 255));
        btn_StudentRecord.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btn_StudentRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit2.png"))); // NOI18N
        btn_StudentRecord.setText("Student Record           ");
        btn_StudentRecord.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_StudentRecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_StudentRecordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_StudentRecordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_StudentRecordMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelEditCoursesLayout = new javax.swing.GroupLayout(panelEditCourses);
        panelEditCourses.setLayout(panelEditCoursesLayout);
        panelEditCoursesLayout.setHorizontalGroup(
            panelEditCoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_StudentRecord, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
        );
        panelEditCoursesLayout.setVerticalGroup(
            panelEditCoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditCoursesLayout.createSequentialGroup()
                .addComponent(btn_StudentRecord)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        panelsideBar.add(panelEditCourses, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 270, 70));

        panelSearchRec.setBackground(new java.awt.Color(0, 102, 102));
        panelSearchRec.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        btn_SearchRecord.setFont(new java.awt.Font("Sylfaen", 0, 20)); // NOI18N
        btn_SearchRecord.setForeground(new java.awt.Color(255, 255, 255));
        btn_SearchRecord.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btn_SearchRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search2.png"))); // NOI18N
        btn_SearchRecord.setText("Pending Requests       ");
        btn_SearchRecord.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_SearchRecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_SearchRecordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_SearchRecordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_SearchRecordMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelSearchRecLayout = new javax.swing.GroupLayout(panelSearchRec);
        panelSearchRec.setLayout(panelSearchRecLayout);
        panelSearchRecLayout.setHorizontalGroup(
            panelSearchRecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_SearchRecord, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
        );
        panelSearchRecLayout.setVerticalGroup(
            panelSearchRecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSearchRecLayout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addComponent(btn_SearchRecord))
        );

        panelsideBar.add(panelSearchRec, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 270, 70));

        panelHome.setBackground(new java.awt.Color(0, 102, 102));
        panelHome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        btn_Home.setFont(new java.awt.Font("Sylfaen", 0, 20)); // NOI18N
        btn_Home.setForeground(new java.awt.Color(255, 255, 255));
        btn_Home.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btn_Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/home_1.png"))); // NOI18N
        btn_Home.setText("  HOME                      ");
        btn_Home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_HomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_HomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_HomeMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelHomeLayout = new javax.swing.GroupLayout(panelHome);
        panelHome.setLayout(panelHomeLayout);
        panelHomeLayout.setHorizontalGroup(
            panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_Home, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
        );
        panelHomeLayout.setVerticalGroup(
            panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHomeLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_Home))
        );

        panelsideBar.add(panelHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 270, 70));

        getContentPane().add(panelsideBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 850));

        panelParent.setBackground(new java.awt.Color(0, 153, 153));
        panelParent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblTranHis.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblTranHis);

        panelParent.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 680, 470));

        lblTranHis.setFont(new java.awt.Font("Timeline", 0, 48)); // NOI18N
        lblTranHis.setForeground(new java.awt.Color(255, 255, 153));
        lblTranHis.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTranHis.setText("Transaction History");
        panelParent.add(lblTranHis, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 420, 80));

        getContentPane().add(panelParent, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 750, 850));

        setSize(new java.awt.Dimension(1095, 873));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_LogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_LogoutMouseClicked
        AdmLogin lgn = new AdmLogin();
        lgn.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_LogoutMouseClicked

    private void btn_LogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_LogoutMouseEntered
        Color clr = new Color (0,153,153);
        panelLogout.setBackground(clr);
    }//GEN-LAST:event_btn_LogoutMouseEntered

    private void btn_LogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_LogoutMouseExited
        Color clr = new Color (0,103,103);
        panelLogout.setBackground(clr);
    }//GEN-LAST:event_btn_LogoutMouseExited

    private void btn_BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_BackMouseClicked
        AdmHome home = new AdmHome(adminPass);
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_BackMouseClicked

    private void btn_BackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_BackMouseEntered
        Color clr = new Color (0,153,153);
        panelBack.setBackground(clr);
    }//GEN-LAST:event_btn_BackMouseEntered

    private void btn_BackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_BackMouseExited
        Color clr = new Color (0,103,103);
        panelBack.setBackground(clr);
    }//GEN-LAST:event_btn_BackMouseExited

    private void TransactionHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TransactionHistoryMouseClicked
        AdmTranHistory trnscthstry = new AdmTranHistory(adminPass);
        trnscthstry.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_TransactionHistoryMouseClicked

    private void TransactionHistoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TransactionHistoryMouseEntered
        Color clr = new Color (0,153,153);
        panelViewAllRecord.setBackground(clr);
    }//GEN-LAST:event_TransactionHistoryMouseEntered

    private void TransactionHistoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TransactionHistoryMouseExited
        Color clr = new Color (0,103,103);
        panelViewAllRecord.setBackground(clr);
    }//GEN-LAST:event_TransactionHistoryMouseExited

    private void btn_ConfirmTransactionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ConfirmTransactionMouseClicked
        AdmConfirmTrans vwalrcd = new AdmConfirmTrans(adminPass);
        vwalrcd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_ConfirmTransactionMouseClicked

    private void btn_ConfirmTransactionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ConfirmTransactionMouseEntered
        Color clr = new Color (0,153,153);
        panelCoursesList.setBackground(clr);
    }//GEN-LAST:event_btn_ConfirmTransactionMouseEntered

    private void btn_ConfirmTransactionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ConfirmTransactionMouseExited
        Color clr = new Color (0,103,103);
        panelCoursesList.setBackground(clr);
    }//GEN-LAST:event_btn_ConfirmTransactionMouseExited

    private void btn_StudentRecordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_StudentRecordMouseClicked
        AdmStudRecord stdntrcd = new AdmStudRecord(adminPass);
        stdntrcd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_StudentRecordMouseClicked

    private void btn_StudentRecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_StudentRecordMouseEntered
        Color clr = new Color (0,153,153);
        panelEditCourses.setBackground(clr);
    }//GEN-LAST:event_btn_StudentRecordMouseEntered

    private void btn_StudentRecordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_StudentRecordMouseExited
        Color clr = new Color (0,103,103);
        panelEditCourses.setBackground(clr);
    }//GEN-LAST:event_btn_StudentRecordMouseExited

    private void btn_SearchRecordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_SearchRecordMouseClicked
        AdmPendingReq Srchrcrd = new AdmPendingReq(adminPass);
        Srchrcrd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_SearchRecordMouseClicked

    private void btn_SearchRecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_SearchRecordMouseEntered
        Color clr = new Color (0,153,153);
        panelSearchRec.setBackground(clr);
    }//GEN-LAST:event_btn_SearchRecordMouseEntered

    private void btn_SearchRecordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_SearchRecordMouseExited
        Color clr = new Color (0,103,103);
        panelSearchRec.setBackground(clr);
    }//GEN-LAST:event_btn_SearchRecordMouseExited

    private void btn_HomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_HomeMouseClicked
        AdmHome home = new AdmHome(adminPass);
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_HomeMouseClicked

    private void btn_HomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_HomeMouseEntered
        Color clr = new Color (0,153,153);
        panelHome.setBackground(clr);
    }//GEN-LAST:event_btn_HomeMouseEntered

    private void btn_HomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_HomeMouseExited
        Color clr = new Color (0,103,103);
        panelHome.setBackground(clr);
    }//GEN-LAST:event_btn_HomeMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdmTranHistory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TransactionHistory;
    private javax.swing.JLabel btn_Back;
    private javax.swing.JLabel btn_ConfirmTransaction;
    private javax.swing.JLabel btn_Home;
    private javax.swing.JLabel btn_Logout;
    private javax.swing.JLabel btn_SearchRecord;
    private javax.swing.JLabel btn_StudentRecord;
    private javax.swing.JLabel cvsu_logo;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTranHis;
    private javax.swing.JPanel panelBack;
    private javax.swing.JPanel panelCoursesList;
    private javax.swing.JPanel panelEditCourses;
    private javax.swing.JPanel panelHome;
    private javax.swing.JPanel panelLogout;
    private javax.swing.JPanel panelParent;
    private javax.swing.JPanel panelSearchRec;
    private javax.swing.JPanel panelViewAllRecord;
    private javax.swing.JPanel panelsideBar;
    private javax.swing.JTable tblTranHis;
    // End of variables declaration//GEN-END:variables
}
