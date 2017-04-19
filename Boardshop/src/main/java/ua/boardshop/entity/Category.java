package ua.boardshop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Category extends AbstractEntity{
	
	private String name;
	
	@OneToMany(
	mappedBy="category")
	private List<Commodity> commodities = new ArrayList<Commodity>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Item item;
	
	public Category(String name) {
		this.name = name;
	}
	
	public Category() {

	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Commodity> getCommodities() {
		return commodities;
	}

	public void setCommodities(List<Commodity> commodities) {
		this.commodities = commodities;
	}			
	
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Category [name=" + name + "]";
	}
	
}
