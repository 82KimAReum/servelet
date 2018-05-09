package com.javasoft.libs.controllers;

import java.sql.SQLException;

import com.javasoft.libs.models.DAO;
import com.javasoft.libs.models.VO;

public class InsertController {
	public static int insert(VO s) {
		int row = 0;
		try {
			row = DAO.insert(s);
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return row;
	}
}
