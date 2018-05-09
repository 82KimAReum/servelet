package com.javaexpert.libs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/Register")
public class RegisterServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException,IOException{
		req.setCharacterEncoding("utf-8");
		String userid=req.getParameter("userid");
		String username=req.getParameter("username");
		String hiredate =req.getParameter("hiredate");
		String salary= req.getParameter("salary");
		
		String [] array=req.getParameterValues("hobby");
		String hobby ="님 취미는";
		if(array.length>0) {
			for(int i=0; i<array.length; i++)
			hobby += array[i] +",";
		}
		hobby = hobby.substring(0, hobby.length()-1)+"이군요";
		String gender =req.getParameter("gender");
		String season =req.getParameter("season");
		
		
		res.setContentType("text/html;charset=utf8");
		PrintWriter out =res.getWriter();
		out.println("<head><meta charset='utf-8'/></head>");
		out.println("<body><h1>사용자 정보</h1>");
		out.println(userid+"<br>");
		out.println(username+"<br>");
		out.println(hiredate+"<br>");
		out.println(salary+"<br>");
		out.println(hobby+"<br>");
		out.println(gender+"<br>");
		out.println(season+"</body>");
		out.close();
	}

}
