package ua.com.int_shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ua.com.int_shop.dao.CommodityDao;
import ua.com.int_shop.dao.Order_CDao;
import ua.com.int_shop.entity.Order_C;
import ua.com.int_shop.service.Order_CService;
import ua.com.int_shop.validation.Validator;

@Service
public class Order_CServiceImpl implements Order_CService{

	@Autowired
	private Order_CDao order_CDao;

	@Autowired
	@Qualifier("order_cValidator")
	private Validator validator;

	public void create(Order_C order_C) throws Exception {

		validator.validate(order_C);

		order_CDao.save(order_C);
	}

	public List<Order_C> getAll() {
		return order_CDao.findAll();
	}

	public Order_C getOne(int id) {
		return order_CDao.findOne(id);
	}

	public void delete(int id) {
		order_CDao.delete(id);
	}

	//public Order_C fetchOrderWithCommodity(int id) {
//		return order_CDao.fetchOrderWithCommodity(id);
//	}


}
