<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	window.onload = function () {
		document.viewFrom.check.length=1;
	// deleteCart()
	}
	
	function deleteCart() {	
		
		var arr = new Array();
		var f = document.viewFrom.check;
		//alert(f.length)
		
		for(var i = 0 ;  i < f.length ;i++)
		{
			if(f.checked==true)
			{
				arr.push(i+1);
			}
		}
		alert(arr);
		location.href="deleteCart.do?"+"arr="+arr;
	}
	
	function btnUp(name, amount)
	{
		
		//alert(name);
		//alert(amount);
		location.href="amountUp.do?"+"name="+name;
	}
	
	function btnDown(name, amount)
	{
		//alert(name);
		//alert(amount);
		if(amount>2)
		{
		location.href="amountDown.do?"+"name="+name;
		}else{
			alert("최소 수량은 1개 입니다.");
		}
	}
</script>

</head>
<body>

<form action="" name ="viewFrom">
	<table align="center" border="2">
	<tr bgcolor="orange"> <td>번호</td> <td>상품이미지</td> <td>상품명</td> <td>상품가격</td> 
	<td>수 량</td> <td><input type="button" value="삭제" onClick="deleteCart()"/></td></tr>

	<c:forEach var ="Fruits" items="${cartList}" varStatus="num">
		
			<tr align="center">
				<td align="center">${num.count}</td>
				<td ><img src="${Fruits.url}" width="100" height="100"></td>
				<td align="center">${Fruits.name}</td>
				<td align="center">${Fruits.price}</td>
				
				<td align="center">
				<img src="img/up.jpg" width="10" height="10" onclick="btnUp('${Fruits.name}','${Fruits.amount}')">
				${Fruits.amount}
				<img src="img/down.jpg" width="10" height="10" onclick="btnDown('${Fruits.name}','${Fruits.amount}')">
				</td>
				
				<td><input type="checkbox" name= "check" value="${num.count}"></input>  </td>
			</tr>
	</c:forEach>
	
	<tr bgcolor="orange" align="right"><td align="right"> totalPrice : ${totalPrice} </td></tr>
	
</table>
</form>

</body>
</html>