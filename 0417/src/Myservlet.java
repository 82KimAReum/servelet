import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;


@WebServlet(name="MyServlet",urlPatterns= {"/servlet/MyFile"},initParams= { 
 @WebInitParam(name="myfile",value="./WEB-INF/count.txt")
,@WebInitParam(name="DBDRIVER",value="com.oracle.driver.OracleDriver")
,@WebInitParam(name="DBURL",value="jdbc:oracle:@localhost:1521:XE")
,@WebInitParam(name="DBUSER",value="scott")
,@WebInitParam(name="DBPWD",value="tiger")})
public class Myservlet extends HttpServlet {
	public RandomAccessFile raf =null;
	public void init() throws ServletException{
//		File file=new File(this.getInitParameter("myfile"));
//		
//		
//	
		
//		String fileName=this.getInitParameter("myfile");
//		System.out.println(fileName);
		//xml의 myfile 찾아옴//가짜 경로라서 사용자가 url로 접근 안됨
		
//		String filename= this.getInitParameter("myfile");
//		File file =new File(filename);
//		try {
//				this.raf=new RandomAccessFile(filename,"rw");
//				System.out.println(this.raf.readLine());
//			
//		} catch (IOException e) {
//			
//			System.out.println(e);
//		}
//		
//		System.out.println("file not found");
		Enumeration<String>enums=this.getInitParameterNames();
		while(enums.hasMoreElements()) {
			String name=enums.nextElement();
			System.out.printf("%s -->  %s \n",name ,this.getInitParameter(name));
		}
		
	}
	public void service(ServletRequest req, ServletResponse res)
     throws ServletException,
            IOException{
		//HttpServletRequest hsr=(HttpServletRequest)req;
		//System.out.println(hsr.getMethod());//GET
		res.setContentType("text/html");
		PrintWriter out =res.getWriter();
		out.println(((HttpServletRequest)req).getMethod());
		out.close();
		
	}
}
