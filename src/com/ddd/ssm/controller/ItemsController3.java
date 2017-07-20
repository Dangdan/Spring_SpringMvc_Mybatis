package com.ddd.ssm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ddd.ssm.pojo.Items;

/**
 * 使用注解开发handler
 * 
 * @author Dan
 *
 */

// 标识它是一个控制器
@Controller
public class ItemsController3{
	// 查询商品列表
	//@RequestMapping("/queryItems")实现了对queryItems()方法和url进行映射，一个方法对应一个url
	//一般方法和url一样便于维护
	@RequestMapping("/queryItems33")
	public ModelAndView queryItems() {
		// 调用service查找数据库，查询商品列表，这里使用静态数据模拟
		List<Items> itemsList = new ArrayList<>();
		// 填充静态数据
		Items items_1 = new Items();
		items_1.setName("皮鞋");
		items_1.setPrice(698f);
		items_1.setDetail("稻草人皮鞋！");

		Items items_2 = new Items();
		items_2.setName("水杯");
		items_2.setPrice(5000f);
		items_2.setDetail("特百惠水杯！");

		itemsList.add(items_1);
		itemsList.add(items_2);
		// 返回modelAndView
		ModelAndView modelAndView = new ModelAndView();
		// 相当于request.setAttribute(..,..)，就是在jsp页面中通过itemsList取数据
		modelAndView.addObject("itemsList", itemsList);
		// 指定视图
		modelAndView.setViewName("/items/itemsList");
		return modelAndView;

	}

}
