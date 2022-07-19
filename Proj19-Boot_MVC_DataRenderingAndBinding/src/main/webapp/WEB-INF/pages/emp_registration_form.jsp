<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Registration Form</title>
</head>
<body>
	<form method="post">
		<table align="center" border = "1" sytle = "collapse-border : collapse">
			<tr>
				<td>Employee No : </td>
				<td><input type = "number" name="eno"/></td>
			</tr>
			<tr>
				<td>Employee Name: </td>
				<td><input type = "text" name="ename"/></td>
			</tr>
			<tr>
				<td>Employee Designation : </td>
				<td><input type = "text" name="desg"/></td>
			</tr>
			<tr>
				<td>Employee Salary : </td>
				<td><input type = "number" name="salary"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="submit">Submit</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>