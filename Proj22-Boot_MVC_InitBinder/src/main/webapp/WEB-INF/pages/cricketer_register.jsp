<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cricketer Registration Page</title>
</head>
<body>
	<div class="container mt-3">
		<h2>Cricketer Registration Form</h2>
		<form:form modelAttribute="crck">
			<div class="mb-3 mt-3">
				<label for="cname" class="form-label">Cricketer Name : </label>
				<form:input class="form-control" id="cname" path="name" />
			</div>

			<div class="mb-3">
				<label for="ctype" class="form-label">Cricketer Type : </label>
				<form:input class="form-control" id="ctype" path="type" />
			</div>

			<div class="mb-3">
				<label for="cdob" class="form-label">Cricketer DOB : </label>
				<form:input type = "date" class="form-control" id="cdob" path="dob" />
			</div>

			<div class="mb-3">
				<label for="ctob" class="form-label">Cricketer TOB : </label>
				<form:input type = "time" class="form-control" id="ctob" path="tob" />
			</div>

			<div class="mb-3">
				<label for="cdoj" class="form-label">Cricketer DOJ : </label>
				<form:input type = "date" class="form-control" id="cdoj" path="doj" />
			</div>

			<div class="mb-3">
				<label for="cdebue" class="form-label">Cricketer Debue Date And Time : </label>
				<form:input type = "datetime-local" class="form-control" id="cdebue" path="debueDate" />
			</div>
			<button type="submit" class = "btn btn-primary">Submit</button>
		</form:form>
	</div>
</body>
</html>