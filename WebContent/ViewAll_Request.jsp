<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.ResultSet" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Request History</title>
</head>
<body>
<table border="2">
<tr>
<td>Request_ID</td>
<td>Requesting User</td>
<td>Date</td>
<td>Description</td>
<td>Department</td>
<td>Experience</td>
<td>Expertise</td>
<td>State</td>
</tr>
<% 

ResultSet rs = (ResultSet)request.getAttribute("rs");
while(rs.next())
	    	 {
	    		String req_id= rs.getString("req_id");
	    		String req_date= rs.getString("req_date");
	    		String req_description= rs.getString("req_description");
	    		String department= rs.getString("department");
	    		String experience = rs.getString("experience");
	    		String expertise = rs.getString("expertise");
	    		String app=rs.getString("state");
	    		String userId= rs.getString("USID");
	    		%>
	    	
<tr>
<td><%= req_id%></td>
<td><%=userId%></td>
<td><%= req_date%></td>
<td><%= req_description%></td>
<td><%= department%></td>
<td><%= experience%></td>
<td><%= expertise%></td>
<td><%= app%></td>
</tr>
	  	
<% } %>
</table>
<br>
 <form action="options.jsp">
 <input type="submit" value="Return to Previous Menu">

 </form>
</body>
</html>