<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.ResultSet" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Approve Requests</title>
</head>
<body>
<table border="2">
<tr>
<td>Request_ID</td>
<td>Date</td>
<td>Description</td>
<td>Department</td>
<td>Experience</td>
<td>Expertise</td>
<td>Requesting User</td>
<td>State</td>
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
<input type="submit" value="Approve Request">
<input type="hidden" value="<%= i %>" name="i">
<input type="hidden" value="1" name ="j">
</form></td>	
<td><form action="ApproveRequest">
<input type="submit" value="Reject Request">
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
<input type="submit" value="Approve Cancellation">
<input type="hidden" value="3" name ="j">
<input type="hidden" value="<%= i %>" name="i">
</form></td>

<%}
i++;} %>	
</tr>
</table><br>
	<form action="options.jsp">
 		<input type="submit" value="Return to previous menu">
</form>

 
</body>
</html>