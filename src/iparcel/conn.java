package iparcel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conn{
	public static Connection initializeDatabase() 
		throws SQLException, ClassNotFoundException{
		
		String dbDriver = "com.mysql.jdbc.Driver";
        String dbURL = "jdbc:mysql://localhost:3306/"; 
        // Database name to access 
        String dbName = "iparcel"; 
        String dbUsername = "root"; 
        String dbPassword = ""; 
  
		
        Class.forName(dbDriver); 
        Connection conn = DriverManager.getConnection(dbURL + dbName, 
                                                     dbUsername,  
                                                     dbPassword); 
        return conn; 
	}

}