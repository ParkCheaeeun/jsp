<%@page import="kr.or.ddit.user.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath()%>/css/signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <div class="container">
    <%
    	HttpSession httpSession = request.getSession();
    		User userVo = (User) httpSession.getAttribute("S_USERVO");
    		String userName = "";
    		userName = userVo == null ? "" : userVo.getUserName();
    %>
		사용자 이름 : <%= userName %>
	
      <form class="form-signin" action="<%= request.getContextPath()%>/login" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="userId" class="sr-only">User Id</label>
        
        <% 
        	String userId = request.getParameter("userId");
        		
        	userId = userId == null ? "" : userId;
        %>
        
        <input type="text" id="userId" name="userId" class="form-control" 
        	   placeholder="Email address" required autofocus value="brown">
        <label for="pass" class="sr-only">Password</label>
        <input type="password" id="pass" name="pass" value="brown1234"
        	   class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>
	
    </div> <!-- /container -->

  </body>
</html>
