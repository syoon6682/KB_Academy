package jdbc.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import jdbc.dao.MemberDAO;
import jdbc.dto.Member;
import jdbc.exception.DuplicateIDException;

public class MemberDAOImpl implements MemberDAO{
	
	private static MemberDAOImpl dao = new MemberDAOImpl();
	private MemberDAOImpl() {
		System.out.println("Creating Object");
	}
	
	public static MemberDAOImpl getInstance() {
		return dao;
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
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		System.out.println("Connection Complete");
		
		return conn;
	}
	

	@Override
	public void closeAll(Connection conn, PreparedStatement ps) throws SQLException {
		if (ps!=null) ps.close();
		if (conn!=null) conn.close();
	}

	@Override
	public void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {
		if (ps!=null) ps.close();
		if (conn!=null) conn.close();
	}

	@Override
	public void insertMember(Member member) throws SQLException, DuplicateIDException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			if(!idExists(member.getId(), conn)) {//id가 없다면 추가 진행
				conn = getConnect();
				
				String query = "INSERT INTO member (id, name, email, phone) VALUES (seq_id.nextVal, ?, ?, ?)";
				ps = conn.prepareStatement(query);
				ps.setString(1, member.getName());
				ps.setString(2, member.getEmail());
				ps.setString(3, member.getPhone());
				
				System.out.println(ps.executeUpdate() + " 명 회원 등록");
			} else {
				// 원래는 예외 발생 시켜서 터트리는 게 정석
				System.out.println(member.getName() + " 님은 이미 회원입니다.");
				throw new DuplicateIDException();
			}
			
		} finally {
			closeAll(conn, ps);
		}
		
	}

	@Override
	public void deleteMember(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMember(Member member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Member getMember(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Member> getMember() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Member> getMember(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
