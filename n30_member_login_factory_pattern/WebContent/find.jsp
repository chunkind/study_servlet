<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search page</title>
<script type="text/javascript">
	function checkID() {
		var cId = document.findForm.id;
		
		if(cId.value == ""){
			alert("Must input your ID.");
			return false;
		}
	}
</script>
</head>
<!-- 
	id에 대한 결과값을 검색하는 로직.
	해당 id를 찾으면 결과 find_OK.jsp 로 페이지를 이동.
	해당 id를 못 찾으면 결과 find_Fail.jsp 로 이동.
 -->
<body>
	<form action="DispatcherServlet" name="findForm" onsubmit="checkID()">
	<input type="hidden" name="command" VALUE="find">
		ID : <input type="text" name="id"><br><br>
		<input type="submit" value="Search">
	</form>
</body>
</html>
