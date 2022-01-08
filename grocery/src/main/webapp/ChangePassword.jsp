<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ChangePassword</title>
</head>
<body>
<form action="ChangePassword">
        <label for="pnumber">Enter MobileNumber</label>
        <input type="text" name="uname" required autofocus pattern="[6-9]{1}[0-9]{9}">   <br><br>
        <label for="pword">New Password</label>
        <input type="password" name="pword" required min="8"> <br> <br>
        <input type="submit">
    </form>

</body>
</html>