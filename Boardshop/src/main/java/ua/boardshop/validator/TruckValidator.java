package ua.boardshop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.boardshop.entity.Truck;
import ua.boardshop.service.TruckService;

public class TruckValidator implements Validator {

	private final TruckService truckService;
	
	public TruckValidator(TruckService truckService) {
		this.truckService = truckService;
	}
	
	public boolean supports(Class<?> zingabouzer) {
		return zingabouzer.equals(Truck.class);
	}

	public void validate(Object target, Errors errors) {
		Truck item = (Truck) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can`t be empty, motherfucker!!! One more time and Samuel L. Jackson will kill you");
		if(truckService.findOne(item.getName()) != null){
			errors.rejectValue("name", "", "Already exist");
		}			
	}
}
