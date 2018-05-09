import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/Redirect")
public class RedirectServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
		int age=Integer.parseInt(req.getParameter("userage"));
		PrintWriter out = res.getWriter();
		if(age<10) {
			res.sendRedirect("http://jr.naver.com/");
		}else if(age >=10 && age <= 19){
			res.sendRedirect("http://www.ebs.co.kr/main");
		}else if(age >19 && age<=65) {
			out.println("<script>");
			out.println("location.href='http://www.moel.go.kr/index.do';");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("location.replace('http://www.elder.or.kr/');");
			out.println("</script>");
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
