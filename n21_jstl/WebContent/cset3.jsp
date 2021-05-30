<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="CODE" value="1004"/>	<!-- scope가 아무것도 없는건 이 페이지에서만 돈다는 것이다. -->
<!-- request.setAttribute("NAME", "KOSTA") -->
<c:set var="NAME" value="KOSTA" scope="request" />
<c:set var="PRICE" value="12000" scope="session"/>
<jsp:forward page="cset3_result.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
상품코드 :: ${CODE}<BR>
상품이름 :: ${NAME}<BR>
</body>
</html>