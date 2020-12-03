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
<jsp:useBean id="cust" class="java.util.ArrayList" scope="request"></jsp:useBean>
<div id="kotak" align="center">
	<form action="InsertMessage" method="POST">
		<input type="hidden" value="staff" name="type">
		<input type="hidden" value="${user.id }" name="sid">
		To : <br>
		<select name="rid">
			<c:forEach var="c" items="${cust }">
				<option value="${c.id }">${c.fullname }</option>
			</c:forEach>
		</select><br>
		Message : <br>
		<textarea name="message" rows="10" cols="100" required></textarea><br>
		<input type="submit" value="Send" class="btn btn-primary">
	</form>
	<br>
	<br>
	<a href="staffMain1.jsp" class="btn btn-danger">Back</a>
</div>

</body>
</html>
