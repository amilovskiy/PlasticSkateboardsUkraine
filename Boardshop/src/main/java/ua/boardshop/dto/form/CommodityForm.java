package ua.boardshop.dto.form;

import org.springframework.web.multipart.MultipartFile;

import ua.boardshop.entity.Category;
import ua.boardshop.entity.Color;
import ua.boardshop.entity.Deck;
import ua.boardshop.entity.Producer;
import ua.boardshop.entity.Truck;
import ua.boardshop.entity.Wheel;

public class CommodityForm {

	private Long id;
	
	private String name;
	
	private String price;
	
	private String count;
	
	private String description;
	
	private Producer producer;
	
	private Category category;
	
	private Deck deck;
	
	private Truck truck;
	
	private Wheel wheel;
	
	private Color color;
		
	private MultipartFile file;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
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

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public Truck getTruck() {
		return truck;
	}

	public void setTruck(Truck truck) {
		this.truck = truck;
	}

	public Wheel getWheel() {
		return wheel;
	}

	public void setWheel(Wheel wheel) {
		this.wheel = wheel;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
}
