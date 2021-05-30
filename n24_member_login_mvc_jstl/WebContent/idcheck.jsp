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
		var of=window.opener.document.registerForm;
		if(result=='true'){ //아이디를 사용하지 못할때
			of.id.value="";
			of.id.focus();
			
		}else{ //아이디를 사용할수 있는 경우
			of.password.focus();
			of.buttonCheck.value=  'yes';
		}
		self.close();
	}
</script>
</head>
<body bgcolor="orange">
<c:set var="message" value="해당 ID는 사용할 수 없음"/>
<c:if test="${idExist ==false}">
	<c:set var="message" value="해당 ID는 사용할 수 있음"/>
</c:if>
${param.id}, ${message}<br><br>
<input type="button" value="확인" onclick="closeWindow('${idExist}')">
</body>
</html>