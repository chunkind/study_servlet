<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function delAction() {
		var pass = document.delCheckForm.password.value;
		if(pass=="")
			alert("비밀번호를 입력하세..");
		else
			document.delCheckForm.submit();
	}
</script>
</head>
<body>
<form action="DispatcherServlet"  name="delCheckForm" method="post">
<input type="hidden" name="command" value="deleteCheckPassword">
<input type="hidden" name="no" value="${param.no}">
<input type="password" name="password"><br><br>
<input type="button" value="삭제" onclick="delAction()">
<input type="button" value="창끄기" onclick="javascript:self.close()">
</form>
</body>
</html>













