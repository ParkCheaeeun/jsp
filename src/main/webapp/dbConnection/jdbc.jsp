<%@page import="java.sql.Statement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
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
Connection conn = null;
Statement stmt = null;
ResultSet rs = null;

Class.forName("oracle.jdbc.driver.OracleDriver");

//start
long start = System.currentTimeMillis();
for(int i=0; i<20; i++){
	conn = DriverManager.getConnection(
			"jdbc:oracle:thin:@localhost:1521:xe",
			"pce",
			"java");
		
	String sql = "select * from lprod";
	stmt = conn.createStatement();
		
	rs = stmt.executeQuery(sql);
	while(rs.next()){
		out.println("lprod_id: " + rs.getInt("lprod_id") + "<br>");
		out.println("lprod_gu: " + rs.getString(2) + "<br>");
		out.println("lprod_nm: " + rs.getString("lprod_nm") + "<br>");
		out.println("--------------------------------------<br>");
	}
	
	stmt.close();
	conn.close();
	rs.close();
}

//end
long end = System.currentTimeMillis();
out.println("end - start: " + (end - start) + "ms <br>");

%>
</body>
</html>