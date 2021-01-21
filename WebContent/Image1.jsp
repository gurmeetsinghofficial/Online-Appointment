
<%@ page contentType="text/html;charset=windows-1252"%>
<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires",0);
	
	%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Pic</title>
<link rel="stylesheet" type="text/css" href="ButtonCss.css"></link>
<style type="text/css">

</style>
</head>
<body bgcolor="Pink">
	
    <img src="file:///Users/gurmeetsingh/eclipse-workspace/LoginTest/WebContent/image1.png" width="300" height="300"/>
    <%!String a="b"; %>
    <% a=request.getParameter("username"); %>
    <p><%=a %></p><br>
    <br><button onclick="window.location.href='./DisplayImage1.jsp'" class="btn cta">back</button><br>
   <br> <button onclick="window.location.href='./Welcome.html'" class="btn cta">back to welcome page</button>
</body>
</html> 
