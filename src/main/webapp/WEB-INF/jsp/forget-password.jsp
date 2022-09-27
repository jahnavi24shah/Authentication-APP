<!DOCTYPE HTML>
<html lang="en">

<head>
<title>TMS</title>
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
		<h2 class="shadow-red-nou">Get Password Here</h2>
		<form method="POST">

			<div class=" w3l-form-group">
				<label>Email:</label>
				<div class="group">
					<i class="fas fa-user"></i> <input type="email" class="form-control"
						placeholder="Username" name="email" required="required" />
				</div>
			</div>
			<div>
				<h3 class="shadow-red" align="center">${errorMessage}</h3>
				<h3 class="shadow-red" align="center">${newUserMessage}</h3>
				<h3 class="shadow-red-nou" align="center">${userPassword}</h3>
			</div>
			<button type="submit">Get Password</button><br><br>
			<input type="reset" value="Reset"/>
		</form>
		<p class=" w3l-register-p">
			Return to login page<a href="/" class="register">
				Login</a>
		</p>
	</div>
	<footer>
		<p class="copyright-agileinfo">&copy; 2022 | Group Nummber 21 | All Rights Reserved</p>
	</footer>
	<script>
    window.onload = function(){
    	var err = "${errorMessage}";
    	var newUser = "${newUserMessage}";
    	if(err!=""){
    		alert(err);
    	}
    	if(newUser!=""){
    		alert(newUser);
    		window.location.pathname = '/register';
    	}
    }
    </script>
</body>

</html>