package com.bawei.hgshop.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.bawei.hgshop.dao.SpuDao;
import com.bawei.hgshop.pojo.Spu;
import com.bawei.hgshop.pojo.SpuVo;
import com.bawei.hgshop.service.SpuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @author 45466
 * spu 的实现类
 *
 */
@Service(interfaceClass = SpuService.class)
public class SpuServiceImpl implements SpuService{

	@Autowired
	SpuDao spuDao;
	
	@Override
	public int add(Spu spu) {
		// TODO Auto-generated method stub
		return spuDao.add(spu);
	}

	@Override
	public int update(Spu spu) {
		// TODO Auto-generated method stub
		return spuDao.update(spu);
	}

	@Override
	public int delete(int[] ids) {
		// TODO Auto-generated method stub
		return spuDao.delete(ids);
	}

	@Override
	public PageInfo<Spu> list(SpuVo spuvo) {
		// TODO Auto-generated method stub
		PageHelper.startPage(spuvo.getPageNum(), spuvo.getPageSize());
		return new PageInfo<Spu>(spuDao.list(spuvo));
	}

	@Override
	public Spu getById(int id) {
		// TODO Auto-generated method stub
		return spuDao.findById(id);
	}

}
