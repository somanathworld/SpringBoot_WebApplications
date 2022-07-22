<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Current Balance Page</title>
</head>
<body>
	<h1 style = "color: blue; text-align: center">Current Balance Page</h1>
	<b>Your balance : <%= new java.util.Random().nextInt(100000) %></b>
	<a href= "./">home</a>
</body>
</html>