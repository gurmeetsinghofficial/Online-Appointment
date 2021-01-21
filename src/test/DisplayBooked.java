package test;

import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.http.*;

public class DisplayBooked extends HttpServlet{
	protected void doPost(HttpServletRequest req,HttpServletResponse res){
		try {
		Connection con=DBConn.getConn();
		String name=req.getParameter("name");
		String str="select * from `DrBooked` where `DrBooked`.`DrName`=? ORDER BY `DrBooked`.`BookingTime`";
		PreparedStatement ps=con.prepareStatement(str);
		PrintWriter out=res.getWriter();
		ps.setString(1,name );
		ResultSet rs=ps.executeQuery();
		out.println("<table border='1'><tr><th>Patient Name</th><th>Booking Time</th></tr>");
		while(rs.next()) {
			out.println("<tr><td>"+rs.getString("PtName")+"</td><td>"+rs.getString("BookingTime")+"</td></tr>");
		}
		out.println("</table><br><br><button onclick='window.location.href=(`./Welcome.html`)'>back to Welcome Page</button><br><br><button onclick='window.location.href=(`./SeeBookedPt.jsp`)'>back </button>");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
