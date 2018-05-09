package com.javasoft.libs.views;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javasoft.libs.controllers.SelectController;
import com.javasoft.libs.models.StudentVO;

public class IndexServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
		throws ServletException, IOException{
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<head><title>성적 관리 프로그램</title>");
		out.println("<meta charset='utf-8'></head>");
		out.println("<body>");
		out.println("<h1>Javasoft School List</h1>");
		out.println("<div><a href='../input.html'>새로 입력하기</a></div>");
		out.println("<table border='1'>");
		out.println("<thead>");
		out.println("<tr>");
		out.print("<th>학번</th><th>이름</th>");
		out.print("<th>국어</th><th>영어</th><th>수학</th>");
		out.println("<th>전산</th>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");
		Vector<StudentVO> vector = SelectController.selectAll();
		for(int i = 0 ; i < vector.size(); i++) {
			StudentVO s = vector.get(i);
			out.println("<tr>");
			out.println("<td>" + s.getHakbun() + "</td>");
			out.println("<td>" + s.getIrum() + "</td>");
			out.println("<td>" + s.getKor() + "</td>");
			out.println("<td>" + s.getEng() + "</td>");
			out.println("<td>" + s.getMat() + "</td>");
			out.println("<td>" + s.getEdp() + "</td>");
			out.println("</tr>");
		}
		out.println("</tbody>");
		out.println("</table>");
		out.println("</body>");
		out.close();
	}
}
