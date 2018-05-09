import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/CartAdd")
public class CartAddServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
     throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		String product = req.getParameter("pname");
		Cookie [] array = req.getCookies();
		Cookie cart = null;
		if(array == null || array.length == 0 ) {
			cart = new Cookie("mycart", product);
		}else {
			cart = new Cookie("mycart" + array.length , product);
		}
		res.addCookie(cart);
		res.setContentType("text/html;charset=utf8");
		PrintWriter out = res.getWriter();
		out.println("<meta charset='utf-8'>");
		out.println("<h1> Cart에" + product + "담았습니다.</h1>");
		out.println("<div><a href='/0419/servlet/CartView'>Cart View</a></div>");
		out.close();
	}
}




