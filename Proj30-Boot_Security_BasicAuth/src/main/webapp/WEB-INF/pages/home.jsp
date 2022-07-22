<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<h1 style = "color:red;text-align : center">Welcome to XYZ Bank - Home Page</h1>
	<ol>
		<li><a href="balance">check balance</a></li>
		<li><a href="loan">Approve Loan</a></li>
		<li><a href="offers">Offers</a></li>
	</ol>
	<%=SecurityContextHolder.getContext().getAuthentication().getName() %>
	<%=SecurityContextHolder.getContext().getAuthentication().getAuthorities() %>
	
	<b><a href="signout">logout</a></b>
</body>
</html>