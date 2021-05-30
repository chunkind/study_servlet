<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">1. 우승자 명단 확인</h2><p>
1등.${requestScope.winner[0]}	<br>
2등.${winner[1]}<br>
3등.${winner[2]}<br>
<hr>
<h2 align="center">2. 이 달에 가장 많이 팔린 과일...(사과, 포도, 레몬순..)</h2><p>
1위 과일.	${items[2]}<br>
2위 과일.	${items[1]}<br>
3위 과일.	${items[0]}<br>
<hr>
<h2 align="center">Edgar의 주소를 출력합니다..</h2><p>
James의 주소는  :: ${sessionScope.map["James"]}<br>
Gosling의 주소는 :: ${map["Gosling"]}<br>
<!-- Edgar가 사는 곳은 Boston 입니다.. 출력되도록 -->
${param.name}가 사는곳은 ${map[param.name]} 입니다.
</body>
</html>