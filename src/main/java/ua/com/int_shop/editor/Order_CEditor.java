package ua.com.int_shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.int_shop.service.Order_CService;

public class Order_CEditor extends PropertyEditorSupport{

	private final Order_CService order_CService;

	public Order_CEditor(Order_CService order_CService) {
		super();
		this.order_CService = order_CService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(order_CService.getOne(Integer.parseInt(text)));
	}
	
	
	
}
