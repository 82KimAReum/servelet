package com.javasoft.libs.views;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javasoft.libs.controllers.CalcController;
import com.javasoft.libs.controllers.InsertController;
import com.javasoft.libs.models.StudentVO;

public class InputServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
     throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		StudentVO s = new StudentVO(req.getParameter("hakbun"), 
				                                       req.getParameter("irum"), 
				                          Integer.parseInt(req.getParameter("kor")), 
				                          Integer.parseInt(req.getParameter("eng")), 
				                          Integer.parseInt(req.getParameter("mat")), 
				                          Integer.parseInt(req.getParameter("edp")));
		CalcController.calc(s);
		int row = InsertController.insert(s);
		res.setContentType("text/html;charset=utf8");
		PrintWriter out = res.getWriter();
		if(row == 1) {
			res.sendRedirect("/SungjukMgmt/servlet/Index");
//			out.println("<body style='background:yellow'>");
//			out.println("<h1>Insert Success</h1>");
		}else {
			out.println("<body style='background:red'>");
			out.println("<h1>Insert Failure</h1>");
		}
		out.close();
	}
}
