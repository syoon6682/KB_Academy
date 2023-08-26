package mybatis.services.user.impl;

/*
 * 	Annotation 기반으로 작성
 * 	xml 빈 설정문서에서 bean태그를 생략 할 수 있다
 * 
 * 
 * 	
 * 	
 */
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mybatis.services.domain.User;
import mybatis.services.user.UserDAO;

@Repository
public class MyBatisUserDAOImpl13 implements UserDAO {

	// DI... 완성
	@Autowired
	private SqlSession sqlSession;
	public static final String MAPPER_NAME = "UserMapper10.";

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
