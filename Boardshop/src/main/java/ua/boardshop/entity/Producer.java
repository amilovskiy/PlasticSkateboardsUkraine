package ua.boardshop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Producer extends AbstractEntity{

	private String name;
	@Transient
	private MultipartFile file;
	@Column(name = "version", nullable = true)
	private Integer version;
	
	@OneToMany(
	mappedBy="producer", fetch = FetchType.EAGER)
	private List<Commodity> commodities= new ArrayList<Commodity>();
	
	public Producer(String name) {
		this.name = name;
	}

	public Producer() {

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
	
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Producer [name=" + name + "]";
	}
	
}
