<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>상품</title>

<%@ include file="/commonJsp/basicLib.jsp"%>
<script type="text/javascript">
$(document).ready(function(){
	$('.prodTr').on('click', function(){
		var dataValue = $(this).data("lprod_gu");
		$('#prod_gu').val(dataValue);
		
		$('#frm').submit();
	})
})
</script>

</head>

<body>
<!-- header -->
<%@ include file="/commonJsp/header.jsp" %>

<form action="${cp}/prod" id="frm">
	<input type="hidden" id="prod_gu" name="prod_gu">
</form> 

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
					<th>상품 아이디</th>
					<th>상품 번호</th>
					<th>상품 이름</th>
				</tr>
				

				<c:forEach items="${lprodList}" var="LprodVo">
					<tr class="prodTr" data-lprod_gu = "${LprodVo.lprod_gu}">
						<td>${LprodVo.lprod_id}</td>
						<td>${LprodVo.lprod_gu}</td>
						<td>${LprodVo.lprod_nm}</td>
					</tr>
				</c:forEach>
			</table>
		</div>

		<a class="btn btn-default pull-right">상품 등록</a>

		<div class="text-center">
			<ul class="pagination">
			 <c:choose>
				 <c:when test="${pageVo.page == 1}">
					 <li class="disabled">
			         	<span aria-hidden="true">&laquo;</span>
				     </li>
				 </c:when>
				 <c:otherwise>
					  <li>
				      <a href="${cp }/LprodPagingList?page=${pageVo.page-1}" aria-label="Previous">
			          <span aria-hidden="true">&laquo;</span>
				      </a>
				      </li>
				 </c:otherwise>
			 </c:choose>
			
			<c:forEach begin="1" end="${totalCnt}" var="page">
				<c:choose>
					<c:when test="${page == pageVo.page }">
						<li class="active"><span>${page}</span></li>
					</c:when>
					<c:otherwise>
						<li><a href="${cp }/LprodPagingList?page=${page}">${page}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			
			<c:choose>
				<c:when test="${pageVo.page == totalCnt }">
					<li class="disabled">
				        <span aria-hidden="true">&raquo;</span>
				    </li>
				</c:when>
				<c:otherwise>
					<li>
				      <a href="${cp }/LprodPagingList?page=${pageVo.page +1}" aria-label="Next">
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
