import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		     throws ServletException, IOException{
		this.doService(req, res);
	}  
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
     throws ServletException, IOException{
		this.doService(req, res);
	}
	private void doService(HttpServletRequest req, HttpServletResponse res)
		     throws ServletException, IOException{
				req.setCharacterEncoding("utf-8");
				String name = req.getParameter("username");
				int age = Integer.parseInt(req.getParameter("userage"));
				res.setContentType("text/html;charset=utf8");
				Date now= new Date();
				
				PrintWriter out =res.getWriter();   
				out.println("<head>");
				out.println("<meta charset='utf-8'>");
				out.println("</head>");
				out.println("<h1>User Information</h1>");
				out.println("방문 날자는 : "+now.toString()+"</br>");

				out.println("<ul>");
				out.println("<li>Name: "+name+"</li>");
				out.println("<li>age: "+age+"</li>");
				
				out.println("</ul>");

		
				out.close();
			}
	
	
}
