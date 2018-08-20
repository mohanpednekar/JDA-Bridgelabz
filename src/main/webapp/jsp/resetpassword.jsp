<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Reset Password</title>
    <script src="../js/resetPassword.js" type="javascript"></script>
</head>
<body>
<form id="resetPasswordForm" onsubmit="identicalPasswords()" action="resetPasswordProcess" method="post">
    <table align="center">
        <input type="hidden" id="resetToken" value="${resetToken}"/>
        <tr>
            <td><label path="password1">Enter New Password</label></td>
            <td>
                <input type="password" name="password1" id="password1"></input>
            </td>

        </tr>
        <tr>
            <td><label path="password">Confirm Password</label></td>
            <td>
                <input type="password" name="password" id="password"></input>
            </td>

        </tr>
        <tr>
            <td></td>
            <td>
                <button id="resetPassword" name="resetPassword">Reset</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
