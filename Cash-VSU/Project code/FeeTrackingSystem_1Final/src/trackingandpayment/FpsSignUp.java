/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trackingandpayment;

import java.sql.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.NoSuchAlgorithmException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;


public class FpsSignUp {
	
	JFrame frame;
	private JPanel contentPane;
	private JTextField StudNumBar;
	private JTextField FirstNameBar;
	private JTextField LastNameBar;
	private JTextField MiddleNameBar;
	private JLabel lblAge;
	private JTextField AgeBar;
	private JTextField CourseBar;
	private JTextField SectionBar;
	private JTextField EmailBar;
	private JPasswordField PasswordBar;		
	private JPanel panel_1;
	private JLabel lblbgSignup;
	private JButton btnSignUp;
	private JButton btnLogin;
	private JLabel lblLogin;
	
	private String algorithm = "SHA-256";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FpsSignUp window = new FpsSignUp();
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
	public FpsSignUp() {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);		
                frame.setTitle("Cash-VSU");
                frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons/MainIcon.png")));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 815, 491);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(60, 179, 113));
		panel.setBounds(0, 0, 322, 454);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblBG = new JLabel("");
		lblBG.setBounds(-17, 0, 339, 509);
		lblBG.setIcon(new ImageIcon(FpsSignUp.class.getResource("/icons/BG.png")));
		panel.add(lblBG);
		
		panel_1 = new JPanel();
		panel_1.setBounds(321, 0, 480, 454);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		btnSignUp = new JButton("SIGN UP");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FpsHashing h = new FpsHashing();
				
				String pw = String.valueOf(PasswordBar.getPassword());
				String hashed = null;				
				
				if (verifyFields() == false) {
					JOptionPane.showMessageDialog(frame, "Missing Information!");					
				}
				else if(StudNumBar.getText().length() != 9 ) {
					JOptionPane.showMessageDialog(frame, "Student Number is invalid!");
					StudNumBar.setText("");
				}
				else if (pw.length() < 8) {
					JOptionPane.showMessageDialog(frame, "Password is too short.");
					PasswordBar.setText("");
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
						String query = "INSERT INTO tbl_user (StudentNum, FirstName, LastName, MiddleName, Course, Section, Email, Password, Age) "
									 + "VALUES (?,?,?,?,?,?,?,?,?)";
						PreparedStatement Add = conn.prepareStatement(query);
						Add.setInt(1, Integer.parseInt(StudNumBar.getText()));
						Add.setString(2, FirstNameBar.getText());
						Add.setString(3, LastNameBar.getText());
						Add.setString(4, MiddleNameBar.getText());
						Add.setString(5, CourseBar.getText());
						Add.setString(6, SectionBar.getText());
						Add.setString(7, EmailBar.getText());
						Add.setString(8, hashed);
                                                Add.setInt(9, Integer.parseInt(AgeBar.getText()));
						
						// insert the values to table
                                                Add.executeUpdate();
                                                JOptionPane.showMessageDialog(frame, "Succesful account creation.");
                                                Clear();
                                                conn.close();
					}
					catch(java.sql.SQLException ex ) {
                                            // error code for duplicate entry
                                            if (ex.getErrorCode() == 1062) {
                                                    JOptionPane.showMessageDialog(frame, "Student Number already signed up.");
                                            StudNumBar.setText("");
                                            }
                                            else {
                                                    JOptionPane.showMessageDialog(frame, ex);
                                                    Clear();
                                            }
					}
				}
			}
		});
		btnSignUp.setBorder(new LineBorder(new Color(0, 0, 0)));                
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
		
		btnLogin = new JButton("LOG IN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FpsLogin lg = new FpsLogin();
				lg.frame.setVisible(true);
				lg.frame.setLocationRelativeTo(frame);
				frame.dispose();
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
		
		lblLogin = new JLabel("Already have an account?");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setForeground(Color.BLACK);
		lblLogin.setFont(new Font("Gill Sans MT", Font.ITALIC, 14));
		lblLogin.setBounds(251, 351, 170, 25);
		panel_1.add(lblLogin);
		btnLogin.setForeground(new Color(0, 51, 0));
		btnLogin.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		btnLogin.setFocusPainted(false);
		btnLogin.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnLogin.setBackground(new Color(230, 248, 221));
		btnLogin.setBounds(268, 379, 133, 35);
                btnLogin.setBorderPainted(false);
		panel_1.add(btnLogin);
		btnSignUp.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		btnSignUp.setBounds(81, 379, 133, 35);
		btnSignUp.setBackground(new Color(230, 248, 221));
		btnSignUp.setForeground(new Color(0, 51, 0));
		btnSignUp.setFocusPainted(false);
                btnSignUp.setBorderPainted(false);
		panel_1.add(btnSignUp);
		
		JLabel lblStudentNum = new JLabel("STUDENT NUMBER:");
		lblStudentNum.setBounds(43, 23, 180, 14);
		panel_1.add(lblStudentNum);
		lblStudentNum.setForeground(Color.BLACK);
		lblStudentNum.setBackground(Color.WHITE);
		lblStudentNum.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		
		StudNumBar = new JTextField();
		StudNumBar.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		StudNumBar.setBounds(43, 43, 180, 35);
		panel_1.add(StudNumBar);
		StudNumBar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if(!Character.isDigit(c)) {
					e.consume();
				}
			}
		});
		StudNumBar.setForeground(Color.BLACK);
		StudNumBar.setBackground(Color.WHITE);
		StudNumBar.setColumns(10);
		
		JLabel lblFirstName = new JLabel("FIRST NAME:");
		lblFirstName.setBounds(43, 89, 126, 14);
		panel_1.add(lblFirstName);
		lblFirstName.setForeground(Color.BLACK);
		lblFirstName.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		
		FirstNameBar = new JTextField();
		FirstNameBar.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		FirstNameBar.setBounds(43, 106, 180, 35);
		panel_1.add(FirstNameBar);
		FirstNameBar.setForeground(Color.BLACK);
		FirstNameBar.setBackground(Color.WHITE);
		FirstNameBar.setColumns(10);
		
		JLabel lblMiddleName = new JLabel("MIDDLE NAME:");
		lblMiddleName.setBounds(43, 152, 126, 14);
		panel_1.add(lblMiddleName);
		lblMiddleName.setForeground(Color.BLACK);
		lblMiddleName.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		
		MiddleNameBar = new JTextField();
		MiddleNameBar.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		MiddleNameBar.setBounds(43, 171, 180, 35);
		panel_1.add(MiddleNameBar);
		MiddleNameBar.setForeground(Color.BLACK);
		MiddleNameBar.setBackground(Color.WHITE);
		MiddleNameBar.setColumns(10);
		
		lblAge = new JLabel("AGE:");
		lblAge.setBounds(266, 152, 126, 14);
		panel_1.add(lblAge);
		lblAge.setForeground(Color.BLACK);
		lblAge.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		
		AgeBar = new JTextField();
		AgeBar.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		AgeBar.setBounds(266, 171, 180, 35);
		panel_1.add(AgeBar);
                AgeBar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if(!Character.isDigit(c)) {
					e.consume();
				}
			}
		});
		AgeBar.setForeground(Color.BLACK);
		AgeBar.setBackground(Color.WHITE);
		AgeBar.setColumns(10);
		
		JLabel lblCourse = new JLabel("COURSE:");
		lblCourse.setBounds(43, 217, 71, 14);
		panel_1.add(lblCourse);
		lblCourse.setForeground(Color.BLACK);
		lblCourse.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		
		CourseBar = new JTextField();
		CourseBar.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		CourseBar.setBounds(43, 233, 180, 35);
		panel_1.add(CourseBar);
		CourseBar.setForeground(Color.BLACK);
		CourseBar.setBackground(Color.WHITE);
		CourseBar.setColumns(10);
		
		JLabel lblSection = new JLabel("SECTION:");
		lblSection.setBounds(267, 217, 126, 14);
		panel_1.add(lblSection);
		lblSection.setForeground(Color.BLACK);
		lblSection.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		
		SectionBar = new JTextField();
		SectionBar.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		SectionBar.setBounds(266, 233, 180, 35);
		panel_1.add(SectionBar);
		SectionBar.setForeground(Color.BLACK);
		SectionBar.setBackground(Color.WHITE);
		SectionBar.setColumns(10);
		
		JLabel lblEmail = new JLabel("EMAIL:");
		lblEmail.setBounds(43, 279, 126, 14);
		panel_1.add(lblEmail);
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		
		EmailBar = new JTextField();
		EmailBar.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		EmailBar.setBounds(43, 295, 180, 35);
		panel_1.add(EmailBar);
		EmailBar.setForeground(Color.BLACK);
		EmailBar.setBackground(Color.WHITE);
		EmailBar.setColumns(10);
		
		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setBounds(266, 23, 126, 14);
		panel_1.add(lblPassword);
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		lblPassword.setBackground(Color.WHITE);
		
		LastNameBar = new JTextField();
		LastNameBar.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		LastNameBar.setBounds(266, 106, 180, 35);
		panel_1.add(LastNameBar);
		LastNameBar.setForeground(Color.BLACK);
		LastNameBar.setColumns(10);
		LastNameBar.setBackground(Color.WHITE);
		
		JLabel lblLastName = new JLabel("LAST NAME:");
		lblLastName.setBounds(266, 89, 126, 14);
		panel_1.add(lblLastName);
		lblLastName.setForeground(Color.BLACK);
		lblLastName.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		
		PasswordBar = new JPasswordField();
		PasswordBar.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		PasswordBar.setBounds(266, 43, 180, 35);
		panel_1.add(PasswordBar);
		PasswordBar.setForeground(Color.BLACK);
		PasswordBar.setBackground(Color.WHITE);
		
		lblbgSignup = new JLabel("");
		lblbgSignup.setBounds(-25, 0, 518, 464);
		lblbgSignup.setIcon(new ImageIcon(FpsSignUp.class.getResource("/icons/bgLogin.jpg")));
		panel_1.add(lblbgSignup);
	}
	
	private boolean verifyFields() {
		if (StudNumBar.getText().isEmpty() || FirstNameBar.getText().isEmpty() || LastNameBar.getText().isEmpty() || 
			MiddleNameBar.getText().isEmpty() || lblAge.getText().isEmpty() || AgeBar.getText().isEmpty() || CourseBar.getText().isEmpty() || 
			SectionBar.getText().isEmpty() || EmailBar.getText().isEmpty() || String.valueOf(PasswordBar.getPassword()).isEmpty()) 
		{
			return false;		
		}
		else {
			return true;
		}
	}
	
	private void Clear() {
		StudNumBar.setText("");
		FirstNameBar.setText("");
		LastNameBar.setText("");
		MiddleNameBar.setText("");
		lblAge.setText("");
		AgeBar.setText("");
		CourseBar.setText("");
		SectionBar.setText("");
		EmailBar.setText("");
		PasswordBar.setText("");
	}
}
