<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
// 		int num1 = Integer.parseInt(request.getParameter("number1"));
// 		int num2 = Integer.parseInt(request.getParameter("number2"));
// 		int res = 0;
		
// 		for(int i=num1; i<=num2; i++){
// 			res +=i;
// 		}

	%>
	<h3>result : <%=  session.getAttribute("sumResult") %></h3>
</body>
</html>