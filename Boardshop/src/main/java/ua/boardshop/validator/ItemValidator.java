package ua.boardshop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.boardshop.entity.Item;
import ua.boardshop.service.ItemService;

public class ItemValidator implements Validator {

	private final ItemService itemService;
	
	public ItemValidator(ItemService itemService) {
		this.itemService = itemService;
	}
	
	public boolean supports(Class<?> zingabouzer) {
		return zingabouzer.equals(Item.class);
	}

	public void validate(Object target, Errors errors) {
		Item item = (Item) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can`t be empty, motherfucker!!! One more time and Samuel L. Jackson will kill you");
		if(itemService.findOne(item.getName())!=null){
			errors.rejectValue("name", "", "Already exist");
		}			
	}
}
