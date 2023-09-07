<%@page import="com.jspider.springmvc.pojo.StudentPOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="Nav.jsp"></jsp:include>
<%
List<StudentPOJO> students = (List<StudentPOJO>) request.getAttribute("students");
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management System</title>
<style>
fieldset {
	width: 900px;
}

#data td {
	border: 1px solid black;
	text-align: center;
	height: 30px;
}

#data th {
	border: 1px solid black;
	text-align: center;
}

#data {
	background-color: white;
	border: 1px solid black;
	width: 100%;
	border: 1px solid black;
	margin-top: 20px;
}

#titletag{
	padding: 25px;
}
</style>
</head>
<body>
	<div align="center">
		<fieldset>
			<h4 id="titletag">Delete Student Details</h4>
			<form action="./delete" method="post">
				<table>
					<tr>
						<td>Enter Your Id</td>
						<td><input type="text" name="id"></td>
						<td><input type="submit" value="Remove" class="btn btn-primary"></td>
					</tr>
				</table>

			</form>
			<%
			if (msg != null) {
			%>
			<h4><%=msg%></h4>
			<%
			}
			%>
			<%
			if (students != null) {
			%>
			<table id="data" class="table table-striped">
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Email</th>
					<th>Contact</th>
					<th>Address</th>
				</tr>
				<%
				for (StudentPOJO student : students) {
				%>
				<tr>
					<td><%=student.getId()%></td>
					<td><%=student.getName()%></td>
					<td><%=student.getEmail()%></td>
					<td><%=student.getContact()%></td>
					<td><%=student.getAddress()%></td>
				</tr>
				<%
				}
				%>
			</table>
			<%
			}
			%>
		</fieldset>
	</div>
</body>
</html>