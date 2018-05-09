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

@WebServlet("/servlet/MyCity")
public class MyServlet extends HttpServlet {
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
	throws ServletException , IOException{
		//http://localhost:8080/0418/servlet/MyCity?countrycode=KOR
		String countrycode =req.getParameter("countrycode");
		Vector<CityVO> vector =SelectController.select(conn, countrycode);
		PrintWriter out =res.getWriter();
		out.println("<h1>Cites Information</h1>");
		out.println("<h1>World database's City Table Infomation</h1>");
		out.println("<ul>");
		for(int i=0 ; i<vector.size();i++) {
			CityVO city= vector.elementAt(i);
			out.print("<li>" + "["+city.getId() + "]" + city.getName()+",");
			out.print(city.getCountrycode()+","+city.getDistrict()+",");
			out.print(city.getPopulation()+ "</li>");
		}
		out.println("</ul>");
		out.close();
	}
	@Override
	public void destroy() {
		DBClose.close(conn);
	}
}
