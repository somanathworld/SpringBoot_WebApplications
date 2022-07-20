<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Marriage Seeker Registration</title>
</head>
<body>
	<form:form modelAttribute="profile" enctype="multipart/form-data">
		<table align="center" border="1px">
			<tr>
				<td>Marriage Seeker Name : </td>
				<td><form:input path="profileName"/></td>
			</tr>
			<tr>
				<td>Marriage Seeker gender : </td>
				<td>
					<form:radiobutton path="gender" value="male"/>Male &npsp;&npsp;
					<form:radiobutton path="gender" value="female"/>Female &npsp;&npsp;
				</td>
			</tr>
			<tr>
				<td>Select Resume : </td>
				<td><form:input type="file" path="resume"/></td>
			</tr>
			<tr>
				<td>Select Photo : </td>
				<td><form:input type="file" path="photo"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit"></td>
				<td><input type="reset" value="cancel"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>