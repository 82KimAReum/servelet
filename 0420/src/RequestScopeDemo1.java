import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/ScopeDemo1")
public class RequestScopeDemo1 extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<h1 style='color:red'>나는 RequestScopeDemo1 입니다.</h1>");
		out.println("User Name : " + 
		       req.getAttribute("username").toString() +"<br />");
		out.println("User Age : " +
		       req.getAttribute("userage").toString());
		out.close();
	}
}



