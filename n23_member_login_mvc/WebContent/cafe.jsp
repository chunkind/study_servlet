<%@page import="model.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor = "red">
<%
	MemberDTO rdto = (MemberDTO)session.getAttribute("rdto");
	if(rdto != null) {
%>
<%=rdto.getAddress() %>에 사는 <%=rdto.getName() %>님 카페 입장 환영!<p>
<a href="index.jsp">홈으로 </a>
<% }else{ %>
<%-- 로그인 안하고 직접 cafe.jsp주소를 치고 들어오는 사람은 이리로 들어온다. --%>
<script type="text/javascript">
	alert("로그인하고 쳐와 씨발넘아");
	location.herf="index.jsp";
</script>
<% } %>
</body>
</html>