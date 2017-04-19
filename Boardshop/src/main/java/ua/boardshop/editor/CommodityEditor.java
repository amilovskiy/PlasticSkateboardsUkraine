package ua.boardshop.editor;

import java.beans.PropertyEditorSupport;

import ua.boardshop.entity.Commodity;
import ua.boardshop.service.CommodityService;

public class CommodityEditor extends PropertyEditorSupport{

	private final CommodityService commodityService;

	public CommodityEditor(CommodityService commodityService) {
		this.commodityService = commodityService;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Commodity commodity= commodityService.findOne(Long.valueOf(text));
		setValue(commodity);
	}
}
