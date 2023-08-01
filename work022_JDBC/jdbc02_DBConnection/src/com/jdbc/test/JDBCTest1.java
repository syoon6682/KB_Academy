package com.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;

public class JDBCTest1 {

	public JDBCTest1() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn =  DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
			System.out.println("Database Connection");
			
			
			/*
			String query = "DELETE custom WHERE id=?";
			
			PreparedStatement ps =conn.prepareStatement(query);
			ps.setInt(1, 1);
			
			System.out.println("PreparedStatement Creation");
			int row = ps.executeUpdate();
			System.out.println(row + "row delete complete");
			*/
			
			// UPDATE : 아이디 10 고객의 이름을 JAMES1, 주소를 NY으로 수정
			/*
			String query = "UPDATE custom SET name = ?, address = ? WHERE id=10";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, "JAMES1");
			ps.setString(2, "NY");
			int row = ps.executeUpdate();
			*/
			
			// SELECT : 
			String query = "SELECT * FROM custom";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t" + rs.getString("address"));
			}
			
		} finally {
			// 가장 먼저 연 것을 가장 나중에 닫는다.
			// connection은 안닫으면 진짜 큰일남..꼭 닫기!
			rs.close();
			ps.close();
			conn.close();
		}
		
		
	}
	
	public static void main(String[] args) throws SQLException {
		new JDBCTest1();
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
