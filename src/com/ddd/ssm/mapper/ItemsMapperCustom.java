package com.ddd.ssm.mapper;

import com.ddd.ssm.pojo.Items;
import com.ddd.ssm.pojo.ItemsCustom;
import com.ddd.ssm.pojo.ItemsExample;
import com.ddd.ssm.pojo.ItemsQueryVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemsMapperCustom {
    //商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)throws Exception;
}