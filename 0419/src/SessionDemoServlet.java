import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//http://localhost:8080/0419/servlet/SessionDemo?command=create
@WebServlet("/servlet/SessionDemo")
public class SessionDemoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
     throws ServletException, IOException{
		res.setContentType("text/html;charset=utf8");
		PrintWriter out= res.getWriter();
		HttpSession session= null;
		String msg= null;
		String comm = req.getParameter("command");
		if(comm.equals("create")) {//?command=create
			session= req.getSession(true); //()없으면 새로 생성,있으면 있는거 씀
			if(session.isNew()) msg="방금 세션이 생성됐습니다.";
			else msg ="이미 생성됐던 세션입니다.";
			System.out.println("SESSIONID: "+session.getId());
			//절대로 중복될수 없으므로 웹서버가 유저를 구별하는 유일한 String값
			//넹네이버를 들어가면 발행하고 네이버를 나오면 닫음
		}else if(comm.equals("destroy")) {
			session=req.getSession(false);//없으면새로 만들지않고  null
			if(session ==null)msg="사용할수 없는 명령입니다.";
			else { 
				session.invalidate();
				msg="세션 객체를 방금 삭제했습니다.";				
			}
		}
		out.println("<h1>처리결과: "+msg+"</h1>");
		out.close();
	}
}
