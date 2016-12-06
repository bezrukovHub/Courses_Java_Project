package ua.com.int_shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.int_shop.dao.CategoryDao;
import ua.com.int_shop.entity.Category;
import ua.com.int_shop.service.CategoryService;
import ua.com.int_shop.validation.Validator;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	@Qualifier("categoryValidator")
	private Validator validator;
	
	@Transactional
	public void save(Category category) throws Exception {

		validator.validate(category);

		categoryDao.save(category);
	}

	@Transactional
	public List<Category> getAll() {
		return categoryDao.findAll();
	}

	@Transactional
	public Category getOne(int id) {
		return categoryDao.findOne(id);
	}

	@Transactional
	public void delete(int id) {
		categoryDao.delete(id);
	}

}
