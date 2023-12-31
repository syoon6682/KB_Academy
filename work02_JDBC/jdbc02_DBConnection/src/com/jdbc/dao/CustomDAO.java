package com.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.ldap.PagedResultsControl;

import config.ServerInfo;
import oracle.jdbc.proxy.annotation.Pre;

/*
 * Business Logic을 가지고 있는 DAO 클래스
 * 하나의 기능이 완벽한 서비스 단위이다.
 * 
 */

public class CustomDAO {
	// private Connection con = null; -> 이딴 식으로 만들면 안됨
	public CustomDAO() {		
		System.out.println("CustomDAO Creating");
	}
	
	////////// 공통적으로 반복되는 로직 /////////////
	private Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		System.out.println("Connection Complete");
		
		return conn;
	}
	
	private void closeAll(Connection conn, PreparedStatement ps) throws SQLException {
		if (ps!=null) ps.close();
		if (conn!=null) conn.close();
	}
	
	private void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {
		if (ps!=null) ps.close();
		if (conn!=null) conn.close();
	}
	
	////////// Business Logic :: Basic CRUD /////////////
	public void addCustom(int id, String name, String addr) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			
			String query = "INSERT INTO custom (id, name, address) VALUES (?, ?, ?)";
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, addr);
			
			ps.executeUpdate();
			System.out.println("등록 성공");
		} finally {
			closeAll(conn, ps);
		}
		
		
	}
	
	public void deleteCustom(int id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			
			String query = "DELETE custom WHERE id = ?";
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, id);
			
			ps.executeUpdate();
			System.out.println("삭제 성공");
					
		} finally {
			closeAll(conn, ps);
		}
	}
	
	public void updateCUstom(int id, String name, String addr) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			
			String query = "UPDATE custom set name=?, address=? WHERE id=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, addr);
			ps.setInt(3, id);
			
			ps.executeUpdate();
			System.out.println("업데이트 성공");
			
		} finally {
			closeAll(conn, ps);
		}
	}
	
	public void printAllCustom() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnect();
			String query = "SELECT id, name, address FROM custom";
			
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("name") + "\t" + rs.getString("address"));
			}
			
		} finally {
			// Overloading 기법을 활용한 closeAll 범용성 확대
			closeAll(conn, ps, rs);
		}
	}
	
	public void printACustom(int id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnect();
			String query = "SELECT id, name, address FROM custom WHERE id = ?";
			
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				System.out.println(rs.getString("name") + "\t" + rs.getString("address"));
			}
			
		} finally {
			// Overloading 기법을 활용한 closeAll 범용성 확대
			closeAll(conn, ps, rs);
		}
	}
	
}
