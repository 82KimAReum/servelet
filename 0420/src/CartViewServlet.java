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

@WebServlet("/servlet/CartView")
public class CartViewServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
     throws ServletException, IOException{
		res.setContentType("text/html;charset=utf-8");
		HttpSession session=req.getSession(false);		
		PrintWriter out = res.getWriter();
		if(session != null) {
			ArrayList<String> cart= (ArrayList<String>)session.getAttribute("mycart");
			out.println("<ul>");
			for(String product : cart) {
				out.println("<li>" +product + "</li>");
			}
			out.println("</ul>");
		}else {
			out.println("<h1>Session Not Found</h1>");
		}
		out.println("<div><a href='/0420/product.html'>장바구니 담기</a></div>");
		out.println("<div><a href='/0420/servlet/CartDelete'>장바구니에서 삭제</a></div>");
		out.close();
	}
}

	
	
	