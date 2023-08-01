package com.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jdbc.dao.CustomDAO;
import com.jdbc.vo.Custom;

import config.ServerInfo;

public class customDAOImpl implements CustomDAO{
	
	private static customDAOImpl dao = new customDAOImpl();
	private customDAOImpl() {
		System.out.println("Creating Object");
	}
	
	public static customDAOImpl getInstance() {
		return dao;
	}
	
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
	
	
	public boolean idExists (int id, Connection conn) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null; 
	
		conn = getConnect();
		String query = "SELECT id FROM custom WHERE id =?";
		ps = conn.prepareStatement(query);
		ps.setInt(1, id);
		rs = ps.executeQuery();
		return rs.next();

	}
	
	@Override
	public void addCustom(Custom cust) throws SQLException {
		// 존재유무 확인
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			if(!idExists(cust.getId(), conn)) {//id가 없다면 추가 진행
				conn = getConnect();
				
				String query = "INSERT INTO custom (id, name, address) VALUES (?, ?, ?)";
				ps = conn.prepareStatement(query);
				ps.setInt(1, cust.getId());
				ps.setString(2, cust.getName());
				ps.setString(3, cust.getAddress());
				
				System.out.println(ps.executeUpdate() + " 명 회원 등록");
			} else {
				// 원래는 예외 발생 시켜서 터트리는 게 정석
				System.out.println(cust.getName() + " 님은 이미 회원입니다.");
			}
			
		} finally {
			closeAll(conn, ps);
		}
		
	}

	@Override
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

	@Override
	public void updateCustom(Custom cust) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Custom getCutomer(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Custom> getAllCustomer() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
