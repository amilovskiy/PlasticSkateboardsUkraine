package ua.boardshop.editor;

import java.beans.PropertyEditorSupport;

import ua.boardshop.entity.Truck;
import ua.boardshop.service.TruckService;

public class TruckEditor extends PropertyEditorSupport {
	
private final TruckService truckService;
	
	public TruckEditor(TruckService truckService) {
		this.truckService = truckService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Truck truck = truckService.findOne(Long.valueOf(text));
		setValue(truck);
	}
}
