<!DOCTYPE HTML>
<html lang="en">
<title>Auth App - Dashboard</title>
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
	<div id="listParticipant">
		<div class="container" style="background-color: #f2f2f2">
			<p class="shadow-red-nou">Group Number: 21</p>
			<div style="overflow-x: auto;">
				<table class="table table-striped" style="font-size: 14px">
					<!-- <caption>Here are the participants you have registered</caption> -->
					<thead>
						<tr>
							<th>Name</th>
							<th>Student ID</th>
						</tr>
					</thead>
					<tbody>
							<tr>
								<td>Gaurav Gupta</td>
								<td>110077023</td>
							</tr>
							<tr>
								<td>Jahnavi Jatinbhai Shah</td>
								<td>110071442</td>
							</tr>
							<tr>
								<td>Dhruvi Jyotindra Patel</td>
								<td>110074281</td>
							</tr>
							<tr>
								<td>Dheeraj Gavini</td>
								<td>110074707</td>
							</tr>
					</tbody>
				</table>
			</div>
		</div>
		<br>
	</div>
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
	<div>
		<%@ include file="/WEB-INF/jsp/common/footer.jsp"%>
	</div>
</body>
</html>