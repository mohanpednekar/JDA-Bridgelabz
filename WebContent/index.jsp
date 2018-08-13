<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel="stylesheet" href="css/styles.css">
    <script src="js/index.js"></script>
</head>
<body>
<h1> Register</h1>
<form name="regForm" onsubmit="return check()" action="register" method="post">
    <label>Name : <input type="text" name="name" value="mohan"></label> <br>
    <label>Email : <input type="email" name="email" value="pednekar.mohan@gmail.com"> </label><br>
    <label>Phone : <input type="number" name="phone" value="9876543210"> </label><br>
    <label>Password : <input type="password" name="password1" value="pass"></label><br>
    <label>Confirm Password : <input type="password" name="password2" value="pass"></label><br>
    <input type="submit" value="Register">
</form>
<a href="jsp/login.jsp">Already registered? Click here to login.</a>
</body>
</html>