import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		     throws ServletException, IOException{
				req.setCharacterEncoding("utf-8");
				String userid = req.getParameter("userid");
				String userpwd = req.getParameter("userpwd");
				res.setContentType("text/html;charset=utf8");
				PrintWriter out=res.getWriter();
				
				if(userid.equals("1234") && userpwd.equals("1234")) {
					out.print("<body style=background-color:'yellow'>");
					out.print("<h1>Success</h1>");
				}
				out.print("</body>");
				out.close();
			}
	
}
