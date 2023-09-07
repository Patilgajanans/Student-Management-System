	<%@page import="java.util.List"%>
	<%@page import="com.jspider.springmvc.pojo.StudentPOJO"%>
	<%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8"%>
	<jsp:include page="Nav.jsp"></jsp:include>
	<%
	String msg = (String)request.getAttribute("msg");
	List<StudentPOJO> students = (List<StudentPOJO>) request.getAttribute("students");
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
			
		}
		#data td{
		
		text-align: center;
		height: 30px;
		}
		#data td{
		
		text-align: center;
		height: 30px;
		}
		#data2 th{
		border: 1px solid black;
		text-align: center;
		height: 30px;
		}
		
		#data2 td{
			border: 1px solid black;
			text-align: center;
		}
		
		#data {
			background-color: white;
			width: 100%;
			
		}
	h3{
	padding: 25px;
	}
		h4{
	padding: 20px;
}
	</style>
	</head>
	<body>
	<div align="center">
		<fieldset>
			<h3>Search Student Details</h3>
			<form action="./search" method="post">
				<table id="data">
					<tr>
						<td>Select Option : </td>
						<td>
							<select id="selectOption" name="selectedOption">
								<option value="All" >All Student</option>
								<option value="id" >Student ID</option>
								<option value="name">Student Name</option>
								<option value="email">Student Email</option>
								<option value="contact">Student Contact</option>
								<option value="address">Student Address</option>
							</select>
						</td>
						<td>Enter Your value : </td>
						<td><input type="text" name="value"> </td>
						<td><input type="submit" value="Search" class="btn btn-primary"></td>
					</tr>
				</table>
			
		</form>
		
			<%
			if(msg != null){
			%>
			<h4><%=msg %></h4>
			<%} %>
			<%
			if (students != null) {
			%>
			<table id="data2" class="table table-striped">
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