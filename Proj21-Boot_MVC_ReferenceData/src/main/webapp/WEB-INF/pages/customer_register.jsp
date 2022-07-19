<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript">
	function sendReqForStates(){
		alert("send req");
		frm.action="states";
		frm.submit();
	}
</script>
<title>Customer Registration Page</title>
</head>
<body>
<form:form action="customer_register" modelAttribute="cust" name="frm">
	<table align="center" border="1">
		<tr>
			<td>Customer Name : </td>
			<td><form:input path="cname"/></td>
		</tr>
		<tr>
			<td>Select Country : </td>
			<td>
				<form:select path="country" onchange="sendReqForStates()">
					<form:options items="${countriesInfo}"/>
				</form:select>
			</td>
		</tr>
		<tr>
			<td>Select state : </td>
			<td>
				<form:select path="state">
					<form:options items="${statesInfo}"/>
				</form:select>
			</td>
		</tr>
		<tr>
			<td>Select Known Languages : </td>
			<td>
				<form:select path="languages">
					<form:options items="${languagesInfo}"/>
				</form:select>
			</td>
		</tr>
		<tr>
			<td>Select Hobbies</td>
			<td>
				<form:checkboxes items="${hobbiesInfo}" path=""/>
			</td>
		</tr>
		
		<tr>
			<td><input type = "submit" value = "submit"></td>
			<td><input type = "reset" value = "reset"></td>
		</tr>
	</table>
</form:form>
</body>
</html>