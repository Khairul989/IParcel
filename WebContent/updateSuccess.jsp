<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<div align="center" id="kotak">
	<h1>Information Updated!</h1><br>
	<h3>Please login again with the new information	<a href="logout">Login</a></h3>
</div>
</body>
</html>