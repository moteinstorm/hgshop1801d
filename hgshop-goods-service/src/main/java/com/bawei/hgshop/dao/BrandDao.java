package com.bawei.hgshop.dao;

import java.util.List;

import com.bawei.hgshop.pojo.Brand;

public interface BrandDao {

	List<Brand> queryAll();

	Brand findById(int id);

}
