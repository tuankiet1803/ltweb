<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<head>
<meta charset="UTF-8">
<title>Registration Form</title>
<style>
/* CSS styles for the registration form container */
.registration-container {
	width: 600px; /* Set the width of the container */
	margin: 0 auto; /* Center the container horizontally */
	padding: 20px; /* Add some padding inside the container */
	border: 2px solid #ccc; /* Add a border */
	border-radius: 10px; /* Add some border radius */
	background-color: #f9f9f9; /* Background color */
}

/* CSS styles for the heading */
.registration-heading {
	text-align: center; /* Center the heading text */
}

/* CSS styles for input fields */
.input-field {
	width: 100%;
	padding: 8px;
	margin: 5px 0;
	box-sizing: border-box;
}
</style>
</head>
<body>

	<div class="registration-container">
		<h2 class="registration-heading">Registration Form</h2>
		<form action="/ltweb/register" method="post">
			<label for="image">Image:</label> 
			<input type="text" id="image" name="image" class="input-field" required><br> 
			<label for="fullname">Full Name:</label> 
			<input type="text" id="fullname" name="fullname" class="input-field" required><br> 
			<label for="email">Email:</label> 
			<input type="email" id="email" name="email" class="input-field" required><br> 
			<label for="phone">Phone:</label> 
			<input type="tel" id="phone" name="phone" class="input-field" required><br> 
			<label for="percentage">Password</label> 
			<input type="text" id="password" name="password" class="input-field" required><br>

			<button class="btn btn-primary" type="submit">Register</button>
			<button class="btn btn-primary" onclick="location.href='/ltweb/login'" type="button">
         Login</button>
		</form>
	</div>
		<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>