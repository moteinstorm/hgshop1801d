package com.bawei.hgshop.service;

import java.util.List;

import com.bawei.hgshop.pojo.OrderDetail;
import com.bawei.hgshop.pojo.Orderz;
import com.bawei.hgshop.pojo.User;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @author 45466
 *
 */
public interface UserService {
	
	// 注册
	User register(User user);
	
	// 登录
	User login(User user);
	
	// 根据用户名查找用户是否存在，  注册时候的唯一性验证使用
	User getUserByName(String name);

	PageInfo<Orderz> listOrderz(Integer uid, int page);

	List<OrderDetail> listOrderDetail(int oid);

}
