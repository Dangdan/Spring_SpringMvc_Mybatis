package com.ddd.ssm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ddd.ssm.pojo.Items;
import com.ddd.ssm.pojo.ItemsCustom;
import com.ddd.ssm.service.ItemsService;

/**
 * ItemsController实现商品查询
 * 
 * @author Dan
 *
 */

@Controller
@RequestMapping("/items")
public class ItemsController{
	//注入itemsService
	@Autowired
	private ItemsService itemsService;
	@RequestMapping("/queryItemsList")
	public ModelAndView queryItems() throws Exception {
		// 调用service查找数据库，查询商品列表，这里使用静态数据模拟
		List<ItemsCustom> itemsList = itemsService.findItemsList(null);
		// 返回modelAndView
		ModelAndView modelAndView = new ModelAndView();
		// 相当于request.setAttribute(..,..)，就是在jsp页面中通过itemsList取数据
		modelAndView.addObject("itemsList", itemsList);
		// 指定视图
		modelAndView.setViewName("/itemsList");
		return modelAndView;

	}
	
	//商品的修改
	@RequestMapping("/editItems")
	public ModelAndView editItems() throws Exception {
		// 调用service查找数据库，查询商品
		ItemsCustom itemsCustom = itemsService.findItemsById(1);
		// 返回modelAndView
		ModelAndView modelAndView = new ModelAndView();
		// 相当于request.setAttribute(..,..)，就是在jsp页面中通过itemsList取数据
		modelAndView.addObject("itemsCustom", itemsCustom);
		// 指定视图
		modelAndView.setViewName("/editItems");
		return modelAndView;

	}

	//商品信息修改后提交
	@RequestMapping("/editItemsSubmit")
	public ModelAndView editItemsSubmit() throws Exception {
		// 调用service更新商品信息，页面需要将商品信息传到此方法
		
		
		// 返回modelAndView
		ModelAndView modelAndView = new ModelAndView();
		
		// 指定视图
		modelAndView.setViewName("success");
		return modelAndView;

	}

}
