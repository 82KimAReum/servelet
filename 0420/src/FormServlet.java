import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/Form")
public class FormServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<h1>상품 리스트</h1>");
		out.println("<form method=\"post\">");
		out.println("     Name : <input type=\"text\" name=\"pname\" /><br />");
		out.println("    <input type=\"submit\" value=\"담기\" />");
		out.println(" </form>");
	}
}
