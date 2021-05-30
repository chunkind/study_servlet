<%@page import="vo.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Attribute에 바인딩된 vo 객체를 다루는 방법..</title>
</head>
<body>
<%
ProductVO vo = new ProductVO();
vo.setName("누가바");
vo.setPrice(1000);

vo.setName("보석바");
vo.setPrice(1500);

request.setAttribute("vo", vo);
request.getRequestDispatcher("el1_view.jsp").forward(request, response);
%>
</body>
</html>