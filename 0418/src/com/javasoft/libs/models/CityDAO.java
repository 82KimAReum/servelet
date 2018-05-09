package com.javasoft.libs.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;



public class CityDAO {
	public static Vector<CityVO> select(Connection conn,String countrycode) throws SQLException{
		Vector<CityVO> vector =new Vector<CityVO>(1,1);
		Statement stmt=conn.createStatement();
		String sql="select id,name,countrycode,district,population "+
		"from City where CountryCode =? ";
		PreparedStatement pstmt= conn.prepareStatement(sql);
		pstmt.setString(1, countrycode);
		ResultSet rs= pstmt.executeQuery();
		while(rs.next()) {
			CityVO city= new CityVO(rs.getInt("id"),rs.getString("name"),rs.getString("countrycode"),rs.getString("district"),rs.getInt("population"));
			vector.addElement(city);
		}
		
		if(stmt != null)stmt.close();
		return vector;
	}
	
	public static Vector<String> select(Connection conn) throws SQLException{
		Vector<String> vector =new Vector<String>(1,1);
		Statement stmt=conn.createStatement();
		String sql="select distinct countrycode "+
		"from world.city ";
		PreparedStatement pstmt= conn.prepareStatement(sql);
		//pstmt.setString(1, countrycode);
		ResultSet rs= pstmt.executeQuery();
		while(rs.next()) {
			String city= rs.getString("countrycode");
			vector.addElement(city);
		}
		
		if(stmt != null)stmt.close();
		return vector;
	}
}
