<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl을 이용해서 sendRedirect() 사용하기.</title>
</head>
<body>
<%--c:redirect 태그는 서브태그로 param을 이용해서 Query String을 URL에 추가할 수 있다. --%>
<%-- <c:redirect url="cRedirect_result.jsp?name=habaree&addr=판교"> --%>
<c:redirect url="cRedirect_result.jsp">
	<c:param name="name" value="habaree" />
	<c:param name="addr" value="판교" />
	<c:param name="email" value="123@asdf.com" />
</c:redirect>

</body>
</html>