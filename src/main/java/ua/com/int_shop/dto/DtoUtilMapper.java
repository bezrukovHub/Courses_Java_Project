package ua.com.int_shop.dto;

import java.util.ArrayList;
import java.util.List;

import ua.com.int_shop.entity.Category;
import ua.com.int_shop.entity.Commodity;
import ua.com.int_shop.entity.Customer;
import ua.com.int_shop.entity.Manufacturer;
import ua.com.int_shop.entity.Order_C;

public class DtoUtilMapper {
	
	public static List<CategoryDTO> categoryToCategoryDTO(List<Category> categories) {

		List<CategoryDTO> categoryDTOs = new ArrayList<CategoryDTO>();

		for (Category category : categories) {

			CategoryDTO categoryDTO = new CategoryDTO();
			
			categoryDTO.setId(category.getId());
			categoryDTO.setName(category.getName());
			categoryDTO.setDescription(category.getDescription());
			
			categoryDTOs.add(categoryDTO);
		}
		
		return categoryDTOs;
	}
	
	public static List<CommodityDTO> commodityToCommodityDTO(List<Commodity>  commodities){
		
		List<CommodityDTO> commodityDTOs = new ArrayList<CommodityDTO>();
		
			for (Commodity commodity : commodities) {
				
				CommodityDTO commodityDTO = new CommodityDTO();
				
				commodityDTO.setId(commodity.getId());
				commodityDTO.setName(commodity.getName());
				commodityDTO.setDescription(commodity.getDescription());
				commodityDTO.setPrice(commodity.getPrice());
				
				commodityDTOs.add(commodityDTO);
			}
		
		return commodityDTOs;
	}

	public static List<CustomerDTO> customerToCustomerDTO(List<Customer>  customers){
		
		List<CustomerDTO> customerDTOs = new ArrayList<CustomerDTO>();
		
			for (Customer customer : customers) {
				
				CustomerDTO customerDTO = new CustomerDTO();
				
				customerDTO.setId(customer.getId());
				customerDTO.setName(customer.getName());
				customerDTO.setPhoneNumber(customer.getPhoneNumber());
				
				customerDTOs.add(customerDTO);
			}
		
		return customerDTOs;
	}

	public static List<ManufacturerDTO> manufacturerToManufacturerDTO(List<Manufacturer> manufacturers){
		
		List<ManufacturerDTO> manufacturerDTOs = new ArrayList<ManufacturerDTO>();
		
			for (Manufacturer manufacturer : manufacturers) {
				
				ManufacturerDTO manufacturerDTO = new ManufacturerDTO();
				
				manufacturerDTO.setId(manufacturer.getId());
				manufacturerDTO.setName(manufacturer.getName());
				
				manufacturerDTOs.add(manufacturerDTO);
			}
		
		return manufacturerDTOs;
	}
	
	public static List<Order_CDTO> order_CToOrder_CDTO(List<Order_C>  order_Cs){
		
		List<Order_CDTO> order_CDTOs = new ArrayList<Order_CDTO>();
		
			for (Order_C order_C : order_Cs) {
				
				Order_CDTO order_CDTO = new Order_CDTO();
				
				order_CDTO.setId(order_C.getId());
				order_CDTO.setName(order_C.getName());
				order_CDTO.setPrice(order_C.getPrice());
				
				order_CDTOs.add(order_CDTO);
			}
		
		return order_CDTOs;
	}

}
