<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
before setTimeZone : <fmt:formatDate value="${dt }" pattern="yyyy-MM-dd HH:mm:ss"/><br>

<fmt:setTimeZone value="Asia/Bangkok"/>

after setTimeZone : <fmt:formatDate value="${dt }" pattern="yyyy-MM-dd HH:mm:ss"/>

<table>
	<thead>
		<tr>
			<th>timeZone</th>
		</tr>
	</thead>
	
	<tbody>
	<c:forEach items="${timeZoneList }" var="time">
		<tr>
			<td>${time }</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</body>
</html>