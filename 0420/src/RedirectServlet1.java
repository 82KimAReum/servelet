import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/Forward")
//동일 도메인만 가능
public class RedirectServlet1 extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
		int age=Integer.parseInt(req.getParameter("userage"));
		RequestDispatcher rd=null;
		if(age<10) {
			rd = req.getRequestDispatcher("http://jr.naver.com/");
			rd.forward(req, res);
		}else if(age >=10 && age <= 19){
			rd = req.getRequestDispatcher("/teenage.html");
			rd.forward(req, res);
		}else if(age >19 && age<=65) {
			rd = req.getRequestDispatcher("/adult.html");
			rd.forward(req, res);
		}else {
			rd = req.getRequestDispatcher("/silver.html");
			rd.forward(req, res);
		}
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<h1>귀하의 나이를 입력해 주세요</h1>");
		out.println("<form method='post'>");
		out.println("Age: <input type ='number' name='userage'>");
		out.println("<input type= 'submit' value='전송'>");
		out.println("</form>");

		out.close();
	}
}
