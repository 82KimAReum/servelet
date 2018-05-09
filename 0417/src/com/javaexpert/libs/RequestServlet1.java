package com.javaexpert.libs;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlet/RequestDemo1")
public class RequestServlet1 extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException,IOException{
		String userid=req.getParameter("userid");
		System.out.println(userid);
		PrintWriter out =res.getWriter();
		if(userid.equals("chimi")) {
			out.println("Enabled");
			
		}else {
			out.println("Disabled");
		}
		out.close();
	}
}
