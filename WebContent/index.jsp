<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login Portal</title>
    <link rel="stylesheet" href="./CSS/styleindex.css" type="text/css" />
</head>
    
    
<body>
    
    <header>
        REQUEST MANAGEMENT PORTAL
        
        </header>
    
		 <div class="options">
        <div class="form">
        <div class="formtext">SIGN IN</div>
       <div class="forminput">
        <form action="LoginServlet" method="post">
		<input type="text" name="uid" placeholder="username" autofocus required><br><br>
		<input type="password" name="pass" placeholder="password" required ><br><br>
	            <button id="p01" type="submit" value="Send" >Send</button>
        </form>
        </div>
    </div>
    </div>
    
</body>
</html>