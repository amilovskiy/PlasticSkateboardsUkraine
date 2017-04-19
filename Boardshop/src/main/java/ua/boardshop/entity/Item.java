package ua.boardshop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Item extends AbstractEntity{

	private String name;

	@OneToMany(
	mappedBy="item")
	private List<Category> categories = new ArrayList<Category>();
	
	public Item(String name) {
		this.name = name;
	}

	public Item() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + "]";
	}
	
}
