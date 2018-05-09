import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/Response")
public class ResponseDemoServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
     throws ServletException, IOException{
		this.doProcess(req, res);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
     throws ServletException, IOException{
		this.doProcess(req, res);
	}
	private void doProcess(HttpServletRequest req, HttpServletResponse res)
     throws ServletException, IOException{
		//res.setBufferSize(1024);
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
//		out.println("Context Path : " + req.getContextPath() + "<br />");
//		out.println("Remote User : " + req.getRemoteUser() + "<br />");
//		out.println("Remote Address : " + req.getRemoteAddr() + "<br />");
//		out.println("Request URI : " + req.getRequestURI() + "<br />");
//		out.println("Request URL : " + req.getRequestURL() + "<br />");
//		out.println("Servlet Path : " + req.getServletPath() + "<br />");
		//out.println("Buffer Size : " + res.getBufferSize());//Buffer Size : 8192
		
		for (int i=1; i<=3000 ; i++) {
			out.print(i+ "&nbsp;&nbsp;&nbsp;");
			//buffer의 size는 8K지만 알아서 auto flush하기 때문에 오류 나지 않음
		}
		
		out.close();
	}
}

//Context Path : /0419
//Remote User : null
//Remote Address : 0:0:0:0:0:0:0:1
//Request URI : /0419/servlet/Response
//Request URL : http://localhost:8080/0419/servlet/Response
//Servlet Path : /servlet/Response


