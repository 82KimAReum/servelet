package com.javasoft.libs.views;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Vector;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javasoft.libs.controllers.DBClose;
import com.javasoft.libs.controllers.DBConnection;
import com.javasoft.libs.controllers.SelectController;
import com.javasoft.libs.models.CityVO;
@WebServlet("/servlet/MyCity1")
public class MyServlet1 extends HttpServlet {
	private Connection conn = null;
	@Override
	public void init(ServletConfig config) throws ServletException{
		ServletContext ctx = config.getServletContext();
		String path = ctx.getRealPath("/WEB-INF/dbinfo.properties");
		//System.out.println(path);
		conn = DBConnection.getConnection(path);
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
		throws ServletException, IOException{
		
		Vector<String> vector = SelectController.select(conn);
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html><head>");
		out.println("<title>Servlet JDBC Demo</title>");
		out.println("<script src='../js/jquery-1.12.4.js'></script>");
		out.println("<script>");
		out.println("$(function(){");
		out.println("	$('select').change(function(){");
		out.println("		$('form').submit();");
		out.println("	});");
		out.println("});");
		out.println("</script>");
		out.println("</head><body>");
		out.println("<h1>Cities Information</h1>");
		out.println("<h3>Please choose below countrycodes ?</h3>");
		out.println("<form action='' method='post'>");
		out.println("<select name=\"countrycode\">");
		out.println("<option>--Please Select--</option>");
		for(int i = 0 ; i < vector.size(); i++) {
			out.print("<option value='" + vector.get(i) + "'>");
			out.println(vector.get(i) + "</option>");
		}
		out.println("</select>");
		out.println("</form>");
		out.close();
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		String countrycode = req.getParameter("countrycode");
		Vector<CityVO> vector = SelectController.select(conn,countrycode);
		PrintWriter out = res.getWriter();
		out.println("<h1>Cities Information</h1>");
		out.println("<a href='javascript:history.go(-1);'>go Back</a>");
		out.println("<ul>");
		for(int i = 0 ; i < vector.size() ; i++) {
			CityVO city = vector.elementAt(i);
			out.print("<li>[" + city.getId() + "] " + city.getName() + ", ");
			out.print(city.getCountrycode() + ", " + city.getDistrict() + ", ");
			out.println(city.getPopulation() + "</li>");
		}
		out.println("</ul>");
		out.close();
	}
	@Override
	public void destroy() {
		DBClose.close(conn);
	}
}
