<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Model Objects Page</title>
</head>
<body>
	<table align="center" border="1">
	<tr>
	<th>ENO</th><th>ENAME</th><th>DESG</th><th>SALARY</th>
	</tr>
	<c:forEach var = "emp" items="${empsInfo}">
		<tr>
			<td>${emp.eno}</td>
			<td>${emp.ename}</td>
			<td>${emp.desg}</td>
			<td>${emp.salary}</td>
		<tr/>
	</c:forEach>
	</table>
</body>
</html>