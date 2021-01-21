package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;

public class BookDr extends HttpServlet{
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException{
		res.setContentType("text/html;charset=UTF-8");

		try {
		Connection con=DBConn.getConn();
		PrintWriter out=res.getWriter();
		String pt=req.getParameter("Ptname");
		String dr=req.getParameter("Drname");
		int time=Integer.parseInt(req.getParameter("time"));
		String patient="select * from `logininfo` where username=?";
		PreparedStatement ps=con.prepareStatement(patient);
		ps.setString(1,pt);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			String doctor="select * from `doclogininfo` where username=?";
			ps=con.prepareStatement(doctor);
			ps.setString(1, dr);
			rs=ps.executeQuery();
			if(rs.next()) {
				String doctorAvail="select * from `DocAvail` where username=?";
				ps=con.prepareStatement(doctorAvail);
				ps.setString(1, dr);
				rs=ps.executeQuery();
				if(rs.next()) {
					if(rs.getInt("startHour")<=time&&rs.getInt("EndHour")>time) {
						String PtAlrHavBooking="select * from `DrBooked` where `DrBooked`.`PtName`=? AND `DrBooked`.`DrName`=?";
						ps=con.prepareStatement(PtAlrHavBooking);
						ps.setString(1, pt);
						ps.setString(2, dr);
						rs=ps.executeQuery();
						if(rs.next()) {
							if(rs.getInt("BookingTime")==time) {
								out.println("You are already having booking of same doctor at same time");
								RequestDispatcher rd=req.getRequestDispatcher("DisplayAvail.jsp");
								rd.include(req, res);
							}
							else {
								String str="select * from `DrBooked` where `DrBooked`.`PtName`=? AND `DrBooked`.`BookingTime`=? ";
								ps=con.prepareStatement(str);
								ps.setString(1, pt);
								ps.setInt(2, time);
								rs=ps.executeQuery();
								if(rs.next()) {
									out.println("You are already having booking of doctor "+rs.getString("DrName")+" at same time");
									RequestDispatcher rd=req.getRequestDispatcher("DisplayAvail.jsp");
									rd.include(req, res);
								}
								String str2="select * from `DrBooked` where `DrBooked`.`DrName`=? AND `DrBooked`.`BookingTime`=? ";
								ps=con.prepareStatement(str2);
								ps.setString(1, dr);
								ps.setInt(2, time);
								rs=ps.executeQuery();
								if(rs.next())
								{
									out.println("Doctor is already having booking for that time");
									RequestDispatcher rd=req.getRequestDispatcher("DisplayAvail.jsp");
									rd.include(req, res);
								}
								else {
									String str1="UPDATE `DrBooked` SET `DrBooked`.`BookingTime`=? WHERE `DrBooked`.`DrName`=? AND `DrBooked`.`PtName`=?";
									ps=con.prepareStatement(str1);
									ps.setInt(1, time);
									ps.setString(2, dr);
									ps.setString(3, pt);
									ps.executeUpdate();
									out.println("Your booking time with Dr "+dr+" is updated to "+time);
									RequestDispatcher rd=req.getRequestDispatcher("DisplayAvail.jsp");
									rd.include(req, res);
									
								}
							}
						}
						String ifDrBooked="select * from `DrBooked` where `DrBooked`.`BookingTime`=? AND `DrBooked`.`DrName`=?";
						ps=con.prepareStatement(ifDrBooked);
						ps.setInt(1, time);
						ps.setString(2, dr);
						rs=ps.executeQuery();
						if(rs.next()) {
							out.println("Doctor is already having booking for that time");
							RequestDispatcher rd=req.getRequestDispatcher("DisplayAvail.jsp");
							rd.include(req, res);
							
						}
						else {
							String str4="select * from `DrBooked` where `DrBooked`.`PtName`=? AND `DrBooked`.`BookingTime`=? ";
							ps=con.prepareStatement(str4);
							ps.setString(1, pt);
							ps.setInt(2, time);
							rs=ps.executeQuery();
							if(rs.next()) {
								out.println("You are already having booking of doctor "+rs.getString("DrName")+" at same time");
								RequestDispatcher rd=req.getRequestDispatcher("DisplayAvail.jsp");
								rd.include(req, res);
							}
							else {
								String insertPt="INSERT INTO `DrBooked` (`DrName`, `PtName`, `BookingTime`) VALUES (?,?,?);";
								ps=con.prepareStatement(insertPt);
								ps.setString(1, dr);
								ps.setString(2, pt);
								ps.setInt(3, time);
								ps.execute();
								out.println("Your booking with Dr "+dr+" is fixed for time "+time);
								RequestDispatcher rd=req.getRequestDispatcher("DisplayAvail.jsp");
								rd.include(req, res);
							}
						}
					}
					else {
						out.println("Doctor is not available for that time");
						RequestDispatcher rd=req.getRequestDispatcher("DisplayAvail.jsp");
						rd.include(req, res);
					}
				}
				else {
					out.println("Doctor is not available today");
					RequestDispatcher rd=req.getRequestDispatcher("DisplayAvail.jsp");
					rd.include(req, res);
				}
			}
			else {
				out.println("None of the docotor in this clinic have this name");
				RequestDispatcher rd=req.getRequestDispatcher("DisplayAvail.jsp");
				rd.include(req, res);
			}
		}
		else
		{
			out.println("Patient is not registered");
			RequestDispatcher rd=req.getRequestDispatcher("DisplayAvail.jsp");
			rd.include(req, res);
		}
		System.out.println("booked");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
