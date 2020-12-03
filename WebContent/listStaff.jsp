<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Data tables -->
	<script type="text/javascript" charset="utf8" src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
	
	<style>
		#kotak {
		  background-color: black;
		  width: 80%;
		  border: 15px solid blueviolet;
		  padding: 50px;
		  margin: 0;
		  position: absolute;
		  top: 50%;
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
<c:if test="${not empty user}">
	<div style="background-color: white;" id="kotak">
	<button class="btn btn-primary" onclick="printstaff()">Print this page</button>
		<table id="example" class="table table-striped table-bordered" style="width:100%">
	        <thead>
	            <tr>
	                <th>ID</th>
	                <th>NAME</th>
	                <th>EMAIL</th>
	                <th>PHONE</th>
	                <th>IC</th>
	                <th>PASSWORD</th>
	                <th>DELETE</th>
	            </tr>
	        </thead>
	        <tbody>
	        	<c:forEach var="st" items="${staff}">
		        	<tr>
		        		<td>${st.id }</td>
		        		<td>${st.name }</td>
		        		<td>${st.email }</td>
		        		<td>${st.phone }</td>
		        		<td>${st.ic }</td>
		        		<td>${st.password }</td>
		        		<td><a href="Delete?id=${st.id }&type=staff" class="btn btn-danger">DELETE</a></td>
		        	</tr>
	        	</c:forEach>
	        </tbody>
	        <tfoot>
	            <tr>
	                <th>ID</th>
	                <th>NAME</th>
	                <th>EMAIL</th>
	                <th>PHONE</th>
	                <th>IC</th>
	                <th>PASSWORD</td>
	                <th>DELETE</th>
	            </tr>
	        </tfoot>
        </table>
        <a href="staffMain1.jsp" class="btn btn-danger">Back</a>
	</div>
</c:if>					
	<script>
	$(document).ready(function() {
	    $('#example').DataTable();
	} );
	function printstaff() {
		   var divToPrint=document.getElementById("example");
		   newWin= window.open("");
		   newWin.document.write(divToPrint.outerHTML);
		   newWin.print();
		   newWin.close();
		}
	</script>
</body>
</html>