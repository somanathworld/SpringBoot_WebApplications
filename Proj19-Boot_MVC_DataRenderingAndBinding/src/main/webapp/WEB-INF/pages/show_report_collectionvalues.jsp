<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>show_report_collectionvalues</title>
</head>
<body>
	<b>Nick Names(array):</b><br/>
	<c:forEach var="name" items="${nickNames}">
		${name}<br/>
	</c:forEach>
	<hr/>
	<b>Phones Info(set):</b><br/>
	<c:forEach var="phone" items="${phonseInfo}">
		${phone}<br/>
	</c:forEach>
	<hr/>
	<b>Course Info(List):</b><br/>
	<c:forEach var="course" items="${courseInfo}">
		${course}<br/>
	</c:forEach>
	<hr/>	
	<b>Ids Info(Map):</b><br/>
	<c:forEach var="id" items="${idsInfo}">
		${id.key} => ${id.value}<br/>
	</c:forEach>
	
</body>
</html>