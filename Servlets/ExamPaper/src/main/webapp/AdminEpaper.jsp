<%@ page import = "java.sql.*" %>
<%@ page import = "java.util.*" %>
<%@ page import = "com.epaper.*" %>
<%@ page import = "com.dao.*" %>

<%-- <%!	
	EpaperDb edb = new EpaperDb();
	List<Epaper_Bean> li = edb.listQuestions();
	
%> --%>

<html>
<head>
<title>
</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
</head>
<body>
	<form action="DelQuestion">
	<div class = "container">
		<div class ="card">
			<div class ="card-header">
				<h1 style=color:brown;text-align:center>Questions List</h1>
			</div>
			<div class ="card-body">
			<%	EpaperDb edb = new EpaperDb();
				List<Epaper_Bean> li = edb.listQuestions(); 
			 	int row = 1;
			 	for(Epaper_Bean epd : li){
					int qno = epd.getQno();
					String qname = epd.getQname();
			%>
				
				<strong><%= row + " ). " + qname %></strong>&emsp;<button type=submit name=submit value=<%= qno%>>Delete</button><br><br>
				<input type=radio name=<%= qno%> value="<%= epd.getOpt1() %>"><%= epd.getOpt1() %>&nbsp;&nbsp;
				<input type=radio name=<%= qno%> value="<%= epd.getOpt2() %>"><%= epd.getOpt2() %>&nbsp;&nbsp;
				<input type=radio name=<%= qno%> value="<%= epd.getOpt3() %>"><%= epd.getOpt3() %>&nbsp;&nbsp;
				<input type=radio name=<%= qno%> value="<%= epd.getOpt4() %>"><%= epd.getOpt4() %>&nbsp;&nbsp;
				<br><br>
				<% row = row + 1; %>
			<%}%>
		</div>
	</div>
	</div>
	</form>
</body>
</html>