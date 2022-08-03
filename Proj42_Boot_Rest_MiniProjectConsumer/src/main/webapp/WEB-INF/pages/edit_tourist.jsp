<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Tourist Form</title>
</head>
<body>
	<h1 style = "color:red; text-align:center">Edit Tourist Form</h1>

	<frm:form modelAttribute="tst">
		<table border="1" align="center" bgcolor="cyan">
			<tr>
				<td><label for = "id">Tourist Name : </label></td>
				<td><frm:input path="tid" id="id"/></td>				
			</tr>
			<tr>
				<td><label for = "tname">Tourist Name : </label></td>
				<td><frm:input path="name" id="tname"/></td>				
			</tr>
			<tr>
				<td><label for = "tcity">Tourist City : </label></td>
				<td><frm:input path="city" id="tcity"/></td>				
			</tr>
			<tr>
				<td><label for = "tpcktyp">Package Type : </label></td>
				<td><frm:input path="packageType" id="tpcktyp"/></td>				
			</tr>
			<tr>
				<td><label for = "tprice">Package Budget : </label></td>
				<td><frm:input path="price" id="tprice"/></td>				
			</tr>
			<tr>
				<td><input type = "submit" value = "UpdateTourist"/></td>
				<td><input type = "reset" value = "Reset"/></td>
			</tr>
		</table>
	</frm:form>
</body>
</html>