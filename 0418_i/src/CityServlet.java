import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/City")
public class CityServlet extends HttpServlet {
	private final String DBDRIVER = "com.mysql.jdbc.Driver";
	private final String DBURL = "jdbc:mysql://localhost:3306/world";
	private final String DBUSER = "root";
	private final String DBPWD = "1234";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
     throws ServletException, IOException{
		//2. 단계
		try {
			Class.forName(DBDRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Class Not Found");
		}
		//3. DB Connection
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT id, name, countrycode, district, population  " +
                "FROM City WHERE countrycode = 'KOR'";
		try {
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPWD);
			//4 단계
			stmt = conn.createStatement();
		}catch(SQLException ex) { 
			System.out.println("Connection Failure");
		}
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		try {
			//5 단계
			rs = stmt.executeQuery(sql);
			//6 단계
			out.println("<h1>World database's City Table Infomation</h1>");
			out.println("<ul>");
			while(rs.next()) {
				out.print("<li>[" + rs.getInt("id") + "] " + rs.getString("name"));
				out.print(", " + rs.getString("countrycode") + ", ");
				out.println(rs.getString("district") + ", " + rs.getInt("population") + "</li>");
			}
			out.println("</ul>");
			//7단계
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		
	}
}





