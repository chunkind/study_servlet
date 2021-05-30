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
	<c:choose>
		<c:when test="${ sessionScope.rdto != null }">
			${ sessionScope.rdto.name } has signed in.<br>
			Welcome to your visit, client ${ sessionScope.rdto.name } living in ${ sessionScope.rdto.addr }. <br>
			<a href="index.jsp">HOME</a><br>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				alert("Need to sign in first.");
				location.href="login.jsp";
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>
