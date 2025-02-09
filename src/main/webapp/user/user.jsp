<%@page import="kr.or.ddit.user.model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
		$('#modifyBtn').on('click', function(){
			$('#frm').submit();
		})
	})

</script>
</head>

<body>

<!-- header -->
<%@ include file="/commonJsp/header.jsp" %>

<form action="${cp }/modify" id="frm">
	<input type="hidden" value="${user.userId}" name="userId">
</form>

<div class="container-fluid">
		<div class="row">
		<div class="col-sm-3 col-md-2 sidebar">
		<!-- left -->
		<%@ include file="/commonJsp/left.jsp" %>
		</div><div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<form class="form-horizontal" role="form">

					<div class="form-group">
						<label for="userPicture" class="col-sm-2 control-label">사용자 사진 </label>
						
						<div class="col-sm-10">
							<%-- <img alt="" src="/jsp${user.realfilename2}"> --%>
							<img src="${cp }/userPicture?userId=${user.userId}"/>
						</div>
					</div>
					<div class="form-group">
						<label for="userId" class="col-sm-2 control-label">사용자 아이디 </label>
						<div class="col-sm-10">
							<label class="control-label">${user.userId}</label>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 이름</label>
						<div class="col-sm-10">
							<label class="control-label">${user.userName }</label>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">별명</label>
						<div class="col-sm-10">
							<div class="col-sm-10">
							<label class="control-label">${user.alias}</label>
						</div>
						</div>
					</div>
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">등록일</label>
						<div class="col-sm-10">
							<label class="control-label">
							<fmt:formatDate value="${user.reg_dt }" pattern="yyyy-MM-dd"/>
							</label>
						</div>
					</div>
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">Password</label>
						<div class="col-sm-10">
							<div class="col-sm-10">
							<label class="control-label">${user.pass}</label>
						</div>
						</div>
					</div>
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label"></label>
						<div class="col-sm-10">
							<button type="button" id="modifyBtn" class="btn btn-default">사용자 수정</button>
						</div>
					</div>

				</form>
			</div>
		</div>
	</div>

</body>
</html>
