package mybatis.services.user.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.services.domain.User;
import mybatis.services.user.UserDAO;

public class MyBatisUserDAOImpl10 implements UserDAO{
	
	// DI... 완성
	private SqlSession sqlSession;
	public static final String MAPPER_NAME ="UserMapper10.";
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		System.out.println("::" + getClass().getName() + ".setSqlSession");
	}

	@Override
	public int addUser(User user) throws Exception {
		int result = sqlSession.insert(MAPPER_NAME + "addUser", user);
		return result;
	}

	@Override
	public int updateUser(User user) throws Exception {
		int result = sqlSession.insert(MAPPER_NAME + "updateUser", user);
		return result;
	}

	@Override
	public int removeUser(String userId) throws Exception {
		int result = sqlSession.insert(MAPPER_NAME + "removeUser", userId);
		return result;
	}

	@Override
	public User getUser(String userId) throws Exception {
		User user = sqlSession.selectOne(MAPPER_NAME + "getUser", userId);
		return user;
	}

	@Override
	public List<User> getUserList(User user) throws Exception {
		List<User> users = sqlSession.selectList(MAPPER_NAME + "getUserList", user);
		return users;
	}
	
}
