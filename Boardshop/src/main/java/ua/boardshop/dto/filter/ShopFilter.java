package ua.boardshop.dto.filter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShopFilter {
	
	private String search = "";
	
	private String maxPrice = "";
	
	private String minPrice = "";
	
	private BigDecimal max;
	
	private BigDecimal min;

	private List<Long> producerIds = new ArrayList<>();
	
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

	public String getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(String maxPrice) {
		this.maxPrice = maxPrice;
	}

	public String getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(String minPrice) {
		this.minPrice = minPrice;
	}
	
	public BigDecimal getMax() {
		return max;
	}

	public void setMax(BigDecimal max) {
		this.max = max;
	}

	public BigDecimal getMin() {
		return min;
	}

	public void setMin(BigDecimal min) {
		this.min = min;
	}

	
}
