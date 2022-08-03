<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tourist Report Page</title>
</head>
<body>
	<c:choose>
		<c:when test="${!empty touristList}">
			<table border="1px" align="center">
				<tr>
					<th>Tourist Id</th>
					<th>Tourist Name</th>
					<th>Tourist City</th>
					<th>Package Type</th>
					<th>Budget</th>
					<th colspan="2">Operations</th>
				</tr>
				<c:forEach var="tourist" items="${touristList}">
					<tr>
						<td>${tourist.getTid()}</td>
						<td>${tourist.getName()}</td>
						<td>${tourist.getCity()}</td>
						<td>${tourist.getPackageType()}</td>
						<td>${tourist.getPrice()}</td>
						<td>
							<a href="edit?id=${tourist.getTid()}" style = "color:gray;text-decoration: none">
								Edit
							</a>
						</td>
						<td>
							<a href="delete?id=${tourist.getTid()}" style = "color:red;text-decoration: none">
								Delete
							</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h1 style="color: red; text-align: center">Record(s) Not found</h1>
		</c:otherwise>
	</c:choose>
	<br />
	<h2 style="text-align: center; color: blue; text-decoration: none">
		<a href="add">Add Tourist</a>
	</h2>
	<br />
	<br />
	<h1 style="color: red; text-align: center">${resultMsg}</h1>
</body>
</html>