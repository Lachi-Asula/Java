<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.ojas.bean.*" %>
<%@ page import="com.ojas.service.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.ojas.controller.*" %>
<!DOCTYPE html>
<html>
<head>
<style>
	table {
		border-collapse: collapse;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border=2px>
		
	<c:forEach var="s" items="${lis}">
		<tr>
			<td>${s.getSid()}</td>
			<td>${ s.getSname() }</td>
			<td>${s.getEmailid() }</td>
			<td>${s.getPassword()}</td>
			<td>${s.getCity()}</td>
			</tr>	
		</c:forEach>
	</table>
</body>
</html>