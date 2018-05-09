import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/servlet/CartView")
public class CartViewServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
     throws ServletException, IOException{
		res.setContentType("text/html;charset=utf8");
		Cookie[] array= req.getCookies();
		PrintWriter out= res.getWriter();
		if(array != null && array.length >0) {
			out.println("<ul>");
			for(Cookie c : array) {
				out.println("<li>"+c.getName() +":"+c.getValue()+"</li>");
			}
			out.println("</ul>");
		}else {
			out.println("<h1>Cookie Not Found </h1>");
		}
		out.println("<div><a href='/0419/product.html'>장바구니 담기</a></div>");
		out.println("<div><a href='/0419/servlet/CartDelete'>장바구니에서 삭제</a></div>");
		out.close();
	}
}
