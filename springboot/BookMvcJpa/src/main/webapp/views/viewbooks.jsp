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
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.1/css/jquery.dataTables.css">

<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.1/js/jquery.dataTables.js"></script>
	
<script>
	$(document).ready( function () {
    $('#bookTable').DataTable();
} );
</script>
</head>
<body>
	<div class="container">
		<div class="card">
			<div class="card-header">
				<h1 style=color:brown;text-align:center>BOOK INFO</h1>
			</div>
		<div class="card-body">
			<table class="table table-dark" id="bookTable">
				<thead><tr>
					<td>Book_Id</td>
					<td>Book_Name</td>
					<td>Book_Author</td>
					<td>Book_Price</td>
					<td>Actions</td>
				</tr></thead>
				<tbody>
					<c:forEach var="book" items="${books}">
						<tr>
							<td>${book.getBook_id()}</td>
							<td>${book.getBook_name()}</td>
							<td>${book.getBook_author()}</td>
							<td>${book.getBook_price()}</td>
							<td><a href="/editBook/${book.getBook_id()}"><button>Edit</button></a>
							<a href="/deleteBook/${book.getBook_id()}"><button>Delete</button></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		</div>
	</div>
</body>
</html>