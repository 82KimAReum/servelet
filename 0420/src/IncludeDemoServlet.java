import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/IncludeDemo")
public class IncludeDemoServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
     throws ServletException, IOException{
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		out.println("<meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">");
		out.println("<title>Document</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Include Demo </h1>");
		out.println("<hr/>");
		RequestDispatcher rd= req.getRequestDispatcher("/myimage.html");
		//"/"로 시작하는 상대 경로만 쓸것
		rd.include(req, res);
		out.println("<hr/>");
		rd=req.getRequestDispatcher("/servlet/Now");
		rd.include(req, res);
		out.println("<p>이상 include 끝 </p>");
		out.println("<hr/>");
		rd=req.getRequestDispatcher("/servlet/Form");
		rd.include(req, res);
		out.println("</body>");
		out.println("</html>");
		out.close();//꼭 닫아야 함
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		     throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		System.out.println(req.getParameter("pname"));
	}
}
