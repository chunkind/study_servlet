<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>the page for signing up.</title>
<script type="text/javascript">
	var checkButtonPressed = false;

	function checkData() {
		var f = document.registerForm;
		
		if(f.id.value == ""){
			alert("input your ID");
			return false;
		}
		if(f.name.value == ""){
			alert("input your name");
			return false;
		}
		if(f.password.value == ""){
			alert("input your password");
			return false;
		}
		if(f.address.value == ""){
			alert("input your address");
			return false;
		}
		/* if(checkButtonPressed == false){
			alert("press the check button.");
			return false;
		} */
		if(f.buttonCheck.value == "no"){
			alert("press the check button.");
			return false;
		}
	}
	
	function checkId() {
		// 여기서 BL이 나오면 안된다. 새 창을 띄우는 방법을 사용한다.
		// 그 새 창에서 서블릿(IdCheckServlet)으로 연결한다.
		var vId = document.registerForm.id.value;
		window.open("DispatcherServlet?id="+vId+"&command=checkId", "", "width=300, height=200, top=100, left=400");
		// window는 네비게이션의 역할이다. 바로 저 servlet을 띄우는 것이 아닌, 말 그대로 servlet으로 get 방식으로,
		// 해당 값들을 전달해주는 역할을 한다.
		checkButtonPressed = true;
	}
	
	function reCheck(){
		checkButtonPressed = false;
	}
</script>
</head>
<body>
	<h1>Sign up page.</h1><p>
	<!-- 폼에 값을 입력하고 전송 버튼을 누르면, 자바스크립트로 연결. 여기서 페이지 이동.
		  RegisterServlet에서 로직을 작성. register_result.jsp 결과 페이지로 이동. 
		  회원 가입시 이미 DB에 들어있는 id 값을 입력하면 가입이 안되도록 logic을 작성.
		  이 때, 자바스크립트 사용.-->
	<!-- <form action="RegisterServlet" method="post" name="registerForm" onsubmit="return checkData()">
		ID : <input type="text" name="id" onfocus="return reCheck()">&nbsp;<input type="button" value="checkId" onclick="checkId()"><br><br>
		NAME : <input type="text" name="name"><br><br>
		PASS : <input type="password" name="password"><br><br>
		ADDR : <input type="text" name="address"><br><br>
		<input type="submit" value="Sign up"><br>
	</form>	  -->
	<form action="DispatcherServlet" method="post" name="registerForm" onsubmit="return checkData()">
	<input type="hidden" name="command" VALUE="register">
		ID : <input type="text" name="id" onfocus="return reCheck()">&nbsp;
		<input type="hidden" name="buttonCheck" value="no">
		<input type="button" value="checkId" onclick="checkId()"><br><br>
		NAME : <input type="text" name="name"><br><br>
		PASS : <input type="password" name="password"><br><br>
		ADDR : <input type="text" name="address"><br><br>
		<input type="submit" value="Sign up"><br>
	</form>
</body>
</html>
