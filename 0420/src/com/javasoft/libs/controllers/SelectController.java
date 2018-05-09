package com.javasoft.libs.controllers;

import java.sql.SQLException;
import java.util.Vector;

import com.javasoft.libs.models.DAO;
import com.javasoft.libs.models.VO;

public class SelectController {
	public static Vector<VO> selectAll(){
		Vector<VO> vector = null;
		try {
			vector = DAO.selectAll();
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return vector;
	}
}





