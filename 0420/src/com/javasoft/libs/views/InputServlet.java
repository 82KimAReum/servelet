package com.javasoft.libs.views;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javasoft.libs.controllers.CalcController;
import com.javasoft.libs.controllers.InsertController;
import com.javasoft.libs.models.VO;
@WebServlet("/servlet/InputServlet")
public class InputServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException{
		String seatcode = req.getParameter("seatcode");
		String place = req.getParameter("place");
		String ipin1 = req.getParameter("inpin1");
		String ipin2 = req.getParameter("inpin2");
		String persent = req.getParameter("persent");
		
		VO vo= CalcController.calc(seatcode,place,ipin1,ipin2,persent);
		int row = InsertController.insert(vo);
		res.setContentType("text/html;charset=utf8");
		PrintWriter out = res.getWriter();
		if(row == 1) {
			//res.sendRedirect("/SungjukMgmt/servlet/Index");
			out.println("<body style='background:yellow'>");
			out.println("<h1>Insert Success</h1>");
		}else {
			out.println("<body style='background:red'>");
			out.println("<h1>Insert Failure</h1>");
		}
		out.close();
	}
}
