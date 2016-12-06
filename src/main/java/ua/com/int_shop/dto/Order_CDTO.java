package ua.com.int_shop.dto;

public class Order_CDTO {

	private int id;
	private String name;
	private int price;
	
	public Order_CDTO() {
		// TODO Auto-generated constructor stub
	}

	public Order_CDTO(int id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
