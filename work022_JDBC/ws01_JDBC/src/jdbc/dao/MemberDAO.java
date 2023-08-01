package jdbc.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.dto.Member;
import jdbc.exception.DuplicateIDException;

public interface MemberDAO {
	Connection getConnect() throws SQLException;
	void closeAll(Connection conn, PreparedStatement ps) throws SQLException;
	void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException;
	void insertMember(Member member) throws SQLException, DuplicateIDException; 
	void deleteMember(int id);
	void updateMember(Member member);
	Member getMember(int id);
	ArrayList<Member> getMember();
	ArrayList<Member> getMember(String name);
}
