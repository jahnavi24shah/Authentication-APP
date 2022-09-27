<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html lang="en">

<head>
<title>TMS - Page Not Found</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/fontawesome-all.css" rel="stylesheet" />
<link
	href="//fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
</head>

<body>
	<h1>Welcome to Tournament Management System</h1>

	<div class="w3l-login-form">
		<h3 class="shadow-red-nou" align="center">Oops! Page not found ...</h3>
		<br><br>
		<div align="center">
			<a href="/" class="shadow-red"><button>CLICK HERE to go to main page</button></a>
		</div>
	</div>

	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
	<footer>
		<p class="copyright-agileinfo">&copy; 2020 Tournament Management
			System. All Rights Reserved | Design by Gaurav Gupta</p>
	</footer>
</body>

</html>