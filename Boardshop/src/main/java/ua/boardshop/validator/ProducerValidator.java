package ua.boardshop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.boardshop.entity.Producer;
import ua.boardshop.service.ProducerService;

public class ProducerValidator implements Validator {

	private final ProducerService producerService;

	public ProducerValidator(ProducerService producerService) {
		this.producerService = producerService;
	}
	
	public boolean supports(Class<?> zingabouzer) {
		return zingabouzer.equals(Producer.class);
	}

	public void validate(Object target, Errors errors) {
		Producer item = (Producer) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can`t be empty, motherfucker!!! One more time and Samuel L. Jackson will kill you");
		if(producerService.findOne(item.getName())!=null){
			errors.rejectValue("name", "", "Already exist");
		}			
	}

}
