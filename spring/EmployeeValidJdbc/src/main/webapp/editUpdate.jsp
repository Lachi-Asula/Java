<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<style>
	.error{
		color:red
	}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="/EmployeeValidJdbc/updat" modelAttribute="emp">
		
		Id: <form:input path="eid" />
		<form:errors path="eid" cssClass="error"></form:errors><br><br>
		
		EmpName: <form:input path="ename" />
		<form:errors path="ename" cssClass="error"></form:errors><br><br>
		
		Salary: <form:input path="salary" />
		<form:errors path="salary" cssClass="error"></form:errors><br><br>
		
		Address: <form:input path="address" />
		<form:errors path="address" cssClass="error"></form:errors><br><br>
		
		EmailId: <form:input path="email" />
		<form:errors path="email" cssClass="error"></form:errors><br><br>
		
		Password: <form:password path="password"/>
		<form:errors path="password" cssClass="error"></form:errors><br><br>
		
		<input type="submit" value="Update">
	</form:form>
</body>
</html>