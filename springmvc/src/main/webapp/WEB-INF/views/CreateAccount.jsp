<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%String msg = (String)request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<fieldset>
		<legend>Create New Account</legend>
		<form action="./createAccount" method="post">
			<table>
				<tr>
					<td>Enter User Name</td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td>Enter Password</td>
					<td><input type="text" name="password"></td>
				</tr>
				
			</table>
			<input type="submit" value="createaccount" class="btn btn-primary">
		</form>
	</fieldset>
	<%if(msg !=null){ %>
	<h5><%=msg%></h5>
	<%}
	%>
		
	</div>
</body>
</html>