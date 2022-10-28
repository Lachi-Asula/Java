<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*" %>
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
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">	
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
$(document).ready(function() {
	$('#emptab').DataTable({
		"pagingType" : "full_numbers"
	});
});
</script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	<div class="card">
		<div class="card-header">
			<h3 style=color:#bc8e52;text-align:center>Orders Info</h3>
		</div><br>
		<div class="card-body">
	<table class="table table-dark" id="emptab">
		<thead><tr>
			<th>OrderId</th>
			<th>Quantity</th>
			<th>ProductName</th>
			<th>TotalPrice</th>
			<th>OrderedDate</th>
			<th>ModifiedDate</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="info" items="${info}">
				<tr>
					<td>${info.getOrderid()}</td>
					<td>${info.getQuantity()}</td>
					<td>${info.getProductname()}</td>
					<td>${info.getTotalamount()}</td>
					<td>${info.getOrderTime()}</td>
					<td>${info.getModifiedTime()}</td>
				</tr>
			</c:forEach>
		</tbody>	
	</table>
	</div>	
	
	</div>
	</div>
</body>
</html>