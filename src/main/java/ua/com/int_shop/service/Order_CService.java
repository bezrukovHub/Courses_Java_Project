package ua.com.int_shop.service;

import java.util.List;

import ua.com.int_shop.entity.Order_C;

public interface Order_CService {
	
	void create(Order_C order_C) throws Exception;
	List<Order_C> getAll();
	Order_C getOne(int id);
	void delete(int id);
	
	//Order_C fetchOrderWithCommodity(int id);
}
