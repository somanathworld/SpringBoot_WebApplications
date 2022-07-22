<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loan Page</title>
</head>
<body>
	<h1 style = "color:blue;text-align : center">Home Approval Page</h1>
	<b>You are approved for loan amount : <%= new java.util.Random().nextInt(1000000) %></b>
	<a href = "./">home</a>
</body>
</html>