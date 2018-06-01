<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Physician Index</title>
</head>
<body>
	<c:if test="${!empty list}">
	<table>
		<tr>
			<th>Name</th>
			<th>Position</th>
			<th colspan="1" />
		</tr>
		<c:forEach var="phys" items="${list}">
			<tr>
				<td><a href=<c:url value = "/Physician/get/${phys.id}"/>>${phys.name}</a></td>
				<td>${phys.position}</td>
				<!--  <td><a href=<c:url value = "/EmployeeUpdateForm/${emp.employeeId}"/>>Update Employee data</a></td>-->
		</c:forEach>

	</table>
	</c:if>
</body>
</html>