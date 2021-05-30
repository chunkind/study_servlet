<%@page import="vo.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>1. 상품정보를 EL로 출력하기 </h2><p>
상품명 :	${requestScope.vo.name}<BR>
상품가격 :	${vo.price}<BR>
상품에 대한 모든 정보 ${vo}<BR>
<hr>
<h2>2. 상품정보를 JSP Element로 출력하기 </h2><p>
상품명 :	<%= ((ProductVO)request.getAttribute("vo")).getName() %> <br>
상품 가격:	<%= ((ProductVO)request.getAttribute("vo")).getPrice()%> <br>
상품에 대한 모든 정보 :	<%= ((ProductVO)request.getAttribute("vo"))%> <br>
</body>
</html>