package ua.com.int_shop.service;

import java.util.List;

import ua.com.int_shop.entity.Category;

public interface CategoryService {
	
	void save(Category category) throws Exception;
	List<Category> getAll();
	Category getOne(int id);
	void delete(int id);

}
