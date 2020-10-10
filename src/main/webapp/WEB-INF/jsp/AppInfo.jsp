<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script> -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script type="text/javascript">
	$('#exampleModal').on('show.bs.modal', function(event) {
		var button = $(event.relatedTarget) // Button that triggered the modal
		var recipient = button.data('whatever') // Extract info from data-* attributes
		// If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
		// Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
		var modal = $(this)
		modal.find('.modal-title').text('New message to ' + recipient)
		modal.find('.modal-body input').val(recipient)
	})
</script>

<script type="text/javascript">
	var itemCount = 0;
	$(document).ready(
			function() {
				var objs = [];
				var temp_objs = [];
				$('#modalSave').click(
						function() {
							var dataEnv = $("#exampleModal #env").val();
							var dataUrl = $("#exampleModal #url").val();

							//#start display modal data on table
							var html = "";

							var obj = {
								"ROW_ID" : itemCount,
								"ENV" : dataEnv,
								"URL" : dataUrl

							}

							// add object
							objs.push(obj);

							itemCount++;
							// dynamically create rows in the table
							html = "<tr id='tr"+ itemCount + "'><td>"
									+ obj['ENV'] + "</td> <td>" + obj['URL']
									+ " </td> <td>";

								
							//add to the table
							$("#bill_table").append(html)
							//#endt display modal data on table
						
							// #start sending modal data to controler
							var postData = {
								env : $("#exampleModal #env").val(),
								url : $("#exampleModal #url").val()
							};
							console.log("Object is : " + postData);

							$.ajax({
								type : "POST",
								contentType : "application/json",
								url : "/sendModal",
								headers : {
									"Content-Type" : "application/json",
									"Accept" : "application/json"
								},
								data : JSON.stringify(postData),

								success : function(data) {
									console.log('my message' + data);

								},
								error : function(req, err) {
									console.log('my message' + err);
								},

							});// #end sending modal data to controler

						});
			});
</script>
</head>
<body>


	<form id="saveModal" action="/sendModal" method="post"></form>
	<form id="saveAppInfo" action="/sendAppInfo" method="post"></form>

	<div class="card text-center"
		style="width: 50rem; margin-top: 20px; margin-left: 200px;">
		<div class="card-header">AddAppInfo</div>
		<div class="card-body">

			<div class="form-row">

				<div class="form-group col-md-6">
					<label>Project Name</label> <input type="text" class="form-control"
						form="saveAppInfo" name="projectName" required>
				</div>

				<div class="form-group col-md-6">
					<label>Version</label> <input type="text" class="form-control"
						form="saveAppInfo" name="version">
				</div>
				<div class="form-group col-md-6">
					<label>Team Manager</label> <input type="text" class="form-control"
						form="saveAppInfo" name="teamManager">
				</div>

				<div class="form-group col-md-6">
					<label>Last Release</label> <input type="date" class="form-control"
						form="saveAppInfo" name="lastRelease">
				</div>

				<div class="form-group col-md-6">
					<label>Team Contact Email</label> <input type="email"
						class="form-control" form="saveAppInfo" name="email" required>
				</div>

				<div class="form-group col-md-6">
					<label>Next Release</label> <input type="date" class="form-control"
						form="saveAppInfo" name="nextRelease">
				</div>
			</div>


			<div class="form-row">

				<div class="form-group col-md-6">
					<label>De-Commissioned</label> <select class="form-control"
						form="saveAppInfo" name="deComm" required>
						<option value="1">YES</option>
						<option value="0">NO</option>
					</select>
				</div>

				<div class="form-group col-md-6">
					<label>Developed Date</label> <input type="date"
						class="form-control" form="saveAppInfo" name="developDate">
				</div>
				<div class="form-group col-md-6">
					

					<button type="button" class="btn btn-primary" data-toggle="modal"
						data-target="#exampleModal" data-whatever="@mdo"
						style="margin-right: 350px;">Add Env</button>
					<br>
				</div>

				<div class="form-group col-lg-6">
				
					<table border='1' id='bill_table' width='50%' cellspacing='3'
						cellpadding='5'></table>
					
				</div>


			</div>
			

			<input type="submit" class="btn btn-primary" name="save"
				id="saveAppData" value="Add" form="saveAppInfo" />

			


		</div>


		<br> <br>

		<div class="card-footer text-muted">Copy right x-workz</div>
	</div>
</body>

<!-- Modal HTML -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">New message</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">

				<div class="form-group">
					<label for="recipient-name" class="col-form-label">ENV:</label> <input
						type="text" class="form-control" form="saveModal" id="env"
						name="env" />
				</div>
				<div class="form-group">
					<label for="recipient-name" class="col-form-label">URL:</label> <input
						type="text" class="form-control" form="saveModal" id="url"
						name="url" />
				</div>
			

			</div>
			<div class="modal-footer">

				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>

				<!-- <input type="submit" class="btn btn-primary" value="Save"
					form="saveModal" /> -->

				<button type="button" class="btn btn-primary" id="modalSave"
					data-dismiss="modal">Save</button>


			

			</div>
		</div>
	</div>
</html>
