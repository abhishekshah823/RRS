<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Welcome</title>
    <link rel="stylesheet" href="./CSS/styleindex.css" type="text/css" />
</head>
<body>
<header>    
You have successfully Logged in <br>
Welcome, ${userId}
    
  </header>  
<div class="options">
<%	String usertype=(String)session.getAttribute("usertype");
if(usertype.equals("hr"))
{
%>
<br>

<form  action= "ViewAllRequest" method="post">
    <button type="submit" value="view the request database">view the request database</button>
</form><br>
<%}%>

    <form  action= "NewRequest">
    <button type="submit" value="Create a New Request">Create a New Request</button>
    </form><br>
<form  action= "ViewRequest" method="Post">
    <button type="submit" value="View My Requests">View My Requests</button>
</form><br>
<form  action= "ApproveRequest" method="Post">
    <button type="submit" value="Manage Subordinate Requests">Manage Subordinate Requests</button>
</form>
<br>
 <form  action= "Logout.jsp">
 <button type="submit" value="Logout">Logout</button></form>
 </div>
</body>
</html>