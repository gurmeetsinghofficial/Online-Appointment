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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.maskedinput/1.4.1/jquery.maskedinput.min.js" integrity="sha512-d4KkQohk+HswGs6A1d6Gak6Bb9rMWtxjOa0IiY49Q3TeFd5xAzjWXDCBW9RS7m86FQ4RzM2BdHmdJnnKRYknxw==" crossorigin="anonymous"></script>
<script>
	$(document).ready(function($){
		$('#time').mask("99to99",{placeholder:"XXtoXX"});
	});
</script>
</head>
<body>
<form action="InsertDocAvail" method="post">
Name
<input type="text" name="docName" required><br><br>
Password
<input type="password" name="docPass" required><br><br>
Available hours
<input type="text" id="time" name="time" required>
<button class="btn cta" type="submit" >submit</button>
</form>
<br><br> 
<button onClick="window.location.href='./Avail.jsp'" class="btn cta">back</button>
<button onClick="window.location.href='./Whichlogin.html'" class="btn cta">Login page</button>
<button onClick="window.location.href='./Welcome.html'" class="btn cta">Welcome page</button>

</body>
</html>