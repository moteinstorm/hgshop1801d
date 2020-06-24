package com.bawei.hgshop.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bawei.hgshop.pojo.Spec;
import com.bawei.hgshop.service.SpecService;
import com.github.pagehelper.PageInfo;

/**
 * 测试规格
 * @author 45466
 *
 */
public class TestSpec extends TestBase{
	
	@Autowired
	SpecService ss;
	
	@Test
	public void testList() {
		PageInfo<Spec> pageInfo = ss.list(1, 3, new Spec());
		pageInfo.getList().forEach(x->{System.out.println("x is " + x);});
		
	}
	
	

}
