package ua.boardshop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Wheel extends AbstractEntity {

	private String name;
	
	@OneToMany(
	mappedBy="wheel", fetch = FetchType.EAGER)
	private List<Commodity> commodities = new ArrayList<Commodity>();

	public Wheel(String name, List<Commodity> commodities) {
		this.name = name;
	}

	public Wheel() {

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
		return "Wheel [name=" + name + "]";
	}

}
