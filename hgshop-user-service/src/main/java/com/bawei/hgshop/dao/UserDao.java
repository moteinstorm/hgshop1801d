package com.bawei.hgshop.dao;

import com.bawei.hgshop.pojo.User;

public interface UserDao {

	User findUserById(Integer uid);

	int add(User user);

	User findUser(User user);

	User findByName(String name);

}
