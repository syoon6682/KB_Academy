package spring.service.dao.impl;

import spring.service.dao.MemberDAO;

public class MemberDAOImpl implements MemberDAO{

	@Override
	public void register(String id, String name, String addr) {
		System.out.println(name+", register success");
		
	}

	@Override
	public void delete(String id) {
		System.out.println(id+", delete success");
		
	}
	
}
