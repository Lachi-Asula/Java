<%@page import="com.epaper.Epaper_Bean"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.EpaperDb"%>
<%!	
	
	
%>

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
	<form action="ScoreServ2" method=post>
	<div class = "container">
		<div class ="card">
			<div class ="card-header">
				<h3 style=color:brown;text-align:center>Welcome <%= session.getAttribute("fname") %></h1>
			</div>
			<div class ="card-body">
			<% 	int row = 11;
				EpaperDb ed = new EpaperDb();	
				List<Epaper_Bean> li = ed.listQuestions();
			 for(int i = 10; i < li.size(); i++){
				Epaper_Bean epd = li.get(i);
				int qno = epd.getQno();
				String qname = epd.getQname();
			%>
				<strong><%= row + ")." +  qname %></strong><br>
				<input type=radio name=<%= qno%> value="<%= epd.getOpt1() %>"><%= epd.getOpt1() %>&nbsp;&nbsp;
				<input type=radio name=<%= qno%> value="<%= epd.getOpt2() %>"><%= epd.getOpt2() %>&nbsp;&nbsp;
				<input type=radio name=<%= qno%> value="<%= epd.getOpt3() %>"><%= epd.getOpt3() %>&nbsp;&nbsp;
				<input type=radio name=<%= qno%> value="<%= epd.getOpt4() %>"><%= epd.getOpt4() %>&nbsp;&nbsp;
				<br><br>
				
			<% row = row + 1;}%>
			</div>
			<div class="card-footer">
				<input type=submit value="submit">
			</div>
		</div>
	</div>
	</form>
</body>
</html>>