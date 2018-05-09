import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//모든 브라우저가 공유
@WebServlet("/servlet/ApplicationCount")
public class ApplicationCountServlet extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException{
		ServletContext ctx = config.getServletContext();
		ctx.setAttribute("mycount", new int [] {0});
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
     throws ServletException, IOException{
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<h1>누적할 숫자를 입력하세요.</h1>");
		out.println("<form method='post'>");
		out.print("Number : <input type='text' name='mycount' />");
		out.println("<input type='submit' value='누적하기' />");
		out.println("</form>");
		out.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
     throws ServletException, IOException{
		ServletContext ctx = req.getServletContext();
		int [] array = (int [])ctx.getAttribute("mycount");
		array[0] += Integer.parseInt(req.getParameter("mycount"));
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<h1>Count : " + array[0] + "</h1>");
		out.println("<div><a href='" + req.getRequestURI() + "'>이전 페이지로</a></div>");
		out.close();
	}
}




