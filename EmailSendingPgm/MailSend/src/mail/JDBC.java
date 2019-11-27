package mail;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class JDBC
{

	public static void main(String[] args)
	{
		try 
		{

			Connection con = ConnectionUtils.getConnection(); // 3.Create Statement
			Statement st = con.createStatement();
			// 4.Execute Query
			ResultSet rs = st.executeQuery("select * from emp");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + "  " + rs.getString(4));
				EmailUtils.send(rs.getString(4).toString(), "test mail", "Welcome to Advance Java Class");
			}
			// 5.Close The Connection
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
