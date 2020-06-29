package com.bawei.hgshop.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.bawei.hgshop.dao.SkuDao;
import com.bawei.hgshop.pojo.Sku;
import com.bawei.hgshop.pojo.SkuVo;
import com.bawei.hgshop.pojo.SpecOption;
import com.bawei.hgshop.service.SkuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @author 45466
 *
 */
@Service(interfaceClass =SkuService.class )
public class SkuServiceImpl implements SkuService {
	
	@Autowired
	SkuDao skuDao;

	@Override
	public int add(Sku sku) {
		// TODO Auto-generated method stub
		//插入主表 生成主键
		int result = skuDao.insert(sku);
		List<SpecOption> options = sku.getOptions();
		//插入子表
		for (SpecOption specOption : options) {
			result+=skuDao.insertSpecOption(sku.getId(),specOption);
		}
		
		return result;
	}

	@Override
	public int update(Sku sku) {
		// TODO Auto-generated method stub
		//修改主表
		int result = skuDao.update(sku);
		// 删除子表的数据
		result += skuDao.deleteSpecOption(sku.getId());
		
		//重新添加   插入子表
		List<SpecOption> options = sku.getOptions();
		for (SpecOption specOption : options) {
			result+=skuDao.insertSpecOption(sku.getId(),specOption);
		}
		return result;
	}

	@Override
	public int delete(int[] ids) {
		// TODO Auto-generated method stub
		// 先删除子表
		int  result = skuDao.deleteSpecOption(ids);
		//再删除主表
		result += skuDao.delete(ids);
		
		return result;
	}

	@Override
	public PageInfo<Sku> list(SkuVo skuvo) {
		// TODO Auto-generated method stub
		PageHelper.startPage(skuvo.getPageNum(), skuvo.getPageSize());
		
		return new PageInfo<Sku>(skuDao.list(skuvo)) ;
	}

	@Override
	public Sku getById(int id) {
		// TODO Auto-generated method stub
		return skuDao.findById(id);
	}

}
