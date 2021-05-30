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
<%
	String[] arr = {"칼국수", "곰국", "순댓국", "홍짜장", "빠담"};
	request.setAttribute("arr", arr);
%>
<!-- cForEach6_result.jsp로 페이지 포워딩 시키세요.. -->
<jsp:forward page="cForEach6_result.jsp" />
</body>
</html>