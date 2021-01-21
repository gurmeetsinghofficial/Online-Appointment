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
<%
	String favLang1=request.getParameter("favLang");
Cookie theCookie=new Cookie("myApp.favLang",favLang1);
theCookie.setMaxAge(60*60*24*365);
response.addCookie(theCookie);
%>
We have set Your Favourite Language to:- ${param.favLang}<br><br>
<a href="PersonalisedPg.jsp" class="btn cta bg">See your selected option</a>
</body>
</html>