<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.back {
  background: #e2e2e2;
  width: 100%;
  position: absolute;
  top: 0;
  bottom: 0;
}

.div-center {
  width: 400px;
  height: 400px;
  background-color: #fff;
  position: absolute;
  left: 0;
  right: 0;
  top: 0;
  bottom: 0;
  margin: auto;
  max-width: 100%;
  max-height: 100%;
  overflow: auto;
  padding: 1em 2em;
  border-bottom: 2px solid #ccc;
  display: table;
}

div.content {
  display: table-cell;
  vertical-align: middle;
}
</style>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
</head>
<body>
	<div class="back" style=background-color:gray>
	<div class="div-center" style=background-color:snow>
		<div class="content">
	
		<div class="card" style=background-color:lightgray>
			<div class="card-header">
				<h3 style=color:brown;text-align:center>Book Signin</h3>
			</div>
			<div class="card-body">
				<!-- <div class="row">
					<div class="col-sm-4"> -->
				<h6 style=color:gray;text-align:center><I>${err}</I></h6>
						<form action="validate" method="post">
							<input type="text" class="form-control" placeholder="Book Name" name="bookname"><br>
							<input type="text" class="form-control" placeholder="Author Name" name="authorname"><br>
							
							<input type="submit" value="signin">
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
<!-- </div></div> -->
</body>
</html>