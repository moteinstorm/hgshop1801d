package com.bawei.hgshop.kfk;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.listener.MessageListener;

import com.bawei.hgshop.controller.ElSearchUtil;
import com.bawei.hgshop.pojo.EsSpu;
import com.bawei.hgshop.pojo.Spu;
import com.github.pagehelper.PageInfo;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @author 45466
 *
 */
public class KfkListener  implements MessageListener<String, String>{
	
	{
		System.out.println(" KfkListener 实例化了。。。。");
	}

	// duiredist 进行操练做
	@Autowired
	RedisTemplate<String, PageInfo<Spu>> redisTemplate;
	
	
	@Autowired
	ElSearchUtil<EsSpu> esUtil;
		
	@Override
	public void onMessage(ConsumerRecord<String, String> data) {
		// TODO Auto-generated method stub
		String key = data.key();
		System.out.println(" KfkListener  收到消息 key " + key + " and  value is " + data.value());
		switch (key) {
		case "addspu":
			//可能首页数据收到影响
			redisTemplate.delete("firstPage");
			
			// es 的数据也会受影响
			String spuJsonStr = data.value();
			Spu spu = JSON.parseObject(spuJsonStr, Spu.class);
			EsSpu esSpu = new EsSpu(spu);
			esUtil.saveObject(esSpu.getId().toString(), esSpu);
			break;
		case "delspu":
			
			break;

		default:
			break;
		}
		
		
		
	}

}
