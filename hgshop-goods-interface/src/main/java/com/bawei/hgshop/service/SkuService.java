package com.bawei.hgshop.service;

import java.util.List;

import com.bawei.hgshop.pojo.Sku;
import com.bawei.hgshop.pojo.SkuVo;
import com.github.pagehelper.PageInfo;

/**
 * sku的管理
 * @author 45466
 *
 */
public interface SkuService {
	
	int add(Sku sku);
	int update(Sku sku);
	int delete(int[] ids);
	
	PageInfo<Sku> list(SkuVo skuvo);
	
	Sku getById(int id);
	// 根据spu 获取sku的集合，同时包含规格详情
	List<Sku> listDetailBySpu(int spuId);
	

}
