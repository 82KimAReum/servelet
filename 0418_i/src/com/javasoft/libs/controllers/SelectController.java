package com.javasoft.libs.controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

import com.javasoft.libs.models.CityDAO;
import com.javasoft.libs.models.CityVO;

public class SelectController {
	public static Vector<CityVO> select(String countrycode){
		Vector<CityVO> vector = null;
		try {
			vector = CityDAO.select(countrycode);
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return vector;
	}
	public static Vector<String> select(){
		Vector<String> vector = null;
		try {
			vector = CityDAO.select();
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return vector;
	}
}
