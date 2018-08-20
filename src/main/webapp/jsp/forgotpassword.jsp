<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Forgot Password</title>
</head>
<body>
<form id="forgotPasswordForm" action="forgotPasswordProcess" method="post">
    <table align="center">
        <tr>
            <td><label path="email">Email: </label></td>
            <td><input path="email" name="email" id="email"/></td>
            <td>
                <errors path="email" name="email" id="email"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td align="left">
                <button id="forgotPassword" name="forgotPassword">Submit</button>
            </td>
        </tr>

    </table>
</form>
</body>
</html>
