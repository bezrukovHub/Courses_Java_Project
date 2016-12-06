package ua.com.int_shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.int_shop.service.CustomerService;

public class CustomerEditor extends PropertyEditorSupport{

	private final CustomerService customerService;

	public CustomerEditor(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException{
		setValue(customerService.getOne(Integer.parseInt(text)));
	}
	
	
	
}
