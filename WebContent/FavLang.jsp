<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
student name is:- <%=request.getParameter("firstname")+" "+request.getParameter("lastname") %><br><br>
${param.firstname} 's
Favourite Language is=> <%=request.getParameter("favLang") %><br><br>
Your Seleceted State is :-${param.state }
<br><br>If multiple Languages Selected<br><br>
Gender => ${param.gen}
<ul>
<%
String lang[]=request.getParameterValues("favLang");
for(String l:lang)
{
	out.println("<li>"+l+"</li>");
}
%>
</ul>
</body>
</html>