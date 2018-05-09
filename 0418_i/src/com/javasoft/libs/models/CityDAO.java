package com.javasoft.libs.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.javasoft.libs.controllers.DBClose;
import com.javasoft.libs.controllers.DBConnection;

public class CityDAO {
	public static Vector<CityVO> select(String countrycode) 
			throws SQLException{
		Connection conn = DBConnection.getConnection("pool");
		Vector<CityVO> vector = new Vector<CityVO>(1,1);
		String sql = "SELECT id, name, countrycode, district, population " +
                          "FROM City WHERE CountryCode = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, countrycode);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			CityVO city = new CityVO(rs.getInt("id"), rs.getString("name"),
					rs.getString("countrycode"), rs.getString("district"),
					rs.getInt("population"));
			vector.addElement(city);
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) DBClose.close(conn);
		return vector;
	}
	public static Vector<String> select() 
			throws SQLException{
		Connection conn = DBConnection.getConnection("pool");
		Vector<String> vector = new Vector<String>(1,1);
		String sql = "SELECT DISTINCT countrycode FROM City";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			vector.addElement(rs.getString(1));
		}
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		if(conn != null) DBClose.close(conn);
		return vector;
	}
}





