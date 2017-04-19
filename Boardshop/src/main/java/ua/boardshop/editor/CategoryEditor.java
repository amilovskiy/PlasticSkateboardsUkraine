package ua.boardshop.editor;

import java.beans.PropertyEditorSupport;

import ua.boardshop.entity.Category;
import ua.boardshop.service.CategoryService;

public class CategoryEditor extends PropertyEditorSupport{

	private final CategoryService categoryService;

	public CategoryEditor(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Category category= categoryService.findOne(Long.valueOf(text));
		setValue(category);
	}
}
