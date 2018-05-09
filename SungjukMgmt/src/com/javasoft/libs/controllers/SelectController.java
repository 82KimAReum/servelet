package com.javasoft.libs.controllers;

import java.sql.SQLException;
import java.util.Vector;

import com.javasoft.libs.models.StudentDAO;
import com.javasoft.libs.models.StudentVO;

public class SelectController {
	public static Vector<StudentVO> selectAll(){
		Vector<StudentVO> vector = null;
		try {
			vector = StudentDAO.selectAll();
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return vector;
	}
}





