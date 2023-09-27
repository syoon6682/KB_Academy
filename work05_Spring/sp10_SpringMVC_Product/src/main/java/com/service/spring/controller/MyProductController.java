package com.service.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.MyProduct;
import com.service.spring.service.MyProductService;

@Controller
public class MyProductController {
	
	@Autowired
	private MyProductService myProductService;
	
	@RequestMapping("myProduct.do")
	public ModelAndView insert(MyProduct pvo) throws Exception{
		System.out.println("호출 전 :: " + pvo);
		myProductService.addProduct(pvo);
		System.out.println("호출 후 :: " + pvo);
		return new ModelAndView("insert_result", "vo", pvo);
	}
	
	@RequestMapping("/myProductSearch.do")
    public ModelAndView find(String command, String word) throws Exception{
        List<MyProduct> list = null;
        String viewName = "find_result";
        MyProduct vo = new MyProduct();
        if(command.equals("findProductByName")) {
        	vo.setName(word);
            list = myProductService.findProductAll(vo);
        }else if(command.equals("findProductByMaker")) {
        	vo.setMaker(word);
            list=myProductService.findProductAll(vo);
        }else if(command.equals("findProducts")) {
            list=myProductService.findProductAll(vo);
        }
        return new ModelAndView(viewName,"list",list);
    }
}
