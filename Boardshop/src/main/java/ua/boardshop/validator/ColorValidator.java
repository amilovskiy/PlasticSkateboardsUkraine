package ua.boardshop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.boardshop.entity.Color;
import ua.boardshop.service.ColorService;

public class ColorValidator implements Validator {

	private final ColorService colorService;
	
	public ColorValidator(ColorService colorService) {
		this.colorService = colorService;
	}
	
	public boolean supports(Class<?> zingabouzer) {
		return zingabouzer.equals(Color.class);
	}

	public void validate(Object target, Errors errors) {
		Color item = (Color) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can`t be empty, motherfucker!!! One more time and Samuel L. Jackson will kill you");
		if(colorService.findOne(item.getName()) != null){
			errors.rejectValue("name", "", "Already exist");
		}			
	}
}
