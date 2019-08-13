<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>두 수 사이의 합 구하기</h3>
	<form action="${pageContext.request.contextPath}/sumCalculation" method="post">
		start : <input type="text" name="num1"><br>
		end : <input type="text" name="num2"><br>
		<input type="submit" value="계산">
	</form>
</body>
</html>