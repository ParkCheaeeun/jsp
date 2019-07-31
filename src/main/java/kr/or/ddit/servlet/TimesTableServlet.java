package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimesTableServlet extends HttpServlet {
	
	private Logger logger = LoggerFactory.getLogger(TimesTableServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String method = req.getMethod();
		
		logger.trace("trace TimesTablesServlet doGet() {} {}", method, method+"test");
		logger.debug("debug TimesTablesServlet doGet() {} {}", method, method+"test");
		logger.info("info TimesTablesServlet doGet()");
		logger.warn("warn TimesTablesServlet doGet()");
		logger.error("error TimesTablesServlet doGet()");
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		
		pw.write("<html>");
		pw.write("	<head>");
		pw.write("		<title>TimesTable</title>");
		pw.write("	<style rel='stylesheet'>");
		pw.write("		table{}");
		pw.write("		td{margin : 10px; padding : 10px;}");
		pw.write("	</style>");
		pw.write("	</head>");
		pw.write("<body>");
		pw.write("	<table border='1' frame='void'>");
		
		for(int i=1; i<10; i++) {
			pw.write("<tr>");
			for(int j=2; j<10; j++) {
				pw.write("<td>"+ j + " * " + i + " = " + j*i +  "</td>");
			}
			pw.write("</tr>");
		}
		
		pw.write("	</table>");
		pw.write("</body>");
		pw.write("</html>");
	}
}
