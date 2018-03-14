<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.ResultSet" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="NewRequest" method="post" >
Request Department:<select name= "department">
<%
ResultSet ps = (ResultSet)request.getAttribute("ps");
while(ps.next())
{	
String dep_name=ps.getString("dep_name");

%>
<option value="<%= dep_name %>"> <%= dep_name %></option>
<% } %>
</select><br><br>
Request Experience:<select name= "experience">
<option value="1yr">1yr</option>
<option value="2-5yrs">2-5yrs</option>
<option value="6-10yrs">6-10yrs</option>
</select><br><br>

Request Expertise:<input type="text" name= "expertise" required><br><br>
Request Description:<input type="text" name= "description"><br><br>
<input type="submit" value="Submit"><br><br>
</form>
<br>
<form action="options.jsp">
<input type="submit" value="Return to previous menu">
</form>
</body>
</html>