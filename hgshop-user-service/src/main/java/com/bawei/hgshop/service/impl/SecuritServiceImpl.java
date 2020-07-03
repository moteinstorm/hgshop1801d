package com.bawei.hgshop.service.impl;

import java.util.UUID;

import org.apache.dubbo.config.annotation.Service;

import com.bawei.hgshop.service.SecuritService;

@Service(interfaceClass =SecuritService.class )
public class SecuritServiceImpl  implements SecuritService {

	@Override
	public String get16RandStr() {
		// TODO Auto-generated method stub
		return UUID.randomUUID().toString().substring(0, 16);
	}

}
