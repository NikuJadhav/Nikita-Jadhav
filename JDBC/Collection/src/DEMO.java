import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

class DEMO
{
	public static void main(String [] args)
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");	
		
		PreparedStatement pstmt=(PreparedStatement) con.prepareStatement("update  emp set EmpName=? where EmpId=110 ");
		pstmt.setString(1, "Pratiksha");
		
		
		
		int i=pstmt.executeUpdate();
		//System.out.println(i);
		
		ResultSet rs=pstmt.executeQuery("select * from emp");
		while(rs.next())
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
		
		con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	} 	
}





