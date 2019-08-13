<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<%= request.getContextPath()%>/elScope" method="post">
request : <input type="text" name="req" value="brown"><br>
session : <input type="text" name="session" value="cony"><br>
application : <input type="text" name="application" value="sally"><br>
<input type="submit" value="전송">

<h2>el scope test</h2>
<%
	//pageContext
	pageContext.setAttribute("attr", "page_attr");
	request.setAttribute("attr", "request_attr");
	session.setAttribute("attr", "session_attr");
	application.setAttribute("attr", "application_attr");

%>

el : ${attr} <br>

<%
	pageContext.removeAttribute("attr", pageContext.PAGE_SCOPE);
%>

el ${attr} <br>
</form>
</body>
</html>