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

</script>

</head>

<body>
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
		<h2 class="sub-header">상품</h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
					<th>상품 분류</th>
					<th>분류 코드</th>
					<th>제조사 이름</th>
					<th>상품 코드</th>
					<th>상품 이름</th>
					<th>상품 가격</th>
				</tr>
				

				<c:forEach items="${list}" var="ProdVo">
					<tr class="prodTr">
						<td>${ProdVo.lprod_nm}</td>
						<td>${ProdVo.prod_lgu}</td>
						<td>${ProdVo.buyer_name}</td>
						<td>${ProdVo.prod_id}</td>
						<td>${ProdVo.prod_name}</td>
						<td>${ProdVo.prod_price}</td>
					</tr>
				</c:forEach>
			</table>
		</div>

		<a class="btn btn-default pull-right">상품 등록</a>

		<div class="text-center">
			<ul class="pagination">
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
			</ul>
		</div>
	</div>
</div>
	</div>
		</div>
	</div>
</body>
</html>
