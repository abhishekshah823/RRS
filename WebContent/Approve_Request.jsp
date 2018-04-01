<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.ResultSet" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Approve Requests</title>
<link rel="stylesheet" href="./CSS/styleindex.css" type="text/css" />
<style>body{background-colour:white;}</style>
</head>
<body>
<div style="overflow-x:auto;">
<table border="4">
<tr>
<th>Request_ID</th>
<th>Date</th>
<th>Description</th>
<th>Department</th>
<th>Experience</th>
<th>Expertise</th>
<th>Requesting User</th>
<th>State</th>
</tr>
<% 
int i=0;
ResultSet rs = (ResultSet)request.getAttribute("qs");
while(rs.next())
	    	 {
	    		String req_id= rs.getString("req_id");
	    		String req_date= rs.getString("req_date");
	    		String req_description= rs.getString("req_description");
	    		String department= rs.getString("department");
	    		String experience = rs.getString("experience");
	    		String expertise = rs.getString("expertise");
	    		String userId= rs.getString("USID");
	    		String app=rs.getString("state");
	    		%>
<tr>
<td><%= req_id%></td>
<td><%= req_date%></td>
<td><%= req_description%></td>
<td><%= department%></td>
<td><%= experience%></td>
<td><%= expertise%></td>
<td><%=userId%></td>
<td><%= app%></td>
<%session.setAttribute("tmp"+i, req_id);
if(app.equals("New Request"))
{ %>
<td><form action="ApproveRequest">
<button type="submit" value="Approve Request">Approve Request</button>
<input type="hidden" value="<%= i %>" name="i">
<input type="hidden" value="1" name ="j">
</form></td>	
<td><form action="ApproveRequest">
<button type="submit" value="Reject Request">Reject Request</button>
<input type="hidden" value="2" name ="j">
<input type="hidden" value="<%= i %>" name="i">
</form></td>
	
<% }
if(app.equals("Approved Request")||app.equals("Rejected Request")||app.equals("Approved Cancelled Request"))
{
//nothing	
}
%>
<%
if(app.equals("Cancelled Request"))
{
%>
<td><form action="ApproveRequest">
<button type="submit" value="Approve Cancellation">Approve Cancellation</button>
<input type="hidden" value="3" name ="j">
<input type="hidden" value="<%= i %>" name="i">
</form></td>

<%}
i++;} %>	
</tr>
</table><br>
</div>
	<form action="options.jsp">
 		<div class="options"><button type="submit" value="Return to previous menu">Return to previous menu</button></div>
</form>

 
</body>
</html>