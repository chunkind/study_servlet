<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">Attribute에 바인딩 된 값을 가져옵니다..</h2><p>
<b>1~100까지의 합산의 결과 : 1)Basic Element :: </b>
<%= request.getAttribute("RESULT") %>
<HR><p>
<b>1~100까지의 합산의 결과 : 2)EL :: </b>
${RESULT}<BR> 
${requestScope.RESULT}<BR>
${requestScope.RESULT +7}<BR>
${name}

</body>
</html>

<%-- 
	<% request.getAttribute("RESULT"); %>
	1.	EL의 꼬라지 : ${ }
	2.	${ }안에 들어가는 RESULT 는 변수명이 아니라
		Attribute에 바인딩 된 이름이다.
--%>