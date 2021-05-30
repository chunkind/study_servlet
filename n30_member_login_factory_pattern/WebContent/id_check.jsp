<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function closeWindow(result) {
		var of = window.opener.document.registerForm;
		
		if(result == 'true'){ // unusable.
			of.id.value="";
			of.id.focus();
			window.opener.checkButtonPressed = false;
		}else{ // usable.
			of.password.focus();
			of.buttonCheck.value = "yes";
		}
		window.self.close();
	}
</script>
</head>
<body bgcolor="orange">
	<c:set var="idExist" value="${ requestScope.idExist }"/>
	<c:set var="mess" value="Cannot use this ID."/>
	
	<c:if test="${ idExist == false }">
		<c:set var="mess" value="Able to use this ID."/>
	</c:if>
	${ param.id }, ${ mess }<br><br>
	<input type="button" value="check" onclick="closeWindow('${ idExist }')">
</body>
</html>
