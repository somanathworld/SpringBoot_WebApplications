<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Pagewise Report</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<c:choose>
		<c:when test="${!empty pageData}">
			<table border="1" bgcolor="cyan" align="center">
				<tr bgcolor="pink">
					<th>eno</th>
					<th>ename</th>
					<th>desg</th>
					<th>salary</th>
					<th>deptNo</th>
					<th>operations</th>
				</tr>
				<c:forEach var="emp" items="${pageData.getContent()}">
					<tr>
						<td>${emp.empno}</td>
						<td>${emp.ename}</td>
						<td>${emp.job}</td>
						<td>${emp.sal}</td>
						<td>${emp.deptno}</td>
						<td><a href="edit_employee?eno=${emp.empno}"><img
								src="images/edit1.png" width="50" height="50">
								&nbsp;&nbsp;</a> <a href="delete_employee?eno=${emp.empno}"
							onclick="confirm('Do u want to delete')"><img
								src="images/delete1.jpg" width="50" height="50"></a></td>
					</tr>
				</c:forEach>
			</table>
			<br>
			<br>
			<p style="text-align: center">
				<c:if test="${!pageData.isFirst()}">
					<a href="page_emp_report?page=0">[first]</a>&nbsp;&nbsp;
				</c:if>
				<c:if test="${!pageData.isLast()}">
					<a href="page_emp_report?page=${pageData.getNumber()+1}">[next]</a>&nbsp;&nbsp;
				</c:if>

				<c:forEach var="i" begin="1" end="${pageData.getTotalPages()}" step="1">
					[<a href="page_emp_report?page=${i-1}">${i}</a>]&nbsp;&nbsp;
				</c:forEach>

				<c:if test="${!pageData.isLast()}">
					<a href="page_emp_report?page=${pageData.getTotalPages()-1}">[last]</a>&nbsp;&nbsp;
				</c:if>
				<c:if test="${!pageData.isFirst()}">
					<a href="page_emp_report?page=${pageData.getNumber()-1}">[previous]</a>&nbsp;&nbsp;
				</c:if>
			</p>
		</c:when>
		<c:otherwise>
			<h1 style="color: red; text-align: center">Records not found</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>