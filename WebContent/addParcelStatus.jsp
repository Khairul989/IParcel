<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Parcel Status</title>
<style>
#kotak {
  background-color: black;
  width: 40%;
  border: 15px solid blueviolet;
  padding: 50px;
  margin: 0;
  position: absolute;
  top: 50%;
  left: 50%;
  -ms-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
}
h1 , h3{
	color: white;
} 
a{
	color: red;
}
</style>
</head>
<body background = "img/wallpaper.jpg">
<c:if test="${requestScope.status == false }">
	<div align="center" id="kotak">
		<h1>Failed to Add!! Duplicate Entry Detected!!!</h1><br>
		<h3>Go back to Menu<a href="staffMain1.jsp">Back</a></h3>
	</div>
</c:if>
<c:if test="${requestScope.status == true }">
	<div align="center" id="kotak">
		<h1>Parcel Added!!</h1><br>
		<h3>Go back to Menu<a href="staffMain1.jsp">Back</a></h3>
	</div>
</c:if>
</body>
</html>