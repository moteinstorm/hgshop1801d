package com.bawei.hgshop.dao;

import java.util.List;

import com.bawei.hgshop.pojo.OrderDetail;
import com.bawei.hgshop.pojo.Orderz;

public interface OrderDao {

	int inert(Orderz orderz);

	int insertDetail(OrderDetail orderDetail);
	
	List<Orderz> list(int uid);
	
	List<OrderDetail> listDetail(int oid);

}
