<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<div class="card">
	<div class="card-header">
		<h1 style=color:brown;text-align:center>Registration Page</h1>
	</div>
		<form:form action="add" modelAttribute="pers"> 
		<div class="card-body">
			<form:input path="firstName" class="form-control" placeholder="Enter FirstName"/><br><br>
			<form:input path="lastName" class="form-control" placeholder="Enter LastName"/><br><br>
			<form:input path="mobileNum" class="form-control" placeholder="Enter MobileNumber"/><br><br>
			<form:input path="emailId" class="form-control" placeholder="Enter EmailID"/><br><br>
			<form:password path="password" class="form-control" placeholder="Enter Password"/>
		</div>
		<div class="card-footer">
			<input type="submit" value="Register"> &nbsp;&nbsp;
		</div>
		</form:form>
		<div class="card-footer" style=background-color:gray>
		<a href="list"><button>List</button></a></div>	
		<form action="/find">
			<div class="card-body">
				<input type="text" class="form-control" placeholder="Enter pid" name="id"><br><br>
			</div>
			<div class="card-footer">
				<input type="submit" value="Find">
			</div>
		</form>
	</div>
</div>
</body>
</html>