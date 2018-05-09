import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AnnotationDemo",
			urlPatterns= {"/servlet/Annotation","/servlet/AnnotationDemo"})	
//이제 url패턴 web.xml를 안만들어 줘도 됨!!!!!!
public class AnnotationDemo extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)
			throws ServletException,IOException{
		res.setContentType("text/html");
		PrintWriter out= res.getWriter();
		out.println("<h1>hello ,Annotation</h1>");
		out.close();
	}
}
