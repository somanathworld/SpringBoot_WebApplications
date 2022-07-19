<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<title>Employee Registration Page</title>
</head>
<body>
	<div class="container">
		<h1 class="bg-secondary text-white text-center mt-3">Employee Registraion Form</h1>
		<form:form modelAttribute="emp" cssClass="mb-3 mt-3">
			<label for = "ename" class="form-label">Emplyee Name : </label>
			<form:input id="ename" cssClass="form-control" path="ename" />
			<label for = "job" class="form-label">Emplyee Job : </label>
			<form:input id="job" cssClass="form-control" path="job" />
			<label for = "sal" class="form-label">Emplyee Salary : </label>
			<form:input id="sal" cssClass="form-control" path="sal" />
			<label for = "deptno" class="form-label">Emplyee Dept No. : </label>
			<form:input id="deptno" cssClass="form-control" path="deptno" />
		<div class = "mt-3">
			<input type = "submit" class = "btn btn-primary" style = "width : 40%" value = "Register"/>
			<input type = "reset" class = "btn btn-danger" style = "width : 40%"value = "Reset"/>
		</div>
		</form:form>
	</div>
</body>
</html>