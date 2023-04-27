/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trackingandpayment;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class FpsLogin {
	
	JFrame frame;
	private JPanel contentPane;
	private JTextField StudNumBar;
	private JPasswordField PasswordBar;
	
	private final String algorithm = "SHA-256";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(FpsHomeSection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(FpsHomeSection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(FpsHomeSection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(FpsHomeSection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FpsLogin window = new FpsLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});                     
	}
	
	/**
	 * Create the application.
	 */
	public FpsLogin() {
		initialize();		
	}

	/**
	 * Create the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
                frame.setTitle("Cash-VSU");
                frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons/MainIcon.png")));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 815, 491);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setForeground(Color.WHITE);
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(Color.WHITE);
		contentPane_1.setBounds(0, 0, 799, 466);
		contentPane.add(contentPane_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(60, 179, 113));
		panel.setBounds(0, 0, 322, 487);
		contentPane_1.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(-17, 0, 339, 509);
		lblNewLabel_1.setIcon(new ImageIcon(FpsLogin.class.getResource("/icons/BG.png")));
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(FpsLogin.class.getResource("/icons/BG.png")));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(322, 0, 477, 456);
		contentPane_1.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnLogin = new JButton("LOG IN");
		btnLogin.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        FpsHashing h = new FpsHashing();

                        String pw = String.valueOf(PasswordBar.getPassword());
                        String hashed = null;

                        if (verifyFields() == false) {
                                JOptionPane.showMessageDialog(frame, "Missing Information!");
                        }
                        else {
                                try {
                                        hashed = h.hashPassword(pw, algorithm);
                                } catch (NoSuchAlgorithmException e1) {
                                        e1.printStackTrace();
                                }

                                Connection conn = null;

                                try {
                                // connect to database
                                conn = FpsDBConnection.dbConnect();
                                String query = "SELECT * FROM tbl_user WHERE StudentNum = ? and Password = ?";

                                PreparedStatement ps = conn.prepareStatement(query);   			
                                ps.setString(1, StudNumBar.getText());
                                ps.setString(2, hashed);

                                ResultSet rs = ps.executeQuery();

                                // if a result set is retrieved then the account exists
                                // and will show the Home Section
                                if (rs.next()) {
                                        String studName = rs.getString(2);
                                        int studNum = rs.getInt(1);
                                        new FpsHomeSection(studNum, studName).setVisible(true);                                            
                                        frame.dispose();
                                }
                                else {
                                        JOptionPane.showMessageDialog(frame,  "Wrong Student Number or Password");
                                        Clear();
                                }

                                conn.close();
                                }

                                catch(Exception ex) {
                                        JOptionPane.showMessageDialog(frame,  ex);
                                }
                        }
                    }
		});
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogin.setBackground(new Color(0, 51, 0));
				btnLogin.setForeground(new Color(230, 248, 221));			
				btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnLogin.setBackground(new Color(230, 248, 221));
				btnLogin.setForeground(new Color(0, 51, 0));
				btnLogin.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		                
		JLabel lblCreateAcc = new JLabel("Don't have an account yet?");
		lblCreateAcc.setForeground(Color.BLACK);
		lblCreateAcc.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateAcc.setFont(new Font("Gill Sans MT", Font.ITALIC, 14));
		lblCreateAcc.setBounds(163, 268, 170, 25);
		panel_1.add(lblCreateAcc);
		btnLogin.setForeground(new Color(0, 51, 0));
		btnLogin.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		btnLogin.setFocusPainted(false);
                btnLogin.setBorderPainted(false);
		btnLogin.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnLogin.setBackground(new Color(230, 248, 221));
		btnLogin.setBounds(178, 363, 133, 35);
		panel_1.add(btnLogin);
		
		JButton btnSignUp = new JButton("SIGN UP");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FpsSignUp su = new FpsSignUp();
				su.frame.setVisible(true);
				su.frame.setLocationRelativeTo(frame);
				frame.dispose();
			}
		});
		btnSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSignUp.setBackground(new Color(0, 51, 0));
				btnSignUp.setForeground(new Color(230, 248, 221));			
				btnSignUp.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSignUp.setBackground(new Color(230, 248, 221));
				btnSignUp.setForeground(new Color(0, 51, 0));
				btnSignUp.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		btnSignUp.setForeground(new Color(0, 51, 0));
		btnSignUp.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		btnSignUp.setFocusPainted(false);
                btnSignUp.setBorderPainted(false);
		btnSignUp.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnSignUp.setBackground(new Color(230, 248, 221));
		btnSignUp.setBounds(178, 303, 133, 35);
		panel_1.add(btnSignUp);
		
		JLabel lblStudentNum = new JLabel("STUDENT NUMBER:");
		lblStudentNum.setBounds(103, 85, 179, 14);
		panel_1.add(lblStudentNum);
		lblStudentNum.setForeground(Color.BLACK);
		lblStudentNum.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		lblStudentNum.setBackground(Color.WHITE);
		
		StudNumBar = new JTextField();
		StudNumBar.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		StudNumBar.setBounds(103, 110, 286, 35);
                StudNumBar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if(!Character.isDigit(c)) {
					e.consume();
				}
			}
		});
		panel_1.add(StudNumBar);
		StudNumBar.setForeground(Color.BLACK);
		StudNumBar.setColumns(10);
		StudNumBar.setBackground(Color.WHITE);
		
		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setBounds(109, 169, 87, 14);
		panel_1.add(lblPassword);
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		
		PasswordBar = new JPasswordField();
		PasswordBar.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		PasswordBar.setBounds(103, 193, 286, 35);
		panel_1.add(PasswordBar);
		PasswordBar.setForeground(Color.BLACK);
		PasswordBar.setBackground(Color.WHITE);
		
		JLabel lblbgLogin = new JLabel("");
		lblbgLogin.setBounds(0, 0, 477, 456);
		lblbgLogin.setIcon(new ImageIcon(FpsLogin.class.getResource("/icons/bgLogin.jpg")));
		panel_1.add(lblbgLogin);
	}
	
	private boolean verifyFields() {
		if (StudNumBar.getText().isEmpty() || String.valueOf(PasswordBar.getPassword()).isEmpty()) {
			return false;		
		}
		else {
			return true;
		}
	}
	
	private void Clear() {
		StudNumBar.setText("");
		PasswordBar.setText("");
	}
}
