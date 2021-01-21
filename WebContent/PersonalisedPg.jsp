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
<% String favlang="Java";
	String str="Java";
Cookie theCookies[]=request.getCookies();
if(theCookies!=null)
{
	for(Cookie tempCook:theCookies){
	if("myApp.favLang".equals(tempCook.getName())){
		favlang=tempCook.getValue();
		break;
	}
	}
	if(favlang=="")
	{
		favlang=str;
	}
}
%>
<h4>Your Favourite Language is <%=favlang %></h4>
<hr>
<a href="FavOp.jsp" class="btn cta">change fav Language</a>
</body>
</html>