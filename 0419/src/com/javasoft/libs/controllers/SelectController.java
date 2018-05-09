package com.javasoft.libs.controllers;

import java.sql.SQLException;
import java.util.Vector;

import com.javasoft.libs.models.EmployeeDAO;
import com.javasoft.libs.models.EmployeeVO;

public class SelectController {
	public static Vector<EmployeeVO> getEmployeeAll(){
		Vector<EmployeeVO> vector = null;
		try {
			vector = EmployeeDAO.selectAll();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return vector;
	}
}
