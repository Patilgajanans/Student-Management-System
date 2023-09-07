<%@page import="com.jspider.springmvc.pojo.StudentPOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<StudentPOJO> students = (List<StudentPOJO>) request.getAttribute("students");
String msg = (String) request.getAttribute("msg");
%>
<jsp:include page="Nav.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Student Management System</title>
<style>
fieldset {
	width: 900px;
	padding: 25px;
}

tr {
	height: 40px;
}

#submit {
	margin-top: 20px;
	width: 150px;
	height: 40px;
	padding: 15px;
}

#data td{
	border: 1px solid black;
	text-align: center;
}

#data th{
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

form{
	padding: 25px;
}

input {
	height: 30px;
	width: 320px;
	
	}
input[type="number"]::-webkit-inner-spin-button,
        input[type="number"]::-webkit-outer-spin-button {
            -webkit-appearance: none;
            appearance: none;
        }
	
h3{
padding: 25px;
}
</style>
</head>
<body>
	<div align="center" >
		<fieldset >
			<h3>Add Student Details</h3> 
			<form action="./add" method="post" class="border border-5">
				<table  >
					<tr>
						<td><label for="">Name</label></td>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
						<td><label for="">Email</label></td>
						<td><input type="text" name="email"></td>
					</tr>
					<tr>
						<td><label for="">Contact</label></td>
						<td><input type="number" name="contact" id="inpnum" ></td>
					</tr>
					<tr>
						<td><label for="">Address</label></td>
						<td><textarea cols="41" rows="3" name="address"></textarea></td>
					</tr>
				</table>
				<input type="submit" id="submit" class="btn btn-primary">

			</form>
		
		<%
		String str = request.getParameter("name");

		if (msg != null) {
			msg = str + " " + msg;
		%>
		<h5 ><%=msg%>
		</h5>
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