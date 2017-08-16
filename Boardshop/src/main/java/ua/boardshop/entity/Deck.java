package ua.boardshop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Deck extends AbstractEntity {

	private String name;

	@OneToMany(
	mappedBy="deck")
	private List<Commodity> commodities = new ArrayList<Commodity>();
	
	public Deck(String name) {
		this.name = name;
	}

	public Deck() {

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
		return "Deck [name=" + name + "]";
	}
}
