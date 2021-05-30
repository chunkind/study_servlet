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
<c:if test="true">
	<script type="text/javascript">
	alert("JSTL Good!!");
	</script>
</c:if>
<a href='jstl1_result.jsp?command=jstlReview'>파라미터를 get 방식으로 다른페이지로 전달함</a><p>
<a href='jstl1_result.jsp?id=jstl&age=24'>파라미터로 나이와 아이디를 다른페이지로 전달함</a><p>
<a href='jstl1_result.jsp?age=23'>파라미터로 나이를 다른페이지로 전달함</a><p>
<hr>

<%-- 받아온 나이가 19세 미만이면 ~~세. ~~세 는 미셩년자라서 카페 출입 제한~- -%>
<%-- 받아온 나이가 19세 이상이면 ~~세. ~~세 는 성인이므로 카페 출입 가능~ --%>

<c:if test="${param.age<19}">
3. 받아온 나이 출력 :: 세는 미성년자라서 케페 출입 제한 합니다..<br>
</c:if>

<c:if test="${param.age>=19}">
3. 받아온 나이 출력 :: 세는 성인이므로 카페 출입 가능합니다..<br>
</c:if>

</body>
</html>