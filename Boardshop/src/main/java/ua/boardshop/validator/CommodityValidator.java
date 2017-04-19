package ua.boardshop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.boardshop.dto.form.CommodityForm;
import ua.boardshop.service.CommodityService;

public class CommodityValidator implements Validator{

	private final CommodityService commodityService;

	public CommodityValidator(CommodityService commodityService) {
		this.commodityService = commodityService;
	}
	
	public boolean supports(Class<?> zingabouzer) {
		return CommodityForm.class.equals(zingabouzer);
	}

	public void validate(Object target, Errors errors) {
		CommodityForm commodity = (CommodityForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can`t be empty, motherfucker!!! One more time and Samuel L. Jackson will kill you");
		if(commodityService.findOne(commodity.getName())!=null){
			errors.rejectValue("name", "", "Already exist");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "", "Oh man, you must enter price");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "", "Leave a description");
	}
}	