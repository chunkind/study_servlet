<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>jstl_if1.jsp에서 보낸 값(파라미터값)을 받습니다.</h2>
전달된 command 값 :: ${param.command} <br>
<hr>
<%--id값이 jstl 이고 age가 24세 일때만 출력하도록 c:if를 이용하세요 --%>
	<c:if test="${param.id=='jstl' && param.age=='24'}"> </c:if>
2. 전달된 파라미터 ID값 : , AGE값 : 
<br><br>
</body>
</html>