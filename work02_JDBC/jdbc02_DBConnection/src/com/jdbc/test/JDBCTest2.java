package com.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbc.dao.CustomDAO;

import config.ServerInfo;

public class JDBCTest2 {

	public JDBCTest2() throws Exception {
			
	}
	
	public static void main(String[] args) throws SQLException {
		CustomDAO dao = new CustomDAO();
//		dao.addCustom(0, "이정재", "신사동");
//		dao.deleteCustom(0);
//		dao.printACustom(30);
//		dao.printAllCustom();
		dao.updateCUstom(12, "Hinson1", "Brandon");
	}
	
	static {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("Driver Loading Success");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Loading Fail");
		}
	}
}
