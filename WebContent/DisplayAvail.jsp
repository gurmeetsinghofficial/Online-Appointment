<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="ButtonCss.css"></link>
</head>
<body>
<br><br>
hello
<br><br>
<%@ page import="java.sql.*" %>
<%
Connection con=null;
try
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
}
catch(Exception e)
{
	System.out.println(e);
	System.out.println("hello");
}
String str="select * from `DocAvail`"; 
Statement st=con.createStatement();
ResultSet rs=st.executeQuery(str);%>
<table border=1>
<tr><th>Name</th><th>Sitting time</th><th>leaving time</th></tr>
<%
while(rs.next())
{
%>
<tr><td><%=rs.getString(1) %></td>
<td><%=rs.getInt(3) %></td>
<td><%=rs.getInt(4) %></td></tr>
<%} %>
</table>
<%rs.close();
	st.close();
	con.close();
%>
<br><br>
Enter Doctor's detail you want to get appointment of:-)<br><br>
<form action="BookDr" method="post">
Patient's Name<input name="Ptname" required><br>
Doctor's Name<input name="Drname" required><br>
Enter Booking Time<input type="number" name="time" min="1" max="24" required>
<button type="submit" class="btn cta">book doctor</button>
</form><br><br>
<button onClick="window.location.href='./WhichLogin.html'" class="btn cta">login</button>

<button onClick="window.location.href='./Welcome.html'" class="btn cta">Welcome page</button>
</body>
</html>