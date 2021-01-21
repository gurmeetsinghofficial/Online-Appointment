package test;

import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;

public class ChangePass3 extends HttpServlet{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
	{
		try
		{
			 res.setContentType("text/html;charset=UTF-8");
			Connection con=DBConn.getConn();
			Statement st=con.createStatement();
			String pass=req.getParameter("pass");
			String pass1=req.getParameter("pass1");
			String uname=req.getParameter("uname");
			String str="SELECT * FROM `Docuserinfo` WHERE `password`='"+pass+"'AND `username`='"+uname+"';";
			ResultSet rs=st.executeQuery(str);
			if(rs.next())
			{
				if(!pass.equals(pass1))
				{
					String str1="UPDATE `Docuserinfo` SET `password` = '"+pass1+"' WHERE `Docuserinfo`.`password` = '"+pass+"'AND `Docuserinfo`.`username` ='"+uname+"';";
					String str2="UPDATE `Doclogininfo` SET `password` = '"+pass1+"' WHERE `Doclogininfo`.`password` = '"+pass+"'AND `Doclogininfo`.`username` ='"+uname+"';";
					st.executeUpdate(str1);
					st.executeUpdate(str2);
					PrintWriter out=res.getWriter();
					out.println("Password updated successfully<br> now you can login with new password");
					RequestDispatcher rd=req.getRequestDispatcher("login1.html");
					rd.include(req, res);
				}
				else
				{
					PrintWriter out=res.getWriter();
					out.println("Can't set old pass as new pass");
					RequestDispatcher rd=req.getRequestDispatcher("forgot3.html");
					rd.include(req, res);
				}
			}
			else
			{
				PrintWriter out=res.getWriter();
				out.println("Wrong old pass or username");
				RequestDispatcher rd=req.getRequestDispatcher("forgot3.html");
				rd.include(req, res);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
