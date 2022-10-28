<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>

<style >
	p{
		color:blue;
		display: table-row-group;
	}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<div class="card">
		<div class="card-header">
			<h5 style=color:brown;text-align:center>Person Info</h5>
		</div>
	<div class="card-body">
		<p>
			${pers.getPid()} &nbsp;
			${pers.getFirstName()} &nbsp;
			${pers.getLastName()} &nbsp;
			${pers.getMobileNum()} &nbsp;
			${pers.getEmailId()} &nbsp;
			${pers.getPassword()} &nbsp;
		</p>
	</div>
	<div class="card-footer">
		<center>
		<a href="/edit/${pers.getPid()}"><button>Update</button></a><br><br>
		<a href="/delete/${pers.getPid()}"><button>Delete</button></a>
		</center>
	</div>
	</div>
</div>
</body>
</html>