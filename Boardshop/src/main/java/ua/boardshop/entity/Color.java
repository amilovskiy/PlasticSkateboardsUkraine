package ua.boardshop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Color extends AbstractEntity {

	private String name;
	
	@OneToMany(
	mappedBy="color")
	private List<Commodity> commodities = new ArrayList<Commodity>();

	public Color(String name) {
		this.name = name;
	}

	public Color() {

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
		return "Color [name=" + name + "]";
	}
	

}
