package com.javaexpert.libs;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlet/RequestDemo")
public class RequestServlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		PrintWriter out = res.getWriter();
		Enumeration<String> headers =req.getHeaderNames();
		while(headers.hasMoreElements()) {
			String name =headers.nextElement();
			System.out.printf("%s --> %s \n",name,req.getHeader(name));
//			host --> localhost:8080 
//			connection --> keep-alive 
//			cache-control --> max-age=0 
//			upgrade-insecure-requests --> 1 
//			user-agent --> Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36 
//			accept --> text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8 
//			accept-encoding --> gzip, deflate, br 
//			accept-language --> ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7 

		}
		
		out.close();
	}
}
