package ua.boardshop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.boardshop.entity.Deck;
import ua.boardshop.service.DeckService;

public class DeckValidator implements Validator {

	private final DeckService deckService;
	
	public DeckValidator(DeckService deckService) {
		this.deckService = deckService;
	}
	
	public boolean supports(Class<?> zingabouzer) {
		return zingabouzer.equals(Deck.class);
	}

	public void validate(Object target, Errors errors) {
		Deck item = (Deck) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can`t be empty, motherfucker!!! One more time and Samuel L. Jackson will kill you");
		if(deckService.findOne(item.getName()) != null){
			errors.rejectValue("name", "", "Already exist");
		}			
	}
}
