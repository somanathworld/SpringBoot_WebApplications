<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tourist Registration Form</title>
</head>
<body>
	<h1 style = "color:red; text-align:center;">Tourist Registration From</h1>
	
	<form:form modelAttribute="tst">
		<table border="1" align="center" bgcolor="cyan">
			<tr>
				<td><label for = "tname">Tourist Name : </label></td>
				<td><form:input path="name" id="tname"/></td>				
			</tr>
			<tr>
				<td><label for = "tcity">Tourist City : </label></td>
				<td><form:input path="city" id="tcity"/></td>				
			</tr>
			<tr>
				<td><label for = "tpcktyp">Package Type : </label></td>
				<td><form:input path="packageType" id="tpcktyp"/></td>				
			</tr>
			<tr>
				<td><label for = "tprice">Package Budget : </label></td>
				<td><form:input path="price" id="tprice"/></td>				
			</tr>
			<tr>
				<td><input type = "submit" value = "Register"/></td>
				<td><input type = "reset" value = "Reset"/></td>
			</tr>
		</table>
	</form:form>
</body>
</html>