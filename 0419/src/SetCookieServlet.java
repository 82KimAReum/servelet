import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/SetCookie")
public class SetCookieServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
     throws ServletException, IOException{
		Cookie c1 =new Cookie("username", "한지민");
		Cookie c2=new Cookie("userage", "24");
		res.setContentType("text/html;charset=utf8");
		res.addCookie(c1); //브라우저 닫으면 사라짐
		c2.setMaxAge(60*60); //1hour
		res.addCookie(c2);
		PrintWriter out= res.getWriter();
		out.println("<h1>Cookie Setting Complete</h1>");
		out.close();
	}
}
