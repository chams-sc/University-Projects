package atm_machine;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection dbConnect() {
		
		// tries to connect to db location
		try {
            Class.forName("com.mysql.jdbc.Driver");
            // conn will try to access db
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/atmdb","root", "");
            return conn;
        }
        catch(Exception e) {
        	System.err.println("Got an exception!");
            System.err.println(e.getMessage());
            return null;
       }
	}
}
