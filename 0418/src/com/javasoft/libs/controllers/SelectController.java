package com.javasoft.libs.controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

import com.javasoft.libs.models.CityDAO;
import com.javasoft.libs.models.CityVO;

public class SelectController {
	public static Vector<CityVO> select(Connection conn,String countrycode){
		Vector<CityVO> vector =null;
		
		try {
			vector = CityDAO.select(conn, countrycode);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return vector;
	}
	public static Vector<String> select(Connection conn){
		Vector<String> vector =null;
		
		try {
			vector = CityDAO.select(conn);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return vector;
	}
}
