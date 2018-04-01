<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Logging Out</title>
<link rel="stylesheet" href="./CSS/styleindex.css" type="text/css" />
</head>
<body><header>
Thank You!</header>
<% session.invalidate(); %>
<div class="options">
<form action="index.jsp">
<button type="submit" value="Return to Homepage">Return to Homepage</button>
</div>
</form>
</body>
</html>