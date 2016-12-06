package ua.com.int_shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.int_shop.service.CategoryService;

public class CategoryEditor extends PropertyEditorSupport{

	private final CategoryService categoryService;

	public CategoryEditor(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException{
		setValue(categoryService.getOne(Integer.parseInt(text)));
	}
	
	
}
