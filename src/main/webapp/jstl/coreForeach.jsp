<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="kr.or.ddit.user.model.User"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.service.UserServiceImpl"%>
<%@page import="kr.or.ddit.user.service.IUserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>coreForeach</h2>
<%
	IUserService userService = new UserServiceImpl();
	List<User> userList = userService.getUserList();
	pageContext.setAttribute("userList", userList);
%>
<%-- java 향상된 for --%>
<c:forEach items="${userList }" var="user" varStatus="loop">
	<c:if test=" ${loop.index<=10 }">
		index: ${loop.index } / count : ${loop.count} / ${user.userId } / ${user.userNm } <br>
	</c:if>
</c:forEach>

<%-- java 일반 for --%>
<%-- <c:forEach begin="0" end="10" var="i"> --%>
<c:forEach begin="0" end="10" var="i" step="2" varStatus="loop">
	${i } <br>
</c:forEach>

<h2>core foreach map</h2>
<%
	//servlet
	Map<String, String> map = new HashMap<String, String>();
	map.put("userId", "brown");
	map.put("userNm", "브라운");
	map.put("userAlias", "곰");
	request.setAttribute("user", map);
	
	//화면: user속성에 있는 모든 값을 화면에 출력
	//		map에 답긴 key를 모를 때, map에 담긴 데이터 확인하기
	
	//a set view of the contained in this map
	Set<String> keySet = map.keySet();
	for(String str : keySet){
		out.write(map.get(str) + "<br>");
	}
%>
	<c:forEach items="${user }" var="entry">
		${entry.key } / ${entry.value } <br>
	</c:forEach>
</body>
</html>