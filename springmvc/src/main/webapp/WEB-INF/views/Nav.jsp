<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management System</title>

<!-- Add this in the <head> section of your JSP file -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<style>


ul {
	display: flex;
	flex-direction: row;
	height: 60px;
	width: 100vw;
	justify-content: space-around;
	background-color: yellow;
	align-items: center;
	list-style-type: none;
}

a{
    text-decoration: none;
    font-size: large;
}
</style>
</head>
<body>
	<div class="nav">
		<ul class="nav nav-tabs">
			<li class="nav-item" ><a href="./home" class="nav-link active">Home</a></li>
			<li class="nav-item" ><a href="./add" class="nav-link active" >Add Student</a></li>
			<li class="nav-item" ><a href="./delete" class="nav-link active" >Delete Student</a></li>
			<li class="nav-item" ><a href="./search" class="nav-link active" >Search Student</a></li>
			<li class="nav-item" ><a href="./update" class="nav-link active" >Update Student</a></li>
			<li class="nav-item" ><a href="./logout" class="nav-link active" >LogOut</a></li>
		</ul>
	</div>
</body>
</html>