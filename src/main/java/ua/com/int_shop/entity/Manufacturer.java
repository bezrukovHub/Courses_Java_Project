package ua.com.int_shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Manufacturer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String country;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="manufacturer")
	private List<Commodity> commodities;
	
	public Manufacturer() {
		// TODO Auto-generated constructor stub
	}

	public Manufacturer(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<Commodity> getCommodities() {
		return commodities;
	}

	public void setCommodities(List<Commodity> commodities) {
		this.commodities = commodities;
	}
	
	@Override
	public String toString() {
		return "Manufacturer " + id + "{" 
				+ "\n name:" + name
				+ "}";
	}
	
}
