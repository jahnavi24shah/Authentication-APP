<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html lang="en">

<head>
<title>Auth App - Login</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/fontawesome-all.css" rel="stylesheet" />
<link
	href="//fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
</head>

<body>
	<h1>Welcome to Authentication Application</h1>
	<div class=" w3l-login-form">
		<h2 class="shadow-red-nou">Login Here</h2>
		<form method="POST" action="/login" name="login">

			<div class=" w3l-form-group">
				<label>Email:</label>
				<div class="group">
					<i class="fas fa-user"></i> <input type="email"
						class="form-control" placeholder="Username" name="username"
						required="required" />
				</div>
			</div>
			<div class=" w3l-form-group">
				<label>Password:</label>
				<div class="group">
					<i class="fas fa-unlock"></i> <input type="password"
						class="form-control" placeholder="Password" name="password"
						required="required" />
				</div>
				<div align="center">
					<h3 class="shadow-red">
						<c:if test="${not empty error}">
							<div class="error">${error}</div>
						</c:if>
						<c:if test="${not empty msg}">
							<div class="msg">${msg}</div>
						</c:if>
					</h3>
				</div>
			</div>
			<div class="forgot">
				<a href="/forget-password">Forgot Password?</a>
				<p>
					<input type="checkbox">Remember Me
				</p>
			</div>
			<button type="submit" class="hover-green">Login</button>
		</form>
		<p class=" w3l-register-p">
			Don't have an account?<a href="/register" class="register">
				Register</a>
		</p>
	</div>
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
	<footer>
		<p class="copyright-agileinfo">&copy; 2022 | Group Number 21 | All Rights Reserved</p>
	</footer>
</body>

</html>