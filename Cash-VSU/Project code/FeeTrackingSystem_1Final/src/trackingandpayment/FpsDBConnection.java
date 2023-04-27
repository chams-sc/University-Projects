/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trackingandpayment;

import java.sql.*;

public class FpsDBConnection {
	public static Connection dbConnect() {
		
		// tries to connect to db location
		try {
            Class.forName("com.mysql.jdbc.Driver");
            // conn will try to access db
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/fee_paymentsys","root", "");
            return conn;
        }
        catch(ClassNotFoundException | java.sql.SQLException e) {
            System.err.println(e.getMessage());
            return null;
       }
	}
}

