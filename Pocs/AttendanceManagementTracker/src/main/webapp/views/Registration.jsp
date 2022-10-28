<!DOCTYPE html>
<html lang="en">
<head>
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
</style>

<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
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
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
	crossorigin="anonymous"></script>

</head>
<body>
	<div class="back">
		<div class="div-center">
			<div class="card">
				<div class="card-header">
					<h4 style="color: gray; text-align: center">
						<b>Employee Registration</b>
						</h2>
				</div>
				<form action="/register" method="post">
					<div class="card-body">
						<input type="text" class="form-control" placeholder="Employee Id"
							name="empId" /><br> <input type="text" class="form-control"
							placeholder="Employee Name" name="empName" /><br> <input
							type="text" class="form-control" placeholder="Email Id"
							name="emailId" /><br> <input type="text"
							class="form-control" placeholder="BatchNum" name="batchNum" /><br>
						<p>
							Doj: <input type="text" id="datepicker" name="doj">
						</p>
					</div>
					<div class="card-footer">
						<input type="submit" value="Register">
					</div>
				</form>
			</div>
		</div>
	</div>
	</div>
</body>
</html>