<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html lang="en">
<script src="https://code.jquery.com/jquery-3.3.1.js"
	integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
<style>
li:hover {
	background-color: #00BCD4;
	transition-duration: 2s;
}

.active {
	text-decoration: bold;
	background-color: #00BCD4;
}
</style>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/fontawesome-all.css" rel="stylesheet" />
<link
	href="//fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light"
		style="background-color: #fc3955">
		<a class="navbar-brand shadow-white-red" href="/">Auth App</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">

				<c:if test="${not empty dashboard}">
					<li class="nav-item active"><a class="nav-link" href="/"><font
							color="white">Dashboard</font> <span class="sr-only">(current)</span></a>
					</li>
				</c:if>
				<c:if test="${empty dashboard}">
					<li class="nav-item"><a class="nav-link" href="/"><font
							color="white">Dashboard</font> <span class="sr-only">(current)</span></a>
					</li>
				</c:if>
<!-- 
				<c:if test="${not empty addParticipants}">
					<li class="nav-item active"><a class="nav-link"
						href="/addParticipants"><font color="white">Add
								Participants</font></a></li>
				</c:if>
				<c:if test="${empty addParticipants}">
					<li class="nav-item"><a class="nav-link"
						href="/addParticipants"><font color="white">Add
								Participants</font></a></li>
				</c:if>

				<c:if test="${not empty update}">
					<li class="nav-item active"><a class="nav-link"
						href="/update-participant"><font color="white">Update
								Participant</font></a></li>
				</c:if>
				<c:if test="${empty update}">
					<li class="nav-item"><a class="nav-link"
						href="/update-participant"><font color="white">Update
								Participant</font></a></li>
				</c:if>

				<c:if test="${not empty delete}">
					<li class="nav-item active"><a class="nav-link"
						href="/delete-participant"><font color="white">Delete
								Participant</font></a></li>
				</c:if>
				<c:if test="${empty delete}">
					<li class="nav-item"><a class="nav-link"
						href="/delete-participant"><font color="white">Delete
								Participant</font></a></li>
				</c:if>

				<c:if test="${not empty bout}">
					<c:if test="${not empty admin}">
						<li class="nav-item active"><a class="nav-link" href="/bout"><font
								color="white">Bout</font></a></li>
					</c:if>
				</c:if>
				<c:if test="${empty bout}">
					<c:if test="${not empty admin}">
						<li class="nav-item"><a class="nav-link" href="/bout"><font
								color="white">Bout</font></a></li>
					</c:if>
				</c:if>
				
				<c:if test="${not empty boutMaker}">
					<c:if test="${empty admin}">
						<li class="nav-item active"><a class="nav-link" href="/boutMaker"><font
								color="white">Bout</font></a></li>
					</c:if>
				</c:if>
				<c:if test="${empty boutMaker}">
					<c:if test="${empty admin}">
						<li class="nav-item"><a class="nav-link" href="/boutMaker"><font
								color="white">Bout</font></a></li>
					</c:if>
				</c:if>
-->
				<c:if test="${not empty profile}">
					<li class="nav-item active"><a class="nav-link"
						href="/myProfile"><font color="white">My Profile</font></a></li>
				</c:if>
				<c:if test="${empty profile}">
					<li class="nav-item"><a class="nav-link" href="/myProfile"><font
							color="white">My Profile</font></a></li>
				</c:if>

			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="nav-item"><a class="nav-link" href="/logout"><font
						color="white">Logout</font></a></li>
			</ul>
		</div>
	</nav>
</body>
</html>