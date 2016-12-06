package ua.com.int_shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.int_shop.service.ManufacturerService;

public class ManufacturerEditor extends PropertyEditorSupport{
	
	private final ManufacturerService manufacturerService;

	public ManufacturerEditor(ManufacturerService manufacturerService) {
		super();
		this.manufacturerService = manufacturerService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(manufacturerService.getOne(Integer.parseInt(text)));
	}

}
