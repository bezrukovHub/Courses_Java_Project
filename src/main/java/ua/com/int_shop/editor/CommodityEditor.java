package ua.com.int_shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.int_shop.service.CommodityService;

public class CommodityEditor extends PropertyEditorSupport{
	
	private final CommodityService commodityService;

	public CommodityEditor(CommodityService commodityService) {
		super();
		this.commodityService = commodityService;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException{
		setValue(commodityService.getOne(Integer.parseInt(text)));
	}
	

}
