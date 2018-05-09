package com.javasoft.libs.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.javasoft.libs.controllers.DBClose;
import com.javasoft.libs.controllers.DBConnection;

public class StudentDAO {
	public static Vector<StudentVO> selectAll() throws SQLException{
		Connection conn = DBConnection.getConnection("pool");
		Vector<StudentVO> vector = new Vector<StudentVO>(1,1);
		String sql = "SELECT hakbun, irum, kor, eng, mat, edp FROM student ";
		sql += "ORDER BY hakbun DESC";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			StudentVO s = new StudentVO(rs.getString("hakbun"), 
					                        rs.getString("irum"), rs.getInt("kor"),
					                        rs.getInt("eng"), rs.getInt("mat"),
					                        rs.getInt("edp"));
			vector.addElement(s);
		}
		if(rs != null) rs.close();    if(stmt != null) stmt.close();
		DBClose.close(conn);
		return vector;
	}
	public static int insert(StudentVO s) throws SQLException {
		Connection conn = DBConnection.getConnection("pool");
		String sql = "INSERT INTO Student VALUES(?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, s.getHakbun());
		pstmt.setString(2, s.getIrum());
		pstmt.setInt(3, s.getKor());
		pstmt.setInt(4, s.getEng());
		pstmt.setInt(5, s.getMat());
		pstmt.setInt(6, s.getEdp());
		pstmt.setInt(7, s.getTot());
		pstmt.setDouble(8, s.getAvg());
		pstmt.setString(9, String.valueOf(s.getGrade()));
		int row = pstmt.executeUpdate();
		if(pstmt != null) pstmt.close();
		DBClose.close(conn);
		return row;
	}
}
