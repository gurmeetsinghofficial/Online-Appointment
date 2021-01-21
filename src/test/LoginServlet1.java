package test;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;


public class LoginServlet1 extends HttpServlet {
 Connection con=DBConn.getConn();
 protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
  {
   // TODO Auto-generated method stub 
	 try {
	 res.setContentType("text/html;charset=UTF-8");

  String uname=req.getParameter("username");
  String pwd=req.getParameter("password");
  Statement st=con.createStatement();
  String str="SELECT * FROM `Doclogininfo` WHERE username='"+uname+"' and password='"+pwd+"'";
  System.out.println("hi "+str);
  ResultSet rs=st.executeQuery(str);
  //if(uname.equals("kamal") && pwd.equals("12345"))
  if(rs.next())
  {
	  System.out.println("hello"+rs);
   RequestDispatcher rd=req.getRequestDispatcher("gaurav3");
   rd.forward(req,res);
  }
  else
  {
   PrintWriter out=res.getWriter();
   out.println("User name or password is incorrect");
   RequestDispatcher rd=req.getRequestDispatcher("login1.html");
   rd.include(req,res);
   
  }
	 }
	 catch(Exception e)
	 {
		 System.out.println(e);
	 }
  
  }
  
 

}
//SELECT * FROM `logininfo` WHERE username='gurug' and password='gurug'