package atm_machine;

import java.awt.Color;
import java.sql.*;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Login extends javax.swing.JFrame {
        
    public Login() {
        initComponents();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblMyBank = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtAccID = new javax.swing.JTextField();
        passfPin = new javax.swing.JPasswordField();
//        passfPin.addKeyListener(new java.awt.event.KeyAdapter() {
//        	@Override
//        	public void keyTyped(java.awt.event.KeyEvent evt) {
//        		passfPinKeyTyped(evt);
//        	}	
//        });
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        lblLogin = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        lblCreateAcc = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon("img/icons8-bank-cards-100.png")); // NOI18N

        lblMyBank.setFont(new java.awt.Font("Bahnschrift", 1, 65)); // NOI18N
        lblMyBank.setForeground(new java.awt.Color(255, 255, 255));
        lblMyBank.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMyBank.setText("MYBANK");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMyBank)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(lblMyBank, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        txtAccID.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        txtAccID.setForeground(new java.awt.Color(102, 102, 102));
        txtAccID.setText("Account ID");
        txtAccID.setToolTipText("");
        txtAccID.setBorder(null);
        txtAccID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lblAccIDFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                lblAccIDFocusLost(evt);
            }
        });

        passfPin.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        passfPin.setForeground(new java.awt.Color(102, 102, 102));
        passfPin.setText("1234");
        passfPin.setBorder(null);
        passfPin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passfPinFocusGained(evt);
            }
        	public void focusLost(java.awt.event.FocusEvent evt) {
        		passfPinFocusLost(evt);
        	}
        });

        jSeparator2.setBackground(new java.awt.Color(101, 101, 101));
        jSeparator2.setForeground(new java.awt.Color(51, 51, 51));

        jSeparator3.setBackground(new java.awt.Color(101, 101, 101));
        jSeparator3.setForeground(new java.awt.Color(51, 51, 51));

        lblLogin.setFont(new java.awt.Font("Bahnschrift", 1, 60)); // NOI18N
        lblLogin.setText("LOG IN");

        btnLogin.setBackground(new java.awt.Color(255, 255, 255));
        btnLogin.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        btnLogin.setText("Log in");
        btnLogin.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLoginMouseExited(evt);
            }
        });
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lblCreateAcc.setBackground(new java.awt.Color(255, 255, 255));
        lblCreateAcc.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        lblCreateAcc.setText("Create New Account");
        lblCreateAcc.setToolTipText("");
        lblCreateAcc.setBorder(null);
        lblCreateAcc.setBorderPainted(false);
        lblCreateAcc.setContentAreaFilled(false);
        lblCreateAcc.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblCreateAcc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
        });
        lblCreateAcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateAccActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel4.setText("X");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator3)
                            .addComponent(txtAccID)
                            .addComponent(jSeparator2)
                            .addComponent(passfPin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE))
                        .addGap(58, 58, 58))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(147, 147, 147))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(lblCreateAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(lblLogin)
                        .addGap(123, 123, 123))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel4)
                .addGap(55, 55, 55)
                .addComponent(lblLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(txtAccID, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passfPin, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(lblCreateAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        
    
    
    private void Clear() {
    	txtAccID.setText("Account ID");
 		passfPin.setText("1234");
    }
    
//Log in Action button
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {
    	String pin = String.valueOf(passfPin.getPassword());
    	
    	if(txtAccID.getText().isEmpty() || pin.isEmpty()) {
    		JOptionPane.showMessageDialog(this, "Missing Information");
    	}
    	else {
    		Connection conn = null;
    		try {
    			conn = DBConnection.dbConnect();
    			String query = "SELECT * FROM usertbl WHERE AccountID = ? and Pin = ?";
    			
    			PreparedStatement ps = conn.prepareStatement(query);   			
    			ps.setString(1, txtAccID.getText());
    			ps.setInt(2, Integer.valueOf(pin));
    			
    			ResultSet rs = ps.executeQuery();
    			
    			// if a result set is retrieved then the account exists
    			if (rs.next()) {
    				new Menu(txtAccID.getText(), rs.getInt(6), rs.getInt(5)).setVisible(true);
    				this.dispose();    				
    			}
    			else {
    				JOptionPane.showMessageDialog(this,  "Wrong Account ID or PIN");
    				Clear();
    			}
    		}
    		catch (NumberFormatException e) {
    			JOptionPane.showMessageDialog(this, "PIN should be numbers.");
    		}
    		catch (Exception e) {
    			JOptionPane.showMessageDialog(this, e);    			
    		}    		
    	}   
    }       
    
//sign up Action button
    private void btnCreateAccActionPerformed(java.awt.event.ActionEvent evt) {                                         
        new SignUp().setVisible(true);
    	this.dispose();
    }                                        

    private void lblAccIDFocusGained(java.awt.event.FocusEvent evt) {
    	if(txtAccID.getText().equals("Account ID")) {
    		txtAccID.setText("");
    	}
        
    }
    private void lblAccIDFocusLost(java.awt.event.FocusEvent evt) {                                
    	if (txtAccID.getText().trim().equals("") || txtAccID.getText().trim().toLowerCase().equals("Account ID")) {
    		txtAccID.setText("Account ID");
    	}
     }

    private void passfPinFocusGained(java.awt.event.FocusEvent evt) {                                
    	if(String.valueOf(passfPin.getPassword()).equals("1234")) {
    		passfPin.setText("");
    	}    	
    }
    private void passfPinFocusLost(java.awt.event.FocusEvent evt) {                                
    	if (String.valueOf(passfPin.getPassword()).equals("") || String.valueOf(passfPin.getPassword()).equals("1234")) {
    		passfPin.setText("1234");
    	}
     }

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {                                     
        System.exit(0);
    }                                                                

    private void btnLoginMouseEntered(java.awt.event.MouseEvent evt) {                                      
      btnLogin.setBackground(new Color(0,0,0));
      btnLogin.setForeground(new Color(255,255,255));
    }                                     

    private void btnLoginMouseExited(java.awt.event.MouseEvent evt) {                                     
      btnLogin.setBackground(new Color(255,255,255));
      btnLogin.setForeground(new Color(0,0,0));
    }
    
    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {                                      
       lblCreateAcc.setForeground(new Color(45, 35, 158));
    }                                     

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {                                     
      lblCreateAcc.setForeground(new Color(0,0,0));
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JPasswordField passfPin;
    private javax.swing.JTextField txtAccID;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton lblCreateAcc;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblMyBank;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration                   
}