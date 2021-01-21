package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayServlet1 extends HttpServlet {

 protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
 {
  try {
	  System.out.println("hello dis");
	  String uname=req.getParameter("username");
	  Connection con=DBConn.getConn();
	  Statement st=con.createStatement();
	  String str="SELECT * FROM `Docuserinfo` WHERE username='"+uname+"'";
	  ResultSet rs=st.executeQuery(str);
	  System.out.println("hello dis");
	  PrintWriter out=res.getWriter();
	  if(rs.next())
	  {
		  
		  out.println("<html><head><style>table, th, td {border: 1px solid blue;border-collapse: collapse; color:white;background-color:black}</style></head><body bgcolor=yellow><table border='1' cellpadding='10' cellspacing='10'><tr><td>Welcome: </td><td></td></tr>"+"<tr><td>Name ->     </td><td>"+rs.getString(1)+"</td></tr><tr><td>UserName -> </td><td>"+" "+rs.getString(2)+"</td></tr><tr><td>Gender ->    </td><td>"+rs.getString(3)+"</td></tr><tr><td>Age ->      </td><td>"+rs.getInt(4)+"</td></tr><tr><td>Occupation -> </td><td>"+rs.getString(5)+"</td></tr><tr><td>Salary ->    </td><td>"+rs.getInt(6)+"</td></tr><tr><td>Image</td><td>"+rs.getBlob(7)+"</td></tr></table><br><p>Click here to see image <button onclick='window.location.href=(`./DisplayImage1.jsp`)'>image</button></p><p>Click here to make changes in available hours<button onclick='window.location.href=(`./Avail.jsp`)'>changes</button></p><p>Click here to see your bookings<button onclick='window.location.href=(`./SeeBookedPt.jsp`)'>check appointments</button></p></body></html>");
	  }
  }
  catch(Exception e)
  {
	  System.out.println(e);
  }
 }
}