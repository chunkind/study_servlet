<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--
    지금 Cookie에 설정한 정보중에 name...habaree 라는 값이 세팅되어 있다.
    이 값을 변경해 보겠다.
    1) 요청시 모든 쿠키를 가져와서
    2) 키값이 name인 쿠키를 찾아서 
    3) habaree라는 값을 James로 변경
    4) body 태그안에서 getCookie.jsp로 연결.. 여기서 변경된 값을 확인 하도록 하자.
    --%>
<%
	Cookie[] cs = request.getCookies();
	for (Cookie c : cs) {
		if (c.getName().equals("name")) {
			c.setValue("James");
			response.addCookie(c); // 이 부분을 해야지만 변경된 쿠키를 다시 받을 수 있다.
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
<a href='getCookie.jsp'>GetCookie로 페이지 연결..</a><br>
<a href='index.html'>index 페이지 연결..</a>
</body>
</html>