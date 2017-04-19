package ua.boardshop.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Commodity extends AbstractEntity{

	private String name;
	private BigDecimal price;
	@Column(length=200000)
	private String description;
	@Column(name = "version", nullable = true)
	private Integer version;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Producer producer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Category category;
	
	@ManyToMany(mappedBy="commodities")
	private List<User> users= new ArrayList<User>();
	
	public Commodity(String name, BigDecimal price, String description) {
		this.name = name;
		this.price = price;
		this.description = description;
	}

	public Commodity() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Producer getProducer() {
		return producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Commodity [name=" + name + ", price=" + price + ", description=" + description + "]";
	}
	
}
