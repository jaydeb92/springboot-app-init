<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<form action="sendMessage" method="post">

		<div class="card text-center"
			style="width: 50rem; margin-top: 20px; margin-left: 200px;">
			<div class="card-header">X-workz</div>
			<div class="card-body">

				<div class="form-row">

					<div class="form-group col-md-4"></div>

					<div class="form-group col-md-4">
						<label>From</label> <input type="text" class="form-control"
							name="fromName" required>
					</div>
					<div class="form-group col-md-4"></div>
					<div class="form-group col-md-4"></div>
					<div class="form-group col-md-4">
						<label>Enter a Message</label> <input type="text"
							class="form-control" name="message" required>
					</div>
				</div>

				<input class="btn btn-primary" type="submit" value="Send">

				<div class="card-footer text-muted">Copy right x-workz</div>
			</div>
	</form>
</body>
</html>