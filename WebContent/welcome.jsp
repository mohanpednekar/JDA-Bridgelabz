<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.jda.dynamic.model.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
</head>
<body>
<%
User user=null;
if(session.getAttribute("user")==null){
  response.sendRedirect("login.jsp");
}else user=(User) session.getAttribute("user");
String userId=null;
String sessionId=null;
Cookie[] cookies=request.getCookies();
if(cookies!=null){
  for(Cookie cookie:cookies){
  if(cookie.getName().equals("userName")) userId=cookie.getValue();
  if(cookie.getName().equals("JSESSIONID")) sessionId=cookie.getValue();
  }
}
%>

<h3>Hi <%=userId%>, Your session ID = <%=sessionId %></h3>
<br>
User=<%=userId%>
<br>
<a href="CheckOutPage.jsp"> Checkout Page</a>
<form action="logout" method="post">
<input type="submit" value="Logout">
</form>
</body>
</html>