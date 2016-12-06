package ua.com.int_shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.int_shop.entity.Category;
import ua.com.int_shop.service.CategoryService; 

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="/newCategory", method=RequestMethod.GET)
	public String newCategory(Model model){
		
		model.addAttribute("categories", categoryService.getAll());
		model.addAttribute("category", new Category());
		
		return "views-admin-newCategory";
	}
	
	@RequestMapping(value="/saveCategory", method=RequestMethod.POST)
	public String saveCategory(@ModelAttribute Category category){
		
		categoryService.save(category);
		
		return "redirect:/newCategory";
	}
	
	@RequestMapping(value="/deleteCategory/{id}", method=RequestMethod.GET)
	public String deleteCategory(@PathVariable String id){
		
		categoryService.delete(Integer.parseInt(id));
		return "redirect:/newCategory";
	}
	
	
}
