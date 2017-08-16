package ua.boardshop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Truck extends AbstractEntity {

	private String name;

	@OneToMany(
	mappedBy="truck")
	private List<Commodity> commodities = new ArrayList<Commodity>();
	
	public Truck(String name) {
		this.name = name;
	}

	public Truck() {

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

	@Override
	public String toString() {
		return "Truck [name=" + name + "]";
	}
	
	
}
