<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Register Success</title>

<style>

#kotak {
  background-color: lightgrey;
  width: 400px;
  border: 15px solid blueviolet;
  padding: 50px;
  margin: 0;
  position: absolute;
  top: 50%;
  left: 50%;
  -ms-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
}

</style>

</head>
<body background = "img/wallpaper.jpg">
		<c:if test="${requestScope.status == false }">
			<div id="kotak" align="center">
			<h3>Failed to Register, Duplicate entry detected!!!</h3>
				Try Again, click <a href="index.jsp" type="button" class="btn btn-primary">here</a>
			</div>
		</c:if>

		<c:if test="${requestScope.status == true }">
			<div id="kotak" align="center">
			<h3>ACCOUNT SUCCESSFULLY REGISTERED</h3>
			To log in, click <a href="index.jsp" type="button" class="btn btn-primary">here</a>
			</div>
		</c:if>

</body>


</body>
</head>
</body>
</html>