package test;

import java.sql.Connection;
import java.sql.DriverManager;
public class DBConn {
	public static Connection getConn()
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
		}
		catch(Exception e)
		{
			System.out.println(e);
			System.out.println("hello");
		}
		return con;
	}
}
