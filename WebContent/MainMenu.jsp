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

<title>Student Menu</title>

<style>
#kotak {
  background-color: white;
  width: 80%;
  border: 15px solid blueviolet;
  padding: 50px;
  margin: 0;
  position: absolute;
  top: 25%;
  left: 10%;
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
#tbl th{
	color:white;
}
</style>
</head>
<body background="img/wallpaper.jpg">
<jsp:useBean id="parcel" class="java.util.ArrayList" scope="request"></jsp:useBean>
<jsp:useBean id="par" class="java.util.ArrayList" scope="request"></jsp:useBean>
<div align="center">
	
	<c:if test="${not empty user }">
		<nav class="navbar navbar-inverse">
	  		<div class="container-fluid">
	    		<div class="navbar-header">
	      			<a class="navbar-brand" href="#"><b>iParcel</b></a>
	    		</div>
	    		<ul class="nav navbar-nav">
	      		<li class="active"><a href="#">Home</a></li>
	      		<li><a href="setMessage?id=${user.id }&type=cust">Sent Message</a></li>
	      		<li><a href="setMessage?id=${user.id }&type=customer">View Message</a></li>
	      		<li><a href="ParcelTaken?id=${user.id }">Taken Parcel</a></li>
	      		<li><a data-toggle="modal" href="#" data-target="#myModal">Update Info</a></li>
	    		</ul>
	    		<ul class="nav navbar-nav navbar-right">
	            <li class="dropdown"><a href='logout'><span class="glyphicon glyphicon-log-in"></span>	Logout</a></li>
	    		</ul>
	  		</div>
		</nav>
		<h1 style="color:white"><b>Welcome to I-Parcel</b></h1>
		<h4 style="color:white">
			Hi ${user.fullname}!.
			Looking for your parcel??
		</h4>
		<div id="kotak" align="center">
			<table id="example" class="table table-striped table-bordered" style="width:100%">
		        <thead>
		            <tr>
		                <th>ID</th>
		                <th>Tracking Number</th>
		                <th>Parcel Type</th>
		                <th>Date Arrive</th>
		                <th>Date Collected</th>
		                <th>Courier</th>
		                <th>Status</th>
		            </tr>
		        </thead>
		        <tbody>
					<c:forEach var="par" items="${parcel}">
						<tr>
							<td>${par.pid }</td>
							<td>${par.ptrack }</td>
							<td>${par.ptype }</td>
							<td>${par.date_arrive }</td>
							<td>${par.date_collected }</td>
							<td>${par.courier }</td>
							<td>${par.status }</td>
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
		            </tr>
		        </tfoot>
		    </table>
		    <a href="takeParcel?status=Taken&id=${user.id }&type=stu" class="btn btn-success">Retrieve Parcel</a>
		</div>
	</c:if>
	
	<c:if test="${empty user}">
	<br>
		<h3 style="color:white">
			You are not logged in.
			<a href="index.jsp">Login</a>
		</h3>
	</c:if>

	<!-- Update -->
	  <div class="modal fade" id="myModal" role="dialog">
	    <div class="modal-dialog modal-lg">
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	          <h4 class="modal-title" align="left">Update Info</h4>
	        </div>
	        <div class="modal-body" style="background-color: black;">
	        <form action="update" method="post">
				<table id="tbl" width="80%" style="border-collapse:collapse; font-family:'Arial Black', Gadget, sans-serif;">
				<input type="hidden" name="type" value="student">
					<tr>
						<th>ID</th>
						<td style="color:red"><input type="hidden" name="id" value="${user.id}">${user.id}</td>
					</tr>
					<tr>
						<th>NAME</th>
						<td><input type="text" name="name" placeholder="${user.fullname}" required></td>
					</tr>
					<tr>
						<th>EMAIL</th>
						<td><input type="email" name="mail" placeholder="${user.email}" required></td>
					</tr>
					<tr>
						<th>PHONE</th>
						<td><input type="text" name="phone" placeholder="${user.phone}" minlength="10" maxlength="11" required></td>
					</tr>
					<tr>
						<th>IC</th>
						<td><input type="text" name="ic" placeholder="${user.ic}" maxlength="12" minlength="12" required></td>
					</tr>
					<tr>
						<th>PROGRAM</th>
						<td><input type="text" name="program" placeholder="${user.program}" required></td>
					</tr>
					<tr>
						<th>PASSWORD</th>
						<td><input type="text" name="pass" placeholder="${user.password}" required></td>
					</tr>
					<tr>
						<th rowspan="2">STATUS</th>
						<td><input type="radio" name="status" value="Active" required checked>Status : ${user.status}</td>
					</tr>
					<tr>
						<td style="color:red"><input type="radio" name="status" value="Inactive" required>Inactive</td>
					</tr>				
					<tr>
						<th></th>
						<td><input type="submit" value="UPDATE" class="btn btn-primary"></td>
					</tr>
					
				</table>
			</form>
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
	        </div>
	      </div>
	    </div>
	  </div>
	</div>

<script>
$(document).ready(function() {
    $('#example').DataTable();
} );
</script>
</body>
</html>