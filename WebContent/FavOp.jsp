<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="preconnect" href="https://fonts.gstatic.com"> 

<link rel="stylesheet" type="text/css" href="ButtonCss.css"></link>
<link href="https://fonts.googleapis.com/css2?family=Dancing+Script&family=Open+Sans:ital,wght@1,700&display=swap" rel="stylesheet"><style>
body{
font-family: 'Dancing Script', cursive;
}
</style>
</head>
<body class="container">
<form action="SelOp.jsp" method="post">
Enter First Name:
<input type="text" name="firstname" required><br>
Enter Last Name:
<input type="text" name="lastname" required><br>
Select Your State:-<br><br>
<select name="state" required>
<option>Haryana</option>
<option>Punjab</option>
<option>Los Angeles</option>
<option>Las Vegas</option>
</select><br><br>
You are<input type="radio" name="gen" value="Male">Male<input type="radio" name="gen" value="Female">Female<br><br>
Select Your Favourite Language:-<br><br>
<input type="checkbox" name="favLang" value="Java">Java<br>
<input type="checkbox" name="favLang" value="PHP">PHP<br>
<input type="checkbox" name="favLang" value="C">C<br>
<input type="checkbox" name="favLang" value="Python">Python<br>
<input type="checkbox" name="favLang" value="Ruby">Ruby<br>
<input class="btn cta"type="submit" value="Go to Personalised Page" name="submit">
</form>
</body>
</html>