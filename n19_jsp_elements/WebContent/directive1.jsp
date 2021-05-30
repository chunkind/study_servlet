<!-- Directive Element :: 특정한 내용을 컨테이너에게 알리는 정보가 들어감 -->
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 선언식 Decrelation Element :: 필드나 메소드를 정의할때 사용 -->
<%!
	Date now = new Date();
	String name = "KOSTA";
	String jspGo(){
		return name;
	}

%>
<!-- Scriptlet Element :: 이 안에 자바 로직이 들어온다 -->
<%
	request.setAttribute("name1", name);
	request.setAttribute("name2", jspGo());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Expression Element: 출력문 -->
<h2>현재 시각은 :: <%= new SimpleDateFormat().format(now) %></h2><p>
<h2>교육 기관명 :: <%= request.getAttribute("name1") %></h2><p>
<h2>지금 배우고 있는 교육과정은 :: <%= request.getAttribute("name2") %></h2><p>
<h2>현재 세션의 ID 값은 :: <%= session.getId() %></h2><p>
<h2>현재 프로젝트명 :: <%= application.getContextPath() %> </h2><p>

</body>
</html>
<%--
jsp에서 제공되는 내장객체(Implicit object) 내장객체의 공통점 : 리턴받지않고 바로 쓸수 있다. 그리고 전부다 소문자이다.
out
request
response
session
application
exception
page
--%>