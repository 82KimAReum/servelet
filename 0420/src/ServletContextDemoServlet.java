import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servlet/ServletContextDemo")
public class ServletContextDemoServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
     throws ServletException, IOException{
		ServletContext ctx= req.getServletContext();//interface
		System.out.println("MajorVersion: "+ctx.getMajorVersion());
		System.out.println("MinorVersion: "+ctx.getMinorVersion());
		
	}
}
