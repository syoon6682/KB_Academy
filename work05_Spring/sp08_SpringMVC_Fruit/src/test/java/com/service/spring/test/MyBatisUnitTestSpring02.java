package com.service.spring.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.spring.domain.Item;
import com.service.spring.service.ItemCatalog;

public class MyBatisUnitTestSpring02 {
	@Test
	public void DITest() throws Exception {
		// ���� �����ϴ� DIDEVELOPMENT�����̳ʸ� ���� -> ���߿����� pre-Loading -> getBean() Ÿ���� �ƴ� �ֹ����� ���ڸ��� ���� ����
		ApplicationContext factory = new ClassPathXmlApplicationContext("bean/itemservice.xml");

		ItemCatalog service = (ItemCatalog) factory.getBean("itemCatalogImpl");
		


		
		System.out.println("===========getItemList=========");
		List<Item> list = service.getItemList();
		for (Item i : list) {
			System.out.println(i);
		}
		
		System.out.println("====================");
		Item item = service.getItem(2222);
		System.out.println(item);
		
		
		
		
	}
}
