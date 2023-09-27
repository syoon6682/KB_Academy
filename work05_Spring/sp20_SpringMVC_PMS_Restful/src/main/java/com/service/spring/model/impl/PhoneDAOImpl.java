package com.service.spring.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.Phone;
import com.service.spring.domain.UserInfo;
import com.service.spring.model.PhoneDAO;

@Repository
public class PhoneDAOImpl implements PhoneDAO {
	
	public static final String NS = "sql.pms.mapper.";
	
	@Autowired
	private SqlSession sqlsession;
	
	@Override
	public int insert(Phone phone) {
		return sqlsession.insert(NS+ "insert", phone);
	}

	@Override
	public int delete(List<String> list) {
		return sqlsession.delete(NS+ "delete", list);
	}

	@Override
	public Phone select(Phone phone) {
		return sqlsession.selectOne(NS+ "select", phone);
	}

	@Override
	public List<Phone> select() {
		return sqlsession.selectList(NS+ "select", null);
	}

	@Override
	public UserInfo select(UserInfo user) {
		return sqlsession.selectOne(NS+ "selectUser", user);
	}

	@Override
	public int update(Phone phone) {
		return sqlsession.update(NS+"update", phone);
	}
	
}
