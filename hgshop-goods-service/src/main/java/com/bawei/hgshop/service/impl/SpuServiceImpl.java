package com.bawei.hgshop.service.impl;


import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import com.alibaba.fastjson.JSON;
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
	KafkaTemplate<String , String> kaTemplate;

	@Autowired
	SpuDao spuDao;
	
	@Override
	public int add(Spu spu) {
		// TODO Auto-generated method stub
		int r= spuDao.add(spu);
		if(r>0) {
			int spuId= spu.getId();
			// 
			Spu spu2 = spuDao.findById(spuId);
			String spuJson = JSON.toJSONString(spu2);
			kaTemplate.send("hgspu", "addspu",spuJson);
		}
		return r;
	}

	@Override
	public int update(Spu spu) {
		// TODO Auto-generated method stub
		return spuDao.update(spu);
	}

	@Override
	public int delete(int[] ids) {
		// TODO Auto-generated method stub
		int n =  spuDao.delete(ids);
		if(n>0) {
			
			String delIdsStr = JSON.toJSONString(ids);
			kaTemplate.send("hgspu", "delspu",delIdsStr);
		}
		return n;
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
