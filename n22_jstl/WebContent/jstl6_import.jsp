<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>c:import | jstl에서는 c:include가 없다..</title>
</head>
<body>
<c:import url="header.jsp"/>
<h3><b>이 부분이 Home의 Main 부분 입니다..</b></h3><p>
<img alt="" src="img/clock.jpg" width="30%" height="35%">
<c:import url="footer.jsp"/>
</body>
</html>