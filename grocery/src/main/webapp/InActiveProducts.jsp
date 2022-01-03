<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1><a href="Logout.jsp">logout</a></h1>
<form action="InActiveproduct">
<label>Enter the product name</label>
<input type="text" name="pname" required>
<label>Status</label>
<input type="radio" id="status" name="status" value="Y"> Active   
<br>  
<input type="radio" id="status" name="status" value="N"> InActive <br/>   
<input type="submit" value="submit">
</form>

</body>
</html>