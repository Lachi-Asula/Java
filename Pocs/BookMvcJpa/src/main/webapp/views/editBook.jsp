<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
				<h2 style=color:brown;text-align:center>Book Registration</h2>
			</div>
			<div class="card-body">
				<form:form action="/BookMvcJpa/update" modelAttribute="book" method="post">
					Book Name: <form:input path="book_name"/><br><br>
					Author Name: <form:input path="author_name"/><br><br>
					Book Price: <form:input path="book_price"/><br><br>
		
				<div class="card-footer">
					<input type="submit" value="UpdateBook"/>
				</div>
				</form:form>
				
			</div>
		</div>
	</div>
</body>
</html>