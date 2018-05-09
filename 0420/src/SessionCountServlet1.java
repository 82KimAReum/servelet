import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servlet/SessionCount1")
public class SessionCountServlet1 extends HttpServlet {
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
		HttpSession session = req.getSession();  //session이 없으면 새로 생성
		if(session.isNew()) {
			session.setAttribute("mycount", new int[] {0});
		}
		int [] array = (int [])session.getAttribute("mycount");
		int count = Integer.parseInt(req.getParameter("mycount"));
		array[0] += count;
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<h1>Count : " + array[0] + "</h1>");
		out.println("<div>SESSION ID : " + session.getId() + "</div>");
		out.println("<div>Session Creation Time : " + 
		                   new java.util.Date(session.getCreationTime()) + "</div>");
		out.println("<div>Session Last Modified Time : " + 
                          new java.util.Date(session.getLastAccessedTime()) + "</div>");
		out.println("<div>Session Timeout : " + 
                session.getMaxInactiveInterval() + "seconds</div>");
		out.println("<div><a href='" + req.getRequestURI() + "'>이전 페이지로</a></div>");
		out.close();
	}
}




