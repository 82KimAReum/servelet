import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servlet/CartAdd")
public class CartAddServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
     throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		String product = req.getParameter("pname");
		HttpSession session =req.getSession();
		ArrayList<String> cart = (ArrayList<String>)session.getAttribute("mycart");
		if(cart == null) {
			cart= new ArrayList<String>();//기본 10개생성
			cart.add(product);
			session.setAttribute("mycart", cart);
		}else {
			cart.add(product);
		}
		
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<meta charset='utf-8'>");
		out.println("<h1>" + "Cart에 " + product + "담았습니다.</h1>");
		out.println("<div><a href='/0420/servlet/CartView'>Cart View</a></div>");
		out.close();
	}
}




