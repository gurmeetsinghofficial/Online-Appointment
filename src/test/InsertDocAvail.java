package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class InsertDocAvail extends HttpServlet{
	 Connection con=DBConn.getConn();
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		try {
			res.setContentType("text/html;charset=UTF-8");
			String uname=req.getParameter("docName");
			String pass=req.getParameter("docPass");
			String time=req.getParameter("time");
			System.out.println(time.substring(0,2)+" "+time.substring(4,6));
			int st=Integer.parseInt(time.substring(0,2));
			int end=Integer.parseInt(time.substring(4,6));
			if(st>=0&&st<25&&end>=0&&end<25&&st<end) {
				Statement stat=con.createStatement();
				  String str1="SELECT * FROM `DocAvail` WHERE username='"+uname+"' and password='"+pass+"'";
				String str="SELECT * FROM `Doclogininfo` WHERE username='"+uname+"' and password='"+pass+"'";
				  ResultSet rs=stat.executeQuery(str);
					System.out.println(str);
				  if(rs.next()) {
					  ResultSet rs1=stat.executeQuery(str1);
					  if(rs1.next()) {
						  String update="UPDATE `DocAvail` SET `startHour` = '"+st+"', `EndHour` = '"+end+"' WHERE `DocAvail`.`username` = '"+uname+"'";
						  PrintWriter out=res.getWriter();
							out.println("Your working hours have been updated successfully");
						  stat.executeUpdate(update);
							RequestDispatcher rd=req.getRequestDispatcher("EnterAvailHour.jsp");
							rd.include(req, res);
					  }
					  else {
						  PrintWriter out=res.getWriter();
							out.println("Your working hours added successfully");
							String insert="INSERT INTO `DocAvail` (`username`, `password`, `startHour`, `EndHour`) VALUES ('"+ uname+"', '"+ pass+"', '"+ st+"', '"+ end+"')";
							stat.executeUpdate(insert);
							RequestDispatcher rd=req.getRequestDispatcher("EnterAvailHour.jsp");
							rd.include(req, res);
					  }  
				  }
				  else
				  {
					  	PrintWriter out=res.getWriter();
						out.println("Invalid userName or Password");
						RequestDispatcher rd=req.getRequestDispatcher("EnterAvailHour.jsp");
						rd.include(req, res);  
				  }
			}
			else
			{
				PrintWriter out=res.getWriter();
				out.println("Enter valid hours");
				RequestDispatcher rd=req.getRequestDispatcher("EnterAvailHour.jsp");
				rd.include(req, res);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
