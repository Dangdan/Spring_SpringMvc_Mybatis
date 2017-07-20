package com.ddd.ssm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ddd.ssm.pojo.Items;
/**
 * 实现HttpRequestHandler接口的处理器
 * @author Dan
 *
 */
public class ItemsController2 implements HttpRequestHandler{

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 调用service查找数据库，查询商品列表，这里使用静态数据模拟
		List<Items> itemsList=new ArrayList<>();
		//填充静态数据
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
		//设置模型数据
		request.setAttribute("itemsList", itemsList);
		//设置要转发到哪个视图
		request.getRequestDispatcher("/WEB-INF/jsp/items/itemsList.jsp").forward(request, response);
		
		//使用此方法可以通过修改response，设置响应数据格式，比如json数据格式
	/*	response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write("json串");
	*/	
	
	
	
	}

}
