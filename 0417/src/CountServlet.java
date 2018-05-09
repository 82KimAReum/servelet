import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class CountServlet extends HttpServlet {
	private RandomAccessFile raf= null;
//	private int initcount= 1000;
//	private int serviceCount=1;
//	private int destroyCount=1;
	private int myCount;
	@Override
	public void init()throws ServletException{
		//System.out.println("inti(): "+initcount++);
		try {
			this.raf= new RandomAccessFile("C:\\temp1\\count.txt", "rw");
			System.out.println("init() called");
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		}
		
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
     throws ServletException,IOException{
		//System.out.println("service(): "+serviceCount++);
		this.raf.seek((long)0);
		this.myCount= Integer.parseInt(this.raf.readLine());
		this.myCount++;
		System.out.println("service() called:"+ this.myCount);
		this.raf.seek((long)0);
		this.raf.writeBytes(this.myCount+ "");;
	}
	@Override
	public void destroy() {
		//System.out.println("destroy(): "+destroyCount++);
		System.out.println("destroy() called: " );
		try {
			this.raf.close();
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}
	
}
