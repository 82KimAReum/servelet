import java.io.IOException;
import java.io.PrintWriter;
import java.util.Formatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/servlet/Now")
public class NowServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException,IOException{
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out= res.getWriter();
		String str="오늘은 "
					+String.format("%1$tY년  %1$tm월  %1$td일 입니다.", new java.util.Date());
		out.println("<div style='color:blue'>"+str+"</div>");
		
		
		//out.close();//절대 하면 안됨.
	}
}
