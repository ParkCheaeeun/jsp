<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- 스크립틀릿, 표현식 --> jstl, el --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
td{
	padding : 10px;
}
</style>
</head>
<body>
	times tables jstl.jsp
	<table border="1">
		<c:forEach begin="1" end="9" var="i">
			<tr>
			<c:forEach begin="1" end="9" var="j">
				<td>${j} * ${i} = ${i*j} </td>
			</c:forEach>
			</tr>
		</c:forEach>
	</table>
</body>
</html>