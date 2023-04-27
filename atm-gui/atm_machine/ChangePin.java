package atm_machine;

import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;


@SuppressWarnings("serial")
public class ChangePin extends javax.swing.JFrame {
        
    public ChangePin() {
        initComponents();
    }
    
    private String AccID;
    private int bal;
    private int pin;
    public ChangePin(String AccID, int bal, int pin) {
        initComponents();
        this.AccID = AccID;
        this.bal = bal;
        this.pin = pin;
    }
        
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblMyBank = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtOldPin = new javax.swing.JTextField();
        txtOldPin.addKeyListener(new java.awt.event.KeyAdapter() {
        	@Override
        	public void keyTyped(java.awt.event.KeyEvent evt) {
        		txtOldPinKeyTyped(evt);
        	}
        });
        txtOldPin.addFocusListener(new java.awt.event.FocusAdapter() {
        	public void focusGained(java.awt.event.FocusEvent evt) {
        		txtOldPinFocusGained(evt);
        	}
        	public void focusLost(java.awt.event.FocusEvent evt) {
        		txtOldPinFocusLost(evt);
        	}
        });
        confirmPin = new javax.swing.JPasswordField();
        confirmPin.addKeyListener(new java.awt.event.KeyAdapter() {
        	@Override
        	public void keyTyped(java.awt.event.KeyEvent evt) {
        		confirmPinKeyTyped(evt);
        	}
        });
        confirmPin.addFocusListener(new java.awt.event.FocusAdapter() {
        	public void focusGained(java.awt.event.FocusEvent evt) {
        		confirmPinFocusGained(evt);
        	}       	
        	public void focusLost(java.awt.event.FocusEvent evt) {
        		confirmPinFocusLost(evt);
        	}
        });
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        lblChangePin = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
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

        txtOldPin.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        txtOldPin.setForeground(new java.awt.Color(102, 102, 102));
        txtOldPin.setText("Old PIN");
        txtOldPin.setToolTipText("");
        txtOldPin.setBorder(null);  
        txtOldPin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOldPinActionPerformed(evt);
            }
        });

        confirmPin.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        confirmPin.setForeground(new java.awt.Color(102, 102, 102));
        confirmPin.setText("1234");
        confirmPin.setBorder(null);
        confirmPin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PinconfirmActionPerformed(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(101, 101, 101));
        jSeparator2.setForeground(new java.awt.Color(51, 51, 51));

        jSeparator3.setBackground(new java.awt.Color(101, 101, 101));
        jSeparator3.setForeground(new java.awt.Color(51, 51, 51));

        lblChangePin.setFont(new java.awt.Font("Bahnschrift", 1, 60)); // NOI18N
        lblChangePin.setText("Change Pin");

        btnSubmit.setBackground(new java.awt.Color(255, 255, 255));
        btnSubmit.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        btnSubmit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSubmit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(255, 255, 255));
        btnBack.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        btnBack.setText("Back");
        btnBack.setToolTipText("");
        btnBack.setBorder(null);
        btnBack.setBorderPainted(false);
        btnBack.setContentAreaFilled(false);
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
        });
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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
                            .addComponent(txtOldPin)
                            .addComponent(jSeparator2)
                            .addComponent(confirmPin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE))
                        .addGap(58, 58, 58))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(147, 147, 147))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(lblChangePin)
                        .addGap(57, 57, 57))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel4)
                .addGap(29, 29, 29)
                .addComponent(lblChangePin)
                .addGap(59, 59, 59)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(txtOldPin, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(confirmPin, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    	txtOldPin.setText("Old PIN");
    	confirmPin.setText("1234");
    }
    
//confirm Actionbutton
    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {
    	int oldPin = Integer.valueOf(txtOldPin.getText());
    	int cPin = Integer.valueOf(String.valueOf(confirmPin.getPassword()));
    	
    	if (oldPin != pin) {
    		JOptionPane.showMessageDialog(this, "Old Pin is wrong.");
    	}
    	else {    		
    		if (oldPin == cPin) {
    			JOptionPane.showMessageDialog(this, "Old and New PIN must be different.");   
    			Clear();
    		}
    		// if Old and New PIN are not equal
    		else {
    			Connection conn = null;
    			try {
    				conn = DBConnection.dbConnect();
    				String query = "UPDATE usertbl SET PIN = ? WHERE AccountID = ?";
    				PreparedStatement ps = conn.prepareStatement(query);
    				ps.setInt(1, cPin);
    				ps.setString(2, AccID);
    				pin = cPin;
    				
    				ps.executeUpdate();
    				JOptionPane.showMessageDialog(this, "PIN successfully updated.");
    				Clear();
    				conn.close();
    			}
    			catch (Exception e) {
    				System.out.println(e.getMessage());
    				Clear();
    			}
    		}
    	}
    	
    }                                        
//back Action button
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        new Menu(AccID, bal, pin).setVisible(true);
    	this.dispose();
    }                                        

    private void txtOldPinFocusGained(java.awt.event.FocusEvent evt) {                                      
    	if(txtOldPin.getText().equals("Old PIN")) {
    		txtOldPin.setText("");
    	}
    }  
    
    private void txtOldPinFocusLost(java.awt.event.FocusEvent evt) {                                    
    	if (txtOldPin.getText().trim().equals("") || txtOldPin.getText().trim().toLowerCase().equals("Old PIN")) {
    		txtOldPin.setText("Old PIN");
    	}
    } 
    
    private void confirmPinFocusGained(java.awt.event.FocusEvent evt) {                                       
    	if(String.valueOf(confirmPin.getPassword()).equals("1234")) {
    		confirmPin.setText("");
    	}    
    }  
    
    private void confirmPinFocusLost(java.awt.event.FocusEvent evt) {                                    
    	if (String.valueOf(confirmPin.getPassword()).equals("") || String.valueOf(confirmPin.getPassword()).equals("1234")) {
    		confirmPin.setText("1234");
    	}
    } 
    
    private void txtOldPinKeyTyped(KeyEvent evt) {
		char c = evt.getKeyChar();
	
		if(!Character.isDigit(c)) {
			evt.consume();
		}
	}
    
    private void confirmPinKeyTyped(KeyEvent evt) {
		char c = evt.getKeyChar();
	
		if(!Character.isDigit(c)) {
			evt.consume();
		}
	}


    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {                                     
        System.exit(0);
    }                                    
//changepin Action Button
    private void txtOldPinActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         
//Pinconfirm Action Button
    private void PinconfirmActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                                                          

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {                                      
      btnSubmit.setBackground(new Color(0,0,0));
      btnSubmit.setForeground(new Color(255,255,255));
    }                                     

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {                                     
      btnSubmit.setBackground(new Color(255,255,255));
      btnSubmit.setForeground(new Color(0,0,0));
    }                                    

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {                                      
      btnBack.setForeground(new Color(45, 35, 158));
    }                                     

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {                                     
      btnBack.setForeground(new Color(0,0,0));
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
            java.util.logging.Logger.getLogger(ChangePin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangePin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangePin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangePin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangePin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTextField txtOldPin;
    private javax.swing.JPasswordField confirmPin;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel lblChangePin;
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