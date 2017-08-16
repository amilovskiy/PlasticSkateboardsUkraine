package ua.boardshop.editor;

import java.beans.PropertyEditorSupport;

import ua.boardshop.entity.Wheel;
import ua.boardshop.service.WheelService;

public class WheelEditor extends PropertyEditorSupport {

private final WheelService wheelService;
	
	public WheelEditor(WheelService wheelService) {
		this.wheelService = wheelService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Wheel wheel = wheelService.findOne(Long.valueOf(text));
		setValue(wheel);
	}
}
