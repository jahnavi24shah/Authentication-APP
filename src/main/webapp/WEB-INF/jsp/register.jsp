<!DOCTYPE HTML>
<html lang="en">
<head>
<title>Auth App - Register</title>
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
		<h2 class="shadow-red-nou">Register Here</h2>
		<form name="registerForm" method="POST" onsubmit="return validate()">
			<div class=" w3l-form-group">
				<label>Full Name:</label>
				<div class="group">
					<i class="fas fa-user"></i> <input type="text" class="form-control"
						placeholder="Full Name" name="name" required="required" />
				</div>
			</div>
			<div class=" w3l-form-group">
				<label>Email:</label>
				<div class="group">
					<i class="fas fa-envelope-square"></i> <input type="email"
						class="form-control" placeholder="Username" name="uname"
						required="required" />
				</div>
			</div>
			<div class=" w3l-form-group">
				<label>Password:</label>
				<div class="group">
					<i class="fas fa-unlock"></i> <input type="password"
						class="form-control" placeholder="Password" name="password1"
						required="required" />
				</div>
			</div>
			<div class=" w3l-form-group">
				<label>Re-Enter Password:</label>
				<div class="group">
					<i class="fas fa-unlock"></i> <input type="password"
						class="form-control" placeholder="Password" name="password"
						required="required" />
				</div>
			</div>
			<div class=" w3l-form-group">
				<label>Mobile Number:</label>
				<div class="group">
					<i class="fas fa-phone-square"></i> <input type="number"
						class="form-control" maxlength="10"
						placeholder="10 digit mobile number" name="mobile"
						required="required" />
				</div>
			</div>
			<div class=" w3l-form-group">
				<label>College Name:</label>
				<div class="group">
					<i class="fas fa-home"></i> <input type="text" class="form-control"
						placeholder="University Name" name="dojoName" required="required" />
				</div>
			</div>
			<div class=" w3l-form-group">
				<label>Designation:</label>
				<div class="group">
					<i class="fas fa-tag"></i> <select class="form-control" name="role"
						required="required">
						<option value="STUDENT">Student</option>
						<option value="INSTRUCTOR">Instructor</option>
					</select>
				</div>
			</div>
			<h3 class="shadow-red" align="center">${errorMessage}</h3>
			<button type="submit" id="submit" name="submit" onClick="validate()">Register</button>
			<br> <br> <input type="reset" value="Reset" />
		</form>
		<p class=" w3l-register-p">
			Already have an account?<a href="/login" class="register"> Login</a>
		</p>
	</div>
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
	<footer>
		<p class="copyright-agileinfo">&copy; 2022 | Group Numner 21 | All Rights Reserved</p>
	</footer>
	<script>
		window.onload = function() {
			var err = "${regErrorMessage}";
			var succ = "${regSuccessMessage}";
			var regErr = "${dupErrorMessage}";
			if (err != "") {
				alert(err);
			}
			if (succ != "") {
				alert(succ);
				window.location.pathname = '/';
			}
			if (regErr != "") {
				alert(regErr);
				window.location.pathname = '/';
			}
		}
		function validate(){
			var pass1=document.forms["registerForm"]["password1"].value;
			var pass2=document.forms["registerForm"]["password"].value;
			var mob=document.forms["registerForm"]["mobile"].value;
			if(pass1!=pass2){
				alert("Password doesn't match");
				return false;
			}
			if(mob.length!=10){
				alert("Mobile number should be of 10 digits!");
				return false;
			}
			return true;
		}
	</script>
</body>

</html>