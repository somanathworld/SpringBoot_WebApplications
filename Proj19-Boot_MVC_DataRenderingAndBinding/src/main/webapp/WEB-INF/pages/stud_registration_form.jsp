<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registration Form</title>
</head>
<body>
	<form:form modelAttribute="st">
		<table>
			<tr>
				<td>Student Roll No. : </td>
				<td><form:input type = "text" path="sno"/>
			</tr>
			<tr>
				<td>Student Name : </td>
				<td><form:input type = "text" path="sname"/>
			</tr>
			<tr>
				<td>Student Address : </td>
				<td><form:input type = "text" path="sadd"/>
			</tr>
			<tr>
				<td>Student Fee : </td>
				<td><form:input type = "text" path="fee"/>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type = "submit" value= "Register"/>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>