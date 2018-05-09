import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/servlet/ServletContextDemo1",
                    initParams = @WebInitParam(name="DBURL", 
                                            value="jdbc:mysql://192.168.56.2:3306/world"))
public class ServletContextDemo1Servlet extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException{
		//web.xml의 <servlet>의 <init-param>
		String url = config.getInitParameter("DBURL");
		System.out.println("URL = " + url);
				
		//web.xml의 <context-param>
		ServletContext ctx = config.getServletContext();
		String driver = ctx.getInitParameter("DBDRIVER");
		System.out.println("DRIVER = " + driver);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
     throws ServletException, IOException{
	}
}




