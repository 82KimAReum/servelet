package com.javasoft.libs.controllers;

import java.sql.SQLException;

import com.javasoft.libs.models.StudentDAO;
import com.javasoft.libs.models.StudentVO;

public class InsertController {
	public static int insert(StudentVO s) {
		int row = 0;
		try {
			row = StudentDAO.insert(s);
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return row;
	}
}
