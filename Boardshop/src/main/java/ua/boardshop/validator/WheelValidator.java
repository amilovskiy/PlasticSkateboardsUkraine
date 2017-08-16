package ua.boardshop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.boardshop.entity.Wheel;
import ua.boardshop.service.WheelService;

public class WheelValidator implements Validator {

	private final WheelService wheelService;
	
	public WheelValidator(WheelService wheelService) {
		this.wheelService = wheelService;
	}
	
	public boolean supports(Class<?> zingabouzer) {
		return zingabouzer.equals(Wheel.class);
	}

	public void validate(Object target, Errors errors) {
		Wheel item = (Wheel) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can`t be empty, motherfucker!!! One more time and Samuel L. Jackson will kill you");
		if(wheelService.findOne(item.getName()) != null){
			errors.rejectValue("name", "", "Already exist");
		}			
	}
}
