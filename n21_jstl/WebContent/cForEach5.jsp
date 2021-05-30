<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>반복문을 작성하는 jstl방법.</title>
</head>
<body>
	<c:forEach begin="1" end="10" var="cnt" step="3">
		<font size=${cnt}>쪼메만 더하면 끝난다..끝나기 전까진 끝난게 아니다..</font><br>
	</c:forEach>
</body>
</html>