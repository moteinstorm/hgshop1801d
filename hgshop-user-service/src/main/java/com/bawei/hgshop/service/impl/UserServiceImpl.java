package com.bawei.hgshop.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.bawei.hgshop.dao.UserDao;
import com.bawei.hgshop.pojo.User;
import com.bawei.hgshop.service.UserService;

/**
 * 
 * @author 45466
 *
 */
@Service(interfaceClass = UserService.class)
public class UserServiceImpl  implements UserService{
	
	@Autowired
	UserDao userDao;

	/**
	 * 注册
	 */
	@Override
	public User register(User user) {
		// TODO Auto-generated method stub
		
		User byName = userDao.findByName(user.getName());
		// 校验用户是否存在
		if(byName!=null)
			return null;
		
		
		// 计算密码的秘文  加盐
		String md5Hex = DigestUtils.md5Hex(user.getPassword() + user.getName()+"aaaa");
		user.setPassword(md5Hex);
		int resutl = userDao.add(user);
		if(resutl<1)
			return null;
		
		return userDao.findUserById(user.getUid());
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		
		// 计算密码的秘文  加盐
		String md5Hex = DigestUtils.md5Hex(user.getPassword() + user.getName()+"aaaa");
		user.setPassword(md5Hex);
		
		return userDao.findUser(user);
	}

	@Override
	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		return userDao.findByName(name);
	}

}
