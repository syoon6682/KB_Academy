package com.service.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.Item;
import com.service.spring.service.ItemCatalog;

@Controller
public class FruitController {
	
	@Autowired
	private ItemCatalog itemCatalog;
	
	@RequestMapping("/list.do")
	public ModelAndView list() throws Exception{
		List<Item> list = itemCatalog.getItemList();
		System.out.println("list comein");
		System.out.println(list);
		return new ModelAndView("itemList.jsp", "list", list);
	}
	
	@RequestMapping("/detail.do")
	public ModelAndView detail(int itemNumber) throws Exception {
		Item item = itemCatalog.getItem(itemNumber);
		return new ModelAndView("detail", "item", item);
	}
	
}
