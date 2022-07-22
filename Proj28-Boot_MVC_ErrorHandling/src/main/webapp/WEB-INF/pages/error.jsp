<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page</title>
</head>
<body>
<h1 style = "color : red; text-align: center">Some internal problem</h1>

<ol>
	<li>status : ${status}</li>
	<li>timestamp : ${timestamp}</li>
	<li>message : ${message}</li>
	<li>type : ${type}</li>
	<li>path : ${path}</li>
	<li>trace : ${trace}</li>
</ol>
</body>
</html>