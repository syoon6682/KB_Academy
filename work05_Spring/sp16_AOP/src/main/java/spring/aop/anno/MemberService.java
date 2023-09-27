package spring.aop.anno;

// Target Class...CoreConcern

public class MemberService {
	
	public void register(String name) {
		System.out.println("register...logic...회원등록성공");
	}
	
	public void findMember(String id) {
		System.out.println("findMember....logic...회원 검색 성공");
	}
}
