package test;

import javax.servlet.http.HttpServlet;

import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;

public class ChangePass2 extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			 res.setContentType("text/html;charset=UTF-8");
			Connection con=DBConn.getConn();
			Statement st=con.createStatement();
			String uname=req.getParameter("uname");
			int age=Integer.parseInt(req.getParameter("age"));
			String str="( SELECT * FROM `Docuserinfo` WHERE `username` LIKE '"+uname+"' AND `age` ="+age+");";
			ResultSet rs=st.executeQuery(str);
			if(rs.next())
			{
				PrintWriter out=res.getWriter();
				out.println("correct details");
				RequestDispatcher rd=req.getRequestDispatcher("forgot3.html");
				rd.include(req, res);
			}
			else
			{
				PrintWriter out=res.getWriter();
				out.println("Username with that age doesn't exist<br>Enter correct details");
				RequestDispatcher rd=req.getRequestDispatcher("forgot2.html");
				rd.include(req, res);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
