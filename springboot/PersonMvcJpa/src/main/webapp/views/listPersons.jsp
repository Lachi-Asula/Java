<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style>
	table{
		border-collapse: collapse;
	}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border=2px>
		<thead><tr>
		<td>PID</td>
		<td>FirstName</td>
		<td>LastName</td>
		<td>MobileNum</td>
		<td>EmailId</td>
		<td>Password</td></tr></thead>
		<tbody>
			<c:forEach var="pers" items="${person}">
				<tr>
				<td>${pers.getPid()}</td>
				<td>${pers.getFirstName()}</td>
				<td>${pers.getLastName()}</td>
				<td>${pers.getMobileNum()}</td>
				<td>${pers.getEmailId()}</td>
				<td>${pers.getPassword()}</td></tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>