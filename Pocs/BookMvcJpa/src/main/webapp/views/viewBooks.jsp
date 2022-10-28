<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<style>
	table{
		border-collapse: collapse;
	}
</style>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<!-- //cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css
 --><link href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css">
	

<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
$(document).ready(function() {
	$('#booktab').DataTable({
		"pagingType" : "full_numbers"
	});
});
</script>
<script>
	function deleteConfirm(){
		return confirm("Are you sure, you want to delete?");
	}
</script>
</head>
<body>
<div class="container">
	<div class="card">
		<div class="card-header">
			<h3 style=color:red;text-align:center>Books Info</h3>
		</div>
		<div class="card-body">
	<table class="table table-dark" id="booktab">
		<thead><tr>
			<th>Book_Id</th>
			<th>Book_Name</th>
			<th>Author_Name</th>
			<th>Book_Price</th>
			<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="book" items="${list}">
				<tr>
					<td>${book.getBook_id()}</td>
					<td>${book.getBook_name()}</td>
					<td>${book.getAuthor_name()}</td>
					<td>${book.getBook_price()}</td>
					<td><a href="/edit/${book.getBook_id()}"><button style=background-color:gray>Edit</button></a>
					<a href="/delete/${book.getBook_id()}" onclick="deleteConfirm()"><button  style=background-color:gray>Delete</button></a></td>
				</tr>
			</c:forEach>
		</tbody>	
	</table>
	</div>
	<div class="card-footer">
		<a href="reg"><button>Add Book</button></a>
	</div>
	</div>	
</div>
</body>
</html>