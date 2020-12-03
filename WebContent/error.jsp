<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Invalid User</title>
<style>
#kotak {
  background-color: black;
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
h3{
	color: red;
}
</style>
</head>
<body background = "img/wallpaper.jpg">
<div align="center" id="kotak">
	<c:if test="${requestScope.err == true }">
			<h3 >Invalid Username and/or Password</h3>
	</c:if>
	<a href="index.jsp" type="button" class="btn btn-danger" >Back to Menu</a>
</div>
</body>
</html>