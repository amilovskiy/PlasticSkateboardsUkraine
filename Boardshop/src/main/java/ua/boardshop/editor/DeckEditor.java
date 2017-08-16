package ua.boardshop.editor;

import java.beans.PropertyEditorSupport;

import ua.boardshop.entity.Deck;
import ua.boardshop.service.DeckService;

public class DeckEditor extends PropertyEditorSupport {

private final DeckService deckService;
	
	public DeckEditor(DeckService deckService) {
		this.deckService = deckService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Deck deck = deckService.findOne(Long.valueOf(text));
		setValue(deck);
	}
}
