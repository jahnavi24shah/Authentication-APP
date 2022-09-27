<!DOCTYPE HTML>
<html lang="en">
<head>
<title>Auth App - My Profile</title>
</head>
<body>
	<div>
		<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
	</div>
	<br>
	<div align="center">
		<p class="shadow-red-nou">Hello ${name} !</p>
	</div>
	<hr color="#fc3955">
	<div class="container" style="background-color: #f2f2f2">
		<div id="changePassword" style="display: none">
			<form method="post" action="/changePassword">
				<div style="overflow-x: auto;">
					<table class="table table-striped" style="font-size: 14px">
						<tr>
							<td><label>Enter old password:</label></td>
							<td><div class="group">
									<i class="fas fa-unlock"></i><input type="password"
										name="passwordOld" />
								</div></td>
						</tr>
						<tr>
							<td><label>Enter new password:</label></td>
							<td><div class="group">
									<i class="fas fa-unlock"></i><input type="password"
										name="passwordNew" />
								</div></td>
						</tr>
						<tr>
							<td><div align="center">
									<input type="button" onclick="back()" value="Back" />
								</div></td>
							<td><div align="center">
									<input type="submit" value="Change Password">
								</div></td>
						</tr>
					</table>
				</div>
			</form>
		</div>
		<div id="changeEmail" style="display: none">
			<form method="post" action="/changeEmail">
				<div style="overflow-x: auto;">
					<table class="table table-striped" style="font-size: 14px">
						<tr>
							<td><label>Enter new email:</label></td>
							<td><div class="group">
									<i class="fas fa-user"></i><input type="email" name="newEmail" />
								</div></td>
						</tr>
						<tr>
							<td><label>Enter password:</label></td>
							<td><div class="group">
									<i class="fas fa-unlock"></i><input type="password" name="password" />
								</div></td>
						</tr>
						<tr>
							<td><div align="center">
									<input type="button" onclick="back()" value="Back" />
								</div></td>
							<td><div align="center">
									<input type="submit" value="Change Email">
								</div></td>
						</tr>
					</table>
				</div>
			</form>
		</div>
		<form method="post" action="/updateMyProfile">
			<div style="overflow-x: auto;">
				<table class="table table-striped" style="font-size: 14px">
					<tr>
						<th>Name</th>
						<td><input type="text" id="name" name="name" readOnly
							value="${user.name}" class="profileUpdate" /></td>
						<td></td>
					</tr>
					<tr>
						<th>Mobile Number</th>
						<td><input type="number" id="mobile" name="mobile" readOnly
							value="${user.mobile}" class="profileUpdate" /></td>
						<td></td>
					</tr>
					<tr>
						<th>College Name</th>
						<td><input type="text" id="dojoName" name="dojoName"
							value="${user.dojoName}" readOnly class="profileUpdate" /></td>
						<td></td>
					</tr>
					<tr>
						<th>Designation</th>
						<td><select id="role" disabled name="role">
								<c:choose>
									<c:when test="${user.role=='INSTRUCTOR'}">
										<option value="INSTRUCTOR" selected>INSTRUCTOR</option>
										<option value="STUDENT">STUDENT</option>
									</c:when>
									<c:otherwise>
										<option value="STUDENT" selected>STUDENT</option>
										<option value="INSTRUCTOR">INSTRUCTOR</option>
									</c:otherwise>
								</c:choose>
						</select></td>
						<td></td>
					</tr>
					<tr>
						<th>Email</th>
						<td><label>${user.email}</label></td>
						<td></td>
					</tr>
					<tr>
						<th><div align="center">
								<!-- <input type="button" value="Change Email"
									onclick="changeEmail()" />&nbsp;&nbsp;&nbsp; --> <input
									type="button" value="Change Password" onclick="changePass()" />
							</div></th>
						<td><div align="center">
								<input type="button" value="Edit Profile" onclick="update()">
								<div id="updateButton" style="display: none">
									<br> <input type="button" onclick="back()" value="Back" />
									&nbsp;&nbsp;&nbsp; <input type="submit" class="hover-green"
										value="Save" />
								</div>
							</div></td>
						<td></td>
					</tr>
				</table>
			</div>
		</form>
	</div>
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
	<div>
		<%@ include file="/WEB-INF/jsp/common/footer.jsp"%>
	</div>
	<script>
		window.onload = function() {
			var err = "${errorMessage}";
			var succ = "${successMessage}";
			var errCP = "${errorMessageCP}";
			var succCP = "${successMessageCP}";
			var errCE = "${errorMessageCE}";
			var succCE = "${successMessageCE}";
			if (err != "") {
				alert(err);
			}
			if (succ != "") {
				alert(succ);
				window.location.pathname = '/myProfile';
			}
			if (errCP != "") {
				alert(errCP);
				window.location.pathname = '/myProfile';
			}
			if (succCP != "") {
				alert(succCP);
				window.location.pathname = '/myProfile';
			}
			if (errCE != "") {
				alert(errCE);
				window.location.pathname = '/myProfile';
			}
			if (succCE != "") {
				alert(succCE);
				window.location.pathname = '/logout';
			}
		}
		function update() {
			document.getElementById("name").focus();
			document.getElementById("name").readOnly = false;
			document.getElementById("name").style.border = "1px solid red";
			document.getElementById("mobile").readOnly = false;
			document.getElementById("mobile").style.border = "1px solid red";
			document.getElementById("dojoName").readOnly = false;
			document.getElementById("dojoName").style.border = "1px solid red";
			document.getElementById("role").disabled = false;
			document.getElementById("role").style.border = "1px solid red";
			document.getElementById("updateButton").style.display = "block";
			document.getElementById("changeEmail").style.display = "none";
			document.getElementById("changePassword").style.display = "none";
		}
		function back() {
			window.location.pathname = '/myProfile';
		}
		function changePass() {
			document.getElementById("changePassword").style.display = "block";
			document.getElementById("name").readOnly = true;
			document.getElementById("name").style.border = "";
			document.getElementById("mobile").readOnly = true;
			document.getElementById("mobile").style.border = "";
			document.getElementById("dojoName").readOnly = true;
			document.getElementById("dojoName").style.border = "";
			document.getElementById("role").disabled = true;
			document.getElementById("role").style.border = "";
			document.getElementById("updateButton").style.display = "none";
			document.getElementById("changeEmail").style.display = "none";
		}
		function changeEmail() {
			document.getElementById("changeEmail").style.display = "block";
			document.getElementById("name").readOnly = true;
			document.getElementById("name").style.border = "";
			document.getElementById("mobile").readOnly = true;
			document.getElementById("mobile").style.border = "";
			document.getElementById("dojoName").readOnly = true;
			document.getElementById("dojoName").style.border = "";
			document.getElementById("role").disabled = true;
			document.getElementById("role").style.border = "";
			document.getElementById("updateButton").style.display = "none";
			document.getElementById("changePassword").style.display = "none";
		}
	</script>
</body>
</html>