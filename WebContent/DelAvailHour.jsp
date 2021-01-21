<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="ButtonCss.css"></link>
<style>
input{
	padding:10px;
	border-raduis:4px;
	font-size:25px;
}
</style>
</head>
<body>
<form action="DelAvailHour" method="post">
Name
<input type="text" name="docName" required><br><br>
Password
<input type="password" name="docPass" required><br><br>
<button type="submit" class="btn cta">submit</button>
</form>
<br><br>
<button onClick="window.location.href='./Avail.jsp'" class="btn cta">back</button>
<button onClick="window.location.href='./Whichlogin.html'" class="btn cta">Login page</button>
<button onClick="window.location.href='./Welcome.html'" class="btn cta">Welcome page</button>
</body>
</html>