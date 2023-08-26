package spring.service.dao.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import spring.service.dao.MemberDAO;

public class DAOTestApp04UsingSpring {
	public static void main(String[] args) {
		// MemberDAOImpl 직접 생성하면 재사용성이 떨어진다
		// 직접 연결되어져 있다는 것은 Coupling이 강하다는 의미
		// 결합도를 아예 없애는 방법이 바로 DI Container를 사용하는것
		/*
		 * 내가 주문서를 작성
		 * DI Container에서 생성후 저장된 객체를 받아서 사용하면 된다.
		 * getBean();
		 */
		
		@SuppressWarnings("deprecation")
		BeanFactory factory = new XmlBeanFactory( new FileSystemResource ("./src/main/resources/config/dao.xml") );
		
		// 2. 공장에서 저장하고 있는 dao빈을 찾아온다. 사용하려고
		MemberDAO dao = (MemberDAO)factory.getBean("dao");
		
		dao.register("kblife", "김국민", "선릉");
		dao.delete("haha0071");
	}
}
