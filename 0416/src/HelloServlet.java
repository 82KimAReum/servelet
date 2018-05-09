import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res) 
		throws IOException, ServletException{
			res.setContentType("text/html;charset=utf8");
			PrintWriter out= res.getWriter();
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet Test</title>");
			out.println("<meta charset='utf-8'>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>안녕 servlet</h1>");
			out.println("</body>");
			out.println("</html>");
			out.close();
		}

	
}
