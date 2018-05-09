package com.javasoft.libs.views;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javasoft.libs.controllers.SelectController;
import com.javasoft.libs.models.EmployeeVO;
//http://localhost/0419/servlet/Select         ///아파치사용
//http://localhost:8080/0419/servlet/Select    ///톰켓 사용
public class SelectServlet extends HttpServlet {
	public void doGet (HttpServletRequest req, HttpServletResponse res) 
	throws ServletException,IOException{
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out =res.getWriter();	
		out.println("<h1>javasoft Inc. Employees List</h1>");
		out.println("<table border='1'>");
		out.println("<thead>");
		out.println("<tr>");
		out.print("<th>Emp No.</th><th>Name</th>");
		out.print("<th>Salary</th><th>Job</th><th>Dept. No</th>");
		out.println("<th>Dept. Name</th><th>Location</th>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");
		Vector<EmployeeVO> vector = SelectController.getEmployeeAll();
		for(int i = 0 ; i < vector.size(); i++) {
			EmployeeVO emp = vector.get(i);
			out.println("<tr>");
			out.println("<td>" + emp.getEmpno() + "</td>");
			out.println("<td>" + emp.getEname() + "</td>");
			out.println("<td>" + emp.getSal() + "</td>");
			out.println("<td>" + emp.getJob() + "</td>");
			out.println("<td>" + emp.getDeptno() + "</td>");
			out.println("<td>" + emp.getDname() + "</td>");
			out.println("<td>" + emp.getLoc() + "</td>");
			out.println("</tr>");
		}
		out.println("</tbody>");
		out.println("</table>");
		out.close();
	}
}
