<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
	form에서 넘어온 값이 19세 이상이면 "성인임으로 카페 입장 가능합니다." 메세지 띄우고
							  (alert창으로도 메세지 띄우고)
	jstl7_cafe.jsp로 이동하도록 로직을 작성 /

	form에서 넘어온 값이 19세 미만이면 "미성년자임으로 카페 입장 가능합니다." 메세지 띄우고
							  (alert창으로도 메세지 띄우고)
	홈으로 이동하도록 로직을 작성 /
	:: choose를 사용하세요. 
 --%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		
	<c:when test="${param.userAge>=19}">
			${param.userName}님은 성인이므로 카페 입장 가능 합니다..<br>
		<script typ="text/jsvascript">
			alert("성인이므로 카페 입장 가능합니다");
			location.href="jstl7_cafe.jsp?age=${param.userAge}";//제일 중요!!
		</script>
	</c:when>
	<c:otherwise>
			${param.userName}님은 미성년자 이므로 입장 불가 합니다..<br>
		<script type="text/javascript">
			alert("카페 입장 불가능 합니다");
			location.href = "jstl7_home.jsp";
	
		</script>
	</c:otherwise>
	</c:choose>
</body>
</html>