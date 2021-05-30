<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 폼</title>
<script type="text/javascript">
	function registerData() {
		var f = document.registerForm;
		if(f.id.value==""){
			alert("아이디를 입력하세요..");
			return false;
		}
		
		if(f.password.value==""){
			alert("패스워드를 입력하세요..");
			return false;
		}
		
		if(f.name.value==""){
			alert("이름을 입력하세요..");
			return false;
		}
		
		if(f.address.value==""){
			alert("주소를 입력하세요..");
			return false;
		
		}if(f.buttonCheck.value=="no"){
			alert("중복확인 해 주세요..");
			return false;
		}
	}
		
		function checkId() {
			// 여기서 비지니스 로직을 호출하지 않고.
			// 새창을 띄우는 방법을 사용하는게 좋다. 그 새창에서 서블릿으로 연결
			// IdCheckServlet?id=값 biz(id)..
			var str = document.registerForm.id.value;
			window.open("IdCheckServlet?id="+str, "", "width=300, height=300, top=100, left=400");
		}
		
</script>
</head>
<body>
<h2><b>Member Register Form..</b></h2><p>
<!-- 폼에 값을 입력하고 전송 버튼을 누르면..자바스크립트로 연결..
	  여기서 페이지 이동.. 회원가입의 로직은 RegisterServlet에서 로직을 작성.
	 register_result.jsp 결과 페이지로 이동
	 회원 가입시 이미 디비에 들어있는 id값을 입력하면 가입이 안되도록 로직을 작성.
	 이건 자바스크립트로 일단 연결하겠다.
 -->
<form action = "RegisterServlet" method = "post" name = "registerForm" onsubmit = "return registerData()">
아이디 : <input type = "text" name = "id">
<input type = "hidden" name = "buttonCheck" value = "no">
<input type = "button" value = "중복확인" onclick = "checkId()"><p>
패스워드 : <input type = "password" name = "password"><p>
이 름 : <input type = "text" name = "name"><p>
주 소 : <input type = "text" name = "address"><p>
<input type = "submit" value = "register">
<input type = "reset" value = "clear">
</form>
</body>
</html>

<!-- 
	RegisterServlet / register_result.jsp
	중복확인 버튼 눌렀는지의 체크 여부

 -->