<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function checkLogin() {
		var f = document.loginForm;
		if(f.id.value==""){
			alert("아이디를 입력하세여...");
			return false;
		}else if(f.password.value==""){
			alert("패스워드를 입력하세여...");
			return false;
		}
	}
</script>
</head>
<body>
<h2>Member Login Form...</h2><p>
<form action="front.do" method="post" name="loginForm" onsubmit="return checkLogin()">
<input type="hidden" name="command" value="login">
아이디 :<input type="text" name="id"><p>
패스워드 : <input type="password" name="password"><p>
<input type="submit" value="로그인">
</form>
</body>
</html>