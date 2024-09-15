<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="ISO-8859-1">
<title>Login and Logout Form</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>Insert title here</title>

<style>
body {
	background-color: #f8f9fa;
	padding-top: 50px;
}

.form-login {
	max-width: 330px;
	padding: 15px;
	margin: auto;
}

.form-login .form-control {
	position: relative;
	box-sizing: border-box;
	height: auto;
	padding: 10px;
	font-size: 16px;
}
</style>
</head>
<body>
	<div class="container">
		<form class="form-login" method="post" action="/ltweb/login">
			<h2 class="mb-3">Login</h2>
			<%
			if (request.getParameter("error") != null) {
			%>
			<div class="alert alert-danger" role="alert"></div>
			<%
			}
			%>
			<div class="mb-3">
				<label for="phone" class="form-label">Phone</label> <input
					type="text" id="phone" name="phone" class="form-control"
					required>
			</div>
			<div class="mb-3">
				<label for="password" class="form-label">Password</label> <input
					type="password" id="password" name="password" class="form-control"
					required>
			</div>
			<button class="btn btn-primary" type="submit">Sign in</button>
			<button class="btn btn-primary" onclick="location.href='/ltweb/register'" type="button">
         Sign up</button><br>
        	<a href = "/ltweb/forgotpassword">Quen mat khau</a>
		</form>
		<br/>
		
		<%

		%>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>