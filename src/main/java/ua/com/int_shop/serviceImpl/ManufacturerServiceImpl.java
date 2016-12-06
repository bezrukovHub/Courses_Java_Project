package ua.com.int_shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.int_shop.dao.CommodityDao;
import ua.com.int_shop.dao.ManufacturerDao;
import ua.com.int_shop.entity.Commodity;
import ua.com.int_shop.entity.Manufacturer;
import ua.com.int_shop.service.ManufacturerService;
import ua.com.int_shop.validation.Validator;

@Service
public class ManufacturerServiceImpl implements ManufacturerService{

	@Autowired
	private ManufacturerDao manufacturerDao;
	@Autowired
	private CommodityDao commodityDao;
	@Autowired
	@Qualifier("manufacturerValidator")
	private Validator validator;

	public void save(Manufacturer manufacturer) throws Exception {

		validator.validate(manufacturer);

		manufacturerDao.save(manufacturer);
	}

	public List<Manufacturer> getAll() {
		return manufacturerDao.findAll();
	}

	public Manufacturer getOne(int id) {
		return manufacturerDao.findOne(id);
	}

	public void delete(int id) {
		manufacturerDao.delete(id);
	}

	@Transactional
	public void addCommoditiesForManufactuer(int idManufacturer, String[] idCommodities) {
		Manufacturer manufacturer = manufacturerDao.findOne(idManufacturer);
		
		for (int i = 0; i < idCommodities.length; i++) {
			
			Commodity commodity = commodityDao.findOne(Integer.parseInt(idCommodities[i]));
			manufacturer.getCommodities().add(commodity);
			manufacturerDao.save(manufacturer);
			
		}
	}
	
	
}
