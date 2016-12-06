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
public class Order_C {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Customer customer;
	
	private String name;
	private int amountOfCommodities;
	private int price;
	private String paymentMethod;
	
	@ManyToMany
	@JoinTable(name = "order_commodity",
	joinColumns = @JoinColumn(name = "order_id")
	, inverseJoinColumns = @JoinColumn(name = "commodity_id"))
	private List<Commodity> commodities;
	
	public Order_C() {
		// TODO Auto-generated constructor stub
	}

	public Order_C(String name, int amountOfCommodities, int price, String paymentMethod) {
		super();
		this.name = name;
		this.amountOfCommodities = amountOfCommodities;
		this.price = price;
		this.paymentMethod = paymentMethod;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmountOfCommodities() {
		return amountOfCommodities;
	}

	public void setAmountOfCommodities(int amountOfCommodities) {
		this.amountOfCommodities = amountOfCommodities;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public List<Commodity> getCommodities() {
		return commodities;
	}

	public void setCommodities(List<Commodity> commodities) {
		this.commodities = commodities;
	}
	
	@Override
	public String toString() {
		return "Order_C " + id + "{" 
				+ "\n name:" + name
				+ "\n amountOfCommodities" + amountOfCommodities
				+ "\n price:" + price 
				+ "\n paymentMethod:" + paymentMethod 
				+ "}";
	}

}
