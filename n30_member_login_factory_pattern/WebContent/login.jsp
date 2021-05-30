<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
<script type="text/javascript">
	function checkLogin() {
		var f = document.loginForm;
		
		if(f.id.value == ""){
			alert("아이디를 입력하세요.");
			return false;
		}else if(f.password.value == ""){
			alert("패스워드를 입력하세요.");
			return false;
		}
	}
</script>
</head>
<body>
	<h1 align="center"><font color="BLUE">Login page</font></h1>
	<form action="DispatcherServlet" method="post" name="loginForm" onsubmit="return checkLogin()">
	<input type="hidden" name="command" VALUE="login">
		ID : <input type="text" name="id"><br><br>
		PASS : <input type="password" name="password"><br><br>
		<input type="submit" value="Sign in">
	</form>
</body>
</html>
