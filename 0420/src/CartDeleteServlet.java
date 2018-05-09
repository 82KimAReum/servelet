import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servlet/CartDelete")
public class CartDeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
     throws ServletException, IOException{
		res.setContentType("text/html;charset=utf-8");
		HttpSession session = (HttpSession)req.getSession(false);
		PrintWriter out = res.getWriter();
		if(session != null ) {
			session.invalidate();
			out.println("<h1>장바구니 비웠음.</h1>");
		}else {
			out.println("<h1>session Not Found</h1>");
		}
		out.println("<div><a href='/0420/product.html'>장바구니 담기</a></div>");
		out.close();
	}
}



