<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form method="POST" modelAttribute="patient" action="/Patient/add">
		<table>
			<tr>
				<td><form:label path="name"> Name</form:label></td>
				<td><form:input path="name" /></td>
			</tr>

			<tr>
				<td><form:label path="address">Address</form:label></td>
				<td><form:input path="address" /></td>
			</tr>

			<tr>
				<td><form:label path="phone">Phone Number</form:label></td>
				<td><form:input path="phone" /></td>
			</tr>


			<tr>
				<td><form:label path="insurance">Insurance Id</form:label></td>
				<td><form:input path="insurance" /></td>
			</tr>

			<tr>
				<form:select path="physician">
					<form:options items="${physList}" value = "name" />
				</form:select>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>