package com.javasoft.libs.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {
	private Properties info = null;
	private Properties getProperties() {
		return this.info;
	}
	private DBConnection(String path) {
		//File file = new File("../../../../../dbinfo.properties");
		this.info = new Properties();
		try {
			this.info.load(new FileInputStream(path));
		} catch (IOException e) {
			System.out.println("File Not Found");
		}
	}
	public static Connection getConnection(String path) {
		DBConnection dbconn= new DBConnection(path);
		Properties info =dbconn.getProperties();
		Connection conn=null;
		try {
			Class.forName(info.getProperty("DBDRIVER"));
			conn=DriverManager.getConnection(info.getProperty("DBURL"), info.getProperty("DBUSER"), info.getProperty("DBPWD"));
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return conn;
	}
}


