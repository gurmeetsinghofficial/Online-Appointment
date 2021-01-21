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
<form action="DisplayBooked" method="post">
	Your name<input required name="name"><br>
	Password<input type="password" required name="pass"><br><br>
	<button onClick="submit">submit</button>
	</form>
</body>
</html>