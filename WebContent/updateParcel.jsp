<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Parcel</title>
<!-- Data tables -->
	<script type="text/javascript" charset="utf8" src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<style>
	#kotak {
	  background-color: white;
	  width: 80%;
	  border: 15px solid blueviolet;
	  padding: 50px;
	  margin: 0;
	  position: absolute;
	  top: 5%;
	  left: 10%;
	}
h1 , h3{
	color: white;
} 
a{
	color: red;
}
</style>
</head>
<body background="img/wallpaper.jpg">
<jsp:useBean id="notTaken" class="java.util.ArrayList" scope="request"></jsp:useBean>
<div id="kotak">
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
		            </tr>
		        </thead>
		        <tbody>
					<c:forEach var="p" items="${notTaken }" >
						<tr>
							<td>${p.pid }</td>
							<td><a href="parcelNotTaken?ptrack=${p.ptrack }&track=track">${p.ptrack }</a></td>
							<td>${p.ptype }</td>
							<td>${p.date_arrive }</td>
							<td>${p.date_collected }</td>
							<td>${p.courier }</td>
							<td>${p.status }</td>
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
		    <a href="staffMain1.jsp" class="btn btn-danger">Back</a>
</div>
<script>
	$(document).ready(function() {
	    $('#example1').DataTable();
	} );
</script>
</body>
</html>