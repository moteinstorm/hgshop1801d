package com.bawei.hgshop.service;

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
	

}
