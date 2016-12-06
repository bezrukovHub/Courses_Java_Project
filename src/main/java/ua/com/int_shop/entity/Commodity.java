package ua.com.int_shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Commodity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String description;
	private double price;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Category category;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Manufacturer manufacturer;
	
	@ManyToMany
	@JoinTable(name = "order_commodity", 
	joinColumns = @JoinColumn(name = "commodity_id"),
	inverseJoinColumns = @JoinColumn(name = "order_id"))
	private List<Order_C> order_Cs;
	
	public Commodity() {
		// TODO Auto-generated constructor stub
	}

	public Commodity(String name, String description, double price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public List<Order_C> getOrder_Cs() {
		return order_Cs;
	}

	public void setOrder_Cs(List<Order_C> order_Cs) {
		this.order_Cs = order_Cs;
	}

	@Override
	public String toString() {
		return "Commodity " + id +"{"
				+ "\n nameOfCommodity:" + name 
				+ "\n description:" + description
				+ "\n price:" + price 
				+ "\n }";
	}
	
}
