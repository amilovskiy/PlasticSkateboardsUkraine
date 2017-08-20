package ua.boardshop.dto.filter;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdminFilter {

	private String search = "";
	
	private List<Long> itemIds = new ArrayList<>();

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public List<Long> getItemIds() {
		return itemIds;
	}

	public void setItemIds(List<Long> itemIds) {
		this.itemIds = itemIds;
	}
	
	
}
