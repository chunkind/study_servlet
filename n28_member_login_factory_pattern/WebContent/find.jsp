<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function checkId() {
		var cid = document.findForm.id;
		if(cid.value==""){
			alert("아이디를 반드시 입력하세여...");
			return false;
		}
	}
</script>
</head>
<!-- 
id에 대한 결과값을 검색하는 로직
해당 id를 찾으면 find_ok.jsp로 페이지를 이동
해당 id를 못찾으면 find_fail.jsp로 페이지를 이동.
 -->
<body>
<form action = "DispatcherServlet" name = "findForm" onsubmit = "return checkId()">
ID : <input type = "text" name = "id">
<input type = "hidden" name = "command" value = "find">
<input type = "submit" value = "id로 검색하기">
</form>
</body>
</html>