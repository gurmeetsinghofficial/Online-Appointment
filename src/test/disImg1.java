package test;

import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class disImg1 extends HttpServlet{
	@SuppressWarnings("resource")
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	 {
		res.setContentType("text/html;charset=UTF-8");
		  try{
		Connection con=DBConn.getConn();
		System.out.println("No");
		File file=new File("/Users/gurmeetsingh/eclipse-workspace/LoginTest/WebContent/image1.png");
		System.out.println("No user");
		FileOutputStream fos=new FileOutputStream(file);
		byte b[];
		Blob blob;
		String uname=req.getParameter("username");
		PreparedStatement ps=con.prepareStatement("select * from `Docuserinfo` where `username`='"+uname+"';"); 
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
		     int i=1;
			FileOutputStream fs=null;
			File f=new File("/Users/gurmeetsingh/eclipse-workspace/LoginTest/WebContent/image1.png");
		     fs=new FileOutputStream(f);
		      blob=rs.getBlob("image");
		      b=blob.getBytes(1, (int)blob.length());
		      fs.write(b);
//		      BufferedImage img=ImageIO.read(f);
//		      ImageIO.write(img, "PNG", f);
		      RequestDispatcher rd=req.getRequestDispatcher("Image1.jsp");
		      rd.include(req, res);
					//System.out.println("if"+b);
//					blob=rs.getBlob("image");
//					b=blob.getBytes(1,(int)blob.length());
//					fos.write(b);
//					System.out.println("if1");
		}
		else
		{
			PrintWriter out=res.getWriter();
			out.println("No such user exist<br>Enter existing user Name <br>or<br>Create Account");
			RequestDispatcher rd=req.getRequestDispatcher("DisplayImage1.jsp");
			rd.include(req, res);
		}
		ps.close();
		fos.close();
		con.close();
	}catch(Exception e){
			e.printStackTrace();
		}
	 }
}