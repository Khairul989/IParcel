<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
<!-- Data tables -->
	<script type="text/javascript" charset="utf8" src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
	
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
	
<style>
	#kotak {
	  background-color: white;
	  width: 80%;
	  border: 15px solid blueviolet;
	  padding: 50px;
	  margin: 0;
	  position: absolute;
	  top: 33%;
	  left: 10%;
	}
	#kotak1 {
	  background-color: white;
	  width: 25%;
	  border: 15px solid blueviolet;
	  padding: 50px;
	  margin: auto;
	  position: absolute;
	  top: 5%;
	}
		#kotak2 {
	  background-color: white;
	  width: 25%;
	  border: 15px solid blueviolet;
	  padding: 50px;
	  margin: 0;
	  position: absolute;
	  left: 25%;
	  top: 5%;
	}
		#kotak3 {
	  background-color: white;
	  width: 25%;
	  border: 15px solid blueviolet;
	  padding: 50px;
	  margin: 0;
	  position: absolute;
	  left: 50%;
	  top: 5%;
	}
		#kotak4 {
	  background-color: white;
	  width: 25%;
	  border: 15px solid blueviolet;
	  padding: 50px;
	  margin: 0;
	  position: absolute;
	  left: 75%;
	  top: 5%;
	}
</style>
</head>
<body background="img/wallpaper.jpg">
<jsp:useBean id="par" class="java.util.ArrayList" scope="request"></jsp:useBean>
<% 
	Object value = request.getAttribute("totPar");
	Object value1 = request.getAttribute("totSt");
	Object value2 = request.getAttribute("totCust");
	Object value3 = request.getAttribute("totntPar");
%>
<div id="kotak1">
	<div align="center">
		<i class="fas fa-mail-bulk"></i>
		<h4>Total parcel is : <%= value %></h4>
	</div>
</div>
<div id="kotak2">
	<div align ="center">
		<i class="fas fa-user-tie"></i>
		<h4>Total Staff is : <%= value1%></h4>
	</div>
</div>
<div id="kotak3">
	<div align="center"><i class="fas fa-user-friends"></i>
	<h4>Total Customer is : <%= value2%></h4></div>
</div>
<div id="kotak4">
	<div align="center">
		<i class="fas fa-times-circle"></i>
		<h4>Total Parcel not taken is : <%= value3%></h4>
	</div>
</div>
<div id="kotak"><button class="btn btn-primary" onclick="printstaff()">Print this page</button>
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
		                <th>Delete</th>
		            </tr>
		        </thead>
		        <tbody>
					<c:forEach var="p" items="${par}">
						<tr>
							<td>${p.pid }</td>
							<td>${p.ptrack }</td>
							<td>${p.ptype }</td>
							<td>${p.date_arrive }</td>
							<td>${p.date_collected }</td>
							<td>${p.courier }</td>
							<td>${p.status }</td>
							<td><a href="Delete?id=${p.ptrack }&type=parcel" class="btn btn-danger">DELETE</a></td>
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
		                <th>Delete</th>
		            </tr>
		        </tfoot>
		    </table>
		    	<a href="staffMain1.jsp" class="btn btn-danger">Back</a>
</div>
<script>
	$(document).ready(function() {
	    $('#example1').DataTable();
	} );
	function printstaff() {
		   var divToPrint=document.getElementById("example1");
		   newWin= window.open("");
		   newWin.document.write(divToPrint.outerHTML);
		   newWin.print();
		   newWin.close();
		}

</script>
</body>
</html>
