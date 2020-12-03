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
</style>
</head>
<body background="img/wallpaper.jpg">
<jsp:useBean id="message" class="java.util.ArrayList" scope="request"></jsp:useBean>
<div id="kotak">
			<table id="example1" class="table table-striped table-bordered" style="width:100%">
		        <thead>
		            <tr>
		            	<th>Message Id</th>
		                <th>SENDER ID</th>
		                <th>Message</th>
		                <th>Receiver</th>
		                <th>DELETE</th>
		            </tr>
		        </thead>
		        <tbody>
					<c:forEach var="m" items="${message}">
						<tr>
							<td>${m.mid }</td>
							<td>${m.senderid }</td>
							<td>${m.msg }</td>
							<td>${m.receiverid }</td>
							<c:if test="${not empty user }">
								<td><a href="Delete?id=${m.mid }&type=stuMessage" class="btn btn-danger">DELETE</a></td>
							</c:if>
							<c:if test="${not empty user1 }">
								<td><a href="Delete?id=${m.mid }&type=lectMessage" class="btn btn-danger">DELETE</a></td>
							</c:if>
						</tr>
					</c:forEach>
		        </tbody>
		        <tfoot>
		            <tr>
		            	<th>Message Id</th>
		                <th>SENDER ID</th>
		                <th>Message</th>
		                <th>Receiver</th>
		                <th>DELETE</th>
		            </tr>
		        </tfoot>
		    </table>
		    <c:if test="${not empty user }">
		    	<a href="MainMenu.jsp" class="btn btn-danger">Back</a>
		    </c:if>
		    <c:if test="${not empty user1 }">
		    	<a href="LectureMenu.jsp" class="btn btn-danger">Back</a>
		    </c:if>
</div>
<script>
	$(document).ready(function() {
	    $('#example1').DataTable();
	} );
</script>
</body>
</html>
