<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- c라는 이름으로 해당 uri를 바인딩 한다는 의미이다.
	 그리고 c는 Core의 약자이다.
 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl :: 출력을 담당하는 jstl의 out 기능에 대해서..</title>
</head>
<body>
<c:out value ="<input>은 <form>의 서브태그 입니다.."></c:out><p>
<!-- <input>은 <form>의 서브 태그입니다.. -->
<c:out value="<h1>오늘의 과제</h1>는 없습니다."></c:out><p>
<c:out value="<h1>오늘의 과제</h1>는 없습니다." escapeXml="false"></c:out><p>
<c:out value="<font size=7>커다란 글씨 </font>는 다음과 같이 출력합니다"></c:out><br>
<c:out value="<font size=7>커다란 글씨</font>는 다음과 같이 출력 합니다." escapeXml="false"></c:out><br>
<c:out value="이것으로 jstl c:out 출력용 속성에 관해서 마치겠습니다."></c:out>
</body>
</html>

<!-- 
jstl을 하기 위한 두가지 전제조건
1.	lib을 다운받아야 한다.
	standard-impl.jar
	jstlel.jar 두개를 받아야 한다.
	이때 jar를 저장할 수 있는 곳이 두 군데..
	eclipse상.. 프로젝트 > WebContent > WEB-INF > lib > 여기다
	Tomcat홈 > lib > 여기다.
	
2. 지시어에 반드시 taglib prefix, uri를 입력해야 한다.
 -->















