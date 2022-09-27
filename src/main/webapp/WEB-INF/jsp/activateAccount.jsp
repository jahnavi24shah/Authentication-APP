<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html lang="en">
<head>
<title>TMS - Activate Account</title>
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
		<div align="center">
			<h2 class="shadow-red-nou">Redirecting to login page ...</h2>
				<a href="/"><button>If not, CLICK HERE to go to Login Page</button></a>
		</div>
	</div>
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
	<footer>
		<p class="copyright-agileinfo">&copy; 2020 Tournament Management
			System. All Rights Reserved | Design by Gaurav Gupta</p>
	</footer>
	<script>
		window.onload = function() {
			var err = "${error}";
			var succ = "${success}";
			if (err != "") {
				alert(err);
				window.location.pathname = '/';
			}
			if (succ != "") {
				alert(succ);
				window.location.pathname = '/';
			}
		}
	</script>
</body>
</html>