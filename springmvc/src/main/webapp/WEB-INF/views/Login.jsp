<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%String msg = (String)request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management System</title>
<style>
	fieldset{
		margin: 0 auto;
		height: 250px;
		width: 350px;
		display: flex;
		align-items: center;
		justify-content: center;
	}
	tr{
		height: 60px;
	}
	input{
		height: 40px;
		width: 220px;
	}
	#sub{
		width: 150px;
		margin-top: 30px;
	}
	label{
		margin-right: 40px;
	}

</style>
</head>
<body>
<div align="center" >
	<fieldset>
        <legend>Student Login Form</legend>
        <form action="./check" method="post">
            <table>
                <tr>
                    <td><label for="">UserName</label></td>
                    <td><input type="text" required name="username" ></td>
                </tr>
                <tr>
                    <td><label for="">Password</label></td>
                    <td><input type="password" required name="password"></td>
                </tr>
            </table>
            <input type="submit" value="Login" id="sub" class="btn btn-primary">
        </form>
        
    </fieldset>	
    <a href="./createAccount">create new account</a>
     <%if(msg !=null){ %>
		<h5><%=msg%></h5>
		<%}%>
</div>

</body>
</html>