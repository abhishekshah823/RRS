<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Select Option</title>
</head>
<body>
You have successfully Logged in <br>
Welcome, ${userId}
<br>
<%	String usertype=(String)session.getAttribute("usertype");
if(usertype.equals("hr"))
{
%>
HR View :<br>
<form action= "ViewAllRequest" method="post">
<input type="submit" value="View the request database">
</form><br>
<%}%>
<form action= "NewRequest">
<input type="submit" value="Create a New Request">
</form><br>
<form action= "ViewRequest" method="Post">
<input type="submit" value="View My Requests">
</form><br>
<form action= "ApproveRequest" method="Post">
<input type="submit" value="Manage Subordinate Requests">
</form>
<br>

<form action= "Logout.jsp">
<input type="submit" value="Logout">
</form>
</body>
</html>