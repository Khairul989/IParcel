<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Add New Parcel</title>
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
<div align="center">
	<h1 style="color:white"><b>Welcome to I-Parcel</b></h1>
</div>
	<jsp:useBean id="lecturer" class="java.util.ArrayList" scope="request"></jsp:useBean>
	<jsp:useBean id="student" class="java.util.ArrayList" scope="request"></jsp:useBean>
	<jsp:useBean id="user" class="iparcel.model.staff" scope="session"></jsp:useBean>
	<div align="center" id="kotak">
		<form action="AddParcelAction" method="POST">
			<table width="100%" cellpadding="8px">
				<tr>
					<th>Tracking Number</th>
					<td><input type="text" name="track" placeholder="Enter tracking Number" required></td>
				</tr>
				<tr>
					<th>Receiver</th>
					<td>
						<select name="customer" required>
								<option value="" selected>-Choose one-</option>
							<c:if test="${not empty lecturer}">
								<c:forEach var="lect" items="${lecturer}">
									<option value="${lect.id}">${lect.fullname} = ${lect.phone}</option>
								</c:forEach>
							</c:if>
							<c:if test="${not empty student}">
								<c:forEach var="stu" items="${student}">
									<option value="${stu.id}">${stu.fullname} = ${stu.phone}</option>
								</c:forEach>
							</c:if>
						</select>
					</td>
				</tr>
				<tr>
					<th>Parcel Type</th>
					<td>
						<select name="type">
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
					<th>Date Collected</th>
					<td style="color:red"><input type="hidden" name="dc" value="not collected">not collected</td>
				</tr>
				<tr>
					<th>Courier</th>
					<td>
						<select name="courier">
							<option value="poslaju">POSLAJU
							<option value="gdex">GDEX
							<option value="ninjavan">NINJAVAN
							<option value="skynet">SKYNET
							<option value="jnt">JNT
						</select>
					</td>
				</tr>
				<tr>
					<th>Parcel Status</th>
					<td style="color:red">
						<input type="hidden" name="status" value="Not taken">Not yet taken
					</td>
				</tr>
				<tr>
					<th>Staff In-charge</th>
					<td style="color:red">
						<c:out value="${user.id}"></c:out>
						<input type="hidden" value="${user.id}" name="staff">
					</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Add" class="btn btn-primary"></td>
				</tr>
			</table>
		</form><br><br>
		<a href="staffMain1.jsp" class="btn btn-danger">Back to Staff Menu</a>
	</div>
</body>
</html>