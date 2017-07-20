package com.ddd.ssm.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.ddd.ssm.mapper.ItemsMapper;
import com.ddd.ssm.mapper.ItemsMapperCustom;
import com.ddd.ssm.pojo.Items;
import com.ddd.ssm.pojo.ItemsCustom;
import com.ddd.ssm.pojo.ItemsQueryVo;
import com.ddd.ssm.service.ItemsService;
/**
 * 商品管理service实现
 * @author Dan
 *
 */
public class ItemsServiceImpl implements ItemsService{
	//自动注入，因为在容器中有该mapper
	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	//注入ItemsMapper对items进行操作
	@Autowired
	private ItemsMapper itemsMapper;
	
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

	@Override
	public ItemsCustom findItemsById(Integer id) throws Exception {
		//中间对商品信息进行业务处理
		//...
		//返回的ItemsCustom
		ItemsCustom itemsCustom=new ItemsCustom();
		
		Items item= itemsMapper.selectByPrimaryKey(id);
		//把item中的属性复制到itemsCustom中
		BeanUtils.copyProperties(item, itemsCustom);
		return itemsCustom;
	}

	@Override
	public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception {
		//添加业务校验，通常在service接口对关键参数进行校验
		//检验id是否为空,如果为空就抛出异常
//		if(id==null){
//			throw NullPointerException
//		}
		//更新,使用updateByPrimaryKeyWithBLOBs来根据主键更新items中所有的字段包括大文本类型字段
		//updateByPrimaryKeyWithBLOBs要求必须传入id
		itemsCustom.setId(id);
		itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
		
	}

}
