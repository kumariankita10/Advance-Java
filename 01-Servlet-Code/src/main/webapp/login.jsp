<!DOCTYPE html>
<html lang="en">
<head>
  
</head>

<body>
 <%String username=request.getParameter("Name"); %>
   <h1>Welcome <%=username %> Please Login to access your account</h1>
    <form action="login">
    USER:<input type="text" name="user">
    PASSWORD:<input type="text" name="pswd">
    <input type="submit" value="Login">
    
    
    
    </form>
</body>
</html>

