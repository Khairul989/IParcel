<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">  
<!-- Data tables -->
	<script type="text/javascript" charset="utf8" src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
	
<title>Main Menu Admin</title>
<style type="text/css">
#kotak {
  background-color: black;
  width: 40%;
  border: 15px solid blueviolet;
  padding: 50px;
  margin: 0;
  position: absolute;
  top: 63%;
  left: 50%;
  -ms-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
}
 input[type=email], select{
	width: 80%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}
 input[type=text], select{
	width: 80%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}
 input[type=password], select{
	width: 80%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}
#tbl1 th{
	color : white;
}
</style>
</head>
<body background = "img/wallpaper.jpg">
	<jsp:useBean id="lecturer" class="java.util.ArrayList" scope="request"></jsp:useBean>
	<jsp:useBean id="student" class="java.util.ArrayList" scope="request"></jsp:useBean>
	<jsp:useBean id="user" class="iparcel.model.staff" scope="session"></jsp:useBean>
	<jsp:useBean id="parcel" class="java.util.ArrayList" scope="request"></jsp:useBean>
	<jsp:useBean id="staff" class="java.util.ArrayList" scope="request"></jsp:useBean>
	<jsp:useBean id="notTaken" class="java.util.ArrayList" scope="request"></jsp:useBean>
<c:if test="${not empty user }">

	<nav class="navbar navbar-inverse">
  		<div class="container-fluid">
    		<div class="navbar-header">
      			<a class="navbar-brand" href="#"><b>iParcel</b></a>
    		</div>
    		<ul class="nav navbar-nav">
      		<li class="active"><a href="#">Home</a></li>
      		
      		<c:if test="${user.id == 1111}"><li class="dropdown"><a data-toggle="modal" href="#" data-target="#myModal">Register new Staff</a></li></c:if>
      		<li><a href="setter">List of Staff</a></li>
      		<li><a href="ViewAll">List All</a></li>
      		<li><a href="parcelNotTaken?track=view">Update Parcel</a></li>
	      	<li><a href="setMessage?id=${user.id }&type=staff">Sent Message</a></li>
	      	<li><a href="setMessage?id=${user.id }&type=staffview">View Message</a></li>
    		</ul>
    		<ul class="nav navbar-nav navbar-right">
            <li class="dropdown"><a href='logout'><span class="glyphicon glyphicon-log-in"></span>	Logout</a></li>
    		</ul>
  		</div>
	</nav>
	<div align="center">
		<h1 style="color:white"><b>Welcome to I-Parcel</b></h1>
			<h4 style="color:white">
				Hi ${user.name}!.
				Add new parcel??
			</h4>
			<div id="kotak">
				<form action="update" method="post">
					<table id="tbl1" width="100%" cellpadding="8px;" style="border-collapse:collapse; font-family:'Arial Black', Gadget, sans-serif;">
						<tr>
							<th>ID</th>
							<td style="color:red"><input type="hidden" name="id" value="${user.id}">${user.id}</td>
						</tr>
						<tr>
							<th>NAME</th>
							<td><input type="text" name="name" placeholder="${user.name}" required></td>
						</tr>
						<tr>
							<th>EMAIL</th>
							<td><input type="email" name="mail" placeholder="${user.email}" required></td>
						</tr>
						<tr>
							<th>PHONE</th>
							<td><input type="text" name="phone" placeholder="${user.phone}" maxlength="11" minlength="10" required></td>
						</tr>
						<tr>
							<th>IC</th>
							<td><input type="text" name="ic" placeholder="${user.ic}" maxlength="12" minlength="12" required></td>
						</tr>
						<tr>
							<th>PASSWORD</th>
							<td><input  type="password" name="pass" placeholder="${user.password }"></td>
						</tr>
						<tr>
							<td></td>
							<td ><input type="submit" value="UPDATE" class="btn btn-primary"></td>
						</tr>
					</table>
					<input type="hidden" name="type" value="staff">
				</form>
			</div>
			 <br><a class="btn btn-success" href="AddParcel?type=lect" >Add Parcel Lecturer</a>
			 <a class="btn btn-success" href="AddParcel?type=stud" >Add Parcel Student</a><br>
	</div>	
</c:if>

<c:if test="${empty user}">
	<br>
	<h3 style="color:white">
		You are not logged in.
		<a href="index.jsp">Login</a>
	</h3>
</c:if>
	
	<!-- modal register staff -->
		<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Lecturer Registration</h4>
				</div>
				<div class="modal-body" style="background-color: black;">
					<div align="center">
						<form action="Registers" method="POST">
							<input type="hidden" name="user" value="staff">
							<input type="text" placeholder="Full Name" name="name" required><br>
							<input type="text" placeholder="IC Number" name="ic" required minlength="12" maxlength="12"><br>
							<input type="text" placeholder="Phone Number" name="phone" required minlength="10" maxlength="11"><br> 
							<input type="email" placeholder="Email" name="mail" required><br> 
							<input type="text" placeholder="Staff ID" name="id" minlength = "10" maxlength = "10" required><br>
							<input type="password" placeholder="Password" name="pwd" required><br> 
							<input type="submit" value="Register" class="btn btn-primary">
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

	<!-- modal register staff -->
		<div class="modal fade" id="myModal2" role="dialog">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Update Parcel</h4>
				</div>
				<div class="modal-body" style="background-color: white;">
					<div align="center">
						<table id="example1" class="table table-striped table-bordered" style="width:100%">
					        <thead>
					            <tr>
					                <th>ID</th>
					                <th>Tracking Number</th>
					                <th>Parcel Type</th>
					                <th>Date Arrive</th>
					                <th>Date Collected</th>
					                <th>Courier</th>
					                <th>Status</th>
					                <th>Update</th>
					            </tr>
					        </thead>
					        <tbody>
								<c:forEach var="p" items="${notTaken}">
									<tr>
										<td>${p.pid }</td>
										<td>${p.ptrack }</td>
										<td>${p.ptype }</td>
										<td>${p.date_arrive }</td>
										<td>${p.date_collected }</td>
										<td>${p.courier }</td>
										<td>${p.status }</td>
										<td><a href="setter?process=update" class="btn btn-success">Update</a>
									</tr>
								</c:forEach>
					        </tbody>
					        <tfoot>
					            <tr>
					                <th>ID</th>
					                <th>Tracking Number</th>
					                <th>Parcel Type</th>
					                <th>Date Arrive</th>
					                <th>Date Collected</th>
					                <th>Courier</th>
					                <th>Status</th>
					                <th>Update</th>
					            </tr>
					        </tfoot>
					    </table>
					</div>
				</div>
				<div class="modal-footer">
					<p align="left">Please fill in this form to create an account</p>
					<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
<script>
	$(document).ready(function() {
	    $('#example1').DataTable();
	} );
</script>
</body>
</html>