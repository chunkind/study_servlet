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
<h2>최대값 구하기</h2><p>
최대값 ::
<c:if test="${param.num1 - param.num2>0}">
<!--  test의 연산을 수행한 결과가 true일때 if 블락이 출력 -->
${param.num1}
</c:if>
<c:if test="${param.num2 - param.num1>0}">
${param.num2}
</c:if>

최소값::

</body>
</html>