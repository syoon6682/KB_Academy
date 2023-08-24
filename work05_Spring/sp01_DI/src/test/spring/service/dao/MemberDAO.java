package spring.service.dao;

public interface MemberDAO {
	void register(String id, String name, String addr);
	void delete(String id);
}
