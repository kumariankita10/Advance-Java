<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String msg=(String)request.getAttribute("msg"); %>
<%=msg %>
<h1> WELCOME AND REGISTER TO OUR APPLICATION</h1>
<form action="register" method="post" >
ID: <input type="text"  name="Id"><br>
NAME: <input type="text" name="Name"><br>
AGE: <input type="text"  name="Age"><br>
<input type="submit" value="Register">
</form>
    
</body>
</html>