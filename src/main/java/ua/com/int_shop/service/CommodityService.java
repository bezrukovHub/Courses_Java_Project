package ua.com.int_shop.service;

import java.security.Principal;
import java.util.List;

import ua.com.int_shop.entity.Commodity; 

public interface CommodityService {

	void save(Commodity commodity) throws Exception;
	List<Commodity> getAll();
	Commodity getOne(int id);
	void delete(int id);
	
	//void buyBook(Principal principal, String id);
}
