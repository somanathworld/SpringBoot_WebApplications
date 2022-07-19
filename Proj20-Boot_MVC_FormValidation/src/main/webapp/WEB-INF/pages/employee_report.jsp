<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<style>
blink {
	color: red;
	-webkit-animation: blink 1s step-end infinite;
	animtaion: blink 1s step-end infinite;
}

@-webkit-keyframes blink { 
	67%{opacity: 0}
}
@keyframes blink { 
	67%{opacity: 0}
}
</style>
<title>Employee Report Page</title>
</head>
<body>
	<div class="container-fluid mt-3">
		<h1 class="bg-secondary text-white text-center">Employee Report</h1>
		<c:choose>
			<c:when test="${!empty empInfo}">
				<table class="table table-dark table-hover">
					<thead>
						<tr>
							<th>EmpNo</th>
							<th>Ename</th>
							<th>Job</th>
							<th>Salary</th>
							<th>DeptNo</th>
							<th colspan="2" align="right">Operations</th>
						</tr>
					<thead>
					<tbody>
						<c:forEach var="emp" items="${empInfo}">
							<tr>
								<td>${emp.empno}</td>
								<td>${emp.ename}</td>
								<td>${emp.job}</td>
								<td>${emp.sal}</td>
								<td>${emp.deptno}</td>
								<td><a href="edit_employee?eno=${emp.empno}"
									style="text-decoration: none; color: white">edit</a></td>
								<td><a href="delete_employee?eno=${emp.empno}"
									style="text-decoration: none; color: white"
									onclick="confirm('Do you want to delete?')">delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
			<c:otherwise>
				<h1 style="text-align: center; color: red">Record Not found.</h1>
			</c:otherwise>
		</c:choose>

		<blink>
			<h1 style="color: green; text-align: center">${resultMsg}</h1>
		</blink>
		<br>
		<h5 style="color: blue; text-align: center">
			<a href="insert_employee" style="text-decoration: none"> Add
				Employee </a>
		</h5>
		<br>
		<h5 style="color: red; text-align: center">
			<a href="./" style="text-decoration: none"> Return to Home </a>
		</h5>
	</div>
</body>
</html>