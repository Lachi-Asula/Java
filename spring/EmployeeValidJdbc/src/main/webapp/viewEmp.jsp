<%@ page isELIgnored="false"%>
<%@ page import="model.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<style>
	table{
		border-collapse: collapse;
		border-color: gray;
	}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border=2px solid>
	<thead>
		<tr>
		<td>Eid</td>
		<td>Ename</td>
		<td>Salary</td>
		<td>Address</td>
		<td>Email</td>
		<td>Password</td>
		<td>Actions</td></tr></thead>
		<tbody>
	<% EmpDao ed = new EmpDao();
	List<Employee> li = ed.getEmps();
	for(Employee e : li){ 
			int id = e.getEid();%>
		<tr>
		<td><%= e.getEid() %></td>
		<td><%= e.getEname() %></td>
		<td><%= e.getSalary() %></td>
		<td><%= e.getAddress() %></td>
		<td><%= e.getEmail() %></td>
		<td><%= e.getPassword() %></td>
		<td><a href="edit/<%= id %>"><button>Edit</button></a>
		<a href="delete/<%= id %>"><button>Delete</button></a></td>
		</tr>
	<% }%>
	</tbody>
	</table>
</body>
</html>