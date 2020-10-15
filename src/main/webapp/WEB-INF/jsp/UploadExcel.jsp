<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
	<center>${message}</center>
	<form action="uploadFile" method="post" enctype="multipart/form-data">

		<div class="card text-center"
			style="width: 50rem; margin-top: 20px; margin-left: 200px;">
			<div class="card-header">X-workz</div>
			<div class="card-body">

				<div class="form-row">

					<div class="form-group col-md-4"></div>

					<div class="form-group col-md-4">
						<label>Choose File</label> <input type="file" class="form-control"
							name="excelfile">
					</div>
				</div>

				<input class="btn btn-primary" type="submit" value="Submit"><br>
				<br>

				<div class="card-footer text-muted">Copy right x-workz</div>
			</div>
	</form>
</body>
</html>