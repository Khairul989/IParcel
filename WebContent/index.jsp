<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>iParcel</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<link href="style.css" rel="stylesheet" type="text/css">

<style>
input[type=email], select {
	width: 30%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

h6 {
	color: white;
}
.fa{
  color:white;
  font-size:27px;
  margin-left:8px;
}
</style>
</head>
<body background="img/wallpaper.jpg">
	<%--Navigation bar--%>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#"><b>iParcel</b></a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Register<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#" data-toggle="modal" data-target="#myModal"><span
								class="glyphicon glyphicon-user"></span> Student</a></li>
						<li><a href="#" data-toggle="modal" data-target="#myModal1"><span
								class="glyphicon glyphicon-user"></span> Lecture</a></li>
					</ul></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"><span
						class="glyphicon glyphicon-log-in"></span> Login<span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#" data-toggle="modal" data-target="#myModal2"><span
								class="glyphicon glyphicon-user"></span> Customer</a></li>
						<li><a href="#" data-toggle="modal" data-target="#myModal4"><span
								class="glyphicon glyphicon-user"></span> Administration</a></li>
					</ul></li>
			</ul>
		</div>
	</nav>

	<%--Logo UiTM--%>
	<div align="center">
		<img src="img\uitm.png" width="330" height="280">
		<h1 align="center">
			<font color="white"><b>Welcome to iParcel<br>Universiti
					Teknologi Mara
			</b> <br></font>
		</h1>
		
		<%--Form search by--%>
		<form action="searchParcel" method="POST">
			<br> <input type="text" name="answer" placeholder="Enter your ID"><br>
			<input type="submit" value="Submit" class="w3-btn w3-purple">
		</form>
	</div>
	
	<%--Student Register--%>
	<!-- Modal -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Student Registration</h4>
				</div>
				<div class="modal-body" style="background-color: black;">
					<div align="center">
						<form action="Registers" method="POST">
							<input type="hidden" name="user" value="student">
							<input type="text" placeholder="Full Name" name="name" required><br>
							<input type="text" placeholder="IC Number" name="ic" maxlength="12" minlength="12" required><br> 
							<input type="text" placeholder="Phone Number" name="phone" required maxlength="11" minlength="10"><br>
							<input type="email" placeholder="Email" name="email" required><br>
							<input type="text" placeholder="Student ID" maxlength="10" minlength="10" name="stu_id" required><br>
							<input type="text" placeholder="Course Code" name="prog" required><br>
							<input type="password" placeholder="Password" name="pass" required><br> <input type="hidden" name="status" value="Active"> 
							<input type="submit" value="Register" class="w3-btn w3-purple">
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<p align="left">Please fill in this form to create an account</p>
					<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>

	<%--Lecture Register--%>
	<!-- Modal -->
	<div class="modal fade" id="myModal1" role="dialog">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Lecturer Registration</h4>
				</div>
				<div class="modal-body" style="background-color: black;">
					<div align="center">
						<form action="Registers" method="POST">
							<input type="hidden" name="user" value="lecturer">
							<input type="text" placeholder="Full Name" name="name" required><br>
							<input type="text" placeholder="IC Number" name="ic" required minlength="12" maxlength="12"><br>
							<input type="text" placeholder="Phone Number" name="phone"
								required minlength="10" maxlength="11"><br> <input type="email"
								placeholder="Email" name="mail" required><br> <input
								type="text" placeholder="Lecturer ID" name="id" minlength = "10" maxlength = "10" required><br>
							<select name="faculty">
								<option value="FSKM" selected>FSKM</option>
								<option value="FPA">FPA</option>
							</select><br> <input type="password" placeholder="Password"
								name="pwd" required><br> <input type="submit"
								value="Register" class="w3-btn w3-purple">
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<p align="left">Please fill in this form to create an account</p>
					<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>

	<%--Customer Login --%>
	<!-- Modal -->
	<div class="modal fade" id="myModal2" role="dialog">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">CUSTOMER LOGIN</h4>
				</div>
				<div class="modal-body" style="background-color: black;"
					align="left">
					<form action="Login" method="POST">
						<br> <input type="text" name="id" placeholder="Please insert your ID" maxlength="10" minlength="10" required>
						<br> <input type="password" name="password" id="password-field" placeholder="Please insert your password" required>
						<i id="pass-status" class="fa fa-eye" aria-hidden="true" onClick="viewPassword()"></i>
						<br>
						<div style="color:white">
							<input type="radio" name="customer" value="student" required>Student<br>
							<input type="radio" name="customer" value="lecturer" required>Lecturer
						</div>
						<br> <input type="submit" value="Submit">
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>

	<%--Admin Login --%>
	<!-- Modal -->
	<div class="modal fade" id="myModal4" role="dialog">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">ADMINISTRATOR LOGIN</h4>
				</div>
				<div class="modal-body" style="background-color: black;">
					<form action="Login" method="POST">
						<br> <input type="text" name="id" maxlength="10" placeholder="Staff ID" required>
						<br> <input id="pass" type="password" name="password" placeholder="Password" required>
						<i id="pass-status1" class="fa fa-eye" aria-hidden="true" onClick="viewPassword1()"></i>
							<input type="hidden" name="customer" value="admin">
						<br> <input type="submit" value="Submit">
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	
<script>
	function viewPassword()
	{
	  var passwordInput = document.getElementById('password-field');
	  var passStatus = document.getElementById('pass-status');
	 
	  if (passwordInput.type == 'password'){
	    passwordInput.type='text';
	    passStatus.className='fa fa-eye-slash';
	    
	  }
	  else{
	    passwordInput.type='password';
	    passStatus.className='fa fa-eye';
	  }
	}
	function viewPassword1()
	{
	  var passwordInput = document.getElementById('pass');
	  var passStatus = document.getElementById('pass-status1');
	 
	  if (passwordInput.type == 'password'){
	    passwordInput.type='text';
	    passStatus.className='fa fa-eye-slash';
	    
	  }
	  else{
	    passwordInput.type='password';
	    passStatus.className='fa fa-eye';
	  }
	}
	
</script>
</body>
</html>