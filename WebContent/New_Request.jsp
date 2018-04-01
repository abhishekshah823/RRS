<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.ResultSet" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Request</title>
<link rel="stylesheet" href="./CSS/styleindex.css" type="text/css" />
</head>
<body>
<div class="form">
       <div class="formtext">Enter your requirement:</div>
       <div class="forminput">
<form action="NewRequest" method="post" >
<div class="options">Select Department:<br><select name= "department">
<%
ResultSet ps = (ResultSet)request.getAttribute("ps");
while(ps.next())
{	
String dep_name=ps.getString("dep_name");

%>
<option value="<%= dep_name %>"> <%= dep_name %></option>
<% } %>
</select></div>
<div class="options">Request Experience:<br><select  name= "experience">
<option value="1yr">1yr</option>
<option value="2-5yrs">2-5yrs</option>
<option value="6-10yrs">6-10yrs</option>
</select></div><br>
<div class="options"><input type="text" name= "expertise" placeholder="Enter expertise" required><br><br></div>
<div class="options"><input type="text" name= "description" placeholder="Enter description here"><br><br></div>
<br>
<div class="options"><button type="submit" value="Submit">Submit</button><br><br></div>
</form>

<form action="options.jsp">
<div class="options"><button type="submit" value="Return to previous menu">Return to previous menu</button></div>

</form>
</div>
</div>
</body>
</html>