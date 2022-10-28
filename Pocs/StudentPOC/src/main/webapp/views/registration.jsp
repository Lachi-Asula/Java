<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="add" modelAttribute="stud">
		StudentID: <form:input path="sid"/><br><br>
		StudentName:<form:input path="sname"/><br><br>
		EmailId:<form:input path="emailid"/><br><br>
		Password<form:password path="password"/><br><br>
		City:<form:input path="city"/>
		<br><br>
		<input type="submit" value="register">
	</form:form>

</body>
</html>