<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  tag는 들어갈 수 없다. 자바 코드만 들어 갈 수 있다. -->
<%
	String url = "http://search.naver.com/search.naver?where=nexearch";
	String keyword = request.getParameter("word");
	
	url += "&query=" + keyword;
	response.sendRedirect(url);
%>
</body>
</html>