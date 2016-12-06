package ua.com.int_shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ua.com.int_shop.dao.CommodityDao;
import ua.com.int_shop.entity.Commodity;
import ua.com.int_shop.service.CommodityService;
import ua.com.int_shop.validation.Validator;

@Service
public class CommodityServiceImpl implements CommodityService{

	@Autowired
	private CommodityDao commodityDao;
	@Autowired
	@Qualifier("commodityValidator")
	private Validator validator;

	public void save(Commodity commodity) throws Exception {

		validator.validate(commodity);

		commodityDao.save(commodity);
	}

	public List<Commodity> getAll() {
		return commodityDao.findAll();
	}

	public Commodity getOne(int id) {
		return commodityDao.findOne(id);
	}

	public void delete(int id) {
		commodityDao.delete(id);
	}
	

}
