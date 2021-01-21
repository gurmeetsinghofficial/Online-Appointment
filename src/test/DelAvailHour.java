package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class DelAvailHour extends HttpServlet{
	 Connection con=DBConn.getConn();
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		try {
			res.setContentType("text/html;charset=UTF-8");
			String uname=req.getParameter("docName");
			String pass=req.getParameter("docPass");
				Statement stat=con.createStatement();
				String str="SELECT * FROM `DocAvail` WHERE username='"+uname+"' and password='"+pass+"'";
				  ResultSet rs=stat.executeQuery(str);
					System.out.println(str);
				  if(rs.next()) {
					  String str1="DELETE FROM `DocAvail` WHERE `DocAvail`.`username` ='"+uname+"' and password='"+pass+"'";
					  PrintWriter out=res.getWriter();
					  out.println("Your working hours have been deleted successfully");
					  stat.executeUpdate(str1);
					  RequestDispatcher rd=req.getRequestDispatcher("DelAvailHour.jsp");
					  rd.include(req, res);  
				  }
				  else
				  {
					  	PrintWriter out=res.getWriter();
						out.println("Invalid userName or Password");
						RequestDispatcher rd=req.getRequestDispatcher("DelAvailHour.jsp");
						rd.include(req, res);  
				  }
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
