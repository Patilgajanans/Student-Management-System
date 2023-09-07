<%@page import="com.jspider.springmvc.pojo.StudentPOJO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="Nav.jsp"></jsp:include>
<%
String msg = (String)request.getAttribute("msg");
StudentPOJO student = (StudentPOJO)request.getAttribute("student");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management System</title>
<style>
	select{
		width: 150px;
	}
	fieldset{
		width: 900px;
	}
	form{
		display: flex;
		align-items: center;
		justify-content: space-around;
		padding: 10px;
	}
	#data td{
	border: 1px solid black;
	text-align: center;
	height: 30px;
	}
	#data th{
	border: 1px solid black;
	text-align: center;
	height: 30px;
	}
	
	#data {
		background-color: white;
		border: 1px solid black;
		width: 100%;
		border: 1px solid black;
		margin-top: 20px;
	}

</style>
</head>
<body>
<div align="center">
	<fieldset>
		<legend>Search Student Details</legend>
		<form action="./search" method="post">
			<table>
				<tr>
					<td>Enter Your Id</td>
					<td><input type="text" name="id"> </td>
				</tr>
			</table>
		<input type="submit" value="Search">
	</form>
	
	
	<%if(msg !=null){ %>
	<h4><%=msg%></h4>
	<%}
	%>
	<%
		if(student != null){
	%>
	<table id="data" class="table table-striped">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Contact</th>
			<th>Address</th>
		</tr>
		<tr>
			<td><%=student.getId()%></td>
			<td><%=student.getName()%></td>
			<td><%=student.getEmail()%></td>
			<td><%=student.getContact()%></td>
			<td><%=student.getAddress()%></td>
		</tr>
	</table>
	<%} %>
	</fieldset>
</div>
</body>
</html>