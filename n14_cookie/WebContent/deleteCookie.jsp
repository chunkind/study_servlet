<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
    기존의 생성된 쿠키 중에서 name이라는 키값으로 세팅된 쿠키를 삭제
   body 태그 안에서 삭제 되었는지를 확인... getCookie.jsp를 연결
-->
<%
	Cookie[ ] cs = request.getCookies();
	for(Cookie c : cs){
		if(c.getName().equals("name")){
			c.setMaxAge(0);
			response.addCookie(c);
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href='getCookie.jsp'>getCookie.jsp 페이지로 연결.. 거기서 삭제 확인.</a>
</body>
</html>