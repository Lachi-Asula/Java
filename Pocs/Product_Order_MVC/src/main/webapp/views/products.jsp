<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>

</head>
<body>
<div class="container">
	<div class="card">
		<div class="card-header">
			<h2 style=color:brown;text-align:center>Product</h2>
		</div>
		<div class="card-body">
		<h3 style=color:green;text-align:center>${msg}</h3>
			<form:form action="addProduct" modelAttribute="prod" method="post">
				<form:input path="productname" class="form-control" placeholder="productname"/><br>
				<form:input path="productprice" class="form-control" placeholder="productprice"/><br>
			
			<div class="card-footer">
				<input type="submit" value="AddProduct"><br>
			</div></form:form>
			</div>
			<div class="card-footer">
				<center>
					<a href="makeOrder"><button>Make An Order</button></a>
				</center>
			</div>
	</div>
	</div>
</body>
</html>