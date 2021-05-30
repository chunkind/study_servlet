<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>ServletContext(application)를 이용한 초기 파라미터 값 받아오기.</h2><p>
1. JSP기본 Element를 이용해서 DD에 설정된 값 받아오기. <br>
Driver FQCN :: <%= application.getInitParameter("ODriver") %><br>
<hr>

2. EL 식을 이용해서 DD에 설정된 값 받아오기.<br>
Driver FQCN :: ${initParam.ODriver}
</body>
</html>