package mail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionUtils 
{

	public static Connection getConnection() throws IOException,FileNotFoundException
	{
		FileInputStream fis= new FileInputStream("F:\\config.properties");
		Properties properties= new Properties();
		properties.load(fis);
		String DBUSER=properties.getProperty("dbuser");
		String DBPASS=properties.getProperty("dbpassword");
		
		Connection con = null;
		try {
			// 1.Load Drivers
			Class.forName("com.mysql.jdbc.Driver");
			// 2.Create Connection Object
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", DBUSER, DBPASS);
			System.out.println("Connnected to DB");
		} catch (Exception e) {
			System.out.println("Conection Failed");
		}
		return con;
	}
	/*public static void main(String[] args) throws IOException {
		
		ConnectionUtils.getConnection();
	}*/
	
	
	
	
}

