import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/CartDelete")
public class CartDeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
     throws ServletException, IOException{
		res.setContentType("text/html;charset=utf8");
		Cookie[] array= req.getCookies();
		PrintWriter out= res.getWriter();
		if(array != null && array.length >0) {
			for(Cookie c: array) {
				c.setMaxAge(0);
				res.addCookie(c);
			}
			out.println("<h1>장바구니 비웠음.</h1>");
		}else {
			out.println("<h1>Cookie Not Found </h1>");
		}
		out.println("<div><a href='/0419/servlet/CartView'>장바구니 보기</a></div>");
		out.println("<div><a href='/0419/product.html'>장바구니 담기</a></div>");
		out.close();
	}
}
