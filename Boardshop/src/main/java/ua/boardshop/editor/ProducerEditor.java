package ua.boardshop.editor;

import java.beans.PropertyEditorSupport;

import ua.boardshop.entity.Producer;
import ua.boardshop.service.ProducerService;

public class ProducerEditor extends PropertyEditorSupport{

	private final ProducerService producerService;

	public ProducerEditor(ProducerService producerService) {
		this.producerService = producerService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Producer producer= producerService.findOne(Long.valueOf(text));
		setValue(producer);
	}
}
