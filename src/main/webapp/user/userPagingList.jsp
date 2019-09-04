 <%@page import="kr.or.ddit.user.model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>

<%@ include file="/commonJsp/basicLib.jsp"%>
<script type="text/javascript">
$(document).ready(function(){
	//사용자 정보 클릭시 이벤트 핸들러
	$(".userTr").on('click', function(){
		console.log("userTr click")
		
		// 두번째 자식
		var tdText = $(this).children().first().text()
		console.log(tdText)
		
		//input 태그에 저장된 값 확인
		var inputValue = $(this).find("input").val();
		console.log("inputValue : " + inputValue);
		
		//data 속성 값 가져오기
		//data속성명은 소문자로 치환된다!!
		//data-userId --> $(this).data("userid");
		//대소문자 주의~~~~~!
		var dataValue = $(this).data("userid");
		console.log("dataValue : " + dataValue);
		
		//input태그에 값 설정
		$('#userId').val(dataValue);
		
		//form태그이용 전송
		console.log("serialize : " + $('#frm').serialize())
		
		$('#frm').submit();
	})
	
})
</script>
</head>

<body>
<form action="${cp }/user" id="frm">
	<input type="hidden" id="userId" name="userId">
</form>

<!-- header -->
<%@ include file="/commonJsp/header.jsp" %>

<div class="container-fluid">
		<div class="row">
			
<div class="col-sm-3 col-md-2 sidebar">
<!-- left -->
<%@ include file="/commonJsp/left.jsp" %>
</div><div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				

<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">사용자</h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
					<th>사용자 아이디</th>
					<th>사용자 이름</th>
					<th>사용자 별명</th>
					<th>등록일시</th>
				</tr>
				<c:forEach items="${userList}" var="user">
					<tr class="userTr" data-userId="${user.userId }">
						<input type="hidden" value="${user.userId }"/>
						<td>${user.userId}</td>
						<td>${user.userName}</td>
						<td>${user.alias}</td>
						<td><fmt:formatDate value="${user.reg_dt}" pattern="yyyy/MM/dd"/></td>
					</tr>
				</c:forEach>
			</table>
		</div>

		<a href="${cp }/userForm" class="btn btn-default pull-right">사용자 등록</a>

		<div class="text-center">
			<ul class="pagination">
			<!-- 이전페이지 가기: 지금 있는 페이지에서 한페이지 전으로 -->
			 <c:choose>
				 <c:when test="${pageVo.page == 1}">
					 <li class="disabled">
			         	<span aria-hidden="true">&laquo;</span>
				     </li>
				 </c:when>
				 <c:otherwise>
					  <li>
				      <a href="${cp }/userPagingList?page=${pageVo.page -1}" aria-label="Previous">
			          <span aria-hidden="true">&laquo;</span>
				      </a>
				      </li>
				 </c:otherwise>
			 </c:choose>
			
			<c:forEach begin="1" end="${paginationSize}" var="page">
				<c:choose>
					<c:when test="${page == pageVo.page }">
						<li class="active"><span>${page}</span></li>
					</c:when>
					<c:otherwise>
						<li><a href="${cp }/userPagingList?page=${page}">${page}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			
			<c:choose>
				<c:when test="${pageVo.page == paginationSize }">
					<li class="disabled">
				        <span aria-hidden="true">&raquo;</span>
				    </li>
				</c:when>
				<c:otherwise>
					<li>
				      <a href="${cp }/userPagingList?page=${pageVo.page +1}" aria-label="Next">
				        <span aria-hidden="true">&raquo;</span>
				      </a>
				    </li>
				</c:otherwise>
			</c:choose>
			</ul>
		</div>
	</div>
</div>
	</div>
		</div>
	</div>
</body>
</html>
