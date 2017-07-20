package com.ddd.ssm.service;

import java.util.List;

import com.ddd.ssm.pojo.ItemsCustom;
import com.ddd.ssm.pojo.ItemsQueryVo;

/**
 * 商品管理的service
 * 
 * @author Dan
 *
 */
public interface ItemsService {
	// 商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;

	// 根据id查询商品信息
	/**
 	findItemsById 
	 * @param id 查询商品的id
	 * @return
	 * @throws Exception
	 */
	public ItemsCustom findItemsById(Integer id) throws Exception;

	// 修改商品信息
	/**
	 updateItems
	 * @param id 修改商品的id
	 * @param itemsCustom 修改的商品信息
	 * @throws Exception
	 */
	public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception;

}
