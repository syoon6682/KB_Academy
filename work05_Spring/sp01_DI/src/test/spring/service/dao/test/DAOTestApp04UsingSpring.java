package spring.service.dao.test;

public class DAOTestApp04UsingSpring {

	public static void main(String[] args) {
		// MemberDAOImpl를 직접 여기서 생성하면 재사용성이 떨어짐
		// 직접 연결되어 있다는 것은 Coupling이 Tight함을 의미
		// 결합도를 아예 없애는 방법이 DIContainer를 사용하는 것
		
		//1. 주문서를 읽어들임과 동시에 공장을 생성
		BeanFactory facotry = new XmlBeanFactory(new FileSystemResource
				(".src"));
	}

}
