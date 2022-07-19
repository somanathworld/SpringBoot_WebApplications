<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Result Page</title>
</head>
<body>
	<h1 style = "text-align : center; color: red">Student Data</h1>
	<h3>Student Data of Model Obj</h3>
	Student No. : ${stud.sno}<br/>
	Student Name : ${stud.sname}<br/>
	Student Address : ${stud.sadd}<br/>
	Student Fee : ${stud.fee}<br/>
	
	<h3>Student Data of Map Obj</h3>
	Student No. : ${studInfo.sno}<br/>
	Student Name : ${studInfo.sname}<br/>
	Student Address : ${studInfo.sadd}<br/>
	Student Fee : ${studInfo.fee}<br/>
	
</body>
</html>