package com.bawei.hgshop.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bawei.hgshop.pojo.Brand;
import com.bawei.hgshop.service.BrandService;


public class TestBrand extends TestBase{
	
	@Autowired
	BrandService bs;
	
	@Test
	public void testGet() {
		
		Brand brand = bs.getById(2);
		System.out.println("brand is " + brand);
		
	}

}
