package com.javasoft.libs.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.javasoft.libs.controllers.DBClose;
import com.javasoft.libs.controllers.DBConnection;

public class DAO {
	public static Vector<VO> selectAll() throws SQLException{
		Connection conn = DBConnection.getConnection("pool");
		Vector<VO> vector = new Vector<VO>(1,1);
		String sql = "SELECT id,place,gender,train,seat,persent,discount,fee FROM test ";
		sql += "ORDER BY gender DESC";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			VO s = new VO(rs.getInt("id"), 
					                        rs.getString("place"), rs.getString("gender"),
					                        rs.getString("train"), rs.getString("seat"),
					                        rs.getString("persent"),rs.getInt("discount"),rs.getInt("fee"));
			vector.addElement(s);
		}
		if(rs != null) rs.close();    if(stmt != null) stmt.close();
		DBClose.close(conn);
		return vector;
	}
	public static int insert(VO s) throws SQLException {
		Connection conn = DBConnection.getConnection("pool");
		String sql = "INSERT INTO(place,gender,train,seat,persent,discount,fee) Student VALUES(?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, s.getPlace());
		pstmt.setString(2, s.getGender());
		pstmt.setString(3, s.getTrain());
		pstmt.setString(4, s.getSeat());
		pstmt.setString(5, s.getPersent());
		pstmt.setInt(6, s.getDiscount());
		pstmt.setInt(7, s.getPee());
		
		int row = pstmt.executeUpdate();
		if(pstmt != null) pstmt.close();
		DBClose.close(conn);
		return row;
	}
}
