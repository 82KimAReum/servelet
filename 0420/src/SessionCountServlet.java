import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/SessionCount")
public class SessionCountServlet extends HttpServlet {
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
		int count = 0;
		count += Integer.parseInt(req.getParameter("mycount"));
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<h1>Count : " + count + "</h1>");
		System.out.println(req.getRequestURI());
		out.println("<div><a href='" + req.getRequestURI() + "'>이전 페이지로</a></div>");
		out.close();
	}
}




