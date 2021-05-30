<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function chooseLine() {
		// 지하철 노선을 선택하지 않으면 " 선택하란" 메세지를 띄우고..
		// 지하철 노선을 선택하면 선택한 값을 변수로 받아 놓는다.
		var fv = document.frm.line.value;
		if(fv=="")
			alert("지하철 노선을 선택하세요..");
		else
			// javascript에서 폼에 입력된 값을 바로 전송한다..
			document.frm.submit();	//이때 frm까지 잡아야 한다는거에 주의 하자.
			
	}
</script>
</head>
<body>
<form action="select_action.jsp" name="frm" method="post">
<h3><b>지하철 노선을 선택하세요..</b></h3><p>
<select name="line" onchange="chooseLine()">
	<option value="">-- 호선 --</option>
	<% for(int i=1; i<10; i++) { %>
	<option value="<%= i %>"><%= i %> 호선</option>
	<% } %>
</select>
<!-- 여기다가 전송 버튼을 만들지 않고.. javascript에서 값을 받아서 처리하는 방법
	 내가 선택한 지하철 호선이 변결될때마다 함수호출 되도록 할려면?
 -->
</form>
</body>
</html>