<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Success</title>
<link rel="stylesheet" href="./CSS/styleindex.css" type="text/css" />
</head>
<body>
<header>
You Have Successfully Cancelled Request:
<%
String req_id =(String)session.getAttribute("tmp"); %>
<%=  req_id %></header>
<div class="options">
<form action="ViewRequest" method="Post">
<button type="submit" value="OK">OK</button>
</div>
</form>
</body>
</html>