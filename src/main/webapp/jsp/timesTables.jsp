<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	times tables.jsp
	<table border="1">
		<% for(int i=1; i<10; i++){ %>
			<tr>
			<%for(int j=1; j<10; j++){ %>
				<td>
					<%= i %> * <%= j %> = <%= i*j %>
				</td>
		<%	} %>
			</tr>	
		<%} %>
	</table>
</body>
</html>