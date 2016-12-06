package ua.com.int_shop.service;

import java.util.List;

import ua.com.int_shop.entity.Manufacturer; 

public interface ManufacturerService {

	void save(Manufacturer manufacturer) throws Exception;
	List<Manufacturer> getAll();
	Manufacturer getOne(int id);
	void delete(int id);
	
	void addCommoditiesForManufactuer(int idManufacturer, String [] idCommodities);
}
