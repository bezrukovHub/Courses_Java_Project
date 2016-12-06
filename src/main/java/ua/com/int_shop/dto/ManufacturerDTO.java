package ua.com.int_shop.dto;

public class ManufacturerDTO {

	private int id;
	private String name;
	
	public ManufacturerDTO() {
		// TODO Auto-generated constructor stub
	}

	public ManufacturerDTO(int id, String name) {
		super();
		this.id = id;
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
	
	
}
