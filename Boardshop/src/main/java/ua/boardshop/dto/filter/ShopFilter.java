package ua.boardshop.dto.filter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShopFilter {
	
	private String search = "";
	
	private String max = "";
	
	private String min = "";
	
	private BigDecimal maxValue;
	
	private BigDecimal minValue;

	private List<Long> producerIds = new ArrayList<>();
	
	private List<Long> colorIds = new ArrayList<>();
	
	private List<Long> deckIds = new ArrayList<>();
	
	private List<Long> wheelIds = new ArrayList<>();
	
	private List<Long> truckIds = new ArrayList<>();
	
	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
	
	public List<Long> getProducerIds() {
		return producerIds;
	}

	public void setProducerIds(List<Long> producerIds) {
		this.producerIds = producerIds;
	}

	public String getMax() {
		return max;
	}

	public void setMax(String max) {
		this.max = max;
	}

	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		this.min = min;
	}

	public BigDecimal getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(BigDecimal maxValue) {
		this.maxValue = maxValue;
	}

	public BigDecimal getMinValue() {
		return minValue;
	}

	public void setMinValue(BigDecimal minValue) {
		this.minValue = minValue;
	}

	public List<Long> getColorIds() {
		return colorIds;
	}

	public void setColorIds(List<Long> colorIds) {
		this.colorIds = colorIds;
	}

	public List<Long> getDeckIds() {
		return deckIds;
	}

	public void setDeckIds(List<Long> deckIds) {
		this.deckIds = deckIds;
	}

	public List<Long> getWheelIds() {
		return wheelIds;
	}

	public void setWheelIds(List<Long> wheelIds) {
		this.wheelIds = wheelIds;
	}

	public List<Long> getTruckIds() {
		return truckIds;
	}

	public void setTruckIds(List<Long> truckIds) {
		this.truckIds = truckIds;
	}

	
}
