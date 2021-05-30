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
			<h1>Page for update</h1>
			<form action="DispatcherServlet" method="post">
			<input type="hidden" name="command" VALUE="update">
				ID : <input type="text" name="id" value="${ sessionScope.rdto.id }" readonly="readonly"><br><br>
				Name : <input type="text" name="name" value="${ sessionScope.rdto.name }" readonly="readonly"><br><br>
				Password : <input type="password" name="password" required="required"><br><br>
				Address : <input type="text" name="address" required="required"><br><br>
				<input type="submit" value="Update info">
			</form>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				alert("Need to sign in or sign up first to update your account.");
				location.href="index.jsp";
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>
