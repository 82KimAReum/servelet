package com.javasoft.libs.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class EmployeeDAO {
	public static Vector<EmployeeVO> selectAll() throws SQLException{
		Connection conn = DBConnection.getConnection("pool");
		Statement stmt = conn.createStatement();
		String sql = "SELECT empno, ename, sal, job, dept.deptno, dname, loc " +
		                  "FROM emp, dept WHERE emp.deptno = dept.deptno";
		ResultSet rs = stmt.executeQuery(sql);
		Vector<EmployeeVO> vector = new Vector<EmployeeVO>(1,1);
		while(rs.next()) {
			EmployeeVO emp = new EmployeeVO();
			emp.setEmpno(rs.getInt("empno"));  
			emp.setEname(rs.getString("ename"));
			emp.setSal(rs.getDouble("sal"));
			emp.setJob(rs.getString("job"));
			emp.setDeptno(rs.getInt("deptno"));
			emp.setDname(rs.getString("dname"));
			emp.setLoc(rs.getString("loc"));
			vector.addElement(emp);
		}
		if(rs != null) rs.close();   if(stmt != null) stmt.close();
		DBClose.close(conn);
		return vector;
	}
}




