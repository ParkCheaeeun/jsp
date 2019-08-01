<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.repository.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%! UserDao dao = new UserDao();
	List<UserVo> list = dao.getUserList();			 
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	td{
		padding : 10px;
	}
	table{
		border-collapse : collapse;
	}
</style>
</head>
<body>
<!-- 1.userdao 선언
	 2.getUserList() 호출
	 3.호출 결과(List<UserVo>)를 for loop를 통해 tr태그 반복생성
 -->
	<table border="1">
		<tr>
			<th>이름</th>
		</tr>
	<% for(UserVo user : list){ %>
		<tr> 
			<td> <%= user.getUserName() %> </td> 
		</tr>
	<% } %>
	</table>
</body>
</html>