package com.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbc.dao.CustomDAO;
import com.jdbc.dao.impl.customDAOImpl;
import com.jdbc.vo.Custom;

import config.ServerInfo;

public class CustomDAOTest {

	public CustomDAOTest() throws Exception {
			
	}
	
	public static void main(String[] args) throws SQLException {
		customDAOImpl dao = customDAOImpl.getInstance();
		dao.addCustom(new Custom(80,"김한주", "별내동"));
//		dao.deleteCustom(0);
//		dao.printACustom(30);
//		dao.printAllCustom();
//		dao.updateCustom(12, "Hinson1", "Brandon");
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
