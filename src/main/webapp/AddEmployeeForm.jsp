<!DOCTYPE html>
<html>

<head>
	<title>Add Employee</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-student-style.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">	
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2 align="center">XYZ Private Ltd</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Add Employee</h3>
		
		<div>
			<img style="float: right;" alt="" src="UEM_New_Logo2016.png" width=350 height=250>
		</div>
		
		<form action="EmployeeControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="ADD" />
			
			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><input type="text" name="firstName" /></td>
					</tr>

					<tr>
						<td><label>Last name:</label></td>
						<td><input type="text" name="lastName" /></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><input type="text" name="email" /></td>
					</tr>
					
					<tr>
						<td><label>Designation:</label></td>
						<td><input type="text" name="designation" /></td>
					</tr>
					
					<tr>
						<td><label>Phone Number:</label></td>
						<td><input type="text" name="contact" /></td>
					</tr>
					<tr>
						<td><label>Dept. ID:</label></td>
						<td><input type="text" name="deptid" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="EmployeeControllerServlet">Back to List</a>
		</p>
	</div>
	<div class="footer">
		<p>Developed By Amitrajit Bose, Sourav Kumar & Kirti Ojha at University of Engineering & Management, Kolkata</p>
	</div>
</body>

</html>











