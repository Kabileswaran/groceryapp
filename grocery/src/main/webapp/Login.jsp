<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<style>
body {
  background-image: url('assets/home.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
  
}
 #myHeader{ 
 font-family: Verdana, Geneva, Tahoma, sans-serif;
margin: 200px 550px;
 position: relative;
  font-size: large;
  color: white;
}
</style>
<body >
<div id="myHeader">
  <h3>Grocery App</h3>
  
    <form action="login">
        <label for="pnumber">Mobile Number</label><br>
        <input type="text" name="uname" required autofocus pattern="[6-9]{1}[0-9]{9}">   <br><br>
        <label for="pword">Password</label><br>
        <input type="password" name="pword" required min="8"> <br> <br>
          
        <input type="submit" value="Login"><br><br>
    </form>
    <label>New User? </label> 
    <input type="button" value="Sign Up" onclick="window.location='signup.jsp'" >
    </div>
</body>
</html>