<%@ page isELIgnored="false" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Registration Page</title>
</head>
<body>
	<h1 style = "color:red; text-align:center"><spring:message code="cust.reg.title"/></h1>
	
	<form:form modelAttribute="cust">
		<table align ="center" border="1px">
			<tr>
				<td><spring:message code="cust.reg.name"/></td>
				<td><form:input path="cname"/></td>
			</tr>
			<tr>
				<td><spring:message code="cust.reg.addrs"/></td>
				<td><form:input path="caddrs"/></td>
			</tr>
			<tr>
				<td><spring:message code="cust.reg.billAmt"/></td>
				<td><form:input path="billAmt"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type = "submit" value = "<spring:message code="cust.reg.submit"/>"/>
				</td>
			</tr>
		</table>
	</form:form>
	<br/>
	
	<p>
		<fmt:setLocale value="${response.locale}"/>
		<jsp:useBean id="dt" class="java.util.Date"/>
		<fmt:formatDate value="${dt}" var="fdt" type="date" dateStyle="full"/>
		System Date :: ${fdt}<br/>
		<fmt:formatDate  value="${dt}" var="ftime" type="time" timeStyle="full"/>
		System Time :: ${ftime}<br/>
		<fmt:formatNumber value="10000000000" var="fprice" type="currency"/>
		Item Price :: ${fprice}<br/>		
		<fmt:formatNumber value="789000000" var="fnumber" type="number"/>
		Item number :: ${fnumber}<br/> 
	</p>
	
	<br/>
	<p style = "text-align:center">
		<a href="?lang=en_US">English</a>&nbsp;&nbsp;
		<a href="?lang=fr_FR">French</a>&nbsp;&nbsp;
		<a href="?lang=de_DE">German</a>&nbsp;&nbsp;
		<a href="?lang=hi_IN">Hindi</a>&nbsp;&nbsp;
	</p>
</body>
</html>