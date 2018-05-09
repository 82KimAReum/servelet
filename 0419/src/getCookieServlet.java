import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/GetCookie")
public class getCookieServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
     throws ServletException, IOException{
		res.setContentType("text/html;charset=utf8");
		PrintWriter out= res.getWriter();
		Cookie[] array=req.getCookies();
		if(array !=null && array.length >0) {
			out.println("<h1>Cookie founded.</h1>");
			out.println("<ul>");
			for(int i=0; i<array.length; i++) {
				out.println("<li>"+array[i].getName()+"[");
				out.println(array[i].getValue()+" ]</li>");
			}
			out.println("</ul>");
		}else {
			out.println("<h1>Cookie Not Found</h1>");
		}
		out.close();
	}
}
