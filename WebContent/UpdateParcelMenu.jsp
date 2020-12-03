<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
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
th{
	color:white;
}
 input[type=date], select{
	width: 80%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}
</style>
</head>
<body background = "img/wallpaper.jpg">
<jsp:useBean id="updatepar" class="iparcel.model.parcel" scope="request"></jsp:useBean>
<jsp:useBean id="customer" class="java.util.ArrayList" scope="request"></jsp:useBean>
<div align="center" id="kotak">
		<form action="UpdateParcel" method="POST">
			<input type="hidden" name="id" value="${updatepar.ptrack }">
			<table width="100%" cellpadding="8px">
				<tr>
					<th>Tracking Number</th>	
					<td><input type="text" name="track" placeholder="${updatepar.ptrack }" required></td>
				</tr>
				<tr>
					<th>Receiver</th>
					<td>
						<select name="customer" required>
								<option value="" selected>-Choose one-</option>
								<c:forEach var="cust" items="${customer}">
									<option value="${cust.id}">${cust.fullname} = ${cust.phone}</option>
								</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<th>Parcel Type</th>
					<td>
						<select name="type" required>
							<option value="mail">MAIL
							<option value="package">PACKAGE
						</select>
					</td>
				</tr>
				<tr>
					<th>Date Arrived</th>
					<td><input type="date" name="da"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Add" class="btn btn-primary"></td>
				</tr>
			</table>
			<a href="staffMain1.jsp" class="btn btn-danger">Back</a>
		</form>
</div>
</body>
</html>