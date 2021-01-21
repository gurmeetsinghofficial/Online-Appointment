package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@MultipartConfig(maxFileSize = 16177216)
public class Sign extends HttpServlet{

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	 {
	  try {
		  res.setContentType("text/html;charset=UTF-8");
		  Part part=req.getPart("image");
		  InputStream is=part.getInputStream();
		  System.out.println("hello sign");
		  String uname=req.getParameter("username");
		  Connection con=DBConn.getConn();
		  Statement st=con.createStatement();
		  String str="SELECT * FROM `userinfo` WHERE username='"+uname+"'";
		  ResultSet rs=st.executeQuery(str);
		  //System.out.println("hello dis");
		  PrintWriter out=res.getWriter();
		  if(rs.next())
		  {
			  out.println("You are already having account better login");
			   RequestDispatcher rd=req.getRequestDispatcher("login.html");
			   rd.include(req,res);
			   
		  }
		  else
		  {
			  String name=req.getParameter("name");
			  String pass=req.getParameter("password");
			  String occ=req.getParameter("occupation");
			  String gender=req.getParameter("sex");
			  int sal=Integer.parseInt(req.getParameter("salary"));
			  int age=Integer.parseInt(req.getParameter("age"));
			  str="INSERT INTO `userinfo` (`username`, `name`, `gender`, `age`, `occupation`, `salary`, `password`,`image`) VALUES ('"+uname+"', '"+name+"', '"+gender+"', '"+age+"', '"+occ+"', '"+sal+"', '"+pass+ "','" +is+"');";
		
			  String str1="INSERT INTO `logininfo` (`username`, `password`) VALUES ('"+uname+"', '"+pass+"');";
			  Statement st1=con.createStatement();
			  st1.executeUpdate(str);
			  Statement st2=con.createStatement();
			  st2.executeUpdate(str1);
			  out.println("Your account is created now you can login");
			   RequestDispatcher rd=req.getRequestDispatcher("login.html");
			   rd.include(req,res);
			   
		  }
	  }
	  catch(Exception e)
	  {
		  System.out.println(e);
	  }
	 }
}
