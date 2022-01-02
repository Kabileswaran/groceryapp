<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h3>login</h3>
    <form action="login">
        <label for="pnumber">Enter MobileNumber</label>
        <input type="text" name="uname" required autofocus pattern="[6-9]{1}[0-9]{9}">   <br><br>
        <label for="pword">Password</label>
        <input type="password" name="pword" required min="8"> <br> <br>
        <input type="submit">
    </form>
      <a href="signup.jsp">SignUp</a>  

</body>
</html>