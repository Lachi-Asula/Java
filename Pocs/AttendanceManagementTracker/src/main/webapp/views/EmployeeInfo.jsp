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

<script>
	$(function() {
		$.datepicker.setDefaults({
			onClose : function(date, inst) {
				$("#selectedDtaeVal").html(date);
			}
		});

		$("#datepicker").datepicker();
	});
</script>
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
	<div class="card">
		<div class="card-header">
	<form action="/empInfo">
	<strong style=color:#2e0000>BatchNum: </strong><select name="batchNum">
			<option selected value="" disabled style=color:gray>BatchId</option>
	<c:forEach var="emp" items="${empList}">
			<option style=color:gray>${emp}</option>	
	</c:forEach></select>
	<input type="submit" value="Info" style=color:navy>
</form>
</div></div>
<form action="/saveStatus" method="post">
	<div class="container">
	<div class="card">
		<div class="card-header">
			<h3 style=color:#bc8e52;text-align:center>Employee Info</h3>
		</div><br>
		<div class="card-body">
	<table class="table table-dark" id="emptab">
		<thead><tr>
			<th>EmpId</th>
			<th>EmpName</th>
			<th>EmailId</th>
			<th>BatchNum</th>
			<th>Doj</th>
			<th><input type="text" id="datepicker" name="now"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="info" items="${Info}">
				<tr>
					<td>${info.getEmpId()}</td>
					<td>${info.getEmpName()}</td>
					<td>${info.getEmailId()}</td>
					<td>${info.getBatchNum()}</td>
					<td>${info.getDoj()}</td>
					<input type="hidden" name="empId" value="${info.getEmpId()}"/>
				<td><select name="status" style=background-color:#c2c2c2>
					<option>Present</option>
					<option>Absent</option>
					<option>Deployed</option>
				</select>
				</tr>
			</c:forEach>
		</tbody>	
	</table>
	</div>	
	
	</div>
	<div class="card-footer">
		<input type="submit" value="save">
	</div>
	</div></form>
</body>
</html>