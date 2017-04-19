package ua.boardshop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.boardshop.entity.Category;
import ua.boardshop.service.CategoryService;

public class CategoryValidator implements Validator{

	private final CategoryService categoryService;

	public CategoryValidator(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	public boolean supports(Class<?> zingabouzer) {
		return zingabouzer.equals(Category.class);
	}

	public void validate(Object target, Errors errors) {
		Category category = (Category) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can`t be empty, motherfucker!!! One more time and Samuel L. Jackson will kill you");
		if(categoryService.findOne(category.getName())!=null){
			errors.rejectValue("name", "", "Already exist");
		}		
	}

	
}
