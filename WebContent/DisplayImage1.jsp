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
	<form action="DisImg1" method="post">
		Enter User Name to see image<input name="username" required>
		<button class="btn" type="submit">submit</button>
	</form>		
    <br><br><button class="btn bg" onclick="window.location.href='./Welcome.html'">back to welcome page</button><br>
    <button class="btn" onclick="window.location.href='./login1.html'">go to login page</button><br>
    <button class="btn" onclick="window.location.href='./SignUp1.html'">Create new Account</button><br>

</body>
</html>