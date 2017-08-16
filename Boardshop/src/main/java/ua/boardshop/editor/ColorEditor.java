package ua.boardshop.editor;

import java.beans.PropertyEditorSupport;

import ua.boardshop.entity.Color;
import ua.boardshop.service.ColorService;

public class ColorEditor extends PropertyEditorSupport {

	private final ColorService colorService;
	
	public ColorEditor(ColorService colorService) {
		this.colorService = colorService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Color color = colorService.findOne(Long.valueOf(text));
		setValue(color);
	}
}
