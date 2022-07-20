<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Page</title>
</head>
<body>
<h1 style = "color:white; background-color: black; text-align: center">Marriage Seeker Profiles</h1>

<c:choose>
	<c:when test="${!empty seekersInfo}">
		<table align = "center" border = "1px">
		<thead>
			<tr>
				<th>ProfileId</th>
				<th>ProfileName</th>
				<th>Gender</th>
				<th>Resume Path</th>
				<th>Photo Path</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="seeker" items="${seekersInfo}">
				<tr>
					<td>${seeker.getProfileId()}</td>
					<td>${seeker.getProfileName()}</td>
					<td>${seeker.getGender()}</td>
					<td><a href="download?file=${seeker.getResumePath()}">${seeker.getResumePath()}</a></td>
					<td><a href="download?file=${seeker.getPhotoPath()}">${seeker.getPhotoPath()}</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</c:when>
</c:choose>
</body>
</html>